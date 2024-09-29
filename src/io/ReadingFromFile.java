package theory.io;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
Иногда нужно получать данные из какого-то текстового файла.
Проще всего это сделать с помощью класса... java.util.Scanner!
Scanner'у не важно, читать ли данные с консоли или из файла.
Только вот чтение из файла посложнее, чем чтение с консоли.
*/
public class ReadingFromFile {

    public static void main (String [] args) throws FileNotFoundException {
        System.out.println();
        System.out.println("Выполняется метод readingFile():");
        readingFile();
        System.out.println();
        System.out.println("Выполняется метод readingSymbols():");
        readingSymbols();
    }
  
    //throws FileNotFoundException - Указываем, что метод может выбросить исключение(об исключениях попозже)
    public static void readingFile() throws FileNotFoundException { 
        //В разных ОС слеши в пути к файлу разные. Чтобы программа была кроссплатформенна,
        //нужно дать java-машине самой подставить нужные слеши.
        String separator = File.separator;      
        //Это путь к файлу. 
        String path = "src" + separator + "io" + separator + "test1.txt";
     
        File file = new File(path); //Создаём объект класса File
        Scanner scanner = new Scanner(file);
     
        System.out.println("Выводится текст файла " + path + " на экран:");
        while(scanner.hasNextLine()){ //Этот цикл будет выполняться, пока в файле есть строки.
            System.out.println(scanner.nextLine()); //Выводим текущую строку на экран.
        }
        scanner.close();
    }
  
    public static void readingSymbols() throws FileNotFoundException { 
        String separator = File.separator;
        String path = "src" + separator + "io" + separator + "test2.txt";
     
        File file = new File(path); 
        Scanner scanner = new Scanner(file);
      
        //С помощью метода split(String) убираем все пробелы из строки
        String[] words = scanner.nextLine().split("-");
        for(String currentString : words){
            System.out.println(currentString);
        }
    }
  
}