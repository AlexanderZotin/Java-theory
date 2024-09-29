package theory.exceptions;

import java.util.Scanner;
import java.io.FileNotFoundException;

/*
Здесь я ещё немного скажу о блоке catch. 
А именно, о том, что блоков catch может быть несколько
и о такой вещи, как multicatching.
*/
public class AboutTheCatchBlock {

    public static void main (String [] args) {
        try{
            someMethod(askUser());
        } catch (FileNotFoundException e){ //В первом блоке catch ловится исключение FileNotFoundException
            System.err.println("Ошибка! Файл не найден!");
            e.printStackTrace(); //Выводим стектрейс 
        } catch (InterruptedException e){ //А во втором - исключение InterruptedException
            System.err.println("Произошло исключение InterruptedException");
            e.printStackTrace(); //Выводим стектрейс 
        }
     
        System.out.println();
        System.out.println("Давайте выбросим исключение ещё раз, чтобы узнать про multicatching!");
        try{
            someMethod(askUser());
        } catch(FileNotFoundException | InterruptedException e) { 
            /*
            Это и есть multicatching!
            То есть обработка нескольких исключекний в одном блоке catch!
            Кстати, эта функция была добавлена лишь в java 7.
            */
            System.err.println("Произошло иcключение: ");
            e.printStackTrace(); //Выводим стектрейс 
        }
    }
  
    public static int askUser(){
        System.out.println();
        System.out.println("Выберите, какую операцию произвести: ");
        System.out.println("1 - выбросить исключение FileNotFoundException;");
        System.out.println("2 - выбросить исключение InterruptedException;");
        System.out.println("Любой другой символ - выход из программы.");
        System.out.println();
     
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try{
            int number = Integer.parseInt(userInput); //Преобразуем строку в число
            if(number == 1 || number == 2){
                return number;
            } else {
                System.exit(0); //Если ввели не 1 и не 2, то выходим из программы
            }  
        } catch(NumberFormatException e){ //Если ввели буквы...
            System.exit(0); //То выходим из программы
        }
        //Эта строка не будет выполнена, но без неё компилятор ругается,
        //что нужно вернуть какое-то значение.
        return 0;
    }
  
    public static void someMethod(int numberOfException) throws FileNotFoundException, InterruptedException {
        if(numberOfException == 1){
            throw new FileNotFoundException("не удалось найти указанный файл"); //Возбуждаем исключение =)
        } else {
            throw new InterruptedException("что-то случилось"); //Возбуждаем исключение =)
        }
    } 
  
}