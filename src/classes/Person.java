package theory.classes;

public class Person { //Это класс. Вне класса не может быть ни полей, ни методов

    String name; //Это поле. Поля - внутри класса, но вне метода
    int age; //И это тоже поле

    void speak() { //Это метод
        System.out.println("Привет! Меня зовут "+ name + ". Мне "+ age + " лет.");
    }
  
    void goodBye(){ //И это тоже метод
         System.out.println("Пока!");
    }
  
}