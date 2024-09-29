package theory.io.serialization;

public class Ruler implements java.io.Serializable {
    /*
    Ключевое слово transient означает, что
    поле не должно быть сериализованно.
    */
    private transient int id;
    
    private String color;
    private int longOfRuler;

    /*
    Это поле нужно для того, чтобы помечать состояние класса. Ведь класс
    после записи его объекта может очень сильно измениться! И если
    serialVersionUID старой версии класса не будет совпадать
    с новым, то произойдёт исключение java.io.InvalidClassException. 
  
    На самом деле, java всё равно генерирует неявно это поле для классов, которые реализуют
    java.io.Serializable. Но значение, которое сгенерирует java, ненадёжно,
    ведь оно может измениться, если поменяются незначительные детали:
    например, версия java. Поэтому лучше объявлять это поле в своём классе.
  
    Генерация serialVersionUID производится с помощью специальной утилиты
    serialver. Вот как сгенерировать значение для этого класса:
    1. Нужно скомпилировать класс;
    2. Ввести в cmd команду: serialver theory.io.serialization.Ruler
    (cmd должна быть запущена из корня проекта).
    */
    private static final long serialVersionUID = -7860262272475033673L;
  
    public Ruler(String color, int longOfRuler, int id){
        this.color = color;
        this.longOfRuler = longOfRuler;
        this.id = id;
    }
  
    @Override
    public String toString() {
        return "Длинна линейки: " + longOfRuler + "; Цвет линейки: " + color + "; id линейки: " + id + ';';
    }
}