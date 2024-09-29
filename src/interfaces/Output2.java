package theory.interfaces;

public class Output2 implements Information {

    @Override 
    public void printLine(){
        System.out.println("Выводим константу string из интерфейса Information: " + string);
    }
  
    @Override
    public void printNumber(){
        System.out.println("Выводим константу number из интерфейса Information: " + number);
    }

}