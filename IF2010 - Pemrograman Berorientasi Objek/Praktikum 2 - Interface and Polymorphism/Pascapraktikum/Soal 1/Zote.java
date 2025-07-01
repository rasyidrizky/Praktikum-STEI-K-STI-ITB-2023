/**
 * Zote.java
 */
public class Zote extends Boss implements SpecialBosses {
    private int minionCount;

    /**
     * Constructor untuk membuat boss zote
     * Boss memiliki nama "Zote", maxHealth sebanyak 500 dan attackPower
     * sebanyak 5
     * 
     * @param minionCount jumlah minion
     */
    public Zote(int minionCount) {
        super("Zote", 500, 5);
        this.minionCount = minionCount;
    }

    /**
     * Mengembalikan battlecry zote
     * Mengembalikan string "You stand no chance!"
     * 
     * @return "You stand no chance!"
     */
    @Override
    public String battleCry() {
        return "You stand no chance!";
    }

    /**
     * Doubles amount of minions
     *
     */
    public void cloneMinion() {
        this.minionCount *= 2;
    }

    /**
     * Ketika melakukan special attack, program akan :
     * 1. Print "BY THE POWER OF ZOTE!"
     * 2. Mengurangi HP knight sebesar attack power dikali dengan minion count
     * 
     * @param knight target
     */
    @Override
    public void specialAttack(Knight knight) {
        System.out.println("BY THE POWER OF ZOTE!");
        knight.setHealth(knight.getHealth() - (super.getAttackPower() * minionCount));
    }

    /**
     * Representasi string dari Zote
     * 
     * @return String yang merepresentasikan Zote
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "[Zote] %d minion", minionCount);
    }
}