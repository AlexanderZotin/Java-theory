package theory.dataTypes.references;

/*
В java можно преобразовывать не только примитивы, 
но и ссылочные типы данных. Есть два вида преобразования:
восходящие и нисходящие (upcasting и downcasting).
*/
public class Casting {

    public static void main (String [] args) {
        //Восxодящее преобразование (Upcasting) - всегда безопасно!
	    //В данном случае мы линейку конвертируем в вещь.
	    Ruler ruler = new Ruler();
	    Thing thing = ruler;
	    thing.testThing(); 
	    /*Если в классе Ruler есть переопределённый метод, то он и будет вызван. 
	    Если его нет, то  вызовется метод из класса Thing */
	  
	    //Нисходящее преобразование (DownCasting) - не всегда безопасно!
	    //В  данном случае мы преобразовываем вещь в линейку.
	    Ruler myRuler = (Ruler) thing;
	    myRuler.testThing(); 
	    myRuler.testRuler(); //Этот метод тоже доступен, так как переменная декларирована как Ruler.
    }
}