package theory.collections.lists;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Arrays;
/*
java.util.Vector - коллекция, появившаяся ещё в JDK1.0! Это было ещё
в те времена, когда не существовала интерфейсов Collection, List
и класса ArrayList, на который, кстати Vector очень похож.
В чём же разница? Главное отличие в том, что Vector
синхронизирован, то есть потокобезопасен, а ArrayList - нет.
И, как следствие, ArrayList работает быстрее.
Когда появился последний, Vector стали использовать
только в многопоточных приложениях.
Сейчас же его не используют и там, потому что
в java 1.5 появился пакет java.util.concurrent, вытеснивший Vector
окончательно. Ещё у Vector'a есть странные методы, которые
дублируют методы из интерфейсов Iterable, Collection и List.
Они остались с времён Java1.0 и Java1.1:
1. void addElement(E obj) - boolean add(E e)
2. E elementAt(int index) - E get(int index)
3. void insertElementAt(Object o, int index) - void add(int index, E element)
4. void copyInto(Object[] array) - Object[] toArray()
5. void setElementAt(E obj, int index) -  E set(int index, E element)
6. void removeAllElements() - void clear()
7. boolean     removeElement(Object obj) - boolean remove(Object o)
8. boolean removeElementAt(int index) - E remove(int index)
9. И самое удивительное: Enumeration<E>    elements()
Это же аналог Iterator<E> iterator()! А с первого взгляда и непонятно, что
это и зачем. 
*/
public class UseVector { 

    public static void main(String [] args) {
        testVector();
        battleOfVectorAndArrayList();
    }
    
    private static void testVector() {
        System.out.println("--------------------------------------------------");
        Vector<Integer> vector = new Vector<>();
        int size = quantity();
        for(int i = 0; i < size; i++) {
            vector.add((int) Math.round(Math.random() * 10));
        }
        Iterator<Integer> iterator = vector.iterator();
        System.out.println("Проитерируемся:");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /*
        Теперь проитерируемся, как  это делали на Java1.1 
        (дженериков тогда, конечно, не было, но в остальном всё происходило именно так)
        */
        Enumeration<Integer> enumeration = vector.elements();
        System.out.println("Проитерируемся по-старому:");
        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }        
        vector.add(666);
        vector.addElement(666); //То же, что и add()
        vector.remove((Object) 666); //Надо прикастовать, а то подумает ещё, что это remove(int index)
        vector.removeElement((Object) 666);
        System.out.println("vector: " + vector); 
        System.out.println("--------------------------------------------------");
    }
    
    private static int quantity() {
        Scanner scanner = new Scanner(System.in);
        int quantity;
        while(true) {
            System.out.println("Введите количество случайных чисел, которое нужно сгненерироввать:");
            String userInput = scanner.nextLine();
            try {
                quantity = Integer.parseInt(userInput);
                if(quantity <= 0) {
                    System.err.println("Количество чисел должно быть больше нуля!");
                    continue;
                }
                break;
            } catch(NumberFormatException e) {
                System.err.println("Нужно было ввести число!");
            }
        }
        return quantity;
    }
    
    public static void battleOfVectorAndArrayList() {
        int counterOfArrayListWins = 0;
        for(int i = 0; i < 10000; i++)  {
            /*
            Это очень важная строка. Дело в том, что во время 
            выполнения программы JVM занимается своими фоновыми
            процессами (например, сборкой мусора) и это фальсифицирует результаты.
            Поэтому лучше вызвать System.gc(), чтобы неиспользуемые объекты были
            удалены из памяти заранее.
            Кроме того, лучше запускать этот код с флагами -Xbatch и -Xcomp для
            уменьшения фоновых "занятий" JVM. Так же рекомендуется
            закрыть все остальные программы (они тоже могут испортить результаты тестов)
            */
            System.gc(); 
            long time = getWinOfArrayList();
            if(time > 0) counterOfArrayListWins++;
        }
        System.out.println("ArrayList выиграл " + counterOfArrayListWins + " раз");
    }
    
    private static List<String> list1 = Arrays.asList("Python", "JavaScript", "HTML", "CSS");
    private static List<String> list2 = Arrays.asList("", null);
    private static List<String> list3 = Arrays.asList("Java", "C++");
    
    private static long getWinOfArrayList() {
        long startTime = System.nanoTime();
        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("C++");
        vector.add(1, "C");
        vector.add(null);
        vector.add("");
        vector.addAll(list1);
        vector.removeLast();
        vector.removeAll(list2);
        vector.retainAll(list3);
        long endTime = System.nanoTime();
        long vectorTime = endTime - startTime;
        startTime = System.nanoTime();
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C++");
        arrayList.add(1, "C");
        arrayList.add(null);
        arrayList.add("");
        arrayList.addAll(list1);
        arrayList.removeLast();
        arrayList.removeAll(list2);
        arrayList.retainAll(list3);
        endTime = System.nanoTime();
        long arrayListTime = endTime - startTime;
        return vectorTime - arrayListTime;
    }
}