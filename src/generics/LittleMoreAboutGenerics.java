package theory.generics;

import java.util.List;
import java.util.ArrayList;

/*
Здесь будут рассмотрены оставшиеся темы, связанные с дженериками:
1. Переменные типа. Множественные ограничения. 
2. Reifiable типы
3. Type Inference
*/
public class LittleMoreAboutGenerics { 
   
    public static void main(String [] args) {
        aboutTypeVariables();
        aboutTypeInference();
    }

    /*
    1. Переменные типа. Множественные ограничения. 
    T - это переменная типа. Она объявляется ДО возвращаемого значения.
    Т.е оба объекта в параметрах - объекты одного класса.
    Здесь указано, что T - не что угодно, а обязательно наследник интерфейсов
    Comparable и CharSequence. Символ & означает и то, и это.
    Если бы было просто <T> - то можно было подставить любой тип.
    Могло быть без &, тогда T наследник чего-то одного.
    Важно! В объявлении переменной типа не может быть слово super!!!
    */
    public static void aboutTypeVariables() {
        System.out.println("---------------------------------------------------");
        System.out.println("aboutTypeVariables():");
        String[] array = new String[] {"Шурик", "Марго", "Пёс Собачий", "Тараканы", "2 Таракана"};
        for(int i = 1; i < array.length; i++) {
            System.out.println
                    ("Строка \"" + array[i - 1] + "\" больше, чем строка \"" + array[i] + "\"? " + 
                    compare(array[i - 1], array[1]));
        }
        System.out.println("---------------------------------------------------");
    }
    
    static <T extends Comparable<T> & CharSequence> int compare(T first, T second) {
        int counter = 0;
        counter += first.compareTo(second);
        counter += Integer.valueOf(first.length()).compareTo(second.length());
        return ((counter > 0)? 1 : ((counter < 0)? -1 : 0));
    }
    
    /*
    2. Reifiable типы или почему нельзя создать параметризованное исключение.
    Reifiable типы - любые типы, информация о которых на 100% доступна в рантайме.
    Не являются Reifiable следующие типы:
    - Переменные типа (T);
    - Дженерик-типы с указанием конкретного типа, например List<Integer>;
    - WildCards-типы (НО кроме неограниченного, <?>);
    
    А параметризованный эксепшн нельзя создать потому, что в catch-блоке под капотом
    используется instanceof, а дженерик-тип - НЕ Reifiable-тип.
    
    class SomeException<T> extends Exception { //error: a generic class may not extend java.lang.Throwable
        T something;
    }
    */
    
    
    //3. Type Inference (Вывод типа)
    public static void aboutTypeInference() {
        System.out.println("---------------------------------------------------");
        System.out.println("aboutTypeInference():");
        List<String> list1 = new ArrayList<>(); //Это diamond-оператор, тип "угадывается" автоматически
        list1.add("Hello!");
        list1.add("Привет!");
        System.out.println(list1);
        String[] arr = {"Шурик", "Марго", "Тараканы", "Пёс Собачий"};
        List<String> list2 = toList(arr); //Тут тоже тип "угадывается"
        System.out.println(list2);
        System.out.println("А теперь проверим, что вызовется при вызове method(null):");
        /*
        При вызове method(null) вызовется метод, принимающий String, 
        т.к любой наследник Object предпочтительней его самого.
        Но если бы в первом методе вместо Object был бы любой другой
        тип, то программа бы не скомпилировалась с ошибкой "reference to method is ambiguous"
        */
        method(null);
        /*
        В java 7 следующая строка бы не скомпилировалась, 
        пришлось бы писать LittleMoreAboutGenerics.<String>toList(new String[] {"abc", "абв"})
        Но в java 8 всё хорошо, т.к работает вывод типа
        и Java знает, что toList() вернёт List<String>,
        т.к в параметры поставлен массив именно из строк.
        
        */
        boolean isCharacterInList = containsCharacter(toList(new String[] {"abc", "абв"}), 's');
        System.out.println("Есть ли  в строке \"abc\" или в строке \"абв\" символ \'s\'? " + isCharacterInList);
        System.out.println("---------------------------------------------------");
    }
    
    static <T> List<T> toList(T[] array) {
        if(array == null) throw new IllegalArgumentException("array не может быть null!");
        List<T> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    
    static void method(Object obj) {
        System.out.println("Метод с java.lang.Object в параметрах!");
    }
    
    static void method(String s) {
        System.out.println("Метод с java.lang.String в параметрах!");
    }
    
    static boolean containsCharacter(List<String> list, char toFind) {
        for(String currentStr : list) {
            if(currentStr.indexOf(toFind) >= 0) return true;
        }
        return false;
    }
}
