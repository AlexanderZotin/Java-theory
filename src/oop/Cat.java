package theory.oop;

public class Cat extends Animal { //Создаём класс Cat, который унаследован от класса Animal
//Важно! Класс-родитель может быть только один! 

    public void eat() { //Переопределяем метод eat
        System.out.println("Кот ест...");
    }
   
    public void printWeight() {
        System.out.println("Возраст кота: " + weight);
        //Поле weight унаследовано из класса Animal
    }
   
}