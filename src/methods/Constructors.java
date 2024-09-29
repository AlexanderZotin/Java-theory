package theory.methods;

/*
Конструктор - это особый метод, который вызывается при создании объекта класса
*/
public class Constructors {

    public static void main (String [] args) {
        Variables variables1 = new Variables(); //При создании этого объекта вызовется конструктор с пустыми параметрами
        System.out.println("Значение строки: " + variables1.getString());
        System.out.println("Значение числа: " + variables1.getNumber());
        Variables variables2 = new Variables("Строка",5); //При создании этого объекта вызовется конструктор, принимающий на вход строку и число
        System.out.println("Значение строки: " + variables2.getString());
        System.out.println("Значение числа: " + variables2.getNumber());
    }
}