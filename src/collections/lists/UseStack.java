package theory.collections.lists;

import java.util.Stack;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
/*
java.util.Stack - это коллекция, которая наследуется от java.util.Vector.
Она тоже появилась в JDK1.0 и тоже синхронизирована.
Как и Vector, эта коллекция является устаревшей.
Вместо неё рекомендуется использовать Deque или потокобезопасные
версии Deque из java.util.concurrent.

Реализует такую структуру данных как стек.
Стек работает по принципу LIFO (last in, first out - последним пришёл, первым ушёл)
Это как стопка книг: первой будет взята книга, которая положена последней.

Краткий обзор методов Stack:
1. E push(E item) - добавляет элемент в стек
2. E pop() - удаляет элемент с верхушки стека и удаляет его
3. E peek() - возвращает элемент с "верхушки" стека, но не удаляет его
4. boolean empty() - старый метод, дублирующий isEmpty() в классе Vector
5. int search(Object o) - возвращает позицию элемента, НАЧИНАЯ С КОНЦА.
И отсчёт ВЕДЁТСЯ С 1, а не с 0! Если элемент не найден, возвращает -1.
*/
public class UseStack {

    public static void main(String [] args) {
        UIManager.put("OptionPane.okButtonText", "Далее"); 
        UIManager.put("OptionPane.cancelButtonText", "Отмена"); 
        Stack<Integer> stack = createStack();
        testStack(stack);
    }
    
    private static Stack<Integer> createStack() {
        int size
                ;
        while(true) {
            String userInput = JOptionPane.showInputDialog(null, "Сколько элементов будет в стеке?",
                    "Ввод", JOptionPane.QUESTION_MESSAGE);
            if(userInput == null) System.exit(0);
            try {
                size = Integer.parseInt(userInput);
                if(size < 0) {  
                    JOptionPane.showMessageDialog(null, "Стек не может иметь отрицательный размер!", 
                        "Неверный ввод", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Нужно было ввести целое число прописью!", 
                        "Неверный ввод", JOptionPane.ERROR_MESSAGE);
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= size; i++) {
            stack.push(i);
        }
        return stack;
    }
    
    private static void testStack(Stack<?> stack) {
        if(stack == null) throw new IllegalArgumentException("Параметр stack не должен быть null!");
        while(true) { 
            if(stack.empty()) {
                JOptionPane.showMessageDialog(null, "Стек пуст!", "Прохождение по стеку",
                    JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            JOptionPane.showMessageDialog(null, 
                    "Стек: " + stack + "; Верхний элемент: " + stack.pop(), 
                    "Прохождение по стеку",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
