package theory.exceptions;

//Класс-исключение должен быть унаследован от Exception
public class IncorrectPasswordException extends Exception { 

    public IncorrectPasswordException(){
        super(); //Вызываем конструктор суперкласса
    }
  
    public IncorrectPasswordException(String description){
        super(description); //Вызываем конструктор суперкласса и поставляем ему сообщение
    }
  
}