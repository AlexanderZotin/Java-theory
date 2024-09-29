package theory.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;

public class Box<E> implements Collection<E>, Comparable<Box<E>> {
    private Object[] value;
    private int currentIndex;
    private int size;
    
    public Box() {
        value = new Object[0];
    }
    
    public Box(E[] elements) {
        if(elements == null) throw new IllegalArgumentException("ѕараметр elements не должен быть null!");
        value = elements;
        size = value.length;
        currentIndex = size - 1;
    }
    
    public Box(Collection<? extends E> collection) {
        this();
        addAll(collection);
        currentIndex = size - 1;
    }
    
    //--------------------- ћетоды из интерфейса Collection --------------------- 
    @Override
    public boolean add(E element) {
        if(element == null) return false;
        size++;
        value = Arrays.copyOf(value, size);
        value[size - 1] = element;
        return true;
    }
    
    @Override 
    public boolean addAll(Collection<? extends E> collection) { 
        if(collection == null) return false;
        Iterator<? extends E> iterator = collection.iterator();
        while(iterator.hasNext()) {
            if(iterator.next() == null) iterator.remove(); 
        }
        if(collection.isEmpty()) return false;
        Object[] valueOfCollection = collection.toArray();
        int newSize = this.value.length + valueOfCollection.length;
        value = Arrays.copyOf(value, newSize);
        for(int i = 0; i < valueOfCollection.length; i++) {
            value[i + this.size] = valueOfCollection[i];
        }
        size = newSize;
        return true;
    }
    
    @Override
    public void clear() {
        size = 0;
        currentIndex = 0;
        value = new Object[0];
    }
    
