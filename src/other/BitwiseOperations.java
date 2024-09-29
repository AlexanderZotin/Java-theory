package theory.other;

import java.util.Scanner;
/*
Побитовые операции раскладываю число на биты и заменяют их по разным принципам.
Их использование иногда помогает ускорить быстродействие программы.
Интересно, что у некоторых побитовых операторов есть братья -
логические операторы, работающие похожим образом.
*/
@SuppressWarnings("UnusedAssignment")
public class BitwiseOperations {

    public static void main(String [] args) {
        /*
        ~ (побитовое НЕ). Меняет значение бита на противоположенное: 1 на 0 и 0 на 1.
        Да-да, привет логический брат (!).
        */
        System.out.println("\nРезультат операции ~2: " + ~2 + "\n"); 
        
        /*
        & (побитовое И). Если значения обоих битов 1, то
        этот оператор оставит 1. В остальных случаях значения битов будут
        заменены на 0. Да-да, привет логический брат (&&).
        */
        System.out.println("Число 2 в двоичном коде: " + Integer.toBinaryString(2));
        System.out.println("Число 11 в двоичном коде: " + Integer.toBinaryString(11));
        System.out.println("Результат операции (2 & 11): " +  (2 & 11) + "\n");
        
        /*
        | (побитовое или). Если хотя бы один из битов будет равен 1,
        то в итоге получится 1. Иначе - 0. Да-да, привет логический брат (||).
        */
        System.out.println("Число 2 в двоичном коде: " + Integer.toBinaryString(2));
        System.out.println("Число 11 в двоичном коде: " + Integer.toBinaryString(11));
        System.out.println("Результат операции 2 | 11: " +  (2 | 11) + "\n");
        
        /*
        ^ (побитовое исключающее ИЛИ). Похоже по работе на обычное И. Отличие: вывод будет true,
        только если одно - true, а второе - false (то есть 2 true даёт false).
        С битами тоже самое: по сути, false - 0, а true - 1.
        */
        System.out.println("Число 2 в двоичном коде: " + Integer.toBinaryString(2));
        System.out.println("Число 11 в двоичном коде: " + Integer.toBinaryString(11));
        System.out.println("Результат операции 2 ^ 11: " +  (2 ^ 11) + "\n");
        
        /*
        << (сдвиг влево). "Передвигает" все биты на указанное количество. При дохождении "до края"
        биты теряются.
        */
        long a = 5L;
        System.out.println("Сдвиг влево: " + (a << 1) + "\n");
        
        /*
        >> (сдвиг вправо). Обратное действие сдвигу влево.
        */
        long b = 10L;
        System.out.println("Сдвиг вправо: " + (b >> 1) + "\n");
        
        usefulTips(); //А теперь к практике...
        aboutIncremetAndDecrement(); //Про ++ и --
    }
    
    public static void usefulTips(){
        //Применение ~ на практике:
        System.out.println("2*(-1) - 1 = " + ~2 + "\n"); //~x = x*(-1) - 1
        
        //Применение & на практике (проверка, является число степенью числа 2):
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int x = scanner.nextInt();
        boolean is = false;
        if(x != 0){
            is = (x & (x - 1)) == 0;
        }
        System.out.println("Число " + x + " является степенью числа 2? " + is + "\n");
        
        //Сдвиги на практике:
        long a = 10L;
        //a << x = a*2 x раз
        System.out.println(a + "*2 = " + (a << 1) + "\n"); 
        
        //a >> x = a/2 x раз
        System.out.println(a + "/2 = " + (a >> 1) + "\n");
        
        /*
        Использование & и >> на практике:
        Вот так можно найти из двух чисел большее.
        */
        int first = 1;
        int second = 7;
        System.out.println("Наибольшее число: " + (first - ((first - second) & ((first - second) >> 31))) + "\n");
    }
    
    public static void aboutIncremetAndDecrement(){
        /*
        Инкремент и декремент не относятся к побитовым операциям, 
        но про их работу тоже надо знать. Зачем создавать ради них
        отдельный теорфайл? Лучше пусть всё будет здесь.
        
        i++ - возвращает значение переменной, потом увеличивает её на 1.
        ++i - увеличивает на 1, потом возвращает значение.
        
        Отличие важно прежде всего в вычислениях.
        */
        int i = 2;
        i++;
        System.out.println("i: " + i);
        int j = 2;
        ++j;
        System.out.println("j: " + j);
        
        System.out.println("i: " + i++);
        System.out.println("j: " + ++j);
    }

}
