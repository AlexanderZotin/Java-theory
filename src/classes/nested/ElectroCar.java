package theory.classes.nested;

//Это обычный класс
public class ElectroCar {
    private int number;
  
    public ElectroCar(int number){
        this.number = number;
    }
    
    public void gas(){ 
        Motor motor = new Motor();
        motor.startMotor();
        System.out.println("Газ!");
     
        /*
        Это анонимный класс. 
        Об анонимных классов есть отдельный теоретический файл (AnonumClasses.java).
        Поэтому не буду здесь писать подробно, а перечислю основные моменты:
     
        1) Анонимные классы объявляются только внутри методов;
        2) Они используются для быстрого переопределения методов из интерфейса или суперкласса;
        3) Видны только внутри того метода, в котором объявлены;
        4) Имеют доступ к полям внешнего класса (в том числе к статическим и приватным!);
        */
        AbleToMove ableToMove = new AbleToMove(){
            @Override
            public void move(){
                System.out.println("Машина едет!");
            }
        };
        ableToMove.move();
    }  
  
    public void brake(){
        System.out.println("Тормоз!");
        /*
        А это локальный класс. Такие классы тоже объявляются внутри 
        методов. Но "выглядит" этот класс как обычный, в отличие 
        от анонимного =). Но всё же с анонимными классами локальные классы сходства имеют:
        например они видны только в пределах того метода, в котор объявлены.
        Можно создавать объекты таких классов сколько угодно, но только в 
        пределах того метода... Ну ты понял =).
        Особенности локальных классов:
        1) Локальные классы имеют доступ ко всем полям внешнего класса;
        2) Локальные классы имеют доступ не ко всем переменным метода, в котором
        они объявлены, а только к final и effective-final. Что такое
        effective-final переменные? Это те переменные, которые не были
        объявлены как final, но значение их не менялось в течении работы метода;
        3) Локальные классы могут содержать обычные поля или статические константы;
        */
        class Localclass {
            public void printNumberOfcar(){
                System.out.println("Номер машины: " + number);
            }
        }
        Localclass localclass = new Localclass();
        localclass.printNumberOfcar();
    }
  
    /*
    Это вложенный нестатический класс. Такие классы могут иметь любой модификатор доступа,
    в отличие от обычных классов, которые могут быть только public и package private.
    Такие классы "выглядят" как обычные(если не считать модификаторы доступа), но у них есть
    важные особенности:
  
    1) Объект такого класса не может существовать без объекта внешнего класса. В данном случае класс
    имеет модификатор private и он доступен только в пределах внешнего класса, но если бы модификатор 
    доступа был бы менее строгим, то за пределами внешнего класса создавать объекты
    внутреннего класса можно было бы так:
  
    ElectroCar electroCar = new ElectroCar(12345);
    ElectroCar.Motor motor = electroCar.new Motor();
  
    А вообще внутренние нестатические классы обычно за пределами внешнего не используют.
    Для этого больше подходят внутренние статические;
  
    2) Во внутреннем классе есть доступ к переменным и методам внешнего, даже если они приватные.
    Более того, доступ к внешним переменным есть и у объектов внутреннего класса.
  
    3) Объект внутреннего класса нельзя создать в статическом методе;
  
    4) Внутренний класс не может содержать статические переменные и ли методы;
    */
    
    private class Motor{
     
        public void startMotor(){
            System.out.println("Мотор машины " + number + " работает!"); 
        }
   
    }
  
    /*
    Это статический вложенный класс. Он тоже может иметь любой модификатор доступа, но чаще всего это 
    модификатор public. Особенности таких классов:
    1) Объект такого класса может существовать без объекта внешнего класса. В файле
    NestedClasses.java показано, как объект такого класса создать;
    2) Из таких классов есть доступ только к статическим полям внешнего класса;
    3) Такие классы могут содержать нестатические поля и методы;
    */
    
    public static class Battery{
     
        public void check(){
            System.out.println("Батарея машины работает нормально!");
        }                                                                                                        
     
    }
  
}