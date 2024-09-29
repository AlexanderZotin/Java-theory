package theory.dataTypes.references.string;

class  WithToString1 {
    /*
    Переопределяем метод toString(),чтобы
    при попытке вывода объекта этого класса
    выведется не хеш-код, а Возвращаемая строка.
    */
    @Override
    public String toString(){
        return "Привет!";
    }
  
}