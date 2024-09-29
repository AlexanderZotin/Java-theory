package theory.begin;

/*
÷икл - это блок кода, который выполняется несколько раз
*/
public class Cycles {

    public static void main (String [] args) {
        // Цикл while. Выполняется, пока условие равно true
        System.out.println("Выполняется цикл while:");
        int number = 5;
	 
        while(true) {
            number++;
            System.out.println(number);
            if (number == 10) {
                break; //Оператор break используется дл¤ досрочного выхода из цикла
            }
        }
	 
        /* 
		Цикл for. Это цикл выполняется, пока условие равно true.
        Главное отличие от while в том, что используется только дл¤ работы с числами.
        */
        System.out.println("Выполняется цикл for:");
	 
        for (int number1 = 1; number1 < 50; number1++) { 
            /*Первый параметр - переменна¤, второй параметр - условие, пока цикл выполняется,
            третий параметр - изменение переменной (например, прибавление единицы, как в данном случае)*/
            if (number1 % 2 == 0) continue; //Оператор continue пропускает какую-либо интеграцию в цикле
            System.out.println(number1);
        }
	 
        //÷икл do ... while. Выполняется минимум один раз, даже если условие ложно
        System.out.println("Выполняется цикл do...while:");
        int number2 = 0;
	 
        do {
            number2++;
            System.out.println(number2);
        } while (number2 < 0); //≈сли условие будет верно, то цикл выполнится снова
	 
    }
}