package theory.other;

/*
Здесь список всех вещей (иногда мелочей, иногда не очень), которые я узнал
из книги "Java на примерах: практика, практика и только практика"
*/
public class ListOfNewsFromBookJavaInExamples {

    public static void main(String [] args) {
        //1) Несколько переменных в цикле for
        for(int i = 0, j = 10; i < 10; i++, j--){
            System.out.println("-------------------------------------------");
            System.out.println("i = " + i);
            System.out.println("j = " + j);
            System.out.println("-------------------------------------------");
        }
        
        //2) Свойства побитового XOR
        int x = 666;
        int y = 12345;
        int z = x ^ y;
        System.out.println("z ^ y: " + (z ^ y)); //Тут будет x
        System.out.println("z ^ x: " + (z ^ x)); //Тут будет y
        
        //3) Везде тебя подстерегают опасности
        int intNumber = 2;
        //Вторые скобки обязательны! Иначе приведение типа будет относиться только к первому множителю!!!
        byte byteNumber = (byte) (intNumber * intNumber); 
        System.out.println("Число: " + byteNumber);
    }
}