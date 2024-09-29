package theory.io.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import static java.io.File.separator;
import java.util.Scanner;
/*
Сериализация - это запись текущего состояния объекта в файл. Часто
сериализация используется для того, чтобы сохранить данные о работе программы
после её завершения.
*/
public class Serialization {

    private static String path = "src" + separator +
            "io" + separator + "serialization" + separator + "test.ser"; 
    /*
    Файл может иметь любое расширение, но лучше использовать расширение .ser, 
    ибо это конвенционное расширение для сериализации.
    */

    public static void main (String [] args) {
        writeObjects(getObjectFromUser(), getObjectFromUser());
	    readObjects();
    }
  
    public static void writeObjects(Variables variables1, Variables variables2) {
	    ObjectOutputStream objectOutputStream = null;
	    try {
	        /*
		    Класс FileOutputStream нужен для записи последовательности байтов в файл.
		    С помощью него можно так же записывать картинки, даже видео... Ведь всё это последовательность байтов!
		    В конструктор нужно подавать путь к нужному файлу.
		    */
	        FileOutputStream fileOutputStream = new FileOutputStream(path); 
		 
		    /*
		    Класс ObjectOutputStream - вещь более конкретная, чем FileOutputStream, ведь
		    ObjectOutputStream записывает в файл только объекты. Но в конструктор
		    всё равно нужно подавать FileOutputStream.
		    */
		    objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(variables1); //Метод writeObject(object) записывает в файл объект 
		    objectOutputStream.writeObject(variables2);
		    System.out.println("Сериализация объектов прошла успешно!");
	    } catch(IOException e) {
            System.err.println("Ошибка! Не удалось сериализовать объекты!");
	    } finally {
		    if(objectOutputStream != null) {
			    try {
			        objectOutputStream.close();
				} catch(IOException e) {
				    System.err.println("Не удалось закрыть поток objectInputStream!");
				}
			}
		}
    }

    public static void readObjects() {
        /*
	    Десериализация объектов происходит похожим образом.
	    Только в названиях классов теперь не output, а input.
	    */
		ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
	        objectInputStream = new ObjectInputStream(fileInputStream);
		    /*
		    Метод readObject() читает объект из файла. Важно! Этот метод возвращает
		    объект класса java.lang.Object,  поэтому необходимо совершить нисходящее преобразование.
		    */
	        Variables variables1 = (Variables) objectInputStream.readObject();
	        Variables variables2 = (Variables) objectInputStream.readObject();
		    System.out.println("Десериализация объектов прошла успешно!");
		 
		   //В классе Variables переопределён метод toString(), поэтому можно просто вывести объекты на экран.
		    System.out.println("Выводятся данные об объекте variables1: " + variables1);
		    System.out.println("Выводятся данные об объекте variables2: " + variables2);
	    } catch(IOException e) {
	        System.err.println("Ошибка! Не удалось десерилизовать объекты!");
	    } catch(ClassNotFoundException e) { 
	        //Это исключение произойдёт, если в проекте не будет класса Variables
	        System.err.println("Ошибка! Класс Variables был удалён или перемещён!");
	    } finally {
		    if(objectInputStream != null) {
			    try {
			        objectInputStream.close();
				} catch(IOException e) {
				    System.err.println("Не удалось закрыть поток objectInputStream!");
				}
			}
		}
    }
  
    public static Variables getObjectFromUser() {
        Scanner scanner = new Scanner(System.in, "Cp866");
	    int number;
	    String string;
	 
        while(true) {
		    System.out.println("Введите число: ");
		    String userNumber = scanner.nextLine();
	        try {
		        number = Integer.parseInt(userNumber);
				break;
		    } catch(NumberFormatException e) {
			    System.out.println("Нужно ввести число, а вы ввели строку!");
		    }
		}
		do {
			System.out.println("Введите строку: ");
			string = scanner.nextLine();
			if(string.isEmpty()) System.out.println("Ошибка! Строка пустая!"); 
			else break;
		} while(true);
		return new Variables(number, string);
    }
  
}