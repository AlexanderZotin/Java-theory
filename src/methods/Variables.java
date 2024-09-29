package theory.methods;

public class Variables {
    private int number;
    private String string;
  
    //Два конструктора могут иметь одинаковые названия, только если у них разные параметры
    public Variables(){
        System.out.println("Конструктор с пустыми параметрами запущен!");
        this.string = "Строка по умолчанию";
        this.number = 1;
    }
  
    public Variables(String string,int number){
        System.out.println("Конструктор, принимающий строку и число, запущен!");
        if (string.isEmpty()) {
            System.out.println("Ошибка! Строка не должна быть пустой! В связи с ошибкой строке присвоено новое значение: Hello!");
            this.string = "Hello";
        } else {
            this.string = string;
        }
        this.number = number;
    }
  
    public String getString(){ 
        return string;
    }
  
    public int getNumber(){ 
        return number;
    }
}