package  theory.exceptions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
Исключения можно не только "обрабатывать", но и "выбрасывать".
Выбросить исключение из метода - это фактически указать, что обрабатывать 
его программа должна в том месте, откуда этот метод будет вызываться.
Вообще, так можно делать лишь в тех случаях, когда исключения скорее всего не произойдёт.
Правильнее всего обрабатывать исключение там, где оно может возникнуть.
Механизм выбрасывания исключений всё равно нужен,
но обычно он используется для "возбуждения" исключения с
помощью ключевого слова throw (а не throws!). Но об этом попозже =).
*/
public class ThrowingOfExceptions {

    public static void main (String [] args){
        System.out.println();
        System.out.println("Вызывается метод readFile(): ");
        ThrowingOfExceptions throwingOfExceptions = new ThrowingOfExceptions();
        /*
        При вызове метода я обработал исключение. На самом деле,
        его можно было выбросить ещё раз.
        И тогда бы исключение можно было бы не обрабатывать вообще,
        ведь метод main() вызывается java-машиной.
        Но тогда в случае, если исключение всё-таки произойдёт,
        пользователь увидит "страшный" стектрейс =).
        */
        try{
            throwingOfExceptions.readFile();
        } catch(FileNotFoundException exception){
            System.err.println("Ошибка! Файл не найден!");
        }  
    }
  
    public void readFile() throws FileNotFoundException { //Выбрасываем исключение
        String separator = File.separator;
        System.out.println();
        File file = new File("D:" + separator + "codes" + separator + "theory" + separator + 
        "exceptions" + separator + "test.txt");
     
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
 
}
