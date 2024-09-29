package theory.streams;

import java.util.Arrays;
import java.util.stream.Stream;
/*
Метод forEach является void (т.е ничего не возвращает) и
принимает на вход Consumer. Он "производит над каждым элементом
указанную операцию" (дословный перевод javadoc'а).
Работает аналогично методу из интерфейса Iterable, например.
*/
public class AboutForEachMethod { 

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------");
        String[] array = {"Пёс Собачий", "Сестра", "Тараканы", "Габадочка"};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Все элементы массива в верхнем регистре:");
        Arrays.stream(array).forEach(current -> System.out.println(current.toUpperCase()));
        //Внимание!!! Stream никогда не меняет коллекцию/массив. Доказательство:
        System.out.println("Массив не изменился: " + Arrays.toString(array));
        System.out.println("--------------------------------------------------------------------");
        
        //Пусть тут ещё будет пример на stream.of(). А то совсем скучно...
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("ОФИГЕТЬ! МОЖНО ВЗЯТЬ И ИЗВЛЕЧЬ КВАДРАТНЫЙ КОРЕНЬ ИЗ ЧИСЕЛ! ВОТ ЭТО ДА!!!");
        stream.forEach(num -> System.out.println(Math.sqrt(num)));
        System.out.println("--------------------------------------------------------------------");
    } 

}
