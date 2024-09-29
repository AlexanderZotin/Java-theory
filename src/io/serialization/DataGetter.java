package theory.io.serialization;

import java.util.Scanner;

public class DataGetter {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] getArrayOfNumbersFromUser() {
        int length = getLengthFromUser();
        int[] numbers = new int[length];
        for(int i = 0; i < length; i++) {
            try {
                System.out.println("Введите индекс массива № " + i + 
                        ". Вы можете ввести любое целое число от " + 
                        Integer.MIN_VALUE + " до " + Integer.MAX_VALUE + ".");
                String userInput = scanner.nextLine();
                numbers[i] = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Введено не число! Попытайтесь ещё раз!");
                i--;
            }
        }
        return numbers;
    }
    
    private static int getLengthFromUser() {
        int length;
        while(true) {
            try {
                System.out.println("Введите длину массива: ");
                String userInput = scanner.nextLine();
                length = Integer.parseInt(userInput);
                if(length < 1) {
                    System.out.println("Ошибка! Введена неверная длинна массива: " + length);
                } else {
                    return length;
                } 
            } catch(NumberFormatException e) {
                System.err.println("Ошибка! Длину массива нужно вводить числом, а не буквами!");
            }
        }
    }
    
    
    public static String[] getArrayOfStringsFromUser() {
        int length = getLengthFromUser();
        String [] strings = new String[length];
        System.out.println();
        for(int i = 0; i < length; i++) {
            System.out.println("Введите индекс массива № " + i + ". Вы можете ввести абсолютно любую строку.");
            String userInput = scanner.nextLine();
            if(userInput.isEmpty()) {
                System.err.println("Нужно ввести непустую строку!");
                i--;
            } else {
                strings[i] = userInput; 
            }
        }
        return strings;
    }
  
}