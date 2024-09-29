package theory.interfaces;

public class Class2 implements Numbers {

    //Методы по умолчанию (default) можно переопределять, но это необязательно
    @Override 
    public void printIncreasedNumber(int number){
        System.out.println("Переопределённый default-метод начал свою работу!");
        number *= 2;
	    System.out.println("Выводится увеличенное число: " + number);
    }
  
}
