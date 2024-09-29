package theory.collections.maps;

import java.util.TreeMap;
import java.util.NavigableMap;
/*
TreeMap реализует не только интерфейс Map, но и два других: SortedMap и
NavigableMap, что говорит о том, что элементы в этой коллекции располагаются в определённом порядке.
В каком порядке? По ключам. А ключи в каком порядке? А в таком, как говорит метод compareTo(), реализованный
в классе, объекты которого используются как ключи. А если он не реализован? То тогда
в конструктор нужно поставить Comparator, иначе получится БАБАХ времени выполнения.
*/
public class UseTreeMap {

    public static void main(String [] args) {
        NavigableMap<Long, String> map = new TreeMap<>();		
		map.put(89657346253L, "Банджю");
		map.put(89653738481L, "Ватя");
		map.put(89653734334L, "Монстриго");
		map.put(89652387389L, "Кабаноид");
		map.put(89653267327L, "Ушастик");
		map.put(88932478321L, "Ушапусик");
		map.put(89653738310L, "Ушаноид");
		TelephoneBook tBook = new TelephoneBook(map);
		tBook.open();
		tBook.printFacts();
		tBook.aboutNumbers();
    }
	
}