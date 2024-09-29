package theory.dataTypes.references.string;

public class Variables {
    private int number;
    private char symbol;
  
    public Variables(int number, char symbol){
        this.number = number;
	    this.symbol = symbol;
    }
  
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Variables otherVariables = (Variables) obj; //применяем нисходящее преобразование
		//Сравниваем поля объектов
        return this.number == otherVariables.number && this.symbol == otherVariables.symbol; 
    }
  
}