package theory.io.serialization;

import static java.io.File.separator;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class LittleMoreAboutSerialization {
    private static String path = "src" +
    separator + "io" + separator + "serialization" + separator + "Ruler.ser";

    public static void main (String [] args) {
        writeObject();
	    readObject();
    }

    public static void writeObject() {
        Ruler ruler = new Ruler("Зелёный",30, 1);
	    /*
	    Этот необычный синтаксис появился в 7 версии java. Данная
	    конструкция называется try-with-resources. Её преимущество в том,
	    что все потоки, которые открыты в скобках перед try
	    будут автоматически закрыты. 
	    */
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(ruler);
        } catch (IOException e) {
	        System.err.println("Не удалось сериализовать объект!");
            System.exit(1);
	    }
	    System.out.println("Сериализация объекта прошла успешно!");
    }

    public static void readObject() {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
	        Ruler ruler = (Ruler) objectInputStream.readObject();
			System.out.println("Выводятся данные об объекте ruler: " + ruler);
	    } catch(IOException e) {
	        System.err.println("Не удалось десериализовать объект!");
		    e.printStackTrace();
		    System.exit(1);
	    } catch(ClassNotFoundException e) {
	        System.err.println("Ошибка! Класс Ruler был удалён или перемещён!");
		    System.exit(1);
	    } 
    }

}