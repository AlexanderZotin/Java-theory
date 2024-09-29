package theory.streams;

import java.util.Arrays;
import java.util.Comparator;
/*
Названия методов min(), max() и findFirst() говорят сами за себя.
Но всё не так просто. Во-первых, они возвращают не значения, а Optional.
Есть ещё IntStream, LongStream и DoubleStream - там возвращаются OptionalInt,
OptionalLong и OptionalDouble соответственно. Во-вторых, в интерфейсе
Stream методы min() и max() принимают в параметры компаратор. И вот что
удивительно: компаратор надо поставлять даже тогда, когда тип 
является Comparable, т.е методов с пустыми параметрами нет...
В стримах для примитивов ситуация обратная: есть только методы
с пустыми параметрами, компаратор поставить не получится.
Короче, в Oracle работают минималисты :)
И ещё: все эти методы - терминальные операции, т.е eager-методы.
*/
public class MinAndMaxAndFindFirstMethods {

    public static void main(String [] args) {
	    //----------------------------------Работаем с IntStream------------------------------------
	    int[] myBusNumbers = {50, 45, 3, 60, 104, 115, 42, 13, 81, 74, 51, 5, 702, 823};
		System.out.println("Массив: " + Arrays.toString(myBusNumbers));
		int max = Arrays.stream(myBusNumbers).filter(arg -> arg < 100).max().getAsInt(); 
		System.out.println("Самый большой номер автобуса: " + max);
		int min = Arrays.stream(myBusNumbers).min().getAsInt();
		System.out.println("Самый маленький номер автобуса: " + min);
		System.out.println("Первый элемент в отсортированном массиве: " +
				Arrays.stream(myBusNumbers).filter(num -> num < 100).findFirst().getAsInt());
		//----------------------А теперь возьмём обычный Stream----------------------------
		String[] charactersFromBook = {"Ушаноид", "Жебчик", "Ватя", "Монстриго", "Маленький Монстрижка", 
		        "Ушастик", "Большой Монстрижка"};
	    System.out.println("Массив: " + Arrays.toString(charactersFromBook));
		Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());
		String minName = Arrays.stream(charactersFromBook).min(comparator).get();
		System.out.println("Самое короткое имя: " + minName);
		String maxName = Arrays.stream(charactersFromBook).max(comparator).get();
		System.out.println("Самое длинное имя: " + maxName);
		String firstNameByAlphabet = Arrays.stream(charactersFromBook).sorted().findFirst().get();
		System.out.println("Первое имя по алфавиту: " + firstNameByAlphabet);
    }

}
