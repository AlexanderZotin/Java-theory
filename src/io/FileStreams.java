package theory.io;

import java.io.*;
import static java.io.File.separator;
import java.util.List;
import java.util.ArrayList;

/*
Классы для работы с выводом из пакета java.io можно поделить на 2 группы:
те, которые работают с байтами (наследники InputStream и OutputStream) и те,
которые работают с символами (наследники Reader и Writer).
 
Подробнее - в папке hierarchy. 
*/

public class FileStreams {
	private static String pathToTextFile = "src" + separator + "io" + separator + "FirstFile.txt";
	private static String pathToImage = "C:" + separator + "codes" + separator + "Дюк.gif";
	private static String pathToNewImage = "src" + separator +  "io" + separator + "Скопированное изображение.gif";
	
    public static void main(String [] args){  
        writeAndReadStrings();	
        copyImage();		
    }
	
	public static void writeAndReadStrings(){
	    /*
		Класс BufferWriter буферизирует запись в файл (то есть считывает информацию не отдельно
		по байтам, а по группам байтов). Но для работы этого объекта нужен объект, который
		умеет записывать в файл, но "по-обычному" (например FileWriter).
		*/
	    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToTextFile))){
		    bufferedWriter.write("Это строка!");
			System.out.println("Запись в файл прошла успешно!");
		} catch(IOException e){
		    System.err.println("Произошла ошибка при записи в файл. Подробнее:");
		    e.printStackTrace();
		}
		
		/*
		То же самое, только с чтением файла. Классы уже другие, но модель та же.
		*/
		System.out.println("Выводится содержимое файла:");
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToTextFile))){
		    String currentString;
            while ((currentString = bufferedReader.readLine()) != null){
                System.out.println(currentString);
            }
		} catch(IOException e){
		    System.err.println("Произошла ошибка при чтении файла. Подробнее:");
		    e.printStackTrace();
		}
		
		
	}
	
	public static void copyImage(){
	    List<Integer> bytesOfImage = new ArrayList<>();
		int currentByte;
	    try(
		    FileInputStream fileInputStream = new FileInputStream(pathToImage);
		    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 1000);
	    ) {
		    while((currentByte = bufferedInputStream.read()) != -1){
			    bytesOfImage.add(currentByte);
			}
			System.out.println("Картинка считана!");
		} catch (IOException e){
		    System.err.println("Не удалось прочитать файл. Попробуйте ещё раз!");
		    e.printStackTrace();
		}
		try(
		    FileOutputStream fileOutputStream = new FileOutputStream(pathToNewImage);
		    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		){
		    for(Integer i : bytesOfImage){
			    bufferedOutputStream.write(i);
			}
			System.out.println("Картинка скопирована!");
		} catch(IOException e){
		    System.err.println("Произошла ошибка при записи в файл. Подробнее:");
		    e.printStackTrace();
		}
	}

}
