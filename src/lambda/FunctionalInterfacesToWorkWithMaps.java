package theory.lambda;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
/*
Здесь будут рассмотрены функциональные интерфейсы с приставкой Bi- и
методы Map'ов, которые с ними работают.
*/
@SuppressWarnings("ALL")
public class FunctionalInterfacesToWorkWithMaps {
    private static Map<Integer, String> cockroaches = new HashMap<>();
    
    static {
        cockroaches.put(1, "Большой");
        cockroaches.put(2, "Сбегучка");
        cockroaches.put(3, "Оторванный");
        cockroaches.put(4, "Подкомодник");
        cockroaches.put(5, "Изабелла");
        cockroaches.put(6, "Рожающий");
        cockroaches.put(7, "Светлая");
        cockroaches.put(8, "Тёмная");
        cockroaches.put(9, "Чебурашка");
        cockroaches.put(10, "Краснорожка");
        cockroaches.put(11, "Филлипочка");
        cockroaches.put(12, "Красная Шапочка");
        cockroaches.put(13, "Яблочко");
        cockroaches.put(14, "Апельсинка");
    }
    
    public static void main(String[] args) {
        System.out.println("---------------------------------------------");
        System.out.println("biConsumerExample():");
        biConsumerExample();
        System.out.println("---------------------------------------------");
        System.out.println("computeMethods():");
        computeMethods();
        System.out.println("---------------------------------------------");
        System.out.println("mergeAndReplaceAllMethods():");
        mergeAndReplaceAllMethods();
        System.out.println("---------------------------------------------");
    }

    public static void biConsumerExample() {
        //Пример на BiConsumer с методом forEach():
        cockroaches.forEach((key, value) -> System.out.println("Номер таракана: " + key + "; Имя: " + value));
        //А вто на дефолтный метод andThen()
        BiConsumer<Integer, String> english = (key, value) -> 
                System.out.println("key = " + key + "; value = " + value);
        BiConsumer<Integer, String> russian = (key, value) -> 
                System.out.println("ключ = " + key + "; значение = " + value); 
        BiConsumer<Integer, String> biConsumer = english.andThen(russian);
        cockroaches.forEach(biConsumer);
    }
    
    /*
    У каждого compute-метода есть "нефункциональный брат",
    то есть метод, работающий аналогично, но без использования
    функциональных интерфейсов.
    */
    public static void computeMethods() { 
        /*
        Метод compute() меняет значение по переданному ключу на то, 
        которое укажет ему метод apply() из переданной BuFunction.
        "нефункциональный брат" - метод put(). 
        */
        BiFunction<Integer, String, String> addNum = (num, str) -> "№" + num + " " + str;
        System.out.println("1-ый элемент: " + cockroaches.compute(1, addNum) + "\n-");    
        
        /*
        Метод computeIfPresent() заменит элемент под ключом key, если ключ key есть в мапе.
        "Нефункциональный брат" - метод replace().
        */
        System.out.println(cockroaches.computeIfPresent(13, addNum) + "\n-");
        
        /*
        computeIfAbsent() добавит элемент в мапу под указанным ключом, если такого ещё нет.
        А значением будет то, что вернёт поставленная в параметры Function.
        У этого метода тоже есть "нефункциональный брат" - putIfAbsent().
        */
        Function<Integer, String> randomCockroachParent = 
                arg -> new Random().nextBoolean()? "Бананчик" : "Шоколадка";
        System.out.println("15-ый элемент: " + cockroaches.computeIfAbsent(15, randomCockroachParent) + "\n-");
        System.out.println("1-ый элемент: " + cockroaches.computeIfAbsent(1, randomCockroachParent) + "\n-");
    }    
    
    public static void mergeAndReplaceAllMethods() { 
        /*
        После вызова merge(): 
        + Если в Map ключа key не существует, или value для этого ключа равно null,
        то метод добавляет в Map переданную пару key-value.
        + Если ключ Key существует и его value не null — 
        метод меняет его value на результат выполнения переданной функции remappingFunction.
        + Если remappingFunction возвращает null - key удаляется из коллекции.
        */
        System.out.println("\nДо:");
        cockroaches.forEach((key, value) -> System.out.println(value));
        cockroaches.merge(3, "Бананчик-тараканчик", (element, arg) -> arg + ": " + element);
        System.out.println("\nПосле:");
        cockroaches.forEach((key, value) -> System.out.println(value));
        System.out.println("-");
        //Метод relpaceAll() заменяет все значения результатом от переданной BiFunction.
        System.out.println("\nДо:");
        cockroaches.forEach((key, value) -> System.out.println(value));
        cockroaches.replaceAll((key, value) -> "Милый таракан: " + value);
        System.out.println("\nПосле:");
        cockroaches.forEach((key, value) -> System.out.println(value));
    }
}
