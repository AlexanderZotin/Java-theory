package theory.dataTypes.references.string;

class WithToString2{
    /*
    Переопределяем метод toString(),чтобы
    при попытке вывода объекта этого класса
    выведется не хеш-код, а Возвращаемая строка.
    */
    public String toString(){
        return "Объект класса WithToString2";
    }
  
}