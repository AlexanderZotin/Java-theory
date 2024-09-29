package theory.classes;

public class Cat extends Animal{
  
    //Этот конструктор здесь нужен, чтобы можно было вызвать конструктор
    //суперкласса, передавая ему строку.
    public Cat(String color){
        super(color);
    }
  
    @Override
    public void voice(){
        System.out.println("ћя”!");
    }
  
}