package theory.dataTypes.references;

class Ruler extends Thing {

    public void testRuler(){
        System.out.println("Линейкой пользуются!");
    }
  
    @Override
    public void testThing(){
        System.out.println("Вызывается переопределённый метод testThing()!");
    }
  
}