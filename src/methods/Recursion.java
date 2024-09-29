package theory.methods;

/*
Рекурсия - это когда метод вызывает сам себя. Однако при рекурсии
может произойти StackOverFlowError, если вызов метода сам себя будет бесконечен.
Поэтому в рекурсивном методе обязательно должно быть условие выхода.
*/

import java.util.Scanner;

public class Recursion{

    public static void main(String [] args){ 
        Scanner scanner = new Scanner(System.in);
	    while(true){
	        System.out.println("Введите число от 1 до 20:");
		    String userInput = scanner.nextLine();
		    try{
		        int number = Integer.parseInt(userInput);
			    if(number > 20){
			        System.err.println("Число слишком большое!");
			        continue;
			    }
			    System.out.println("Результат: " + factorial(number));
			    break;
		    } catch(NumberFormatException e){
		        System.err.println("Введено не число или слишком большое число! Попытайтесь ещё раз!");
		    }
	    }
    }

    public static long factorial(int number){
        if(number == 1 || number == 0){ //Условие выхода
	        return 1;
	    }
	    if(number < 0){ 
	        throw new IllegalArgumentException("отрицательное число");
	    }
	    return number * factorial(number - 1); //Вызываем 
    }

}
