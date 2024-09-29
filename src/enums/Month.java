package theory.enums;

//Перечисление помечается ключевым словом enum.
public enum Month {
    January("Январь", 1), //Объекты перечисляются через запятую
    February("Февраль", 2),
    March("Март", 3),
    April("Апрель", 4),
    May("Май", 5),
    June("Июнь", 6),
    July("Июль", 7),
    August("Август", 8),
    September("Сентябрь", 9),
    October("Октябрь", 10),
    November("Ноябрь", 11),
    December("Декабрь", 12); //После объявления последнего объекта нужно ставить точку с запятой
  
    //У перечисления могут быть обычные поля
    private int ordinalNumber;
    private String translation;
  
    /*
    У перечислений могут быть конструкторы!
    Они вызываются при перечислении объектов
    (в данном случае - при объявлении месяцев).
  
    К конструктору из
    перечисления нельзя обратиться за его пределами, поэтому обычно 
    такие конструкторы объявляются приватными, это делается для наглядности. 
    Кстати, компилятор не даст сделать конструктор 
    перечисления public или protected, ведь это бессмысленно =).
    */
    private Month(String translation, int ordinalNumber){
        System.out.println("Конструктор из перечисления запущен!");
        this.ordinalNumber = ordinalNumber;
        this.translation = translation;
    }
  
    //В перечислениях могут быть свои методы!
    public int getOrdinalNumber(){
        return ordinalNumber;
    }
  
    public String getTranslation(){
        return translation;
    }
  
    //В перечислениях можно переопределять метод toString()!
    @Override
    public String toString(){
        return "Название месяца: " + name() + "; Перевод на русский язык: " + 
        translation + "; Порядковый номер месяца: " + ordinalNumber + ";";
    }
  
}