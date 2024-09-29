package theory.oop;

/*
Наследование - один из трёх основных принципов ООП.
Если один класс унаследован от другого,
то он получает все его поля и методы (кроме приватных!)
Как правило, наследование используется,
когда есть более широкое понятие и более узкое
*/
public class Inheritance {

    public static void main (String [] args) {
        System.out.println("Сейчас будут выводится данные о каком-то животном: ");
        Animal animal = new Animal();
	    //Вызываем методы класса Animal 
	    animal.eat();
	    animal.sleep();
	 
	    System.out.println();
	 
	    System.out.println("Сейчас будут выводится данные о коте: ");
	    //Вызываем методы класса Cat
	    Cat cat1 = new Cat();
	    cat1.eat();
	    cat1.printWeight();
    }
}