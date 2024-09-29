package theory.begin;

/*
Ћогические операторы играют большую роль и в отдельных логических выражениях,
и в конструкции if-else
*/

public class LogicOperators {

    public static void main (String [] args) {
        //ќбъ¤вл¤ем переменные
        boolean isTrue1 = true;
        boolean isTrue2 = true;
        boolean isFalse1 = false;
        boolean isFalse2 = false;
     
        // Логический оператор && (и)
        // Значение переменной result1 будет равно истине, так как значения переменных isTrue1 и isTrue2 равняются истине
        boolean result1 = isTrue1 && isTrue2; 
        //Значение переменной result2 будет равно лжи, так как значения переменных isFalse1 и isFalse2 равняются лжи
        boolean result2 = isFalse1 && isFalse2;
        //Значение переменной result3 будет равно лжи (значение переменной isTrue1 - истина, переменной isFalse1 - ложь, в таком случае "побеждает" ложь)
        boolean result3 = isTrue1 && isFalse1;
  
        // Ћогический оператор || (или)
        boolean result4 = 5 != 5 || 6 == 7 || 2 + 2 == 5 || 6 > 8; // Значением переменной result4 будет ложь, так как все варианты - ложь
        boolean result5 = 5 != 5 || 6 == 7 || 2 + 2 == 4 || 6 > 8; // Одно из значений - истина, поэтому значение переменной result5 будет равно истине
     
        //Ћогический оператор ! (не)
        //ћен¤ет значение переменной типа boolean на противоположенное
        boolean result6 = true;
        result6 = !result6;
     
        //Выводим результаты на экран
        System.out.println("Общее значение переменных isTrue1 и isTrue2: " + result1);
        System.out.println("Общее значение переменных isFalse1 и isFalse2: " + result2);
        System.out.println("Общее значение переменных isTrue1 и isFalse2: " + result3);
        System.out.println("Значение переменной result4:  " + result4);
        System.out.println("Значение переменной result5 " + result5);
        System.out.println("Новое значение переменной result6: " + result6);
    }
}