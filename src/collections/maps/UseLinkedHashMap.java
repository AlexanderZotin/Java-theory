package theory.collections.maps;

import java.util.Map;
import java.util.LinkedHashMap;
/*
LinkedHashMap наследуется от HashMap, и поэтому эти две коллекции очень похожи.
Однако отличие Linked- от HasMap в том, что в HashMap порядок элемент никак не связан
с порядком их добавления и даже может полностью поменяться, даже если был добавлен/удалён
всего один элемент! А в LinkedHashMap все ключи располагаются в порядке добавления.

У LinkedHashMap есть классная фишка: такой вот конструктор:

public LinkedHashMap(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) 
						 
initialCapacity и loadFactor изучаются ещё при знакомстве с
HashMap'ом, а вот accessOrder - это кое-что новое.
В простом хешмепе такого нет. Если accesOrder будет false,
то ничего интересного не произойдёт. А если true...
Вот обратишься ты к какому-то элементу с помощью get().
И после этого этот элемент встанет на последнее место, 
и неважно, где он был до этого.
*/
public class UseLinkedHashMap {

    public static void main(String [] args) {
	    //Все значения оставляем по умолчанию, кроме accesOrder
	    Map<Long, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true); 
		linkedHashMap.put(89222456789L, "Таракан Сбегучка");
		linkedHashMap.put(89222432969L, "Таракан Большой");
		linkedHashMap.put(89222475931L, "Таракан Нитуп");
		linkedHashMap.put(89222403900L, "Таракан Путин");
		linkedHashMap.put(89222449301L, "Таракан Полкомодник");
		linkedHashMap.put(89222449302L, "Таракан Рожающий");
		linkedHashMap.put(89222420201L, "Тараканиха Чебурашка");
		linkedHashMap.put(89222478500L, "Тараканиха Светлая");
		linkedHashMap.put(89222453428L, "Тараканиха Тёмная");
		linkedHashMap.put(89222416113L, "Тараканиха Краснорожка");
		linkedHashMap.put(89222411998L, "Тараканиха Красношапочка");
		linkedHashMap.put(89222456280L, "Тараканиха Филлипочка");
		linkedHashMap.put(89222453342L, "Тараканиха Изабелла");
		linkedHashMap.put(89222456384L, "Тараканиха Яблочко");
		linkedHashMap.put(89222458743L, "Тараканиха Апельсинка");
		TelephoneBook tBook = new TelephoneBook(linkedHashMap);
		tBook.open();
		tBook.printFacts();
		tBook.aboutNumbers();
    }

}
