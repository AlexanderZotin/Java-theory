package theory.streams;

import java.util.Arrays;
/*
Методы distinct() и count() очень просты, чтобы создавать для них отдельный теорфайл,
поэтому я рассмотрю их вместе. К тому же, придумал классный пример, где используются оба.
1) distinct() возвращает стрим, в котором есть только уникальные элементы,
т.е удаляет дубликаты.  Для проверки уникальности используется метод equals().
2) count() возвращает количество элементов в стриме.
Ещё замечу, что count() - терминальный метод, так как возвращает НЕ стрим, а long.
*/
public class AboutDistinctAndCountMethods { 

    public static void main(String[] args) {
	    int[] array = {2, 4, 5, -2, 5, 77, 4, -3, 5, -2, 4, 67, -8, 0, 5, 7, 8, 9, -10, 45, 67, 54};
		System.out.println("Есть массив: " + Arrays.toString(array));
		//-----------------------------Пример 1 на distinct() и count()-----------------------------
		long distinctElements = Arrays.stream(array).distinct().count();
		System.out.println("Сколько в нём уникальных элементов? " + distinctElements);
		//-----------------------------Пример 2 на filter() и count()-------------------------------
		long positiveElements = Arrays.stream(array).filter(arg -> arg > 0).count();
		System.out.println("Сколько в нём положительных элементов?  " + positiveElements);
		//-----------------------------Пример 3 на filter() и count()-------------------------------
		long countOfPrimeRoots = Arrays.stream(array).filter(arg -> Math.sqrt(arg) % 1 == 0).count();
		System.out.println("Сколько в нём чисел, из которых легко вычисляется корень? " + countOfPrimeRoots);
    }

}
