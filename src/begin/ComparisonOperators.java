package theory.begin;

/*
Операторы сравнения - довольно полезная вещь и ими нужно уметь пользоваться
Некоторые из них можно использовать в конструкции if - else
*/

public class ComparisonOperators {

    public static void main (String [] args) {
        int number1 = 5;
        int number2 = 4;

        boolean check1 = (number1 == number2); // Проверяет, равны ли числа
        boolean check2 = (number1 != number2); //Проверяет неравенство чисел
        boolean check3 = (number1 > number2); //Проверяет, больше ли первое число второго
        boolean check4 = (number1 < number2); //Проверяет, меньше ли первое число второго
        boolean check5 = (number1 >= number2); //Проверяет, больше или равно первое число
        boolean check6 = (number1 <= number2); //Проверяет, меньше или равно первое число 

        String string1 = "Привет!";
        String string2 = "Пока!";
	    boolean isEqual = string1.equals(string2); //Строки сравниваются только так, а не с помощью "==" !!!
	 
	    //Выводим результаты на экран
        System.out.println(number1 + "=" + number2 +" - " + check1);
        System.out.println(number1 + " не равно " + number2 +" - " + check2);
        System.out.println(number1 + ">" + number2 +" - " + check3);
        System.out.println(number1 + "<" + number2 +" - " + check4);
        System.out.println(number1 + " больше или равно " + number2 +" - " + check5);
        System.out.println(number1 + " меньше или равно " + number2 +" - " + check6);
	    System.out.println("Строка " + string1 + " и строка " + string2 + " одинаковы - " + isEqual);
    }
}