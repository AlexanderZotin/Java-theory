package theory.swing.dialogs;

import javax.swing.JOptionPane; 
/*
С помощью диалогового окна такого типа можно сообщить пользователю
какую-либо информацию.
*/
public class DialogWindowWithMessage {

    public static void main (String [] args) {
	    //За диалоговое окно с сообщением отвечает метод showMessageDialog класса JOptionPane
        JOptionPane.showMessageDialog(null,
	            "Привет!", //Этот параметр отвечает за текст окна
	            "Приветствие", //А этот - за название окна
                JOptionPane.INFORMATION_MESSAGE);//Этот параметр отвечает за иконку окна
	 
	    /*
        JOptionPane.PLAIN_MESSAGE - без иконки
        JOptionPane.ERROR_MESSAGE - иконка ошибки
        JOptionPane.WARNING_MESSAGE - иконка предупреждения
        JOptionPane.QUESTION_MESSAGE - иконка вопроса
        JOptionPane.INFORMATION_MESSAGE - иконка информации
        */
	    JOptionPane.showMessageDialog(null, "Будь здоров!",  "А-пчхи!", JOptionPane.WARNING_MESSAGE);
	    JOptionPane.showMessageDialog(null,"Всё ОК?",  "Вопрос", JOptionPane.QUESTION_MESSAGE);
	    JOptionPane.showMessageDialog(null,"Пока!",  "Прощание...", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null,"Мне пора...",  "", JOptionPane.PLAIN_MESSAGE);
    }
}