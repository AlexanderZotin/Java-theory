package theory.generics.wildcards;

public class Ruler extends Thing {
    private int longOfRuler;
  
    public Ruler(int longOfRuler){
        this.longOfRuler = longOfRuler;
    }
  
    @Override
    public String toString(){
        return "" + longOfRuler;
    }
  
}