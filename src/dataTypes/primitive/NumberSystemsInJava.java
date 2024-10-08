package theory.dataTypes.primitive;

import static java.lang.System.out;
/*
Java - мощный язык и, конечно, позволяет записывать числа не только
в десятичной системе исчисления.
*/
public class NumberSystemsInJava {

    public static void main(String [] args) {
        /*
        1. Восьмеричные числа. Чтобы дать понять Jav'е, что число
        восьмеричное, надо просто поставить перед ним 0.
        И, естественно, цифр 8 и 9 в восьмеричных числах
        быть не может.
        Используются редко.
        */
        int number1 = 071;
        out.println(number1); //Но выведется это число всё равно в 10-чном виде
        /*
        2. Двоичные числа. В двоичной форме записи есть только нули и единицы.
        Это используется при работе с побитовыми операциями, т.к наглядна.
        Запись таких чисел начинается с 0b:
        */
        int number2 = 0b11010;
        out.println(number2); //Но выведется всё ранено в десятичной записи :(
        /*
        3. Шестнадацетиричные числа. Ух, я написал это слово :)
        Используется для обозначения символов в юникоде, например:
        char umbrella = 0x2602;
        
        Запись этого чуда начинается с 0x. Вместо "недостающих"
        цифр используются первые буквы латинского алфавита:
        A - 10; B - 11; C = 12; D - 13; E - 14; F - 15;
        */
        int number3 = 0xFFF; //Да, это число :)
        out.println(number3);
    }

}
