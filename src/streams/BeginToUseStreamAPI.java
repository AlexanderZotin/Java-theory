package theory.streams;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
Stream API появилось в той же версии языка, что и лямбды, то есть в восьмой.
Эта функция языка позволяет писать быстрый и мощный код для работы с коллекциями и массивами.
Stream - это поток данных, который получается из коллекции/массива.
Как его получить? Если речь идёт о коллекции, то с помощью метода stream(),
если нужно работать с массивом, то приходит на помощь утилитарный класс
java.util.Arrays со static-методами stream().
*/
public class BeginToUseStreamAPI {

    public static void main(String[] args) {
        //Пример на работу со списком
        List<String> listOfStrings = listOfStrings("строку");
        System.out.println("Вот был у нас список строк: " + listOfStrings);
        List<char[]> listOfCharArrays = listOfStrings.stream().map(arg -> arg.toCharArray())
                .collect(Collectors.toList());
        /*
        А без Stream API пришлось бы писать это:
        List<char> listOfCharArrays = new ArrayList<>();
        for(int i = 0; i < listOfStrings.size(); i++) {
            listOfCharArrays.add(listOfStrings.get(i).toCharArray());
        }
        */
        System.out.println("А сейчас список массивов. Да, конечно данные видно не будет :)\n" 
                + listOfCharArrays);
        System.out.println("А сейчас будет... ");
        listOfCharArrays.forEach(arg -> System.out.println(Arrays.toString(arg)));
        
        //Пример на работу с массивом
        Integer[] array = arrayOfIntegers();
        Integer[] result = Arrays.stream(array).map(arg -> arg * 2)
                .toArray(arg -> new Integer[arg]);
        System.out.println("Было: " + Arrays.toString(array));
        System.out.println("Стало: " + Arrays.toString(result));
    }

    private static List<String> listOfStrings(String whatToInput) {
        Scanner scanner = new Scanner(System.in, "Cp866");
        int count;
        while(true) {
            System.out.println("Введите количество элементов:");
            count = scanner.nextInt();
            if(count > 0) break;
            else System.err.println("Количество элементов списка должно быть положительным!");
        }
        scanner.nextLine(); //Это обязательно!!!
        List<String> list = new ArrayList<>();
        String requestForInput = "Введите " + whatToInput + " №";
        for(int i = 1; i <= count; i++) { 
            System.out.println(requestForInput + i);
            list.add(scanner.nextLine());
        }
        return list;
    }
    
    private static Integer[] arrayOfIntegers() {
        return listOfStrings("число").stream().map(Integer::parseInt).toArray(Integer[]::new);
        /*
        А без Stream API пришлось бы писать это:
        List<String> listOfStrings = listOfStrings();
        List<Integer> listOfIntegers = new ArrayList<>();
        for(int i = 0; i < listOfStrings.size(); i++) {
            listOfIntegers.add(Integer.parseInt(listOfStrings.get(i)));
        }
        return listOfIntegers;
        */
    }
}
