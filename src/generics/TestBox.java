package theory.generics;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TestBox {

    public static void main(String [] args) { 
        printAllDataAboutBox();
        checkHowWorkAddingMethods();
        checkHowWorkRemovingMethods();
        checkHowWorkEqualsAndCompareToMethods();
        checkHowToWorkToArrayMethods();
        tryIterator();
        tryPassiveIteratorMethods();
    }

    public static void printAllDataAboutBox() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Проверяем работу методов toString(), size(), isEmpty(), contains и containsAll():");
        Box<Integer> box = new Box<>();
        box.add(1);
        box.add(2);
        box.add(666);
        System.out.println("Коробка: " + box);
        System.out.println("Размер: " + box.size());
        System.out.println("Пустая? " + box.isEmpty());
        System.out.println("Есть 1? " + box.contains(1));
        System.out.println("Есть 99? " + box.contains(99));
        System.out.println("Есть 1 и 2? " + box.containsAll(Arrays.asList(1, 2)));
        System.out.println("Есть 1 и 3? " + box.containsAll(Arrays.asList(1, 3)));
        System.out.println("-------------------------------------------------------");
    }

    public static void checkHowWorkAddingMethods() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Проверяем работу методов add() и addAll():");
        Box<Integer> box = new Box<>();
        System.out.println("Коробка: " + box);
        //------------------------ Метод add() ------------------------
        box.add(1);
        box.add(2);
        box.add(null);
        box.add(-6);
        System.out.println("Пытались добавить поочерёдно: [1, 2, null, -6]. В итоге: " + box);
        //------------------------ Метод addAll() ------------------------
        box.addAll(new ArrayList<>(Arrays.asList(-4, 4, 56)));
        System.out.println("Пытались добавить сразу: [-4, 4, 56]. В итоге: " + box);
        box.addAll(new ArrayList<>(Arrays.asList(null, 4, null)));
        System.out.println("Пытались добавить сразу: [null, 4, null]. В итоге: " + box);
        box.addAll(new ArrayList<>(Arrays.asList(null, null, null)));
        System.out.println("Пытались добавить сразу: [null, null, null]. В итоге: " + box);
        box.addAll(new Box<>());
        System.out.println("Пытались добавить пустой список. В итоге: " + box);
        box.addAll(null);
        System.out.println("Пытались добавить null. В итоге: " + box);
        Box<Integer> someBox = new Box<>();
        someBox.add(1);
        someBox.add(2);
        someBox.add(58);
        box.addAll(someBox);
        System.out.println("Пытались добавить сразу: " + someBox + ". В итоге: " + box);
        System.out.println("-------------------------------------------------------");
    }

    public static void checkHowWorkRemovingMethods() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Проверяем работу методов remove, removeAll() и retainAll():");
        Box<String> box = new Box<>();
        box.add("Ёжик");
        box.add("Пёс Собачий");
        box.add("Ёжик");
        box.add("Ыыы");
        box.add("Ыыы");
        box.add("Икс");
        box.add("Тараканы");
        box.add("12345");
        box.add("qwerty");
        box.add("йцукен");
        System.out.println("Коробка: " + box);
        //------------------------ Метод remove() ------------------------
        box.remove("Икс");
        System.out.println("После box.remove(\"Икс\"): " + box);
        box.remove("Ёжик");
        System.out.println("После box.remove(\"Ёжик\"): " + box);
        box.remove("54321");
        System.out.println("После box.remove(\"54321\"): " + box);
        //------------------------ Метод removeAll() ------------------------
        box.removeAll(Arrays.asList("Ыыы", "ddd", "йцукен"));
        System.out.println("После box.removeAll(Arrays.asList(\"Ыыы\", \"ddd\", \"йцукен\")): " + box);
        box.removeAll(new ArrayList<String>());
        System.out.println("После box.removeAll(Arrays.asList()): " + box);
        box.removeAll(Arrays.<String>asList(null, null, null));
        System.out.println("После box.removeAll(Arrays.asList(null, null, null)): " + box);
        //------------------------ Метод retainAll() ------------------------
        Box<String> someBox = new Box<>();
        someBox.add("Пёс Собачий");
        someBox.add("Тараканы");
        someBox.add("Ватя");
        box.retainAll(someBox);
        System.out.println("После box.retainAll(someBox): " + box);
        System.out.println("-------------------------------------------------------");
    }

    public static void checkHowWorkEqualsAndCompareToMethods() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Проверяем работу методов equals() и compareTo():");
        List<Box<String>> boxesWithStrings = new ArrayList<>();
        boxesWithStrings.add(new Box<>(Arrays.asList("Привет", "Пока")));
        boxesWithStrings.add(new Box<>(Arrays.asList("Привет", "Пока")));
        boxesWithStrings.add(new Box<>(Arrays.asList("Привет", "Tschus!")));
        boxesWithStrings.add(new Box<>(Arrays.asList("Привет", "Пока", "Пока")));
        boxesWithStrings.add(new Box<>());
        boxesWithStrings.add(new Box<>());
        startTestingOfComparing(boxesWithStrings);

        List<Box<Object>> boxesWithObjects = new ArrayList<>();
        for(int i = 0; i < 5; i++) boxesWithObjects.add(new Box<>(Arrays.asList(new Object(), new Object())));
        startTestingOfComparing(boxesWithObjects);
        System.out.println("-------------------------------------------------------");
    }

    private static <T> void startTestingOfComparing(List<Box<T>> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            System.out.println("Коробка " + list.get(i) + " больше коробки " +
                    list.get(i + 1) + "? " + list.get(i).compareTo(list.get(i + 1)));
            System.out.println("Коробка " + list.get(i) + " равна коробке " +
                    list.get(i + 1) + "? " + list.get(i).equals(list.get(i + 1)));
        }
    }

    public static void checkHowToWorkToArrayMethods() {
        System.out.println("-------------------------------------------------------");
        Box<Integer> box = new Box<>();
        box.add(1);
        box.add(2);
        System.out.println("Проверяем работу методов toArray():");
        Object[] array1 = box.toArray();
        Integer[] array2 = box.<Integer>toArray(new Integer[0]);
        Integer[] manyNums = new Integer[50];
        Arrays.fill(manyNums, 5);
        Integer[] array3 = box.<Integer>toArray(manyNums);
        System.out.println("Из объектов: " + Arrays.toString(array1));
        System.out.println("Из чисел (в параметрах: пустой массив): " + Arrays.toString(array2));
        System.out.println("Из чисел (в параметрах: массив больше, чем надо): " + Arrays.toString(array3));
        System.out.println("-------------------------------------------------------");
    }

    public static void tryIterator() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Проверяем работу итератора:");
        Box<Integer> box = new Box<>();
        box.add(0);
        box.add(-5);
        box.add(7);
        box.add(101);
        box.add(99);
        Iterator<Integer> iterator = box.iterator();
        while(iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("Текущее значение: " + i);
            if(i > 0) {
               iterator.remove();
               System.out.println("Текущее значение (" + i + ") удалено, так как оно больше нуля.");
            }
        }
        System.out.println("Итого: " + box);
        System.out.println("-------------------------------------------------------");
    }

    public static void tryPassiveIteratorMethods() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Проверяем работу методов из интерфейса PassiveIterator:");
        Box<String> box = new Box<>();
        box.add("Яблоко");
        box.add("Тараканы");
        box.add("Бананчик");
        box.add("Бананчик-тараканчик есть яблоко");
        box.add("Пёс Собачий + Псёнок Собачий = любовь");
        box.add("Пёс Собачий ест дракона");
        box.setCurrentElement(box.size() - 1);
        while(true) {
            System.out.println
                    ("Текущий элемент: " + box.getCurrentElement() + "; его индекс: " +
                    box.getCurrentIndex());
            if(box.canGoNext()) box.goNext();
            else break;
        }
        System.out.println("Теперь в обратном порядке:");
        while(box.canGoBack()) {
            System.out.println
                    ("Текущий элемент: " + box.getCurrentElement() + "; его индекс: " +
                    box.getCurrentIndex());
            box.goBack();
        }
        box.setCurrentElement(3);
        System.out.println
                ("Элемент: " + box.getCurrentElement() + "; его индекс: " +
                box.getCurrentIndex());
        System.out.println("-------------------------------------------------------");
    }
}
