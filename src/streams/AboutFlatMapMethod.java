package theory.streams;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
/*
Метод flatMap() нужен для работы с многомерными коллекциями.
Когда нам нужно работать не с элементами потока, а с элементами элементов,
так сказать. В прочем, проще понять на практике.
*/
public class AboutFlatMapMethod {

    public static void main(String[] args) { 
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(3, 16, 4, -4, 0));
        matrix.add(Arrays.asList(512, 0, -27, 9, 14));
        matrix.add(Arrays.asList(-8, -3, -99, 1, 0));
        System.out.println("\nБыло: " + matrix);
        //Пример 1
        System.out.println("------------------------------------------------------------------");
        List<Double> result = matrix.stream().flatMap(Collection::stream)
                .distinct()
                .filter(arg -> arg >= 0)
                .sorted()
                .peek(arg -> System.out.println("Этот элемент остался: " + arg))
                .map(Math::sqrt)
                .collect(Collectors.toList());
        System.out.println("Стало: " + result);
        //Пример 2
        System.out.println("------------------------------------------------------------------");
        double sumOfCbrts = matrix.stream().flatMap(Collection::stream)
                .map(Math::cbrt)
                .peek(System.out::println)
                .reduce((accumulator, current) -> accumulator += current)
                .orElse(0.0);
        System.out.println("---\nСумма кубических корней: " + sumOfCbrts);
        System.out.println("------------------------------------------------------------------");
    }
}
