package theory.swing.dialogs;

/*
Диалоговое окно с выпадающим списком позволяет пользователю выбрать один из предложенных вариантов.
*/

import javax.swing.JOptionPane; 

public class DialogWindowsWithList {

    public static void main(String [] args) {
	    //Объявляем и инициализируем массив
	    String[] variants = {"Яблоки", "Бананы", "Ананасы","Мандарины","Не могу точно сказать"}; 
        String selectedValue = (String) JOptionPane.showInputDialog(null, 
	            "Что вы любите больше?", "Выбор", //Заполняем окно текстом и даём ему название
	            JOptionPane.QUESTION_MESSAGE, //Выбираем иконку окна
                null, variants, //Указываем массив, в котором содержатся строки для вариантов выбора
	            variants[0]); //Выбираем вариант по умолчанию
	 
	    JOptionPane.showMessageDialog
	            (null,"Ваш выбор: " + selectedValue, "Информация", JOptionPane.INFORMATION_MESSAGE);
    }
}