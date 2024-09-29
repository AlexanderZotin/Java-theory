package theory.generics.wildcards;

public class Thing {
    private String color;
  
    public Thing() {
    }
  
    public Thing(String color) {
        this.color = color;
    }
  
    @Override
    public String toString() {
        return color;
    }
  
}