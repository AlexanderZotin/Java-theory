package theory.generics.wildcards;

import java.util.List;
import java.util.ArrayList;

/*
PECS = producer - extends; consumer - super.
*/
public class PECS_Principle {

    public static void main(String [] args) {
	    List<Double> list1 = new ArrayList<>();
		list1.add(1.0);
		list1.add(Math.PI);
		list1.add(-8.88);
	    testProducer(list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(444);
		list2.add(666);
		list2.add(-49);
 		testConsumer(list2);
		testUnboundWildcard(list1);
		System.out.println(addFirstHalf(list1));
    }

	/*
	Wildcard <? extends> - producer. Из него можно только читать значения.
	Добавлять нельзя. Хотя на самом деле можно добавить null. Но не более.
	*/
	public static void testProducer(List<? extends Number> list) {
	    System.out.println("--------------------------------------");
	    System.out.println("Это метод testProducer:");
	    //list.add(3); ОШИБКА КОМПИЛЯЦИИ!!!
		list.add(null); //Пожалуйста
		System.out.println(list); //Спокойно
		System.out.println("Элемент с индексом 0: " + list.getFirst()); //Без проблем
		System.out.println("--------------------------------------");
	}
	
	/*
	Wildcard <? super> - consumer. Из него вообще можно только читать, а "доставать"
    можно только тип Object.
	*/
	public static void testConsumer(List<? super Integer> list) {
	    System.out.println("--------------------------------------");
		System.out.println("Это метод testConsumer:");
	    //Number number = list.get(0); //ОШИБКА КОМПИЛЯЦИИ!!!
        Object some = list.getFirst(); //Так можно
		System.out.println("Нулевой элемент: " + list.getFirst()); //Это то же самое, что и предыдущее, тут тип Object
	    Number num = (Number) list.getFirst(); //И так можно, т.к сделано приведение типа
	    list.add(6); //ОК
		System.out.println(list); //ОК
		System.out.println("--------------------------------------");
	}
	
	/*
	Wildcard <?> позволяет, как известно, поставлять список с чем угодно, разумеется,
	кроме примитивов. То есть, это то же самое, что и <? extends Object>, а значит,
	это producer.
	*/
	public static void testUnboundWildcard(List<?> list) {
	    System.out.println("--------------------------------------");
		System.out.println("Это метод testUnboundWildcard:");
	    // list.add("Это объект типа String"); //ОШИБКА КОМПИЛЯЦИИ!!!
	    list.add(null); //null добавить можно, это же обычный producer
   	    System.out.println(list); //Спокойно
	    System.out.println("Элемент с индексом 0: " + list.getFirst()); //Без проблем
		System.out.println("--------------------------------------");
	}
	
	/*
	Это демонстрация паттерна wildcard capture. Внутри этого метода мы не можем ничего
	добавлять список, т.к wildcard <?> является продюсером. Поэтому нужна хитрость:
	из метода с символом подстановки вызываем метод с типом <T>. И всё будет работать.
	И да, так можно с любым wildcard'ом.
	*/
	public static List<?> addFirstHalf(List<?> list) {
	    return addFirstHalf1(list);
	}
	
	private static <T> List<T> addFirstHalf1(List<T> list) {
	    if(list == null) throw new IllegalArgumentException("list не может быть null!");
	    int newSize = (int) Math.round(list.size() / 2.0);
		for(int i = 0; i < newSize; i++) {
		    list.add(list.get(i));
		}
		return list;
	}
}
