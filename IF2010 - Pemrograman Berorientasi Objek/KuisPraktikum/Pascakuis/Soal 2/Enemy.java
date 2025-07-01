/**
 * Enemy.java
 */
public class Enemy {
    private String name;
    private int attack;
    private int currHP;
    private int maxHP;

    /**
     * Constructor untuk membuat enemy baru
     * currHP akan sama dengan maxHP ketika inisiasi enemy baru
     * 
     * @param name   Nama enemy
     * @param maxHP HP maksimum enemy
     * @param attack Kekuatan attack enemy
     */
    public Enemy(String name, int maxHP, int attack) {
        this.name = name;
        this.maxHP = maxHP;
        this.attack = attack;
        this.currHP = maxHP;
    }

    /**
     * Mendapatkan nama enemy
     * 
     * @return nama enemy
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mendapatkan HP enemy pada saat ini
     * 
     * @return current HP enemy
     */
    public int getHP() {
        return this.currHP;
    }

    /**
     * Mengatur HP enemy
     * Bila nilai HP yang diberikan lebih besar daripada maxHP maka currHP akan
     * menjadi maxHP
     * Bila nilai HP lebih kecil daripada nol maka currHP adalah 0
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
     * Menyerang seorang player
     * Mengurangi HP player dengan kekuatan attack enemy
     * 
     * @param HP nilai HP baru
     */
    public void attack(Player player) {
        player.setHP(player.getHP()-this.attack);
    }

    /**
     * Mencetak status enemy pada saat ini
     * Sistem akan mencetak : "<nama enemy> - HP : <current HP enemy> / Attack : <attack enemy>"
     * Contoh : "Jimbo - HP : 25 / Attack : 50"
     */
    public void printStatus() {
        System.out.println(this.name + " - HP : " + this.currHP + " / Attack : " + this.attack);
    }
}