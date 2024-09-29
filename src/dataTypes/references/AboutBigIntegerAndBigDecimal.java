package theory.dataTypes.references;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
/*
Если число не влезает даже в long - не беда! Ведь есть java.math.BigInteger!
НО: важно помнить, что классы BigInteger и BigDecimal 
являются неизменяемыми и потребляют больше памяти, чем примитивы.
*/
public class AboutBigIntegerAndBigDecimal {

    public static void main(String [] args) {
		aboutBigInteger();
		aboutBigDecimal();
    }
	
	public static void aboutBigInteger(){
	    BigInteger veryLongNumber = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999");
		System.out.println("\nСейчас на экране появится очень большое число:\n" + veryLongNumber);
		veryLongNumber = veryLongNumber.add(BigInteger.valueOf(2));
		System.out.println("Сейчас это огромное число будет увеличено на 2:\n" + veryLongNumber);
		veryLongNumber = veryLongNumber.subtract(BigInteger.valueOf(1));
		System.out.println("Сейчас это огромное число будет уменьшено на 1:\n" + veryLongNumber);
		veryLongNumber = veryLongNumber.multiply(veryLongNumber);
		System.out.println("Сейчас это огромное число будет умножено на само себя:\n" + veryLongNumber);
		veryLongNumber = veryLongNumber.divide(veryLongNumber);
		System.out.println("Сейчас это огромное число будет поделено на само себя:\n" + veryLongNumber);
		System.out.println("На экран выводится тип int: " + veryLongNumber.intValue());
		System.out.println("На экран выводится тип float: " + veryLongNumber.floatValue());
	}
	
	public static void aboutBigDecimal(){
	    BigDecimal veryLongNumber = new BigDecimal("66666666666666666666666666666666.666666666666666666666666666666666666666666666666666666");
		System.out.println("\nСейчас на экране появится очень большое число c плавающей точкой:\n" + veryLongNumber);
	
		/*
		BigDecimal предоставляет возможность по-разному округлять числа.
		Для этого используется метод setScale(). Первый параметр (int) - это
		кол-во знаков после запятой, а второй - режим округления.
		*/
		BigDecimal normalNumber = new BigDecimal("2.666");
		System.out.println("На экран выводится число с плавающей точкой: " + normalNumber);
		
		System.out.println("Округление числа в большую сторону: " + normalNumber.setScale(0, RoundingMode.CEILING));
		System.out.println("Отбрасывание разряда: " + normalNumber.setScale(0, RoundingMode.DOWN));
		System.out.println("Округление числа в меньшую сторону: " + normalNumber.setScale(0, RoundingMode.FLOOR));
		System.out.println("Округление числа в большую сторону, если число после запятой > 5: " + normalNumber.setScale(0, RoundingMode.HALF_UP));
		System.out.println("Округление числа в  сторону, если число после запятой < 5: " + normalNumber.setScale(0, RoundingMode.HALF_DOWN));
		System.out.println("Округление числа в зависимости от цифры слева от запятой (Если чётная - то в большую сторону, иначе - в меньшую): " + normalNumber.setScale(0, RoundingMode.HALF_EVEN));
		System.out.println("Округление числа в большую сторону: " + normalNumber.setScale(0, RoundingMode.UP));
		//Следующая строка выбрасывает java.lang.ArithmeticException
		// System.out.println("Делаем вид, что округление не требуется: " + normalNumber.setScale(0, BigDecimal.ROUND_UNNECESSARY));
		
		/*
		Если сравнивать BigDecimal методом equals(), то будут сравнены не просто числа в объектах,
		а объекты со всеми полями, то есть будет ещё учитываться параметр scale и нули после запятой. А для
		сравнения самих чисел есть метод compareTo(). Он возвращает 0, если числа равны, 
		-1, если число меньше переданного в параметры и 1, если число больше переданного в параметры.
		*/
		
		BigDecimal first = new BigDecimal("0.3");
        BigDecimal second = new BigDecimal("0.30");

        System.out.println("Числа равны? " + first.equals(second));
        System.out.println("-1 - первое число меньше второго, 0 - числа равны, 1 - первое больше второго: "
    	        + first.compareTo(second));
	}
}