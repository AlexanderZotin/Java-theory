package theory.enums;

import java.util.Scanner;

/*
У перечислений есть некоторые удобные методы для работы с ними.
Вот они:
1) name(). Возвращает имя константы, как она объявлена в перечислении.

Month month = Month.May;
System.out.println(month.name());

Вывод: May

2) values(). Возвращает массив из сех констант перечисления.

Month[] monthes = Month.values();
System.out.println(java.util.Arrays.toString(monthes));

Вывод слишком длинный, поэтому приводить его не буду =).

3) valueOf(). Возвращает enum-константу по заданному имени. Если такой
константы не существует, то выбрасывается исключение java.lang.IllegalArgumentException.

Month month = Month.valueOf("June");
System.out.println(month);

Вывод: Название месяца: June; Перевод на русский язык: Июнь; Порядковый номер месяца: 6;

4) ordinal(). Выводит порядковый номер enum-константы. Важно: отсчёт начинается с нуля, как в массивах!

Month month = Month.January;
System.out.println(month.ordinal());

Вывод: 0
*/

public class MethodsOfEnums {

    public static void main(String [] args){ 
        System.out.println("--------------------------------------------------------");
        int index = (int) Math.round(Math.random() * 10);
        Month[] monthes = Month.values();
        Month month = monthes[index];
        askAboutMonth(month);
    }
  
    private static void askAboutMonth(Month month){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("--------------------------------------------------------");
            System.out.println("Как будет по-английски " + month.getTranslation() + "?");
            String userInput = scanner.nextLine();
            try {
                Month userMonth = Month.valueOf(userInput);
                if(userMonth.equals(month)){
                    System.out.println("Верно! " + month.getTranslation() + 
                    " по-английски будет " + month.name() +
                    ". Его порядковый номер - " + month.ordinal() + ".");
                    break;
                } else {
                    System.err.println("Неверно! " + userMonth.name() + " - это не " + month.getTranslation() + ".");
                }
            } catch (IllegalArgumentException e){
                System.err.println("Вы не ввели название месяца на английском языке!");
            }
        }
        System.out.println("--------------------------------------------------------");
    } 
  
}