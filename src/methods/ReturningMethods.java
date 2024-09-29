package theory.methods;

/*
Некоторые методы нужны для того, что бы произвести какой-то расчёт и вернуть значение 
*/

import java.util.Scanner;

public class ReturningMethods {

    public static void main (String [] args) {
        Return returnNum = new Return(); //Создаём объект returnNumber1 со ссылкой на класс Return
	    //Получаем значения из методов
	    System.out.println("Введите первое число: "); //Просим пользователя ввести первое число
        double number1 =  returnNum.returnNumber();
        System.out.println("Введите второе число: "); //Просим пользователя ввести второе число	 
        double number2 =  returnNum.returnNumber(); 
	 
	    //Производим расчёты
	    double resultOfAddition = number1 + number2;
        double resultOfSubtraction = number1 - number2;
        double resultOfMultiplication = number1 * number2;
        double resultOfDivision = number1 / number2;
        double resultOfDivisionByModulus = number1 % number2; 
	 
        //Выводим результаты на экран
        System.out.println(number1 +" + "+ number2 +" = " + resultOfAddition);
        System.out.println(number1 +" - "+ number2 +" = " + resultOfSubtraction);
        System.out.println(number1 +" * "+ number2 +" = " + resultOfMultiplication);
        System.out.println(number1 +" / "+ number2 +" = " + resultOfDivision);
        System.out.println("Остаток деления числа " + number1 + " на число " + number2 +" = " + resultOfDivisionByModulus);
    }
}

class Return {

    double returnNumber() { //Создаём метод, возвращающий тип данных double
        Scanner scanner = new Scanner(System.in); //Создаём объект класса Scanner
        return scanner.nextDouble(); //Завершаем метод и возвращаем значение
    }
  
}