    @Override
    public boolean contains(Object element) {
        if(this.isEmpty() || element == null) return false;
        if(element instanceof Comparable && value[0] instanceof Comparable){
            Object[] tmp = Arrays.copyOf(value, value.length);
            Arrays.sort(tmp);
            return (Arrays.binarySearch(tmp, element) >= 0);
        } else {
            for(Object current : value) {
                if(current.equals(element)) return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> collection) { 
        if(collection == null || collection.isEmpty()) return true;
        Object[] array = collection.toArray();
        for(Object current : array) {
            if(!contains(current)) return false;
        }
        return true;
    }
    
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    
    @Override 
    public Iterator<E> iterator() {
        return new BoxIterator();
    }
    
    private class BoxIterator implements Iterator<E> {
        private int cursorOfIterator = size;
        
        @Override
        public boolean hasNext() {
            return (cursorOfIterator > 0);
        }
        
        @SuppressWarnings("unchecked")
        @Override 
        public E next() {
            cursorOfIterator--;
            try {
                return (E) value[cursorOfIterator];
            } catch(IndexOutOfBoundsException e) {
                throw new java.util.NoSuchElementException(e.getMessage());
            }
        }
    
        @Override
        public void remove() { 
            if(!Box.this.remove(value[cursorOfIterator])) {
                throw new IllegalStateException("Ќе был вызван метод next()!");
            }
        }
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean remove(Object element) { 
        if(!contains(element)) return false;
        int index = 0;
        for(int i = 0; i < value.length; i++) {
            if(value[i].equals(element)) {
                index = i;
                break;
            }
        }
        if(index == (this.size - 1)) value = Arrays.copyOfRange(value, 0, value.length - 1);
        else if(index == 0) value = Arrays.copyOfRange(value, 1, value.length);
        else {
            Object[] fromStartToRemovedElement = Arrays.copyOfRange(value, 0, index);
            Object[] fromIndexToEnd = Arrays.copyOfRange(value, index + 1, value.length);
            value = Arrays.copyOf(fromStartToRemovedElement, value.length - 1);
            for(int i = fromStartToRemovedElement.length, j = 0; j < fromIndexToEnd.length; i++, j++) {
                value[i] = fromIndexToEnd[j];
            }
        }
        size--;
        return true;
    }
    
    @Override
    public boolean removeAll(Collection<?> collection) { 
        if(collection == null || collection.isEmpty()) return false;
        int nulls = 0;
        for(int i = 0; i < value.length; i++) {
            if(collection.contains(value[i])) { 
                value[i] = null; 
                nulls++;
            }
        }
        if(nulls == value.length) clear(); 
        else if(nulls == 0) return false;
        else {
            Object[] newValue = new Object[value.length - nulls];
            for(int i = 0, j = 0; i< value.length; i++) {
                if(value[i] != null) {
                    newValue[j] = value[i];
                    j++;
                }
            }
            value = newValue;
        }
        return true; 
    }
    
    @Override
    public boolean retainAll(Collection<?> collection) {
        if(collection == null || collection.isEmpty()) return false;
        Object[] elementsToRemove = new Object[0];
        for (Object o : value) {
            if (!collection.contains(o)) {
                elementsToRemove = Arrays.copyOf(elementsToRemove, elementsToRemove.length + 1);
                elementsToRemove[elementsToRemove.length - 1] = o;
            }
        }
        return removeAll(new Box<>(elementsToRemove)); 
    }
    
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) {
        if(array.length > value.length) {
            T[] tmp = Arrays.copyOfRange(array, this.size, array.length);
            array = (T[]) Arrays.copyOf(value, array.length, array.getClass());
            for(int i = this.size, j = 0; i < array.length; i++, j++) {
                array[i] = tmp[j];
            }
            array[this.size] = null;
        } else {
            array = (T[]) Arrays.copyOf(value, value.length, array.getClass());
        }
        return array;
    }
    
    public Object[] toArray() {
        return Arrays.copyOf(value, value.length); 
    }
    
    //--------------------- ћетоды из класса Object ---------------------
    @Override
    public boolean equals(Object otherBox) { 
        if(otherBox == null) return false;
        if(this == otherBox) return true;
        if(otherBox.getClass() != this.getClass()) return false;
        
        Box<?> box = (Box<?>) otherBox;
        return Arrays.equals(this.toArray(), box.toArray());
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(value) + this.size;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(value);
    }
    
    // --------------------- Собственные методы ---------------------
    public boolean canGoNext() {
        return (currentIndex > 0);
    }
    
    public boolean canGoBack() {
       return (currentIndex < value.length);
    }
    
    @SuppressWarnings("unchecked")
    public E getCurrentElement() {
        return (E) value[currentIndex];
    }
    
    public int getCurrentIndex() {
        return currentIndex;
    }
    
    public void goNext() { 
        if(!canGoNext()) {
            throw new IndexOutOfBoundsException("»дти дальше невозможно, так как индекса -1 не существует");
        }
        currentIndex--;
    }
    
    public void goBack() {
        if(!canGoBack()) {
            throw new IndexOutOfBoundsException
                    ("»дти назад невозможно, так как индекса " + value.length + " не существует");
        }
        currentIndex++;
    }
    
    public void setCurrentElement(int newIndex) {
        if(newIndex < 0 || newIndex >= value.length) {
            throw new IllegalArgumentException("Индекса " + newIndex + " не существует!");
        }
        currentIndex = newIndex;
    }
    
    //--------------------- ћетод из интерфейса Comparable ---------------------
    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Box<E> otherBox) {
        if(this.size != otherBox.size) {
            return (this.size - otherBox.size);
        } else {
            if(this.isEmpty()) return 0;
            int result = 0;
            Iterator<? extends E> iteratorForThis = this.iterator();    
            Iterator<? extends E> iteratorForOtherBox = otherBox.iterator();    
            while(iteratorForThis.hasNext()) {
                E elementOfThisBox = iteratorForThis.next();
                E elementOfOtherBox = iteratorForOtherBox.next();
                if(elementOfThisBox instanceof Comparable) {
                    Comparable<E> first = (Comparable<E>) elementOfThisBox;                
                    result += first.compareTo(elementOfOtherBox);
                } else {
                    result += Integer.compare(elementOfThisBox.hashCode(), 
                            elementOfOtherBox.hashCode());
                }
            }
            return result;
        } 
    }
}
