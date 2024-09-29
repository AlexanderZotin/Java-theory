package theory.swing.dialogs;

import javax.swing.JOptionPane;
/*
С помощью диалогового окна с полем ввода можно получить от пользователя какую-либо строку
*/
public class DialogWindowsWithInput {

    public static void main (String [] args) {
	    //За диалоговое окно с полем ввода отвечает метод showInputDialog класса JOptionPane
	    //Данный метод возвращает переменную типа String, в неё помещается та строка, которую ввёл пользователь
	    String message = JOptionPane.showInputDialog(null, "Введите что-нибудь:");
	 
	    if(!message.isEmpty()) {
	        //Выведем на экран введённый пользователем метод в простом окне сообщения
            JOptionPane.showMessageDialog
			        (null, "Вы ввели: " + message, "Сообщение", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        //В случае нажатия ОК печатаем ошибку
	        JOptionPane.showMessageDialog(null, "Вы ничего не ввели!", "Ошибка", JOptionPane.ERROR_MESSAGE);
	    }
    }
}
