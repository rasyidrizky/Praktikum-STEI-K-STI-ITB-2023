/**
 * Bumbu.java
 * Mendefinisikan kelas Bumbu dengan atribut dan method
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class Bumbu {
    private String name;

    public Bumbu(String name) {
        this.name = name;
    }
    
    public void grindSpice() {
        System.out.println("Grinding " + name + " spice");
    }
    
    public void saute() {
        System.out.println("Sauteing " + name + " spice until fragrant");
    }
    
    public void stopSaute() {
        System.out.println("Turning off the heat for " + name + " spice");
    }
}