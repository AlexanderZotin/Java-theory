package theory.io.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.FileNotFoundException;
import static java.io.File.separator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/*
В java 7 появилась новая возможность работы с файлами - классы из пакета java.nio.file:
Paths, Path(интерфейс, а не класс) и Files. Кратко о классах:
---------------------------------------------------------------------------------------
  -Paths:
  В нём есть два метода: Path get(String) и Path get(URI). Этот класс нужен
  для преобразования String/URI в Path.
  -Path:
  переработанный аналог класса File. Кстати, большинство методов в нём возвращают Path =).
  Это сделано "для однородности".
  -Files:
  Класс со статическими методами (утилитный класс). В нём методов больше, чем в Path,
  но все эти методы нужны для действий, которые не зависят от объекта. 
---------------------------------------------------------------------------------------
*/

/* 
     Основные методы класса (интерфейса) java.nio.file.Path:
     -----------------------------------------------------------------------------------
     |          метод              |            что делает                             |
     -----------------------------------------------------------------------------------
     |  Path getFileName()         |      Возвращает имя файла, без пути               |
     -----------------------------------------------------------------------------------
     |  Path getParent()           |      Возвращает путь к файлу без его имени        |
     -----------------------------------------------------------------------------------
     |  Path getRoot()             |      Возвращает корень пути                       |
     -----------------------------------------------------------------------------------
     |  Path getName(int index)    |      Возвращает элемент пути по индексу           |
     -----------------------------------------------------------------------------------
     | boolean endsWith(Path other)|      Проверяет, заканчивается ли путь переданным  |
     |                             |      путём. Примечание: в классе Path есть        |
     |                             |      перегруженный метод, который принимает на    |
     |                             |      вход строку.                                 |
     ----------------------------------------------------------------------------------
     | boolean startsWith(Path     |     Проверяет, начинается ли путь с указанного    |
     | other)                      |     пути. Как и в случае с endsWith, есть         |
     |                             |     перегруженный метод, принимающий String       |
     ----------------------------------------------------------------------------------
     | boolean isAbsolute()        |     Проверяет, является ли путь абсолютным.       |
     ----------------------------------------------------------------------------------
     | Path relativize(Path other) |     Вычисляет разницу между двумя путями.         |
     |                             |     Есть перегруженный метод, принимающий String  |
     ----------------------------------------------------------------------------------
     | Path toAbsolutePath()       |     Преобразует путь в абсолютный                 |
     ----------------------------------------------------------------------------------
     | File toFile()               |    Возвращает объект класса java.io.File, который |
     |                             |    соответствует объекту класса Path.             |
     ----------------------------------------------------------------------------------
     | Path subpath(int beginIndex,|    Обрезает путь от первого индекса до второго.   |
     | int endIndex)               |                                                   |
     ----------------------------------------------------------------------------------
     
     Основные методы класса java.nio.file.Files:
     -----------------------------------------------------------------------------------
     |          метод                  |            что делает                         |
     -----------------------------------------------------------------------------------
     |  static Path createFile(        |     Создаёт новый файл. Бросает IOException,  |                   
     |  Path path) throws IOException  |     если файл не удалось создать.             |                                          |
     ----------------------------------------------------------------------------------    
     |  static Path createDirectory(   |     Создаёт директорию. Бросает IOException,  |
     |  Path dir) throws IOException   |     если не удалось создать директорию.       | 
     -----------------------------------------------------------------------------------
     |  static Path createDirectories  |     Создаёт директорию и её поддиректории.    |
     |  (Path dir) throws IOException  |                                               |
     ----------------------------------------------------------------------------------
     |  static Path createSymbolicLink |     Создаёт ярлык к файлу. Бросает            |
     |  (Path link, Path existing)     |     IOException, если ярлык создать не       |
     |  throws IOException             |     удалось.                                  |
     ----------------------------------------------------------------------------------
     |  static boolean isDirectory(    |     Определяет, является ли объект            |
     |  Path path)                     |     существующей директорией.                 |
     ----------------------------------------------------------------------------------
     |  static boolean exists()        |     Проверяет наличие файла                   |
     ----------------------------------------------------------------------------------
     | static void delete(Path path)   |     Удаляет файл. Бросает IOException, если   |
     | throws IOException              |     не удалось удалить файл.                  |
     ----------------------------------------------------------------------------------
     | static boolean deleteIfExists(  |     Удаляет файл, если он существует.         |
     | Path path) throws IOException   |                                               |
     ----------------------------------------------------------------------------------
     | static Path copy(Path source,   |     Копирует файл. Бросает IOException, если  |
     | Path target) throws IOException |     не удалось скопировать файл.              |
     ----------------------------------------------------------------------------------
     | static Path createTempDirectory |     Создаёт временную директорию по           |
     | (Path dir, String prefix)       |     указанному пути и с указанным префиксом.  |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static Path createTempDirectory |     Создаёт временную директорию в            |
     | (String prefix)                 |     каталоге системы для временных файлов.    |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static Path createTempFile(     |     Создаёт временный файл по указанному      |
     | Path dir, String prefix,        |     пути и с указанными суффиксом и префиксом. |
     | String suffix)                  |                                               |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static Path createTempFile(     |     Создаёт временный файл в каталоге системы |
     | String prefix, String suffix)   |     для временных файлов                      |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static boolean isExecutable(    |     Проверяет, может ли jvm открыть файл      |
     | Path path)                      |                                               |
     ----------------------------------------------------------------------------------
     | static boolean isHidden(        |     Проверяет, является ли файл скрытым.      |
     | Path path) throws IOException   |                                               |
     ----------------------------------------------------------------------------------
     | static boolean isReadable(      |     Проверяет, можно ли прочитать файл.       |
     | Path path)                      |                                               |
     ----------------------------------------------------------------------------------
     | static boolean isSameFile(      |     Проверяет, указывают ли два пути          |
     | Path path, Path path2)          |     одинаковый существующий файл. То есть     |
     | throws IOException              |     отличие от Path.equals() в том, что       |
     |                                 |     если файла не будет существовать, то      |
     |                                 |     метод вернёт false.                       |
     ----------------------------------------------------------------------------------
     | static boolean isWritable(      |    Проверяет, может ли jvm записать в файл    |
     | Path path)                      |    какие-либо данные.                         |
     ----------------------------------------------------------------------------------
     | static Path move(Path source,   |    Перемещает файл.                           |
     | Path target, throws IOException |                                               |
     ----------------------------------------------------------------------------------
     | static String probeContentType( |    Проверяет тип содержимого файла.           |
     | Path path) throws IOException   |                                               |
     ----------------------------------------------------------------------------------
     | static List<String> readAllLines|    Читает все строки из файла.                |
     | (Path path, Charset cs          |                                               |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static byte[] readAllBytes(Path |    Читает все байты из файла.                 |
     | path) throws IOException        |                                               |
     ----------------------------------------------------------------------------------
     | static long size(Path path)     |    Возвращает размер файла в байтах.          |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static Path write(Path path,    |    Записывает строки в файл.                  |
     | Iterable<? extends CharSequence>|                                               | 
     | lines, Charset cs)              |                                               |
     | throws IOException              |                                               |
     ----------------------------------------------------------------------------------
     | static Path write(Path path,    |    Записывает массив байтов в файл.           |
     | byte[] bytes) throws IOException|                                               |
     ----------------------------------------------------------------------------------
*/

