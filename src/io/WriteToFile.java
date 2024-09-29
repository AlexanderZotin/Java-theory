package theory.io;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
/*
Пример программы с записью в файл с помощью класса java.io.PrintWriter.
*/
public class WriteToFile {

    public static void main (String [] args) {
		writeToFile();
    }
  
    public static int getQuantityOfStrings(){
        Scanner scanner = new Scanner(System.in);
	    while(true){
	        System.out.println("Введите количество строк в новом файле: ");
	        String userInput = scanner.nextLine();
	        try {
	            int quantityOfLines = Integer.parseInt(userInput);
			    if(quantityOfLines < 1){
			        System.out.println("Введено некорректное количество строк: " + quantityOfLines);
			    } else {
			        System.out.println("-------------------------------------------------");
			        return quantityOfLines;
			    }
	        } catch (NumberFormatException e){
	         System.out.println("Количество строк нужно вводить цифрами, а не буквами!");
	        }
        }
    }
  
    private static String[] getStringsFromUser(){
        System.out.println("-------------------------------------------------");
        int quantityOfStrings = getQuantityOfStrings();
        String [] userStrings = new String[quantityOfStrings];
	    Scanner scanner = new Scanner(System.in);
	    int currentString = 1;
	    for(int i = 0; i < quantityOfStrings; i++){
	        System.out.println("Введите строку №" + currentString);
	        userStrings[i] = scanner.nextLine();
		    currentString++;
	    }
	    System.out.println("-------------------------------------------------");
	    return userStrings;
    }
  
    public static void writeToFile(){
        String separator = File.separator;
	    String path = "src" + separator + "io" + separator + "test3.txt";
	    File file = new File(path);
	    try {
	        PrintWriter writer = new PrintWriter(file); 
	        String[] strings = getStringsFromUser();
	        for(String currentString : strings){
                writer.println(currentString);
	        }
		    writer.close();
		    System.out.println("Запись в файл прошла успешно!");
		    readFile(file);
	    } catch(FileNotFoundException e){
	        System.err.println("Ошибка! Не удалось создать файл! Возможно, указанной директории не существует!");
	    }  
    }
  
    public static void readFile(File file) throws FileNotFoundException{
        Scanner scanner = new Scanner(file);
	    System.out.println("-------------------------------------------------");
	    System.out.println("Выводится содержимое файла: ");
	    while(scanner.hasNextLine()){
	        System.out.println(scanner.nextLine());
	    }
	    System.out.println("-------------------------------------------------");
	    scanner.close();
    }
}