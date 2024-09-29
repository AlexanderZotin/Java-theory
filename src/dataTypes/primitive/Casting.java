package theory.dataTypes.primitive;

public class Casting {

    public static void main (String [] args) {
        long longNumber1 = 100L; 
        //При создании переменной типа long после значения ставим букву L, чтобы jvm понимала,
        //что это точно long, а не что-нибудь другое

        //Это явное приведение типа. Мы говорим jvm, что знаем, что long поместиться¤ в int
        int intNumber1 = (int) longNumber1;


        int intNumber2 = 50;
        //Это неявное приведение типа. JVM точно знает, что int поместиться в long
        long longNumber2 = intNumber2;

        System.out.println("Выводится значение переменной intNumber1: " + intNumber1);
        System.out.println("Выводится значение переменной longNumber2: " + longNumber2);

        //Но что же будет, если мы попытаемся "солгать" jvm?
        byte byteNumber =  (byte) 128; //максимальное значение - 127
        System.out.println("Выводится значение переменной byteNumber: " + byteNumber);
        /*
        Выведется значение -127. почему? Всё просто: дл¤ типа byte значение 128 слишком большое.
        И значение берётся "из следующего круга": после максимального значения отсчёт с минимального значения(-128)
        и это -127
        */
    }
}