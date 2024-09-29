package theory.streams;

import java.util.Arrays;
/*
Метод reduce преобразует весь Stream в единое значение.
Есть два его варианта (он перегружен): возвращающий Optional (он с двумя параметрами),
и возвращающий T (с тремя параметрами).
*/
public class AboutReduceMethod {

    public static void main(String[] args) {
        //(1) Optional<T> reduce(BinaryOperator<T> accumulator)
        int[] array = {2, 4, 5, 3, 9, 3};
        System.out.println("Был у нас массив: " + Arrays.toString(array));
        int sum = Arrays.stream(array).reduce((accumulator, current) -> accumulator += current).orElse(0);
        System.out.println("И сумма его элементов была: " + sum);

        //(2) T reduce(T identity, BinaryOperator<T> accumulator)
        String[] arr = {"Строка 1", "Строка 2", "Строка 3"};
        System.out.println("Был у нас массив: " + Arrays.toString(arr));
        System.out.println("И получилось вот что: " + Arrays.stream(arr)
                .reduce("Строка 0", (accumulator, current) -> accumulator = accumulator + "; " + current));
    }

}
