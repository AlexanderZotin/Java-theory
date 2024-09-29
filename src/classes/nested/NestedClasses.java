package theory.classes.nested;

/*
В java класс может находиться внутри другого класса.
Такие классы называются вложенными. Есть 4 вида
вложенных классов: статические вложенные классы,
внутренние классы, локальные классы и анонимные классы.
Об каждом виде этих вложенных классов в файле ElectroCar.java,
ведь этот класс лишь "пульт управления".
*/
public class NestedClasses {

    public static void main (String [] args) {
        System.out.println();
	    ElectroCar car = new ElectroCar(12345);
	    //Так создаётся экземпляр статического вложенного класса
	    ElectroCar.Battery battery = new ElectroCar.Battery(); 
	    battery.check();
	    car.gas();
	    car.brake();
    }
}