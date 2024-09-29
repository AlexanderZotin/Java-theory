package theory.interfaces;

/*
Интерфейс задаёт поведение, но не имеет реализации.
А все его поля - открытые статические константы.
*/
public class Interfaces {

    public static void main (String [] args) {
	    Output1 out1 = new Output1();
	    System.out.println();
	    System.out.println("Вызывается переопределённый метод printInformation из класса Output1:");
	    out1.printLine();
	    System.out.println("Вызывается переопределённый метод printNumber из класса Output1:");
	    out1.printNumber();
	 
	    Output2 out2 = new Output2();
	    System.out.println();
	    System.out.println("Вызывается переопределённый метод printInformation из класса Output2:");
	    out2.printLine();
	    System.out.println("Вызывается переопределённый метод printNumber из класса Output2:");
	    out2.printNumber();
    }
}