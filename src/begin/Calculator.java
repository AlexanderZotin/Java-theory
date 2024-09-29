package theory.begin;

import java.util.Scanner;

/*
Пример с использованием класса Scanner и математических операторов.
*/
public class Calculator {

    public static void main (String [] args) {
        //Объявляем переменные, которые будут использованы во время работы программы
        double number1, number2;
        double resultOfAddition, resultOfSubtraction, resultOfMultiplication, resultOfDivision, resultOfDivisionByModulus;
	 
	    //Просим пользователя ввести два числа и считываем введённое
        System.out.println("Введите первое число: ");
        Scanner scanner = new Scanner(System.in);
        number1 = scanner.nextDouble();
        System.out.println("Введите второе число: ");
        number2 = scanner.nextDouble();
	 
	    //Производим вычисления
        resultOfAddition = number1 + number2;
        resultOfSubtraction = number1 - number2;
        resultOfMultiplication = number1 * number2;
        resultOfDivision = number1 / number2;
        resultOfDivisionByModulus = number1 % number2; 
	 
	    //Выводим результаты на экран
        System.out.println(number1 +" + "+ number2 +" = " + resultOfAddition);
        System.out.println(number1 +" - "+ number2 +" = " + resultOfSubtraction);
        System.out.println(number1 +" * "+ number2 +" = " + resultOfMultiplication);
        System.out.println(number1 +" / "+ number2 +" = " + resultOfDivision);
        System.out.println("Остаток деления числа " + number1 + " на число " + number2 +" = " + resultOfDivisionByModulus);
    }
}