package theory.streams;

import java.util.Arrays;
import java.util.Random;
/*
Метод peek() похож на forEach, но отличается тем, что возвращает Stream.
То есть его можно использовать в середине цепочки методов. И стоит помнить
про lazy-методы и eager-методы: метод peek() не должен
вызываться последним, он же lazy!
*/
public class AboutPeekMethod {

    public static void main(String [] args) {
        int[] array = {3, 4, 11, 3, -9, 0, 87, -4, -54, 31, 3, 4, 7, 9, 12, -443, 5, 34, 5, 5, 25, 6};
        System.out.println("\nМассив: " + Arrays.toString(array));
        //Пример 1
        Arrays.stream(array).distinct()
                .peek(arg -> System.out.println("Уникальный элемент: " + arg))
                .filter(arg -> (Math.sqrt(arg) % 1 == 0))
                .peek(arg -> System.out.println("Из этого числа можно легко извлечь корень: " + arg))
                .sorted().forEach(arg -> System.out.println("Итоговый элемент: " + arg));
        //Пример 2
        int sumOfRandomElements = Arrays.stream(array).filter(arg -> new Random().nextBoolean())
                .peek(arg -> System.out.println("Это число попало в список случайно выбранных: " + arg))
                .reduce((accumulator, element) -> accumulator += element)
                .orElse(0);
        System.out.println("Сумма случайно выбранных элементов: " + sumOfRandomElements);
    }

}
