package theory.streams;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
Метод filter() из интерфейса Stream принимает на вход предикат и
оставляет только те значения, на которые предикат возвращает true.
*/
public class AboutFilterMethod {

    public static void main(String[] args) {
	    List<Integer> allNumbers = listOfNumbers();
		List<Integer> onlyEvenNumbers = allNumbers.stream()
		        .filter(num -> num % 2 == 0)
				.collect(Collectors.toList());
		System.out.println
		        ("Все чётные числа от " + allNumbers.getFirst() + " до " +
				allNumbers.getLast() + ": " + onlyEvenNumbers);
    }

	private static List<Integer> listOfNumbers() {
	    List<Integer> result = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите первое число в диапазоне:");
		int firstNumberInRange = scanner.nextInt();
		System.out.println("Введите второе число в диапазоне:");
		int secondNumberInRange = scanner.nextInt();
		result.add(firstNumberInRange);
		for(int i = firstNumberInRange + 1; i < secondNumberInRange; i++) {
		    result.add(i);
		}
		return result;
	}
}
