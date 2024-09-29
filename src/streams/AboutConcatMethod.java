package theory.streams;

import java.util.*;
import java.util.stream.Stream;
/*
Статический метод concat() из интерфейса Stream соединяет два стрима в один.
Вообще, его суть чрезвычайно проста, и поэтому большая часть кода ниже
будет посвящена обобщению информации по изученным методам Stream API.
*/
public class AboutConcatMethod {

    public static void main(String[] args) {
        //-----------------------------Пример на метод concat()-----------------------------
        Stream<Integer> firstStream = Stream.of(2, 4, -8, 0, 7, -54, 1, 16);
        Stream<Integer> secondStream = Stream.of(9, 4, 2, -11, -9, 256, 1024, 0, 777, -6);
        Stream<Integer> result = Stream.concat(firstStream, secondStream);
        //-----------------------------Использование созданных потоков-----------------------------
        String resultString = result.filter(num -> num >= 0)
                .distinct().sorted()
                .map(arg ->
                    new StringBuilder().append('√').append(arg).append(" = ")
                            .append(Math.sqrt(arg)).toString())
                .reduce((accumulator, element) -> 
                    new StringBuilder().append(accumulator).append("; ").append(element).toString())
                .orElse("Все числа отрицательные!");
        System.out.println(resultString);
        
        //-----------------------------Как бы это делалось до Java 8?-----------------------------
        List<Integer> list = 
                new ArrayList<>(Arrays.asList(2, 4, -8, 0, 7, -54, 1, 16, 9, -11, -9, 256, 1024, 777, -6));
        //For-each использовать не получится; Вылетит ConcurrentModificationException
        for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) { 
            if(iterator.next() < 0) iterator.remove();
        }
        Set<Integer> distinctElements = new HashSet<>(list);
        list = new ArrayList<>(distinctElements);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append('√').append(integer).append(" = ").append(Math.sqrt(integer))
                    .append("; ");
        }
        if(sb.isEmpty()) sb = new StringBuilder("Все числа отрицательные!");
        System.out.println(sb);
    }
}
