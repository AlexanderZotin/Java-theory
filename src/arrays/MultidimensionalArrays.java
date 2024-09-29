package theory.arrays;

/*
Многомерный массив - это массив массивов.
Многомерные массивы делятся на двумерные, трёхмерные, четырёхмерные и т.д
Здесь будут рассматриваться только двумерные, так как остальные используется редко.
Но нужно понимать, что такое трёхмерный массив: это массив тех массивов, в которых лежат массивы.
А четырёхмерный - это массив тех массивов, в которых лежат массивы массивов...
*/

public class MultidimensionalArrays {

    public static void main (String [] args) {
        //Объявляем двумерный массив типа int. Если бы мы хотели объявить трёхмерный, то пар квадратных скобок было бы три
        int [][] numbers = new int [][]{ 
	                                {1, 2, 3}, //Нулевой массив
	                                {4, 5, 6}, //Первый массив
									{7, 8, 9, 10} //Второй массив. Длинна рядов может быть разная!
									};
									
	    System.out.println("Выводится нулевой индекс нулевого массива:");	
        //Обращаемся к нулевому индексу нулевого массива (в данном случае это число 1)		
        System.out.println(numbers[0][0]); 
	    System.out.println("Выводится второй индекс первого массива:");	
        //Обращаемся ко второму индексу первого массива (в данном случае это число 5)		
	    System.out.println(numbers[1][2]); 
	 
	    //Можно произвести изменения какого - либо индекса:
	    System.out.println("Первый индекс нулевого массива до изменения: " + numbers[0][1]);
		//Уменьшаем первый индекс нулевого массива на 10 с помощью оператора '-='
	    numbers[0][1] -= 10; 
	    System.out.println("Первый индекс нулевого массива после изменения: " + numbers[0][1]);
	 
	    /*
	    Вывести многомерный массив на экран можно с помощью "двойного" цикла.
	    Это может быть и просто for, но гораздо удобнее в данном случае использовать foreach.
	    Внешний цикл проходится по массивам, которые лежат внутри двумерного, а внутренний -
	    по самим элементам.
	    */
	    System.out.println("Выводиться двумерный массив на экран: ");
	    for (int[] i : numbers) { 
            for (int j: i) { 
                System.out.print(j + " "); 
            }
            System.out.println();
        }
	 
	 
    }
}
