package theory.begin;

/*
Довольно часто нужно, чтобы пользователь ввёл в консоль какие-либо данные.
Считать их можно с помощью класса Scanner. 
*/
import java.util.Scanner; //Импортируем класс Scanner из пакета java.util 

public class ReadingWithScanner{

    public static void main(String[] args) {
        System.out.println("Введите что-нибудь: "); //Просим пользователя что-нибудь ввести
	 
        Scanner scanner = new Scanner(System.in,"Cp866"); 
	    /*Создаём объект класса Scanner и передаём информацию о том,
	    что он будет делать, указываем кодировку символов
	    (если не указать, русские буквы неправильно считаются)*/
	 
        System.out.println("Вы ввели: " + scanner.nextLine()); 
	    //Выводим на экран то, что считал сканер с помощью метода nextLine()
    }
}