package theory.methods;

/*
 Параметры метода нужны дл¤ передачи данных из одного метода в другой.
*/

public class MethodParameters {

    public static void main (String [] args) {
        SomeClass someClass = new SomeClass();
        someClass.printing("Привет!"); //Вместо параметров метода указываем строку
        String goodBye = "Пока!"; //Вместо параметров метода указываем переменную, в которой хранится строка
        someClass.printing(goodBye);
    }
}

class SomeClass {
  
    void printing(String message) {
        System.out.println(message);
    }
  
}