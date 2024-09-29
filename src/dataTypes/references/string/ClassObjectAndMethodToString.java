package theory.dataTypes.references.string;

/*
В java любой класс наследуется от класса Object.
А в классе Object есть метод toString, который 
вызывается автоматически при выводе объекта на экран.
Данный метод можно переопределить.
*/
public class ClassObjectAndMethodToString {

    public static void main (String [] args) {
        WithoutToString withoutToString = new WithoutToString();
	    System.out.println("Выводится объект класса WithoutToString:");
        System.out.println(withoutToString);
	    /*При выводе объекта на экран неявно вызывается метод
	    toString() класса Object.*/
	 
	    WithToString1 withToString1 = new WithToString1();
	    System.out.println("Выводится объект класса WithToString1:");
        System.out.println(withToString1);
	    /*При выводе объекта на экран неявно вызывается переопределённый 
	    метод toString() из класса WithToString1.*/
	 
	    WithToString2 withToString2 = new WithToString2();
	    System.out.println("Выводится объект класса WithToString2:");
	    System.out.println(withToString2);
	    /*При выводе объекта на экран неявно вызывается переопределённый 
	    метод toString() из класса WithToString2.*/ 
    }
}