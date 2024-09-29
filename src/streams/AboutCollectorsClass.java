package theory.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
Класс Collectors - утилитарный класс, т.е класс только со static-методами,
который предоставляет коллекторы (объекты, реализующие интерфейс Collector).
Здесь будут рассмотрены некоторые методы этого класса.
*/
@SuppressWarnings({"SimplifyStreamApiCallChains", "SpellCheckingInspection", "RedundantStreamOptionalCall"})
public class AboutCollectorsClass {

    public static void main(String[] args) {        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("toSomethingMethods():");
        toSomethingMethods();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("groupingByAndPartitioningByMethods:");
        groupingByAndPartitioningByMethods();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("otherMethods():");
        otherMethods();
        System.out.println("-----------------------------------------------------------------");
    }
    
    /*
    Здесь рассматриваются методы для преобразования стрима в какую-либо коллекцию:
    toList(), toSet(), toMap(Function, Function) и toCollection(Supplier)
    */
    public static void toSomethingMethods() {
        int[] array = {4, -6, 0 , 9, 7, 7, -9, 0, -6, 8, 144, 121, 121, 49, 1, 3, -4};
        //-------------------------------Метод toList()-------------------------------
        List<Integer> positiveNumbersList = Arrays.stream(array).filter(arg -> arg > 0)
                .sorted().boxed()
                .collect(Collectors.toList());
        System.out.println("Список положительных чисел: "  + positiveNumbersList);
        //-------------------------------Метод toSet()-------------------------------
        Set<Integer> positiveNumbersSet = Arrays.stream(array).filter(arg -> arg > 0)
                .sorted().boxed() //Потом это всё преобразуется в сет, результат сортировки исчезнет. 
                          //Добавил, чтобы это показать
                .collect(Collectors.toSet()); 
        System.out.println("Множество положительных чисел без дубликатов: "  + positiveNumbersSet);
        //-------------------------------Метод toMap(Function, Function)-------------------------------
        Map<Integer, Double> map = Arrays.stream(array).filter(arg -> arg > 0)
               .distinct().boxed()
               .collect(Collectors.toMap(Function.identity(), arg -> Math.sqrt(arg)));
               
        for(Map.Entry<Integer, Double> current : map.entrySet()) {
            System.out.println("Число: " + current.getKey() + "; Корень: " + current.getValue());
        }
        //-------------------------------Метод toCollection(Supplier)-------------------------------
        Deque<Integer> negativeNumbersDeque = Arrays.stream(array).filter(num -> num < 0)
                .boxed().collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println("Очередь из отрицательных чисел: " + negativeNumbersDeque);
    }
    
    public static void groupingByAndPartitioningByMethods() {
        //-------------------------------groupingBy(Function)-------------------------------
        String[] array = {"Ватя", "Банджю", "Ушастик", "Ушаноид", "Ушапарик", "Монстриго", "Кабаноид",
                "Валерыч", "Бобыч", "Барабаныч", "Кабаняшка"};
        Map<Integer, List<String>> result1 = Arrays.stream(array).sorted()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(result1);    
        //-------------------------------partitioningBy(Predicate)-------------------------------
        Map<Boolean, List<String>> result2 = Arrays.stream(array).sorted()
                .collect(Collectors.partitioningBy(str -> str.compareTo("Жебчик") < 0));
        System.out.println("До Жебчика по алфавиту: " + result2.get(true));
        System.out.println("После Жебчика по алфавиту: " + result2.get(false));
     }
    
    public static void otherMethods() {
        String[] array = {"Первая строка", "Вторая строка", "Третья строка"};
        //------------------------------joining()------------------------------
        String result1 = Arrays.stream(array).collect(Collectors.joining());
        System.out.println(result1);
        //------------------------------joining(CharSequence delimiter)------------------------------
        String result2 = Arrays.stream(array).collect(Collectors.joining("; "));
        System.out.println(result2);
        //------------joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)------------
        String result3 = Arrays.stream(array)
                .collect(Collectors.joining("; следующий элемент: ", "Первый элемент: ", "; Конец"));
        System.out.println(result3);
    }
}
