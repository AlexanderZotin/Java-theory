package theory.io.serialization;

public class Variables implements java.io.Serializable {
    private int number;
    private String string;
  
    public Variables(int number, String string) {
        this.number = number;
	    this.string = string;
    }
  
    @Override
    public String toString() {
        return "Строка: " + string + "; Число: " + number + ';';
    }
 
}