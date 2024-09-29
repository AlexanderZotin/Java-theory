package theory.dataTypes.references.string;

import static java.lang.System.out;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
/*
Здесь будут рассмотрены основные конструкторы класса String.
Не представлены: пустой конструктор, устаревшие и 
ещё те, которые конвертируют строку, используя кодировку
по умолчанию. 
*/
public class StringConstructors {

    public static void main(String [] args) {
	    //1. String(String original)
		String str = new String("Это строка!");
		out.println(str);
		//2. String(StringBuilder builder)
		StringBuilder builder = new StringBuilder();
		builder.append("Случайное число: ").append(Math.round(Math.random() * 10)).append(';');
		str = new String(builder);
		out.println(str);
		//3. String(StringBuffer buffer)
		StringBuffer buffer = new StringBuffer();
		buffer.append("Выбираем случайным образом 0 или 1: ").append(Math.round(Math.random())).append(';');
		str = new String(buffer);
		out.println(str);
		//4. String(char[] value)
		char[] value = {'Ш', 'у', 'р', 'и', 'к'};
		str = new String(value);
		out.println(str);
		//5. String(char[] value, int offset, int count)
		str = new String(value, 2, 2);
		out.println(str);
		/*
		6. String(byte[] bytes, Charset charset)
		Конвертировать строку в массив байтов и обратно легко.
		Если надо получить байты из строки - то на помощь приходит метод getBytes(Charset).
		Если наоборот - то есть конструктор
		*/
	    byte[] bytes = "Это привидение: \uD83D\uDC7B".getBytes(StandardCharsets.UTF_8);
		str = new String(bytes, StandardCharsets.UTF_8);
		JOptionPane.showMessageDialog(null, str, "", 0);
		/*
		7. String(byte[] bytes, int offset, int length, Charset charset)
		Тут стоит сказать про параметр length. Это не количество символов
		в строке, а количество байтов, которые будут использоваться.
		Ведь один символ может занимать от 1 до 4 байтов памяти.
		*/
		bytes = "Пёс Собачий".getBytes(StandardCharsets.UTF_8);
		str = new String(bytes, 0, 6, StandardCharsets.UTF_8);
		out.println(str);
		/*
		8. String(int[] codePoints, int offset, int count)
		массив codepoints - это номера символов в юникоде.
		*/
		int[] codePoints = {65, 66, 67, 68};
		str = new String(codePoints, 0, codePoints.length);
		out.println(str);
    }
} 
