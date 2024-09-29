package theory.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.math.BigInteger;
/*
Ссылка на метод или конструктор - способ упростить лямбда-выражение ещё больше.
*/
public class MethodReference {

    public static void main(String[] args) {
	    System.out.println("-------------------------------------------------------------------------");
	    List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(-43);
		list.add(25);
		list.add(16);
		list.add(0);
		list.add(11);
		list.add(-2);
		System.out.println("Выводится первоначальный список на экран:");
		/*
		Вот это но и есть. Фактически это тоже самое, что и:
		list.forEach(arg -> System.out.println(arg));
		*/
		list.forEach(System.out::println);
		/*
		Method reference удобно использовать при работе со Stream API.
		Иначе очень громоздко и не так лаконично получается.
		*/
		List<Double> result = list.stream().map(Math::sqrt).collect(Collectors.toList());
		System.out.println("А теперь результат:");
		result.forEach(System.out::println);
		/*
		Это уже ссылка на конструктор.
		Заменяет это:
		Function<String, BigInteger> factory = arg -> new BigInteger(arg);
		*/
		System.out.println("-------------------------------------------------------------------------");
		Function<String, BigInteger> factory = BigInteger::new; 
		System.out.println("Попробуем Constructor reference: " + 
		        factory.apply("11111111111111111111111").add(factory.apply("22222222222222222222222")));
		System.out.println("-------------------------------------------------------------------------");
    }

}
