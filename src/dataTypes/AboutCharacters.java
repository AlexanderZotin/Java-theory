package theory.dataTypes;

import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
/*
Строки и символы в Java хранятся в кодировке UTF-16. У символов есть 
числовые значения. Например, 65 - это большая латинская буква 'A'.
Для того чтобы вывести на экран по коду, можно использовать
шестнадцатеричные значения.
Список тем и явлений, которые разбираются здесь
1) Числовые значения символов и как их можно использовать.
2) escape-последовательности
3) Как работать с эмодзи и сколько символов они занимают
*/
public class AboutCharacters {

    public static void main(String [] args) { 
	    System.out.println("-------------------------------------------------------------");
	    System.out.println("workWithCodePoints():");
		workWithCodePoints();
		System.out.println("-------------------------------------------------------------");
		System.out.println("escapedCharacters():");
		escapedCharacters();
		System.out.println("-------------------------------------------------------------");
		System.out.println("workWithEmoji():\nВключаем графический интерфейс...");
		workWithEmoji();
		System.out.println("-------------------------------------------------------------");
    }

	public static void workWithCodePoints() {
	    /*
		Ниже используется свойство латинских символов:
		ASCII-код заглавной буквы на 32 меньше маленькой.
		В UTF-16 коды латинских символов совпадают с ASCII-кодами...
        То есть если к char'у, в котором хранится буква 'a' прибавить 32,
        то получится 'A'. 		
		*/
	    Character[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		       'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	    UIManager.put("OptionPane.cancelButtonText", "Отмена");
		Character selected = (Character) JOptionPane.showInputDialog(null, "Выберите букву:", "", 
		        JOptionPane.QUESTION_MESSAGE, null, letters, letters[0]);
		if(selected == null) return;
		char upperCaseChar = (char) (selected - 32);
		msgBox("Маленькая: " + selected + "; Большая: " + upperCaseChar, 50);
	}
	
	public static void escapedCharacters() {
	    /*
		Есть такие символы, которые просто так не напечатаешь.
		Например, кавычки или перенос строки.
		Вот для них придумали специальные escape-последовательности.
		Их немного, поэтому их несложно запомнить.
		Важно: сами escape-последовательности
		считаются одним символом! И при чём длину остальной
		строки они не меняют: например, длинна строки
		1234\b5 равна 6. Т.е 4 никуда из строки не исчезает,
		всего лишь не печатается! И \b - один символ, а не два и не ноль. 
		*/
		
		//1. \n (Перенос строки)
	    System.out.println("Первая строка\nВторая строка");
		//2. \" (Кавычка)
	    System.out.println("\"Текст в двойных кавычках\"");
		//3. \' (Кавычка одинарная)
	    System.out.println("\'Текст в одинарных кавычках\'");
		//4. \\ (Один слеш влево)
	    System.out.println("Один слеш влево: \\");
		//5. \t (Табуляция). По сути, это выравнивание текста
	    System.out.println("***\t***\t***");
	    System.out.println("***\t***\t***");
	    System.out.println("***\t***\t***");
		/*
		6. \b (Backspace). Тут нюанс: командная строка не стирает последний символ.
		Поэтому после \b должно быть что-то ещё, например, пробел.
		*/
	    System.out.println("12345\b ");
		/*
		7. \r (Возврат каретки). Текст до \r будет перекрыт текстом после \r.
		Ну как будто реально сверху написали, только предварительно
		закрасив старые буквы :)
		Кстати, если текст до возврата каретки
		длиннее, чем после, то кусок первого текста будет
		"выглядывать" в конце, как в примере ниже (см. вывод в консоли)
		*/
		System.out.println("Вот был такой вот текст...\rИ поверх его ещё один!");
		/*
		8. \f (прогон страницы). Эта штука пришла из принтеров) Реально)
		Это что-то вроде разрыва страницы в ворде. Сейчас \f практически не
        используется, разрывы страницы для принтеров по-другому
		реализуются... Да и в принципе работа с принтером - нечастая задача :)
		Но знать об этой штуке всё равно надо.
		Данная esc-последовательность не предназначена для консоли, но
		всё же если это сделать, выходит прикольно: либо текст переносится
		на несколько строк и немного вправо (так происходит в онлайн-компиляторе), 
		либо выводится символ-обозначение женского пола))))) Забавно :)
		*/
		System.out.println("До\fПосле");
		
		/*
		Простое доказательство того, что escape-последовательности занимают один символ:
		попробуем поместить любую из них в char - и это получится сделать.
		А char - одиночный символ.
		*/
		char enter = '\n'; //И это скомпилируется!
		char slash = '\\'; //И это тоже!
		System.out.print("Слеш: " + slash + enter);
		System.out.print("Это уже другая строка!");
		System.out.println();
	}
	
	public static void workWithEmoji() {
	    /*
		Если нужно использовать какие-то необычные символы,
		например, эмодзи, то нужно найти 16-ричный код
		символа, поставить перед ним слеш влево и затем букву u.
		Хотя можно и просто взять 16-ичное числовое значение :)
		Но вот что важно: некоторые эмодзи хранятся 
		как два символа, т.е их лучше в строке держать. 
		*/
	    char umbrella1 = '\u2602';
		char umbrella2 = 0x2602; //Эта и предыдущая записи дадут одинаковый результат.
		msgBox(umbrella1);
		msgBox(umbrella2);
		//"Двухсимвольные" эмодзи
	    msgBox("\uD83D\uDE0E"); //Лицо в очках
	    msgBox("\uD83D\uDC4B"); //Ладонь
	    msgBox("\uD83D\uDC7B"); //Приведение
	    msgBox("\uD83D\uDE8C"); //Автобус
	    msgBox("\uD83D\uDCA3"); //Бомба
	    msgBox("\uD83D\uDE0D"); //Лицо с сердечками
	    msgBox("\uD83D\uDC80"); //Череп
	    msgBox("\uD83C\uDFF0"); //Замок
		
		//А теперь проверим гипотезу про "Двухсимвольные" эмодзи:
		System.out.println("Сколько символов занимает автобус? " + "\uD83D\uDE8C".length());
		char[] bus = "\uD83D\uDE8C".toCharArray();
		System.out.println("Длинна массива с автобусом: " + bus.length);
	}
	
	public static void msgBox(char ch) {
	    msgBox(String.valueOf(ch), 500);
	}
	
	public static void msgBox(String bigCharacter) {
	    msgBox(bigCharacter, 500);
	}
	
	public static void msgBox(String msg, int fontSize) {
	    JLabel label = new JLabel(String.valueOf(msg));
		label.setFont(new Font(null, Font.PLAIN, fontSize));
	    JOptionPane.showMessageDialog(null, label, "", JOptionPane.PLAIN_MESSAGE);
	}
}
