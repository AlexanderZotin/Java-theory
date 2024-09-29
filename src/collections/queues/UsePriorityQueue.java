package theory.collections.queues;

import java.util.Queue;
import java.util.PriorityQueue;
/*
PriorityQueue - очередь с приоритетом. Приоретет определяется с помощью метода compareTo(),
если элементы имплементируею Comparable, или поставленным в конструктор Comparator'ом.
Чем меньше элемент, тем выше его приоритет.
Данная коллекция реализована на такой структуре данных, как двоичная (бинарная) куча
(англ. binary heap). Поиск, добавление и удаление элементов занимают O(logn) времени.
В файле "Двоичная куча.png" есть визуализация этой структуры данных
и схема, как она помещается в обычный массив. 
*/
public class UsePriorityQueue {

    public static void main(String [] args) {
	    Queue<String> queue = new PriorityQueue<>();
		queue.offer("Маша");
		queue.offer("Кролик");
		queue.offer("Бобоська");
		queue.offer("Бубарка");
		queue.offer("Кошка Лемми");
		queue.offer("Львёнок Шура");
		queue.offer("Зублик");
		queue.offer("Цыпа");
		queue.offer("Пёс Собачий");
		CashRegister cashRegister = new CashRegister(queue);
		cashRegister.open();
    }

}
