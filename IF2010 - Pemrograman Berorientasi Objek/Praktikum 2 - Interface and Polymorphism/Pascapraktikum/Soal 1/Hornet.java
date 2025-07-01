/**
 * Hornet.java
 */
public class Hornet extends Boss implements SpecialBosses {
    private int stringAmount;

    /**
     * Constructor untuk membuat boss hornet
     * Hornet memiliki nama "Hornet", maxHealth sebanyak 900 dan attackPower
     * sebanyak 15
     * 
     * @param stringAmount jumlah string yang dimiliki hornet
     */
    public Hornet(int stringAmount) {
        super("Hornet", 900, 15);
        this.stringAmount = stringAmount;
    }

    /**
     * Mengembalikan battlecry hornet
     * Mengembalikan string "HEGALE!"
     * 
     * @return "HEGALE!"
     */
    @Override
    public String battleCry() {
        return "HEGALE!";
    }

    /**
     * Menambahkan jumlah string sebanyak 100
     *
     */
    public void chargeString() {
        this.stringAmount += 100;
    }

    /**
     * Special attack hanya bisa dilakukan apabila jumlah string di atas 10
     * Apabila jumlah string kurang, maka program akan print "[String insufficient]"
     * INGAT : tuliskan juga bracketnya ya!!
     * Apabila jumlah string memenuhi maka program akan :
     * 1. print "ADINO!"
     * 2. mengurangi HP knight sebanyak attack power + total string
     * 3. special attack pasti menggunakan semua string, string akan habis
     * 
     * @param knight target
     */
    @Override
    public void specialAttack(Knight knight) {
        if (stringAmount > 10) {
            System.out.println("ADINO!");
            knight.setHealth(knight.getHealth() - (super.getAttackPower() + stringAmount));
            this.stringAmount = 0;
        }
        else {
            System.out.println("[String insufficient]");
        }
    }

    /**
     * Representasi string dari Hornet
     * 
     * @return String yang merepresentasikan Hornet
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "[Hornet] %d string", stringAmount);
    }
}