package theory.dataTypes.references.string;

/*
Чтобы сравнить переменные ссылочного типа, нельзя использовать 
оператор "==", ведь "==" сравнивает не сами объекты, а лишь ссылки на них.
Для сравнения объектов ссылочного типа существует специальный метод equals(),
который определён в классе Object. Если необходимо использовать этот метод
для сравнения объектов своего класс, то в нём нужно переопределить метод equals().
(Об этом в классе Variables). 
Строки об обёртки тоже нужно сравнивать методом equals, ведь это тоже
ссылочные типы данных.
*/

public class ObjectComparison {

    public static void main (String [] args) {
        Variables variables1 = new Variables(5, '=');
        Variables variables2 = new Variables(5, '=');
        System.out.println("Неправильное сравнение объектов variables1 и variables2: ");
        System.out.println(variables1 == variables2); //Вывод: false
        System.out.println("Правильное сравнение объектов variables1 и variables2: ");
        System.out.println(variables1.equals(variables2)); //Вывод: true
     
        String string1 = "Привет!";
        String string2 = "Привет!";
        System.out.println("Неправильное сравнение строк string1 и string2: ");
        System.out.println(string1 == string2); //Вывод: true
        /*
        Иногда сравнение строк оператором "==" срабатывает верно. Почему?
        Дело в том, что существует такая вещь, как String Pool.
        Если создаётся строка, которая раньше была создана,
        то новая не создаётся, а указывает на то же самое место в памяти.
        Но String Pool работает не всегда и на него в серьёз полагаться не стоит.
        */
     
        System.out.println("Правильное сравнение строк string1 и string2: ");
        System.out.println(string1.equals(string2)); //Вывод: true
     
        String string3 = "Пока!";
        String string4 = new String("Пока!");
     
        System.out.println("Неправильное сравнение строк string3 и string4: ");
        System.out.println(string3 == string4); //Вывод: false.
        System.out.println("Правильное сравнение строк string3 и string4: ");
        System.out.println(string3.equals(string4)); //Вывод: true
    }
}