public class MethodsOfClassesPathAndFiles{

    public static void main(String [] args){ 
        StringBuilder path = new StringBuilder();
        path.append("src").append(separator)
        .append("io").append(separator)
        .append("files").append(separator)
        .append("test2").append(separator);
     
        Path folder = Paths.get(path.toString());
        //Есть ещё такой вариант: Path folder = Paths.get("src", "io", "files");
        Path file = Paths.get(path.toString(), separator, "Test2.txt"); //Cм предыдущую строку
        Path link = Paths.get(path.toString(), separator, "Test2 - Ярлык");
        create(folder, file, link);
        try {
            readAndWrite(file);
            aboutFile(file);
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
     
        if(askToDelete()){
            try{
                Files.deleteIfExists(link);
                Files.deleteIfExists(file);
                Files.deleteIfExists(folder);
            } catch(IOException e){
                System.err.println("Произошла ошибка при удалении файла.");
                System.err.println("Более подробная информация о случившимся:");
                e.printStackTrace();
            }
        }
    }
 
    public static void create(Path folder, Path file, Path link){
        System.out.println("----------------------------------------------------------------------------");
        try{
            System.out.println((Files.exists(folder))? "Папка уже существует!" : "Папка будет создана!");
            if(!Files.exists(folder)) Files.createDirectory(folder);
            System.out.println((Files.exists(file))? "Файл уже существует!" : "Файл будет создан!");
            if(!Files.exists(file)) Files.createFile(file);
            System.out.println((Files.exists(link))? "Ярлык уже существует!" : "Ярлык будет создан!");
            if(!Files.exists(link)) Files.createSymbolicLink(link, file);    
            System.out.println("Операция по созданию и проверке наличия файла, папки и ярлыка прошла успешно!");
         
        } catch (IOException e){
            System.err.println("Произошла ошибка при создании файла, папки или ярлыка.");
            System.err.println("Скорее всего ошибка вызвана тем, что один из путей указан неверно.");
            System.err.println("Дальнейшее выполнение программы может происходить не совсем корректно.");
            System.err.println("Более подробная информация о случившимся:");
            e.printStackTrace();
        } 
        System.out.println("----------------------------------------------------------------------------");
    }
  
    public static void aboutFile(Path file) throws FileNotFoundException{
        if(file == null) throw new IllegalArgumentException("file не может быть null");
        if(!Files.exists(file)) throw new FileNotFoundException("Файл "+  file +" не существует!");
         
        System.out.println("----------------------------------------------------------------------------");         
        System.out.println("Может ли программа открыть файл? " + Files.isExecutable(file));
        System.out.println("Короткое имя файла: " + file.getFileName());
        System.out.println("Файл находится на диске " + file.getRoot());
        System.out.println("Может ли программа прочитать файл? " + Files.isReadable(file));
     
        try {
            System.out.println("Тип файла: " + Files.probeContentType(file));
            System.out.println("Файл - скрытый? " + Files.isHidden(file));
            System.out.println("Размер файла (в байтах): " + Files.size(file));
        } catch(IOException e){
            System.err.println("При получении данных о файле или при копировании файла произошла ошибка.");
            System.err.println("Более подробная информация:");
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------------------------");
    }
  
    public static void readAndWrite(Path file) throws FileNotFoundException{
        if(file == null) throw new IllegalArgumentException("file не может быть null");
        if(!Files.exists(file)) throw new FileNotFoundException("Файл "+  file +" не существует!");

        System.out.println("----------------------------------------------------------------------------");
     
        List<String> lines = new ArrayList<>();
        lines.add("Это первая строка");
        lines.add("Это вторая строка");
        lines.add("Это третья строка");
        try{
            Files.write(file, lines, StandardCharsets.UTF_8);
            System.out.println("Запись в файл прошла удачно!");
        } catch (IOException e){
            System.err.println("К сожалению программе не удалось записать строки в файл.");
            System.err.println("Более подробная информация:");
            e.printStackTrace();
        } 
        System.out.println("----------------------------------------------------------------------------");
     
        try{
            List<String> allLines = Files.readAllLines(file);
            if(allLines == null) {
                System.out.println("Файл пустой!");
                return;
            }
            System.out.println("Выводиться содержимое файла:");
            for(String currentLine : allLines){
                System.out.println(currentLine);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------------------------");
    }
  
    public static boolean askToDelete(){
        Scanner scanner = new Scanner(System.in, "Cp866");
        System.out.println("Удалить файл и папку? Введите да, чтобы удалить, или любой другой символ, чтобы не удалять");
        String userInput = scanner.nextLine();
        if(userInput == null){
             return false;
        }
        return userInput.equalsIgnoreCase("да");
    }
  
}
