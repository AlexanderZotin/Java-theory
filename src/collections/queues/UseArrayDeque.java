package theory.collections.queues;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;
/*
Deque (Сокращение от Double Ended Queue) - двунаправленная очередь. 
Элементы в неё можно добавлять с двух концов, удалять с двух концов и получать
тоже с двух концов. Кроме того, коллекции, которые имплементируют Deque, 
можно использовать как стек.
*/
public class UseArrayDeque {

    public static void main(String [] args) {
        Deque<String> deque = new ArrayDeque<>();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Используем ArrayDeque в качестве стека (включаем swing)...");
        deque.push("Кролик");
        deque.push("Габадка");
        deque.push("Львёнок Шура");
        deque.push("Кошка Лемми");
        deque.push("Бимб");
        while(!deque.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Стек: " + deque + "\nТекущий элемент: " + deque.pop(), "ArrayDeque как стек",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Ок, с этим понятно. Переходим к двойным очередям:");
        System.out.println("Сначала будем добавлять элементы:");
        Random random = new Random();
        String[] arr = {"Пёс Собачий", "Цыпа", "Сестра", "Медведь", "Тараканы"};
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Очередь: " + deque);
            boolean first = random.nextBoolean();
            if(first) {
                System.out.println("Вызываем метод offerFirst():");
                deque.offerFirst(arr[i]);
            } else {
                System.out.println("Вызываем метод offerLast():");
                deque.offerLast(arr[i]);
            }
            System.out.println("Очередь после модификации: " + deque);
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Проитерируемся в обратном порядке:");
        Iterator<String> iterator = deque.descendingIterator();
        while(iterator.hasNext()) System.out.println(iterator.next());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("А теперь будем удалять элементы:");
        while(!deque.isEmpty()) {
            System.out.println("Очередь: " + deque);
            boolean first = random.nextBoolean();
            if(first) {
                System.out.println("Вызываем метод pollFirst():");
                deque.pollFirst();
            } else {
                System.out.println("Вызываем метод pollLast():");
                deque.pollLast();
            }
            System.out.println("Очередь после модификации: " + deque);
        }
        System.out.println("---------------------------------------------------------------------");
    }

}
