package theory.classes.nested;

import java.util.Scanner;
/*
Анонимные классы удобно использовать, чтобы переопределить метод
из интерфейса или супер класса. Анонимные классы видны только внутри того метода,
в котором объявлены, имеют доступ к полям внешнего класса и 
используются(как правило) лишь один раз.
*/
public class AnonumClasses {

    public static void main (String [] args) { 
	    Scanner scanner = new Scanner(System.in);
	 
        /*Кажется, что создаётся объект интерфейса, но это не так. 
	    На самом деле создаётся безымянный(анонимный) класс!*/
        Printing printing = new Printing(){  
		    //Переопределяем методы
		    @Override
		    public void printString(){
		        System.out.println("Введите строку: ");
			    System.out.println(scanner.nextLine());
		    }
		   
		    @Override 
		    public void printNumber(){
		        System.out.println("Введите число: ");
			    System.out.println(scanner.nextInt());
		    }
		   
	    }; //Не забываем про точку с запятой
	 
	    //А вот так вызываем методы из анонимного класса:
	    printing.printString();
	    printing.printNumber();
	    scanner.close(); 
    }
 
}