package theory.io.serialization;

import static java.io.File.separator;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
В java можно сериализовывать массивы, ведь массив - тоже объект!
При чём можно сериализовывать массивы любых типов данных,
даже примитивов. Есть два способа как это сделать. Оба подойдут для
массивов с объектами и лишь один - для массива с примитивами.
*/

public class SerializationOfArrays {

    private static String firstPath = "src" +
            separator + "io" + separator + "serialization" + separator + "ArrayOfStrings.ser";
  
    private static String secondPath = "src" +
            separator + "io" + separator + "serialization" + separator + "ArrayOfNumbers.ser";
  
    public static void main (String [] args) {
        firstWayToWriteArray();
	    firstWayToReadArray();
        secondWayToWriteArray();
	    secondWayToReadArray();
    }
  
    /*
    Первый способ сериализации массивов - запись его длинны и всех 
    элементов как объекты. Этот способ подходит только для массивов с переменными ссылочных
    типов данных, и пожалуй, способ посложней, чем второй. Но знать и об этом тоже надо.
    */
    public static void firstWayToWriteArray() {
	   ObjectOutputStream objectOutputStream = null;
       String [] array = DataGetter.getArrayOfStringsFromUser();
	   System.out.println(Arrays.toString(array));
       try {
            FileOutputStream fileOutputStream = new FileOutputStream(firstPath);
	        objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeInt(array.length); //Записываем в файл длину массива
		 
		    for(String currentString : array) {
		        //Записываем каждый элемент массива как отдельный объект
		        objectOutputStream.writeObject(currentString); 
		    }
		 
	        objectOutputStream.close(); //Закрываем поток =)
		    System.out.println("Сериализация массива строк прошла успешно!");
	    } catch (IOException e) {
	        System.err.println("Не удалось сериализовать массив строк!");
	    } finally {
		    if(objectOutputStream != null) {
			    try {
			        objectOutputStream.close();
				} catch(IOException e) {
				    System.err.println("Не удалось закрыть поток objectInputStream!");
				}
			}
		}
    }
  
    /*
    Второй способ сериализовать и десериализовать массив - это рассматривать сам массив как
    объект. Этот способ проще, короче. К тому же, таким образом можно сериализовать не только массив 
    ссылочных типов данных, но и массив примитивов. Пожалуй, при разработке лучше пользоваться
    именно этим способом.
    */
    public static void secondWayToWriteArray() {
	    ObjectOutputStream objectOutputStream = null;
        int[] array = DataGetter.getArrayOfNumbersFromUser();
	    System.out.println(Arrays.toString(array));
	    try {
	        FileOutputStream fileOutputStream = new FileOutputStream(secondPath);
	        objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeObject(array); //Просто записываем массив как объект в файл
	        objectOutputStream.close();//Закрываем поток =)
		    System.out.println("Сериализация массива чисел прошла успешно!");
	    } catch (IOException e) {
	        System.err.println("Не удалось сериализовать массив чисел!");
	    } finally {
		    if(objectOutputStream != null) {
			    try {
			        objectOutputStream.close();
				} catch(IOException e) {
				    System.err.println("Не удалось закрыть поток objectInputStream!");
				}
			}
		}		
    }
  
    public static void firstWayToReadArray() {
	    ObjectInputStream objectInputStream = null;
        try {
	        FileInputStream fileInputStream = new FileInputStream(firstPath);
            objectInputStream = new ObjectInputStream(fileInputStream);
		    int length = objectInputStream.readInt();
		    String[] array = new String[length];
		 
		    for(int i = 0; i < length; i++) {
		        array[i] = (String) objectInputStream.readObject();
		    } 
		 
		    objectInputStream.close(); //Закрываем поток =)
		    System.out.println("Десериализация массива прошла успешно!");
		    System.out.println(Arrays.toString(array));
	    } catch(IOException e) {
	        System.err.println("Не удалось десериализовать массив из файла " + firstPath);
	    } catch (ClassNotFoundException e) {
	        System.err.println("Ошибка! java на вашем компьютере повреждена, попробуйте её переустановить!");
	    } finally {
		    if(objectInputStream != null) {
			    try {
			        objectInputStream.close();
				} catch(IOException e) {
				    System.err.println("Не удалось закрыть поток objectInputStream!");
				}
			}
		}
    }
  
    public static void secondWayToReadArray() {
	     ObjectInputStream objectInputStream = null;
        try {
	        FileInputStream fileInputStream = new FileInputStream(secondPath);
            objectInputStream = new ObjectInputStream(fileInputStream);
	        int[] array = (int[]) objectInputStream.readObject(); //Считываем массив как объект
	        objectInputStream.close(); //Закрываем поток =)
		    System.out.println("Десериализация массива прошла успешно!");
            System.out.println(Arrays.toString(array));
 	    } catch(IOException e) {
	        System.err.println("Не удалось десериализовать массив из файла " + secondPath);
	    } catch(ClassNotFoundException e) {
	        System.err.println("Ошибка! java на вашем компьютере повреждена, попробуйте её переустановить!");
	    } finally {
		    if(objectInputStream != null) {
			    try {
			        objectInputStream.close();
				} catch(IOException e) {
				    System.err.println("Не удалось закрыть поток objectInputStream!");
				}
			}
		}
    }
  
}