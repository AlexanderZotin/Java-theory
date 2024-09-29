package theory.enums;

/*
Перечисление очень похоже на класс. В перечислении есть список объектов,
которые схожи между собой. Яркий пример того - месяца, дни недели, времена года и т. д.
Все объекты в перечислении ведут себя как статические константы, и являются одного
типа данных (перечисление и есть тип данных).

Перечисления помечаются не ключевым словом class, а ключевым словом enum
(сокращение от enumeration). От перечислений нельзя наследоваться.
Но любое перечисление расширяет класс java.lang.Enum. То есть иерархия наследования
такая:
java.lang.Object > java.lang.Enum > твоё_перечисление > ничего_не_может_быть_дальше
*/

public class Enums { 

    public static void main (String [] args) { 
	    /*
	    Объект перечисления через оператор new создать нельзя.
	    После знака равно нужно указать имя перечисления
        и выбрать один из его элементов.
	    */
	    System.out.println("-------------------------------------------------");	
	    Month month = Month.May; 
	    System.out.println("-------------------------------------------------");
	    System.out.println("Вызывается метод printNameOfMonth(): ");
        printNameOfMonth(month);
	
	    //"Пересоздаём" месяц
	    System.out.println("-------------------------------------------------");	
	    month = Month.September;
	    System.out.println("Вызывается метод printNameOfMonth(): ");
	    printNameOfMonth(month);
	 
        System.out.println("-------------------------------------------------");	
	    System.out.println("Выводится информация о месяце: ");
	    System.out.println(month);
	 
	    System.out.println("-------------------------------------------------");	
	    month = Month.December;
	 
	    //Методы из перечисления вызываются так же, как и из обычных классов
	    int ordinalNumberOfDecember = month.getOrdinalNumber();
	    System.out.println("Выводится порядковый номер месяца декабрь: " + ordinalNumberOfDecember);
	 
	    System.out.println("-------------------------------------------------");	
    }
  
    private static void printNameOfMonth(Month month){
        //По перечислениям можно проходиться с помощью switch:
	    switch(month){ 
	        case January:
		        System.out.println("Сегодня январь!");
		     break;
		    case February:
		        System.out.println("Сегодня февраль!");
		    break;
		    case March:
		        System.out.println("Сегодня март!");
		    break;
		    case May:
		        System.out.println("Сегодня май!");
		    break;
		    case April:
		        System.out.println("Сегодня апрель!");
		    break;
		    case June:
		        System.out.println("Сегодня июнь!");
		    break;
		     case July:
		        System.out.println("Сегодня июль!");
		    break;
		    case August:
		        System.out.println("Сегодня август!");
		    break;
		    case September:
		        System.out.println("Сегодня сентябрь!");
		    break;
		    case October:
		        System.out.println("Сегодня октябрь!");
		    break;
		    case November:
		        System.out.println("Сегодня ноябрь!");
		    break;
		    case December:
		         System.out.println("Сегодня декабрь!");
		    break;
		    default:
		        System.out.println("Указанного месяца не существует!");
	    }
    }

}