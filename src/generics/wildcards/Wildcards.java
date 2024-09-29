package theory.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    public static void main (String [] args) {
        System.out.println();
        //Создаём списки
        List<Thing> listOfThings = new ArrayList<>();
        listOfThings.add(new Thing("Зелёный"));
        listOfThings.add(new Thing("Жёлтый"));
     
        List<Ruler> listOfRulers = new ArrayList<>();
        listOfRulers.add(new Ruler(15));
        listOfRulers.add(new Ruler(30));
     
        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(5);
        listOfNumbers.add(12);
     
        List<Object> listOfObjects = new ArrayList<>();
        listOfObjects.add(new Object());
        listOfObjects.add(new Object());
     
        //Вызываем методы
        System.out.println("Вызывается метод test1: ");
        test1(listOfThings);
        test1(listOfRulers);
        test1(listOfNumbers);
        test1(listOfObjects);    
     
        System.out.println();
        System.out.println("Вызывается метод test2: ");
        test2(listOfNumbers);
     
        System.out.println();
        System.out.println("Вызывается метод test3: ");
        test3(listOfThings);
        test3(listOfRulers);
     
        System.out.println();
        System.out.println("Вызывается метод test4: ");
        test4(listOfThings);
        test4(listOfObjects);    
    }
  
    //Этот метод принимает список с чем угодно
    private static void test1(List<?> list) { 
        System.out.println(list);
    }
  
    //А этот метод принимает на вход список целых чисел (только Integer!)
    private static void test2(List<Integer> list) {
        System.out.println(list);
    } 
  
    /*
    Этот метод принимает на вход список с объектами класса Thing 
    или с объектами тех классов, которые унаследованы от Thing
    */
    private static void test3(List<? extends Thing> list) {
        System.out.println(list);
    }
  
    /*
    Этот метод принимает на вход список с объектами класса Thing 
    или с объектами тех классов,
    которые находятся выше по иерархии наследования относительно Thing
    */
    private static void test4(List<? super Thing> list) {
        System.out.println(list);
    }
  
}