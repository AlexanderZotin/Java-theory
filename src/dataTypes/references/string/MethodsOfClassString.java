package theory.dataTypes.references.string;

/*
Класс String используется очень часто. И неплохо бы знать хотя бы основные его методы.
Важно! Класс String неизменяем!
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MethodsOfClassString {

    public static void main(String [] args) {
        workingWithCaseOfString();
        stringFromArrayOfSymbols();
        dataTypesToString();
        getIndexOfSomeSymbol();
        collectionToString();
        deleteLastSymbol();
        getSymbolsFrom3To5();
        arrayFromString();
    }

    private static void stringFromArrayOfSymbols(){
        char[] symbols = new char[]{'a', '0', '{', '}'};
        String someString = new String(symbols);
        System.out.println("Строку создали из массива символов: " + someString + "\n");
    }
    
    private static void workingWithCaseOfString(){
        String hello = "Привет";
        System.out.println("Строка: " + hello);
        System.out.println("Длинна строки в символах: " + hello.length());
        System.out.println("Строка в верхнем регистре: " + hello.toUpperCase());
        System.out.println("Строка в нижнем регистре: " + hello.toLowerCase() + "\n");
        
        System.out.println("Сравнение строк без учёта регистра: " + hello.equalsIgnoreCase(hello.toLowerCase()) + "\n");
    }
    
    private static void dataTypesToString(){
        //Получаем из примитивов и объектов строку:
        String one = String.valueOf(1);
        String numberWithFloatingPoint = String.valueOf(1.1);
        String isTrue = String.valueOf(true);
        String stringWithObject = String.valueOf(new Object());
        System.out.println("Строка one: " + one);
        System.out.println("Строка numberWithFloatingPoint: " + numberWithFloatingPoint);
        System.out.println("Строка isTrue: " + isTrue);
        System.out.println("Строка stringWithObject: " + stringWithObject + "\n");
    }
    
    private static void getIndexOfSomeSymbol(){
        String java = "Java";
        System.out.println("Строка: " + java);
        System.out.println("Индекс первого символа J: " + java.indexOf('J'));
        System.out.println("Индекс первого символа a: " + java.indexOf('a'));
        System.out.println("Индекс последнего символа a: " + java.lastIndexOf('a') + "\n");
    }
    
    private static void collectionToString(){
        /*
        А теперь создаём строку из коллекции. Да не просто создаём,
        да ещё и элементы запятыми разделяем!
        */
        List<String> oridinalNumbers = new ArrayList<>(Arrays.asList("номер 1", "номер 2", "номер 3"));
        System.out.println("Список oridinalNumbers: ");
        for(String currentString : oridinalNumbers) {
            System.out.println(currentString);
        }
        String allOridinalNumbersInOneString = String.join(", ", oridinalNumbers); //Первый параметр - разделитель.
        System.out.println("Единая строка: " + allOridinalNumbersInOneString + "\n");  
    }
    
    private static void deleteLastSymbol(){
        String someString = "12345";
        System.out.println("Исходная строка: " + someString);
        System.out.println("Строка без последнего символа: " + someString.substring(0, someString.length() - 1) + "\n");
    }
    
    private static void getSymbolsFrom3To5(){
        String someString = "0123456789";
        System.out.println("Исходная строка: " + someString);
        /*
        Первый символ включительно, а последний - нет. И не стоит забывать, что 
        первый индекс - 0!
        */
        System.out.println("Символы с 3 до 5: " + someString.substring(3, 6) + "\n");
    }
    
    public static void arrayFromString(){
        String colors = "белый, красный, чёрный, зелёный";
        System.out.println("Исходная строка: " + colors);
        String[] allColors = colors.split(", ");
        System.out.println("Выводится массив на экран: ");
        for(String currentString : allColors){
            System.out.println(currentString);
        }
    }
    
}
