package theory.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;
/*
Здесь будут рассмотрены основные функциональные интерфейсы 
из пакета java.util.function: Consumer,  Supplier,
Predicate, Function и UnaryOperator.
*/
@SuppressWarnings("ALL")
public class FunctionalInterfacesForCollections {

    public static void main(String[] args) {
	    System.out.println("--------------------------------------------------");
	    System.out.println("consumerExample():");
	    consumerExample();
		System.out.println("--------------------------------------------------");
		System.out.println("supplierExample():");
		supplierExample();
		System.out.println("--------------------------------------------------");
		System.out.println("predicateExample():");
		predicateExample();
		System.out.println("--------------------------------------------------");
		System.out.println("functionExample():");
		functionExample();
		System.out.println("--------------------------------------------------");
		System.out.println("unaryOperatorExample():");
		unaryOperatorExample();
		System.out.println("--------------------------------------------------");
    }

	public static void consumerExample() {
	    //Consumer = потребитель. Абстрактный метод данного интерфейса - accept(T t),
	    List<String> list = new ArrayList<>();
		list.add("Цыпа");
		list.add("Пёс Собачий");
		list.add("Тараканы");
		list.forEach(s -> System.out.println("Строка: " + s + "; Её длинна: " + s.length()));
		//А вот пример на дефолтный метод andThen(). Он полезен, когда 
		//надо объединить два Consumer'a
		Consumer<String> c1 = string -> System.out.println("Длинна строки: " + string.length());
		Consumer<String> c2 = s -> System.out.println("Строка: " + s);
		Consumer<String> consumer = c1.andThen(c2);
		list.forEach(consumer);
	}
	
	public static void supplierExample() {
	    //Supplier - поставщик. Он имеет единственный метод - T get().
		Supplier<String> supplier = () -> {
			return switch(new Random().nextInt(10)) {
			    case 0 -> "Ноль";
			    case 1 ->"Один";
			    case 2 -> "Два";
			    case 3 -> "Три";
			    case 4 ->"Четыре";
			    case 5 ->"Пять";
			    case 6 -> "Шесть";
			    case 7 -> "Семь";
			    case 8 -> "Восемь";
			    case 9 -> "Девять";
				default -> null; //Этого никогда не случится
			};
		};
		for(int i = 0; i < 5; i++) {
		    System.out.println(supplier.get());
		}
	}
	
	public static void predicateExample() {
	    //Predicate - предикат. Абстрактный метод: boolean test(T t)
		//Кроме него есть ещё несколько дефолтных и один статический (см. ниже)
	    List<String> list = new ArrayList<>();
		list.add("Банджю");
		list.add("Монстриго");
		list.add("Кредит!!!");
		list.add("Валерыч");
		list.add("Кредиты пенсионерам!");
		list.add("Ватя");
		list.add("Ушапарик");
		list.add("Акция! ДВЕ пачки печенья по цене ОДНОЙ!");
		list.add("Банджюшка");
		list.add("Ушапусик");
		list.add("Акция в пятёрочке!!!!");
		list.add("Большой Монстрижка");
		/*
		Методы and() и or() работают как логическое И/ИЛИ. 
		Они принимают на вход другой предикат и "объединяют"
		их по логическим принципам: если and(), то оба метода 
		test() должны возвращать true для того, чтобы действие
		совершилось, если or(), то для выполнения действия
		потребуется true-результат только от одного test().
		Здесь будет пример только с методом or().
		Ещё есть метод negate(), аналогичный оператору "!".
		Он возвращает "перевёрнутый" предикат, т. е предикат возвращал бы
		true - он будет возвращать false, и наоборот.
		*/
		System.out.println("Было: " + list);
		Predicate<String> tmpPredicate = str -> str.toUpperCase().contains("Кредит".toUpperCase());
		Predicate<String> predicate = 
		        tmpPredicate.or(str -> str.toUpperCase().contains("Акция".toUpperCase()));
		list.removeIf(predicate);
		System.out.println("Стало: " + list);
		/*
		Пример на статический метод isEqual(Object targetRef). Он просто возвращает предикат,
		который проверяет на равенство объект из параметров
		метода test() и объект из своих параметров.
		Т.е эта строчка:
		Predicate<Integer> notZeroPredicate = Predicate.isEqual(0);
		абсолютно идентична этой: 
		Predicate<Integer> notZeroPredicate = num -> num.equals(0);
		*/
		Predicate<Integer> notZeroPredicate = Predicate.isEqual(0);
		List<Integer> integerList = new ArrayList<>();
		integerList.add(-7);
		integerList.add(5);
		integerList.add(7);
		integerList.add(0);
		integerList.add(98);
		integerList.add(0);
		integerList.add(-2);
		System.out.println("Было: " + integerList);
		integerList.removeIf(notZeroPredicate);
		System.out.println("Стало: " + integerList);
		Predicate<Integer> greaterThanZero = num -> num > 0;
		System.out.println("Было: " + integerList);
		integerList.removeIf(greaterThanZero.negate());
		System.out.println("Стало: " + integerList);
	}
	
	public static void functionExample() {
	    /*
		Fucntion (функция) принимает на вход один тип, а возвращает другой 
		(хотя типы всё-таки могут и совпадать).
		Абстрактный метод: R apply(T t). Есть ещё несколько дефолтных и 1 статический (см. ниже).
		*/
		Function<Integer, String> compareToZero = arg -> {
			return (arg > 0)? "больше 0" : ((arg < 0)? "меньше 0" : "равно 0");
		};
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
		    int current = random.nextInt(10);
			boolean lessThanZero = random.nextBoolean();
			if(lessThanZero) current *= -1;
		    System.out.println(String.valueOf(current) + ' ' + 
			        compareToZero.apply(current));
		}
		/*
		С помощью static-метода identity() можно получить функцию, которая возвращает параметр.
        Т.е результат работы этого метода идентичен этому:
        Function<String, String> function = arg -> arg;		
		*/
		Function<String, String> identityMethodEx = Function.identity();
		System.out.println(identityMethodEx.apply("Это параметр, он и будет возвращён..."));
		/*
		Вот ещё пример на дефолтные методы: andThen() и compose()
		Про andThen() уже было, когда речь шла о Consumer'е.
		А compose() - это просто противоположность andThen().
		*/
		Function<String, String> f1 = arg -> arg + " f1 ";
        Function<String, String> f2 = arg -> arg + " f2 ";
        Function<String, String> f3 = arg -> arg + " f3 ";
		Function<String, String> resultFunction = f1.compose(f2).andThen(f3);
		System.out.println(resultFunction.apply("Порядок вызовов:"));
	}
	
	public static void unaryOperatorExample() {
	    /*
		UnaryOperator - наследник Function. Отличие в том, что метод apply()
		возвращает тот же самый тип, что и принимает, поэтому при создании
		в дженерики указывается только один тип данных.
		*/
		UnaryOperator<String> unaryOperator = arg -> "Тараканы съели " + arg;
		List<String> list = new ArrayList<>();
		list.add("бананы");
		list.add("шкаф");
		list.add("автобус");
		list.add("облако");
		System.out.println("До: " + list);
		list.replaceAll(unaryOperator);
		System.out.println("После: " + list);
		/*
		Сам по себе интерфейс содержит только статический метод identity().
		Он работает аналогично такому же методу в Function,
		только возвращает UnaryOperator
		*/
		UnaryOperator<String> identityEx = UnaryOperator.identity();
		System.out.println(identityEx.apply("Хм... Какой же будет результат?"));
	}
}
