package theory.interfaces;

/*
Интерфейс может быть унаследован от нескольких интерфейсов. 
Тогда классы, реализующие такой интерфейс, должны
реализовывать методы обоих интерфейсов.
*/

public interface Swimmable extends Moveable, AbleToMakeSound { 
    void swim();
}

interface AbleToMakeSound{
    void makeSound();
}

interface Moveable {
    void move();
}
