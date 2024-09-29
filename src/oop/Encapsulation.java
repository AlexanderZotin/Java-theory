package theory.oop;

/*
Инкапсуляция - один из трёх основных принципов ООП.
Инкапсуляция - это сокрытие данных в пределах класса 
и доступ к ним только через методы класса, а не напрямую.
*/

import java.util.Scanner;

public class Encapsulation {

    public static void main (String [] args) {
        //Создаём объекты
        Variables variables = new Variables(); //Объект нашего класса Variables
        Scanner scanner = new Scanner(System.in); //Объект класса Scanner из пакета java.util
     
        //Получаем от пользователя число
        System.out.println("Введите какую-нибудь непустую строку:"); //Просим пользователя ввести непустую строку
        variables.setString(scanner.nextLine()); //Вызываем для строки метод setString (сеттер), а в параметрах указываем строку, которую считает сканер
     
        //Получаем от пользователя строку
        System.out.println("Введите какое-нибудь положительное число: "); //Просим пользователя ввести положительное число
        variables.setNumber(scanner.nextInt()); //Вызываем для числа метод setNumber (сеттер), а в параметрах указываем число, которое считает сканер
     
        //Выводим строку и число на экран
        System.out.println("Выводим значение числа на экран: " + variables.getNumber()); //метод getNumber() возвращает число
        System.out.println("Выводим значение строки на экран: " + variables.getString()); //метод getString() возвращает строку 
    }
}