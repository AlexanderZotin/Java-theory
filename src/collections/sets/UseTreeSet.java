package theory.collections.sets;

import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.Iterator;
import javax.swing.JOptionPane;
/*
TreeSet - реализация упорядоченного множества. "Под капотом" использует TreeMap.
И обладает свойствами TreeMap'а, которые изложены в файле про TreeMap.
Имплементирует интерфейсы SortedSet и NavigableSet (Ну и Set, естественно, тоже).
*/
public class UseTreeSet {

    public static void main(String [] args) {
        NavigableSet<String> set = new TreeSet<>();
        set.add("Печенье");
        set.add("Яблоки");
        set.add("Апельсины");
        set.add("Бананы");
        set.add("Кефир");
        set.add("Йогурт");
        System.out.println("Прежде чем запускать класс ButPlan, поиграемся с сетом :)");
        System.out.println("Сначала просто проитерируемся:");
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Теперь то же самое, только в обратном порядке:");
        Iterator<String> descendingIterator = set.descendingIterator();
        while(descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
        System.out.println("Просто выведем set на экран: " + set);
        System.out.println("Перевернём: " + set.descendingSet());
        System.out.println("Теперь тестируем всякие методы:");
        System.out.println("Первый элемент сета: " + set.first());
        System.out.println("Последний элемент сета: " + set.last());
        System.out.println("Последний: " + set.last());
        System.out.println("set.headSet(\"Бананы\", true): " + set.headSet("Бананы", true));
        System.out.println("set.tailSet(\"Бананы\", true): " + set.tailSet("Бананы", true));
        System.out.println("set.subSet(\"Бананы\", true, \"Кефир\", true): "
                + set.subSet("Бананы", true, "Кефир", true));
        System.out.println("set.lower(\"Кефир\"): " + set.lower("Кефир")); //Выведется предыдущий элемент
        System.out.println("set.higher(\"Кефир\"): " + set.higher("Кефир")); //Выведется следующий элемент
        //Выведется самый большой элемент до "Каша"
        System.out.println("set.floor(\"Каша\"): " + set.floor("Каша")); 
        //Выведется самый маленький элемент после "Каша"    
        System.out.println("set.ceiling(\"Каша\"): " + set.ceiling("Каша")); 
        System.out.println("Теперь возьмём, и будем итерироваться, удаляя элементы (включаем swing!):");
        NavigableSet<String> copy = new TreeSet<>(set); 
        while(!copy.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Set: " + copy + ";\nТекущий элемент: " + copy.pollFirst(), 
                    "Выводим на экран и удаляем", JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println("Подключаем BuyPlan...");
        BuyPlan plan = new BuyPlan(set);
        plan.open();
    }

}
