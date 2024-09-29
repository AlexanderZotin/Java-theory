package theory.exceptions;

import java.util.Scanner;
import java.io.IOException;

/*
Java даёт возможность самим возбуждать не только те исключения, которые находятся
в java-библиотеках, но и те исключения, которые вы сами создали!

Возбуждение исключения даёт важное преимущество:
если метод возбуждает исключение и выбрасывает его, то
при вызовах этого метода это исключение можно по-разному обрабатывать.
А если просто произвести какие-то действия в if-else,
метод не будет универсален: например на некорректный ввод
пользователя программа будет реагировать всегда одинаково.
*/
public class CreatingYourOwnException {

    public static void main (String [] args) {
        System.out.println();
        System.out.println("Вызывается метод inputNumber():");
	    try{
	        inputNumber();
        } catch (IOException exception){
	        System.err.println(exception.getMessage());
	    }
        try{
	        System.out.println();
	        System.out.println("Вызывается метод inputPassword(): ");
	        inputPassword();	 
	    } catch(IncorrectPasswordException exception){
	        System.err.println(exception.getMessage());
	    }
    }

    public static void inputNumber() throws IOException { 
        //В сигнатуре метода указываем, что метод может выкинуть исключение
	 
        Scanner scanner = new Scanner(System.in);
	    System.out.println("Введите положительное число:");
	    int number = scanner.nextInt();
        if(number < 0){
	        //Выбрасываем java-исключение из пакета java.io
	        throw new IOException("Введено отрицательное число");
	    } else {
	        System.out.println("Спасибо, что ввели правильное число!");
	    }
    }

    public static void inputPassword() throws IncorrectPasswordException {
        Scanner scanner = new Scanner(System.in);
	    System.out.println("Введите ваш пароль: ");
        String password = scanner.nextLine();
	    if(password.equals("12345")){
            System.out.println("Ура! Вы ввели верный пароль!");	 
	    } else {
	        //Выбрасываем собственное исключение с сообщением.
	        throw new IncorrectPasswordException("Пользователь ввёл неверный пароль");
	    }
    }

}