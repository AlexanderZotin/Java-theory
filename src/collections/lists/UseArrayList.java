package theory.collections.lists;
/*
ArrayList - это класс из пакета java.util. 
Он позволяет создавать динамический массив:
в такой массив всегда можно добавить любое количество элементов 
или даже удалить несколько. К тому же данный класс 
содержит некоторые удобные методы.
*/
import java.util.ArrayList;
import java.util.List;

public class UseArrayList {

    public static void main (String [] args) {
        List<Integer> myList = new ArrayList<>();
        /*Создаём объект класса ArrayList и ссылаем его на интерфейс List.
        В параметрах указываем тип данных. Важно! В листе не могут лежать примитивы!*/
     
        System.out.println("Выводится ArrayList myList на экран:");
        for(int i = 0; i < 10; i++){
            myList.add(i); //Этот метод добавляет индекс в ArrayList
            System.out.println("Выводится индекс " + i + ": " + i);
        }
     
        myList.remove(9); //Так можно удалять индекс ArrayList'а
        myList.remove(8);
     
        //Для вывода на экран можно воспользоваться и циклом foreach:
        System.out.println("Выводится ArrayList myList на экран:");
        for(Integer i: myList){
            System.out.println("Выводится индекс " + i + ": " + i);
        }
        //Но самый простой способ - сделать вот так:
        System.out.println("Выводиться ArrayList myList на экран: " + myList);
     
        //А так можно получить конкретный индекс
        int number = myList.get(5);
        System.out.println("Выводится переменная number на экран: " + number);
     
       //И последнее - вот как можно узнать длину ArrayList 'а:
       System.out.println();
       System.out.println("Длинна myList: " + myList.size());
    }
}