package theory.swing.dialogs;

import javax.swing.JOptionPane; 
/*
Диалоговое окно с несколькими кнопками позволяет получить от пользователя один из ответов.
Есть три стандартных набора кнопок: ОК/ОТМЕНА, ДА/НЕТ и ДА/НЕТ/ОТМЕНА.
*/
public class DialogWindowsWithMoreButtons{

    public static void main(String[] args) { 
        //За диалоговое окно с несколькими кнопками отвечает метод showConfirmDialog класса JOptionPane
        //Данный метод возвращает переменную типа int, в неё помещается то строка, которую обозначает нажатую кнопку
     
        /*
        Таблица чисел:
        0 - нажата кнопка "да"
        1 - нажата кнопка "нет"
        2 - нажата кнопка "отмена"
        */
     
        int answer = JOptionPane.showConfirmDialog(null, "Вы любите помидоры?", "Вопрос", 
        JOptionPane.YES_NO_CANCEL_OPTION); //Этот параметр отвечает за кнопки в диалоговом окне
     
        /*
        JOptionPane.OK_CANCEL_OPTION - кнопки "ок" и "отмена"
        JOptionPane.YES_NO_OPTION - кнопки "да", "нет" и "отмена"
        JOptionPane.YES_NO_CANCEL_OPTION - "кнопки" да "нет" и "отмена"
        */
     
        switch (answer) {
            case 0:
                JOptionPane.showMessageDialog
                        (null, "Вы любите помидоры", "Информация", JOptionPane.INFORMATION_MESSAGE);
            break;
            case 1:
                JOptionPane.showMessageDialog
                        (null,"Вы не любите помидоры", "Информация", JOptionPane.INFORMATION_MESSAGE);
            break;
            case 2:
                JOptionPane.showMessageDialog
                        (null, "Вы нажали отмена", "Информация", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }
  
}