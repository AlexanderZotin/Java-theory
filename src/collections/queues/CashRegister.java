package theory.collections.queues;

import java.util.Queue;
import javax.swing.JOptionPane;

public class CashRegister {
    private Queue<String> queue;
	
    public CashRegister(Queue<String> queue) {
	    if(queue == null) throw new IllegalArgumentException("Параметр queue не должен быть null!");
		this.queue = queue;
    }

	public void open() {
	    String[] options = {"Следующий покупатель", "Закрыть кассу"};
		while(true) {
	        int selected = JOptionPane.showOptionDialog(null, 
		            "Выберете действие:", "Касса", 0, JOptionPane.PLAIN_MESSAGE, null, 
				    options, options[0]);
		    if(selected == 0) nextBuyer();
		    else System.exit(0);
		}
	}
	
	private void nextBuyer() {
	    StringBuilder message = new StringBuilder();
	    if(queue.isEmpty()) message.append("Очередь пуста, покупателей пока нет!");
		else {
			message.append("Очередь: ").append(queue).append('\n')
			        .append("Обслуживается покупатель: ").append(queue.poll()).append('.');
		}
	    JOptionPane.showMessageDialog(null, message, "Касса", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override 
	public String toString() {
	    return "CashRegister: queue = " + queue;
	}
}
