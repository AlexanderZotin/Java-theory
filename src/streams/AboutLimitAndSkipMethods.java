package theory.streams;

import java.util.Arrays;
/*
Методы limit(), skip() похожи по своему назначению
limit() ограничивает число элементов в потоке: например, у нас есть
поток из чисел [3, 4, 6, -6, 3, 1, 5] и на нём будет вызван 
метод limit(3), то останутся числа [3, 4, 6].
skip() в каком-то смысле противоположен методу limit():
он, наоборот, удалит первые n элементов и оставит последние.
Например, если взять тот же поток (3, 4, 6, -6, 3, 1, 5), то останутся
[-6, 3, 1, 5]. Но лучше понять это на практике, что
будет и сделано чуть ниже :)
*/
public class AboutLimitAndSkipMethods {

    public static void main(String [] args) {
        //Пример 1: предположим, что нам надо найти первых пяти монстров по алфавиту
        System.out.println("\n-------------------------------Пример 1-------------------------------");
        String[] monstersFromBook = {"Ватя", "Банджю", "Маленький Монстрижка", "Монстриго",
                "Большой Монстрижка", "Ушастик", "Ушапусик", "Ушаноид", "Ушапарик", "Ушамалопарик",
                "Кабаноид", "Валерыч", "Бобыч", "Барабаныч", "Кабаняшка"};
        System.out.println("Первые 5 монстров по алфавиту:");
        Arrays.stream(monstersFromBook).sorted().limit(5).forEach(System.out::println);
        System.out.println("\nВсе остальные монстры:");
        Arrays.stream(monstersFromBook).sorted().skip(5).forEach(System.out::println);
        //Пример 2: предположим, нам надо взять случайную подстроку
        System.out.println("-------------------------------Пример 2-------------------------------");
        String source = "I like Java";
        for(int i = 0; i < 20; i++) {
            int[] codePoints = source.codePoints().limit(1 + Math.round(Math.random() * 10)).toArray();
            String resultStr = new String(codePoints, 0, codePoints.length);
            System.out.println(resultStr);
        }
        System.out.println("----------------------------------------------------------------------");
    }

}
