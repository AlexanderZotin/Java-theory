package theory.dataTypes.references.string;

/*
Иногда действительно нужно красиво отформатировать строки.
Вот как это делается.
*/

public class FormatOfStrings {

    public static void main (String [] args) {
        System.out.println("Сейчас будут выводиться форматированные строки по правому краю:");
        //Спецификатор %25s означает, что строка будут отформатирована по правому краю на 25 символов. А \n делает перенос строки.
        System.out.printf("%25s\n", "Привет!");
        System.out.printf("%25s\n", "Как дела?!");
        System.out.printf("%25s\n", "Как успехи в java?");
        System.out.printf("%25s\n", "Пока!");
     
        System.out.println();
        System.out.println("А сейчас - по левому:");
        System.out.printf("%-25s\n", "Привет!"); //Знак минус форматирует по левому краю
        System.out.printf("%-25s\n", "Как дела?!");
        System.out.printf("%-25s\n", "Как успехи в java?");
        System.out.printf("%-25s\n", "Пока!");
     
        System.out.println();
        System.out.println("А сейчас будем форматировать целые числа:");
        System.out.printf("%25d\n", 5); //То же самое, только с целыми числами
        System.out.printf("%25d\n", 35);
        System.out.printf("%25d\n", 1000000);
        System.out.printf("%25d\n", -555);
     
        System.out.println();
        System.out.println("А сейчас будем округлять дробные числа:");
        System.out.printf("%.3f\n", 5.555555555555); //%.3f Округляет число до трёх знаков после запятой(если поставить другое число, то до другого количества знаков)
        System.out.printf("%.3f\n", 5.555555555555);
    }
}