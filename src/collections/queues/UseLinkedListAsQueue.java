package theory.collections.queues;

import java.util.Queue;
import java.util.LinkedList;
/*
Queue - очередь. Работает по принципу FIFO (first in, first out).
Кто встал в очередь первым, тот из неё первым и уйдёт.
Методы этого интерфейса можно поделить на две группы: те, которые
выбрасывают исключение, если что-то пошло не так и те, которые 
просто возвращают null.
-------------------------------------------------------
| Операция | Выбрасывает исключение | Возвращает null |
-------------------------------------------------------
| Вставка  | add(e)                 | offer(e)        |
-------------------------------------------------------
| Удаление | remove()               | poll()          |
-------------------------------------------------------
| Полуение | element()              | peek()          |
-------------------------------------------------------
*/
public class UseLinkedListAsQueue {

    public static void main(String [] args) {
	    Queue<String> queue = new LinkedList<>(); 
		queue.offer("Таракан Сбегучка");
		queue.offer("Таракан Большой");
		queue.offer("Тараканиха Светлая");
		queue.offer("Тараканиха Чебурашка");
		queue.offer("Таракан Оторванный");
	    CashRegister cashRegister = new CashRegister(queue);
		cashRegister.open();
    }

}
