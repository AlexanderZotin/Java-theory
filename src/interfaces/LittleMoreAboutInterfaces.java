package theory.interfaces;

public class LittleMoreAboutInterfaces implements Swimmable{

    public static void main(String [] args){ 
        DataPrinter printer = new DataPrinter();
        printer.print();
        LittleMoreAboutInterfaces littleMore = new LittleMoreAboutInterfaces(); 
        littleMore.swim();    
        littleMore.makeSound();    
        littleMore.move();
    }

    /*
    Реализую методы не только интерфейса Swimmable, но и интерфейсов
    AbleToMakeSound и Moveable, ведь Swimmable унаследован
    от этих двух интерфейсов.
    */
  
    @Override
    public void swim(){
        System.out.println("ѕереопределЄнный метод swim() сработал!");
    }
  
    @Override
    public void makeSound(){
        System.out.println("ѕереопределЄнный метод makeSound() сработал!");
    }
  
    @Override
    public void move(){
        System.out.println("ѕереопределЄнный метод move() сработал!");
    }
  
}
