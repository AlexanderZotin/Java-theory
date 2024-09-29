package theory.collections.sets;

import java.util.Set;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class BuyPlan {
    private Set<String> set;

    public BuyPlan(Set<String> set) {
        if(set == null) throw new IllegalArgumentException("set не должен быть null!");
        this.set = set;
    }

    public void open() {
        UIManager.put("OptionPane.cancelButtonText", "Выход");
        while(true) {
            String[] options = {"Добавить товар", "Удалить товар", "Выход"};
            int selected = JOptionPane.showOptionDialog(null, toHtmlString(),
                    "План покупок", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(selected == 0) addItem();
            else if(selected == 1) removeItem();
            else System.exit(0);
        }
    }

    public void addItem() {
        String userInput = JOptionPane.showInputDialog(null,
                "Введите название товара, который хотите добавить в план:", "Добавление товара",
                JOptionPane.QUESTION_MESSAGE);
        if(userInput == null) return;
        JOptionPane.showMessageDialog(null, "Товар \"" + userInput +
                ((set.add(userInput))? "\" был добавлен." : " не был добавлен."), "",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void removeItem() {
        if(set.isEmpty()) {
            JOptionPane.showMessageDialog(null, "В плане нет ни одного товара!",
                    "Удаление невозможно", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] options = set.toArray(new String[0]);
        String selected = (String) JOptionPane.showInputDialog(null,
                "Выберите товар, который хотите удалить из плана:", "Удаление товара",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        JOptionPane.showMessageDialog(null, "Товар \"" + selected +
                ((set.remove(selected))? "\" был удалён." : " не был удалён."), "",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public String toHtmlString() {
        if(set.isEmpty()) {
            return "План не определён!";
        } else {
            Iterator<String> iterator = set.iterator();
            StringBuilder sb = new StringBuilder("<html><ul>");
            sb.append("Нужно купить:");
            while(iterator.hasNext()) {
                sb.append("<li>").append(iterator.next()).append("</li>");
            }
            sb.append("</ul></html>");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        return (set.isEmpty())? "План не определён!" : set.toString();
    }
}
