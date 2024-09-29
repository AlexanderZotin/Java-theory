package theory.collections.sets;

import java.util.Set;
import java.util.HashSet;
/*
Set - множество. HashSet - одна из самых популярных реализаций, в которой
элементы не имеют какого-то определённого порядка. Set реализован на основе HashMap,
где каждый элемент складывается в мапу как ключ, а вместо значения ставится "заглушка".
Интерфейс Set не имеет каких-то собственных, уникальных методов - все они "украдены"
из Collection и Iterable.
*/
public class UseHashSet {

    public static void main(String [] args) {
        Set<String> set = new HashSet<>();
        set.add("Творог");
        set.add("Молоко");
        set.add("Конфеты \"Костёр\"");
        BuyPlan plan = new BuyPlan(set);
        plan.open();
    }
}
