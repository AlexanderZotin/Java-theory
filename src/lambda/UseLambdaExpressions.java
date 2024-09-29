package theory.lambda;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
/*
Лямбда-выражениями можно пользоваться тогда, когда какой-то метод/конструктор
принимает в параметры реализацию какого-то интерфейса.
До Java 8 это делалось с помощью анонимных классов, либо вообще
создавалась отдельная сущность. Лямбды позволяют сократить код и выкинуть "лишние слова".

Но! Лямбда-выражения будут работать только с функциональными интерфейсами, то есть
с интерфейсами, в которых только ОДИН АБСТРАКТНЫЙ метод.

Есть два способа написания данных выражений. Первый - это полный:
(Тип_Данных_параметра_метода имя_параметра) -> {сделать что-то; return что-то;}
И есть ещё краткий, но он подходит только тогда, когда в выражении не больше
одной строки, т.е statement'а. Вот краткий вариант:
имя_параметра -> return что-то
*/
public class UseLambdaExpressions { 

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Сначала пример с постановкой компаратора в конструктор TreeSet:");
        firstExample();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Теперь пример со swing...");
        secondExample();
        System.out.println("-------------------------------------------------------------------");
    }
    
    public static void firstExample() {
        //Вот так делали до 8 версии Java:
        NavigableSet<String> collections1 = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        });
        collections1.add("ArrayList");
        collections1.add("LinkedList");
        collections1.add("Vector");
        collections1.add("Stack");
        collections1.add("HashMap");
        collections1.add("LinkedHashMap");
        System.out.println(collections1);
        
        //А сейчас можно проще (полный вариант лямбда-выражения):
        NavigableSet<String> collections2 = new TreeSet<>((String first, String second) -> {
            return Integer.compare(first.length(), second.length());
        });
        collections2.add("ArrayList");
        collections2.add("LinkedList");
        collections2.add("Vector");
        collections2.add("Stack");
        collections2.add("HashMap");
        collections2.add("LinkedHashMap");
        System.out.println(collections2);
        //А можно и так (краткий вариант лямбда-выражения, тут я добавил записывание его в переменную):
        Comparator<String> comp = (first, second) -> Integer.compare(first.length(), second.length());
        NavigableSet<String> collections3 = new TreeSet<>(comp);
        collections3.add("ArrayList");
        collections3.add("LinkedList");
        collections3.add("Vector");
        collections3.add("Stack");
        collections3.add("HashMap");
        collections3.add("LinkedHashMap");
        System.out.println(collections3);
    }
    
    public static void secondExample() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Нажимайте кнопку, сколько хотите!");
        dialog.setLayout(new FlowLayout());
        JButton clickButton = new JButton("Это я, кнопка! Нажми меня!");
        JButton exitButton = new JButton("Выход");
        dialog.add(clickButton);
        dialog.add(exitButton);
        dialog.setSize(50, 50);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //Полный вариант
        clickButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Куку!", "Вы нажали кнопку", JOptionPane.WARNING_MESSAGE);
        });
        //Краткий вариант
        exitButton.addActionListener(e -> System.exit(0));
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
    }
}
