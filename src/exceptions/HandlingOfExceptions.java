package theory.exceptions;

/*
Исключения - это некоторые ситуации, которые не должны происходить 
при нормальном исполнении программы. Но такие ситуации нельзя 
разрешить на стадии компиляции. 

Яркий пример (он будет рассмотрен ниже):
программа должна читать файл, а файла не существует! В таких случаях
приходят на помощь исключения, которые обрабатывает программист,
то есть говорит java-машине, что делать, если исключение произошло.

Есть два вида исключений: 
1) проверяемые(на стадии компиляции видно, что они могут произойти и их обрабатывать обязательно);
2) непроверяемые(на стадии компиляции не ясно, что они могут произойти и их обрабатывать необязательно); 

Но сейчас - про обработку исключений в принципе, а не про их проверяемость =).

Ещё важно сказать, что исключения можно "выбрасывать", просто добавляя в сигнатуру метода,
в котором оно может произойти "throws название_исключения". Но В таком случае есть свои 
нюансы. Главное, что при таком подходе пользователь просто увидит "страшное"
сообщение об неведомой ошибке =), а программа может вообще прекратить работу,
что не есть хорошо. Но об выбрасывании исключений попозже.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HandlingOfExceptions {

    public static void main (String [] args) {
        System.out.println();
        System.out.println("Вызывается метод readFile1(): ");
        HandlingOfExceptions handlingOfExceptions = new HandlingOfExceptions();
        handlingOfExceptions.readFile();
    }
 
    public void readFile(){
        String separator = File.separator;
        System.out.println();
        File file = new File("D:" + separator + "codes" + separator + "theory" + separator + 
        "exceptions" + separator + "test.txt");

        try{
            /*
            В блок try помещается тот код, который может вызвать исключение.
            Если оно произошло, то программа автоматически переходит в блок catch, даже
            не заканчивая выполнять блок try.
            */
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            System.out.println("Чтение файла прошло успешно!");
            scanner.close();
        } catch(FileNotFoundException exception){
            /*
            В блок catch программа перепрыгивает, если в блоке try произошло исключение.
            Если же нет, то блок catch не выполнится.
            */
            System.err.println("Ошибка! Файл не найден!");
        } finally {
            /*
            Блок finally не обязателен, в отличие от блока try и блока catch.
            Выполняется вне зависимости от того, произошло исключение или нет.
            */
            System.out.println("Исполнение метода закончено!");
        }
    }
  
}