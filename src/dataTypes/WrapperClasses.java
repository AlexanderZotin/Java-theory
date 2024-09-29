package theory.dataTypes;

/*
Классы-обёртки содержат методы, с помощью которых можно произвести
какие-либо действия над примитивами, константы, которые иногда бывают полезны.
Этих классов всего восемь:
Integer, Long, Byte, Short, Double, Float, Boolean, Character.

Преимущества таких классов:
1)Позволяют не нарушать принцип "все является объектом", благодаря чему числа,
символы и булевы значения true/false не выпадают из этой концепции.
2)Расширяют возможности работы с этими значениями, предоставляя удобные методы и поля.
3)Необходимы, когда какой-то метод может работать исключительно с объектами.

Минус:
Занимают много памяти.
*/
public class WrapperClasses {

    public static void main (String [] args) {
	    printMaxAndMinValue();
	    printSize();
	    stringToInt();
	    createObject();
	    primitiveAndWrapper();
    }

    public static void printMaxAndMinValue (){
	    //Используем статические константы из классов-обёрток
        System.out.println("\nМинимальное значение типа byte: " + Byte.MIN_VALUE);
        System.out.println("Максимальное значение типа byte: " + Byte.MAX_VALUE);
	    System.out.println("Минимальное значение типа short: " + Short.MIN_VALUE);
        System.out.println("Максимальное значение типа short: " + Short.MAX_VALUE);
        System.out.println("Минимальное значение типа int: " + Integer.MIN_VALUE);
        System.out.println("Максимальное значение типа int: " + Integer.MAX_VALUE);
	    System.out.println("Минимальное значение типа long: " + Long.MIN_VALUE);
        System.out.println("Максимальное значение типа long: " + Long.MAX_VALUE);
    }

    public static void printSize (){
	    //Используем статические константы из классов-обёрток
	    System.out.println("\nПеременная типа float занимает байтов: " + Float.BYTES);
	    System.out.println("Переменная типа double занимает байтов: " + Double.BYTES);
    }

    public static void stringToInt(){
	    //Используем статический метод parseInt(String) для преобразования строки в число
        String stringWithNumber = "5";
		int number = Integer.parseInt(stringWithNumber);
        System.out.println("\nВыводиться переменная number: " + number);
    }

    public static void createObject(){
	    Integer number1 = Integer.valueOf(5); //Можно делать так
	    Integer number2 = 12; //Но лучше вот так
	    Character character1 = Character.valueOf('x');
        Character character2 = 'y';
	    Boolean isTrue = Boolean.valueOf(true);
	    Boolean isFalse = false;
	    Double num1 = Double.valueOf(2.3);
	    Double num2 = 6.3;
     
        System.out.println("\nВыводиться переменная number1: " + number1);
	    System.out.println("Выводиться переменная number2: " + number2);
	    System.out.println("Выводиться переменная сharacter1: " +  character1);
	    System.out.println("Выводиться переменная сharacter2: " + character2);
	    System.out.println("Выводиться переменная isTrue: " + isTrue);
	    System.out.println("Выводиться переменная isFalse: " + isFalse);
	    System.out.println("Выводиться переменная num1: " + num1);
	    System.out.println("Выводиться переменная num2: " + num2); 
    }
   
    public static void primitiveAndWrapper(){
        //Примитивы и классы обёртки совместимы между собой:
        int i = 5;
	    Integer j = 3;
	    System.out.println("\nВыводиться старое значение переменной i (тип int): " + j);
	    System.out.println("Выводиться старое значение переменной j: (тип Integer)" + j);
	    i += j;
	    j += i;
	    System.out.println("Выводиться новое значение переменной i (тип int): " + j);
	    System.out.println("Выводиться новое значение переменной j: (тип Integer)" + j);
    } 
}
