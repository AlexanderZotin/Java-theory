package theory.dataTypes.references.string;

/*
Класс StringBuilder следует использовать тогда, когда в программе
часто складываются строки. При обычном сложении строк
виртуальная машина каждый раз создаёт новую строку и лишь потом затирает ненужные.
Это сильно расходует память и тормозит приложение. 
Поэтому когда программа складывает строки большое количество раз,
нужно использовать класс StringBuilder.
*/
public class BuilderOfStrings {

    public static void main (String [] args) {
        //Создаём объект класса StringBuilder и передаём в параметрах изначальную строку
        StringBuilder stringBuilder = new StringBuilder("Java"); 
        //Выводим первоначальное значение на экран, используя метод toString()
        System.out.println("Вывод строки до изменения: " + stringBuilder);
      
        //С помощью метода append() добавляем к строке ещё несколько символов
        stringBuilder.append(" - лучший");
        System.out.println("Вывод строки после первого изменения: " + stringBuilder);
     
        //Так тоже можно делать.
        stringBuilder.append(" в мире ").append("язык программирования");
        System.out.println("Вывод строки после второго изменения: " + stringBuilder);
     
        stringBuilder.append(", поэтому я ");
        System.out.println("Вывод строки после третьего изменения: " + stringBuilder);
     
        stringBuilder.append("его изучаю.");
        //Выводим итоговый результат
        System.out.println("Вывод конечной строки: " + stringBuilder);
    }
}