package theory.interfaces;

class ClassWithInterface{

  /*
  Вложенный интерфейс (как и вложенный класс) может иметь любой модификатор доступа:
  public, protected, package private или private.
  */
    public interface Printable{ //Вложенный интерфейс
        void print();
    }
  
}

//Вот так можно указать, что класс реализует интерфейс.
public class DataPrinter implements ClassWithInterface.Printable { 

    @Override
    public void print(){
        System.out.println("Переопределённый метод print() из интерфейса ClassWithInterface.Printable сработал!");
    }
  
}