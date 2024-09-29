package theory.collections.maps;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
/*
Map - это коллекция с элементами, которые получаются по уникальным
ключам. Значения могут повторяться, ключи - нет. И ключ, и
значение могут быть null.

HashMap - одна из наиболее популярных реализаций Map.
Элементы в HashMap находятся очень быстро.
*/
public class UseHashMap { 

    public static void main(String [] args) {
		Map<Long, String> map = new HashMap<>();
		map.put(89657483838L, "Тётя Зина");
		map.put(89657987383L, "Пёс Собачий");
		map.put(89222431290L, "Таракан Нападучка");
		map.put(89657483839L, null); 
		map.put(null, "Вася");
		map.replace(null, "Олег", "Вася"); 
		map.replace(null, "Петя"); 
		removeTrash(map);
		map.putIfAbsent(112L, "Единый телефон экстренных служб");
	    TelephoneBook telephoneBook = new TelephoneBook(map);
		telephoneBook.open();
		telephoneBook.printFacts();
	    telephoneBook.aboutNumbers();
    }
	
	private static void removeTrash(Map<?, ?> map) {
	    if(map == null) throw new IllegalArgumentException("map не должна быть null!");
	    map.remove(null);
		Collection<?> value = map.values();
		Iterator<?> iterator = value.iterator();
		while(iterator.hasNext()) {
		    if(iterator.next() == null) iterator.remove();
		}
	}
}
