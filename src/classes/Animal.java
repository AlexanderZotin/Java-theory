package theory.classes;

//Если нужно сделать класс абстрактным, то пометь его словом abstract
public abstract class Animal { 
  
    //У абстрактного класса могут быть поля с любыми модификаторами доступа
    private String color;
  
    /*
    У абстрактного класса могут быть конструкторы!
    Они вызываются при создании объектов классов-наследников. Хотя
    есть пару нюансов... Но об этом в классе Cat.
    */
    public Animal(){
        System.out.println("Конструктор без параметров запущен!");
    }
  
    public Animal(String color){
        System.out.println("Конструктор, принимающий на вход строку, запущен!");
	    this.setColor(color);
    }
  
    /*
    У абстрактного класса могут быть обычные методы. В этом классе есть только
    сеттеры и геттеры, но в принципе тут могли быть какие-то другие методы.
    */
    public String getColor(){
        return color;
    }

    public void setColor(String color){
        if(color.isEmpty()){
	        System.out.println("Ошибка! Цвет не может быть пустым!");
	    }  else {
            this.color = color;
	    }
    }
  
    //А это абстрактный метод. У него нет тела и он помечается словом abstract.
    public abstract void voice();
  
}