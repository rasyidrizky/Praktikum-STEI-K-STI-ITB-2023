/**
 * Kuali.java
 * Mendefinisikan kelas Kuali dengan atribut dan method
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class Kuali {
    private String size;
    
    public Kuali(String size) {
        this.size = size;
    }
    
    public void heat() {
        System.out.println("Heating the " + size + " cauldron");
    }
    
    public void cook() {
        System.out.println("Cooking rendang in the " + size + " cauldron");
    }
    
    public void turnOff() {
        System.out.println("Turning off the heat for the " + size + " cauldron");
    }
}