package theory.arrays;

import java.util.Arrays;

/*
Arrays - утилитарный класс дл¤ работы с массивами.
*/
public class MethodsOfClassArrays {

    public static void main(String [] args) {
	    int[] array = {3, -666, 666, 0, 10};
		
		/*
		toString(массив) - печатает массив на экран. Стоит заметить, что
		это вовсе не переопределение toString() из класса Object,
		так как у метода есть параметры. Да и метод статический :)
		*/
		System.out.println("Вывод массива на экран: " + Arrays.toString(array));
		
		/*
		copyOf() - копирование массива. Первый параметр - массив,
		из которого будут взяты значение, а второй - да какого индекса надо копировать.
		*/
		int[] newArray = Arrays.copyOf(array, array.length - 1);
		System.out.println("Все элементы массива, кроме последнего: " + Arrays.toString(newArray));
		
		/*
		copyOfRange() - тоже, что и copyOf(), только копирование будет производиться
		не с 0, а с указанного индекса.
		*/
		newArray = Arrays.copyOfRange(array, 2, array.length);
		System.out.println("Элементы с индекса 2 и до последнего: " + Arrays.toString(newArray));
		
		/*
		equals(). Ёто статический метод, то есть не переопределение метода object(). 
		Зачем же он нужен? Дело в том, что у массивов-то метод equals()
		не переопределён.
		*/
		int[] first = {1, 2, 3};
		int[] second = {1, 2, 3};
		System.out.println("Массивы равны? " + Arrays.equals(first, second));
		
		/*
		sort() - сортирует массив чисел от меньшего к большему.
		*/
		Arrays.sort(array);
		System.out.println("Отсортированный массив: " + Arrays.toString(array));
		
		/*
		fill() - заполняет массив одинаковыми значениями.
		*/
		int[] arr = new int[10];
		Arrays.fill(arr, 666);
		System.out.println("Вывод массива на экран: " + Arrays.toString(arr));
    }

}
