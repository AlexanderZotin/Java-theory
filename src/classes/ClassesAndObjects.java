package theory.classes;

/*
Классы и объекты играют важную роль в языке java.
Когда кода много (а его всегда много), его разбивают на классы, в которых содержаться методы.
Класс - это набор методов, которые выполняют что-то "на одну тему"
*/

public class ClassesAndObjects {

    public static void main (String [] args) {
        Person person1  = new Person(); //Создаём объект person1, ссылаясь на класс Person
        person1.name = "Шурик"; //Присваиваем значение переменной name для объекта person1
        person1.age = 13; //Присваиваем значение переменной age для объекта person1
        person1.speak(); //Вызываем метод speak для объекта person1 (без вызова метод не запуститься!)
        person1.goodBye(); //Вызываем метод GoodBye для объекта person1 
	 
        Person person2  = new Person();
        person2.name = "Маргарита";
        person2.age = 7;
        person2.speak();
        person2.goodBye();
    }
  
}