package theory.classes;

public class Dog extends Animal{

    /*
    А вот что происходит в конструкторе по умолчанию:
	 
    public Dog(){
	    super();
	}
    */
  
    //Здесь нужно обязательно переопределить метод voice()
    @Override
    public void voice(){
        System.out.println("ГАВ!");
    }
  
}