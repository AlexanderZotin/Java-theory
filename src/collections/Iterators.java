package theory.collections;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Arrays;

/*
Итераторы нужны для перебора элементов коллекции. 
Здесь я рассмотрю два класса: java.util.Iterator и java.util.ListIterator.

В классе Iterator есть 4 метода, из которых я рассмотрю три.
1) next(). Возвращает следующий по счёту элемент.
2) hasNext(). Проверяет, есть ли ещё элементы.
3) remove(). Удаляет элемент из списка.

ListIterator расширяет функционал обычного итератора.
То есть он содержит все методы, которые содержит ListIterator и 
предоставляет дополнительные:
1) previous(). Возвращает предыдущий элемент.
2) add(E e). Вставляет элемент в коллекцию, вставляя его между тем элементом, который был бы
возвращён методом next() и между тем, который был бы возвращён методом previous().
3) set(E e). Редактирует последний возвращённый методом next() элемент.
4) nextIndex(). Возвращает индекс элемента, который был бы возвращён методом next().
5) previousIndex(). Возвращает индекс элемента, который был бы возвращён методом previous().

В примерах кода будет использоваться только ListIterator, так как обычный Iterator
работает аналогично, только методов у него меньше.
*/

public class Iterators {

    public static void main(String [] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(-6, 4, 8, 0, -14, 66, 32, -1, 13));
		System.out.println("---------------------------------------");
		System.out.println("Первоначальный список:");
		for(int i: numbers) {
		    System.out.println(i);
		}
		System.out.println("---------------------------------------");
		
		ListIterator<Integer> listIterator = numbers.listIterator();
		System.out.println("---------------------------------------");
		while(listIterator.hasNext()){ 
			if(listIterator.next() < 0) {
			    listIterator.remove(); 
				System.out.println("Элемент под индексом " + (listIterator.nextIndex()) + " отрицательный, поэтому был удалён.");
				listIterator.add((int) Math.round(Math.random() * 10));
			}
		}
		
		listIterator = numbers.listIterator();
		System.out.println("---------------------------------------");
		System.out.println("Исправлены й список:");
		while(listIterator.hasNext()){
		    System.out.println(listIterator.next());
		}
		System.out.println("---------------------------------------");
		
		//А теперь пересоздаём этот итератор и он будет на последнем элементе, так как я указал в параметрах numbers.size()
		listIterator = numbers.listIterator(numbers.size()); 
		System.out.println("---------------------------------------");
		System.out.println("Список наоборот:");
		while(listIterator.hasPrevious()){
		    System.out.println(listIterator.previous());
		}
		System.out.println("---------------------------------------");
    }
	
}
