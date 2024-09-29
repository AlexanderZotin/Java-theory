package theory.interfaces;

import java.util.Scanner;

public class Output1 implements Information { //Интерфейсы implements, а не extends!
/*
Важно! Класс может реализовывать сколько угодно интерфейсов!
А вот extends какой-то другой класс может только один!
*/

    @Override //Данная аннотация означает, что метод переопределяется
    public void printLine(){
        System.out.println("Введите что-нибудь: ");
        Scanner scanner = new Scanner(System.in,"Cp866");
	    System.out.println("Вы ввели: " + scanner.nextLine());
    }
  
    @Override
    public void printNumber(){
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in,"Cp866");
	    System.out.println("Вы ввели: " + scanner.nextInt()); 
    }

}