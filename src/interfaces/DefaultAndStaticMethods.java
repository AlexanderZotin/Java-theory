package theory.interfaces;

import java.util.Scanner;
/*
В java 8 появилось возможность задавать методам в интерфейсе реализацию!
Для этого метод должен быть помечен ключевым словом static или ключевым словом default.
Подробней про такие методы в Numbers.java
*/
public class DefaultAndStaticMethods {

    public static void main(String [] args){ 
        System.out.println("----------------------------------------------------");
        int number = getNumber();
	    System.out.println("----------------------------------------------------");
        System.out.println("Вызывается статический метод из интерфейса: ");
	    number = Numbers.increaseNumber(number);
	    System.out.println("Выводиться увеличенное число: " + number);
	    System.out.println("----------------------------------------------------");
	    Class1 class1 = new Class1();
	    Class2 class2 = new Class2();
	    class1.printIncreasedNumber(number);
	    System.out.println("----------------------------------------------------");
	    class2.printIncreasedNumber(number);
	    System.out.println("----------------------------------------------------");
    }
  
    private static int getNumber(){
        Scanner scanner = new Scanner(System.in);
	    while(true){
	        System.out.println("Введите число:");
            String userInput = scanner.nextLine();
	        try {
	            return Integer.parseInt(userInput);
	        } catch(NumberFormatException e){
	            System.err.println("Вы ввели не число!");
	        }
	    }
    }
  
}
