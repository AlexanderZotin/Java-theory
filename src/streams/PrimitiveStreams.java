package theory.streams;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
/*
Кроме обычного Stream, в Java есть ещё IntStream, LongStream и DoubleStream.
Аналогично с Optional: OptionalInt, OptionalLong и OptionalDouble.
У стримов для примитивов есть особые методы.
Из примитивного стрима легко можно сделать
обычный - и наоборот.
*/
public class PrimitiveStreams {

    public static void main(String [] args) {
	    //Пример 1: подсчёт среднего балла
		out.println("---------------------------------------------------------------");
	    int[] marks = {5, 4, 5, 3, 4, 4, 5};
		out.println("Все оценки: " + Arrays.toString(marks));
		double average = Arrays.stream(marks).average().getAsDouble();
		out.println("Средний балл: " + average);
		out.println("---------------------------------------------------------------");
		//Пример 2: поиск минимального положительного значения
		out.println("---------------------------------------------------------------");
		int[] numbers = {9, 9, -7, 99, 90, -54, 0xFFF, 0b110, -66, 023, 0};
		out.println(Arrays.toString(numbers));
		out.println(Arrays.stream(numbers).filter(num -> num > 0).min().getAsInt());
		out.println("---------------------------------------------------------------");
		//Пример 3: Stream в IntStream
		out.println("---------------------------------------------------------------");
		List<String> list = new ArrayList<>();
		list.add("5");
		list.add("0");
		list.add("333");
		list.stream().mapToInt(Integer::parseInt).forEach(arg -> out.println(arg * 2));
		out.println("---------------------------------------------------------------");
		//Пример 4: IntStream в Stream
		out.println(Arrays.toString(numbers));
		Set<Integer> numbersSet = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
		out.println("Только уникальные элементы: " + numbersSet);
    }

}
