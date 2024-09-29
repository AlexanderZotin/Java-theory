package theory.oop;

public class Variables {
  
    //модификатор private означает, что переменная будет доступна только в пределах этого класса.
    private String string; 
    private int number;
  
    public void setNumber(int number){ //Это сеттер
        if(number < 0){ 
            //Если число меньше 1, то выводим сообщение об ошибке и присваиваем переменной значение 1
            System.out.println("Ошибка! Число не должно быть отрицательным! В связи с ошибкой числу присвоено новое значение: 1");
            //Слово this указывает, что это переменная класса, а не та, которая подалась в параметрах. Далее это значение будет сохранено в поле класса и возвращено через геттер
            this.number = 1; 
        } else {
            //Иначе просто сохраняем поданное значение в поле
            this.number = number;
        }
    }
  
    public int getNumber(){ //Это геттер
        return number; //Возвращаем переменную
    }
  
    public void setString(String string){ //И это сеттер
        if(string.isEmpty()) {
            System.out.println("Ошибка! Строка не должна быть пустой! В связи с ошибкой строке присвоено новое значение: Hello!");
            this.string = "Hello!";
        } else {
            this.string = string;
        }
    }
  
    public String getString(){ //И это геттер
        return string;
    }
}