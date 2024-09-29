package theory.other;

import java.util.Optional;
import java.util.Random;
/*
Optional - класс, который появился в Java 8.
Его призвание - борьба с NPE (NullPointerException).
Объект этого класса представляет собой "контейнер" для
хранения либо другого объекта, либо пустоты.

Зачем же Optional, если можно просто объекты на null
проверять? А за тем, что:
1) Optional показывает, что значение может быть null.
2) Optional предоставляет удобные методы. Например, orElse().
3) Optional очень пригождается при работе со Stream API.
*/
public class UseOptional {

    public static void main(String[] args) {
        /*
        У Optional'а приватные конструкторы. Создаются объекты с помощью методов-фабрик.
        Первый подходит только для not-null значений, иначе получится БАБАХ (NPE).
        */
        Optional<String> optional1 = Optional.of("Тараканы");
        //Тут БАБАХ'а не будет.
        Optional<String> nullableOptional = Optional.ofNullable(null);
        //То же самое, что и Optional.ofNullable(null):
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("\nУ Optional переопределён метод toString(): " + optional1);
        //Метод equals() у Optional тоже переопределён
        boolean resultOfTest = nullableOptional.equals(emptyOptional);
        System.out.println
                ("А сейчас докажем, что Optional.ofNullable(null) и Optional.empty() - одно и то же: " + 
                resultOfTest);
        //Прежде чем доставать значение из Optional, стоит проверить, есть ли там что-то:
        System.out.println(optional1.isPresent()? 
                ("Получаем значение из Optional'а: " + optional1.get()) : "В Optional'е null!");
        /*
        Есть ещё три классных метода для получения значения: orElse(T other), 
        orElseGet(Supplier<? extends T> other), orElseThrow(Supplier<? extends X> exceptionSupplier)
        */
        System.out.println(optional1.orElse("Внутри null!"));
        System.out.println(nullableOptional.orElseGet(() ->
                String.valueOf(new Random().nextInt(10))));
        System.out.println(emptyOptional.orElseThrow(IllegalStateException::new));
    }

}
