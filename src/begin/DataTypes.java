package theory.begin;

/*
В языке java типы данных делятся на примитивные и ссылочные.
Здесь представлены все примитивные типы и один ссылочный. 
В чём их различие? Об этом попозже :)
*/
public class DataTypes {

    public static void main (String [] args) {
        // Строковой. В отличие от остальных типов данных, пишется с большой буквы, т.к. переменная ссылочного типа
        String text = "Привет!"; //НЕ ПРИМИТИВ!!!
        
        // Целочисленный (диапазон от -128 до 127) - 1 байт
        byte number1 = 1;
     
        // Целочисленный (диапазон от -32 768 до 32 767) - 2 байта
        short number2 = 1; 
        
        // Целочисленный (диапазон от -2 147 483 648 до 2 147 483 647) - 4 байта
        int number3 = 5;
     
        // целочисленный (диапазон от -9 223 372 036 354 775 808 до 9 223 372 036 354 775 807) - 8 байтов
        long number4 = 1000000000L;  
     
        // дробный - 8 байтов
        double number5 = 4.67; 
     
        // дробный (менее точный) - 4 байта
        float number6 = 5.5f; 
     
        // Одиночный символ - 2 байта. Обрати внимание: символ в одинарных кавычках!
        char singleCharacter = 'a';
        
        //логический (либо true, либо false) - 1 байт
        boolean logic = true;
     

        //Выводим значения переменных на экран
        System.out.println("Значение переменной text: " + text);
        System.out.println("Значение переменной number1: "+ number1);
        System.out.println("Значение переменной number2: " +  number2); 
        System.out.println("Значение переменной number3: "+ number3);
        System.out.println("Значение переменной number4: "+ number4);
        System.out.println("Значение переменной number5: "+ number5);
        System.out.println("Значение переменной number6: "+ number6);
        System.out.println("Значение переменной singleCharacter: " + singleCharacter);
        System.out.println("Значение переменной logic: " + logic);

    }
}