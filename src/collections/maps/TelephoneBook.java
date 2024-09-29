package theory.collections.maps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TelephoneBook {
    private Map<Long, String> telephoneNumbers;
    
    public TelephoneBook(Map<Long, String> map) {
        telephoneNumbers = map;
        addImpotantNumbers();
    }
    
    private void addImpotantNumbers() {
        telephoneNumbers.put(101L, "Пожарная часть");
        telephoneNumbers.put(102L, "Полиция");
        telephoneNumbers.put(103L, "Скорая помощь");
        telephoneNumbers.put(104L, "Газовая служба");
        telephoneNumbers.put(112L, "Единый телефон экстренных служб");
        telephoneNumbers.put(900L, "Сбербанк");
        telephoneNumbers.put(666L, "Сатана");
    }    
    
    public void open() {
        String msg = toMarkedList(telephoneNumbers, "В телефонной книге есть номера следующих абонентов:");
        JOptionPane.showMessageDialog(null, "<html>" + msg + "</html>", "Список номеров", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private String toMarkedList(Map<Long, String> map, String title) {
        Iterator<String> iterator = map.values().iterator();
        StringBuilder sb = new StringBuilder(title);
        sb.append("<ul>");
        while(iterator.hasNext()) {
            sb.append("<li>").append(iterator.next()).append("</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }
    
    public void printFacts() {
        StringBuilder message = new StringBuilder();
        message.append("В телефонной книге ").append(telephoneNumbers.size())
        .append(" элементов, то есть она ")
        .append((telephoneNumbers.isEmpty())? "пустая.<br>" : "непустая.<br>")
        .append("<br>В книге ")
        .append((telephoneNumbers.containsValue("Единый телефон экстренных служб"))? "есть" : "отсутствует")
        .append(" Единый телефон экстренных служб.")
        .append("<br>В книге ")
        .append((telephoneNumbers.containsKey(89654312901L))? "есть" : "отсутствуют")
        .append(" данные о телефоне 89654312901.");
        if(telephoneNumbers instanceof NavigableMap<Long, String> navigableTelephoneNumbers) {
            message.append("<br>Первый телефон: ").append(navigableTelephoneNumbers.firstKey())
            .append("; Он принадлежит абоненту: ").append(navigableTelephoneNumbers.firstEntry().getValue())
            .append('.')
            .append("<br>Последний телефон: ").append(navigableTelephoneNumbers.lastKey())
            .append("; Он принадлежит абоненту: ").append(navigableTelephoneNumbers.lastEntry().getValue())
            .append('.');
            String emergencyServicesList = toMarkedList(navigableTelephoneNumbers.headMap(666L, false), 
                    "<br><br>Экстренные службы:");
            message.append(emergencyServicesList);
            String telephonsOfFriendsList = toMarkedList(navigableTelephoneNumbers.tailMap(900L, false), 
                    "Друзья:");
            message.append(telephonsOfFriendsList);
        }
        JOptionPane.showMessageDialog(null, "<html>" + message + "</html>", "Факты о телефонной книге", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void aboutNumbers() {
        UIManager.put("OptionPane.cancelButtonText", "Выход");
        while(true) {
            Object[] options = telephoneNumbers.keySet().toArray();
            Long key = (Long) JOptionPane.showInputDialog(null, "Какой телефон вас интересует?", 
                    "Выбор телефона", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(key == null) System.exit(0);
            JOptionPane.showMessageDialog(null, telephoneNumbers.get(key), "Телефон " + key, 
                    JOptionPane.INFORMATION_MESSAGE);
        }    
    }
    
    @Override
    public String toString() {
        return telephoneNumbers.toString();
    }
}
