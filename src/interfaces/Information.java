package theory.interfaces;

public interface Information {
    /*
    Все поля интерфейса - public static final, то есть константы.
    Даже если ты объявишь их как простые переменные, они всё равно будут такими.
    */
    public static final int number = 5;
    public static final String string = "Строка";
  
    //Методы в интерфейсах не имеют тела, а имеют лишь сигнатуру.
    public void printLine();
  
    public void printNumber();
  
}