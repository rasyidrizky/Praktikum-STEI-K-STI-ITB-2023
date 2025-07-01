/**
 * Player.java
 */
public abstract class Player {
    private String name;
    private int currHP;
    private int maxHP;
    private int currMana;
    private final int maxMana;

    /**
     * Constructor untuk membuat player baru
     * curr_HP akan sama dengan maxHP ketika inisiasi enemy baru
     * curr_mana akan sama dengan maxMana ketika inisiasi enemy baru
     * 
     * @param name    Nama player
     * @param maxHP   HP maksimum player
     * @param maxMana mana maksimum player
     */
    public Player(String name, int maxHP, int maxMana) {
        this.name = name;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.currMana = maxMana;
        this.maxMana = maxMana;
    }

    /**
     * Mendapatkan nama player
     * 
     * @return nama player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mendapatkan HP player pada saat ini
     * 
     * @return current HP player
     */
    public int getHP() {
        return this.currHP;
    }

    /**
     * Mendapatkan mana player pada saat ini
     * 
     * @return current mana player
     */
    public int getMana() {
        return this.currMana;
    }

    /**
     * Mengatur HP player
     * Bila nilai HP yang diberikan lebih besar daripada maxHP maka curr_HP akan
     * menjadi maxHP
     * Bila nilai HP lebih kecil daripada nol maka curr_HP adalah 0
     * 
     * @param HP nilai HP baru
     */
    public void setHP(int HP) {
        if (HP < 0) {
            this.currHP = 0;
        } else if (HP > this.maxHP) {
            this.currHP = this.maxHP;
        } else {
            this.currHP = HP;
        }
    }

    /**
     * Mengatur mana player
     * Bila nilai mana yang diberikan lebih besar daripada maxMana maka curr_mana
     * akan
     * menjadi maxMana
     * Bila nilai mana lebih kecil daripada nol maka curr_mana adalah 0
     * 
     * @param HP nilai HP baru
     */
    public void setMana(int mana) {
        if (mana < 0) {
            this.currMana = 0;
        } else if (mana > this.maxMana) {
            this.currMana = this.maxMana;
        } else {
            this.currMana = mana;
        }
    }

    public abstract void basicAttack(Enemy enemy);

    public abstract void ultimateAttack(Enemy enemy);

    public abstract void printStatus();
}
