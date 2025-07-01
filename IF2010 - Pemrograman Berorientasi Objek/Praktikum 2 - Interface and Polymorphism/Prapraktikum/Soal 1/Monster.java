/**
 * Monster.java
 */
public class Monster implements MonsterTarget, Comparable<Monster> {
    private String name;
    private int health;
    private int attackPower;
    private int enragedThreshold;
    private boolean isEnraged;
    private static final double ENRAGE_MULTIPLIER = 1.5;
    
    /**
     * Constructor untuk membuat Monster baru
     * 
     * @param name Nama monster
     * @param health Health points monster
     * @param attackPower Kekuatan serangan monster
     * @param enragedThreshold Batas health untuk monster menjadi enraged
     */
    public Monster(String name, int health, int attackPower, int enragedThreshold) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.enragedThreshold = enragedThreshold;
        this.isEnraged = false;
    }
    
    /**
     * Mendapatkan nama monster
     * 
     * @return nama monster
     */
    public String getName() {
        return name;
    }
    
    /**
     * Mendapatkan health monster
     * 
     * @return health monster
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * Mengatur health monster
     * 
     * @param health nilai health baru
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * Mendapatkan status enraged monster
     * 
     * @return true jika monster enraged, false jika tidak
     */
    public boolean isEnraged() {
        return isEnraged;
    }
    
    /**
     * Memeriksa apakah monster menjadi enraged berdasarkan health
     * 
     * Efek:
     * - Mengubah status isEnraged menjadi true jika:
     *   - Monster belum dalam status enraged
     *   - Health monster berada di bawah threshold
     *   - Monster masih hidup
     */
    public void checkEnrage() {
        if (!isEnraged && health < enragedThreshold && health > 0) {
            isEnraged = true;
        }
    }
    
    /**
     * Monster menyerang balik Hunter
     * 
     * @param hunter Hunter yang akan diserang
     * 
     * Efek:
     * - Mengurangi health hunter sebesar attackPower * (isEnraged ? ENRAGE_MULTIPLIER : 1)
     * - Jika health hunter <= 0, hunter menjadi stunned
     * 
     * Output:
     * - "[Nama Monster] [ENRAGED] counter-attacks [Nama Hunter] for [damage] damage!"
     * - "[Nama Hunter] has been stunned!" jika hunter stunned setelah serangan
     */
    @Override
    public void counterAttack(Hunter hunter) {
        int damage = (int) (attackPower * (isEnraged ? ENRAGE_MULTIPLIER : 1));
        hunter.setHealth((int)hunter.getHealth() - damage);
        System.out.println(name + (isEnraged ? " [ENRAGED] " : " ") + "counter-attacks " + hunter.getName() + " for " + damage + " damage!");
        if (hunter.getHealth() <= 0) {
            hunter.setStunned(true);
            System.out.println(hunter.getName() + " has been stunned!");
        }
    }
    
    /**
     * Monster melakukan serangan area pada party Hunter
     * 
     * @param hunters Array Hunter yang akan diserang
     * 
     * Efek:
     * - Mengurangi health setiap hunter sebesar attackPower * 0.7 * (isEnraged ? ENRAGE_MULTIPLIER : 1)
     * - Jika health hunter <= 0, hunter menjadi stunned
     * 
     * Output:
     * - "[Nama Monster] [ENRAGED] performs area attack for [damage] damage to all hunters!"
     * - "[Nama Hunter] has been stunned!" untuk setiap hunter yang stunned setelah serangan
     */
    @Override
    public void areaAttack(Hunter[] hunters) {
        int damage = (int) (attackPower * 0.7 * (isEnraged ? ENRAGE_MULTIPLIER : 1));
        System.out.println(name + (isEnraged ? " [ENRAGED]" : "") + " performs area attack for " + damage + " damage to all hunters!");
        for (Hunter hunter : hunters) {
            if (hunter != null && !hunter.isStunned()) {
            hunter.setHealth(hunter.getHealth() - damage);
                if (hunter.getHealth() <= 0) {
                    hunter.setStunned(true);
                    System.out.println(hunter.getName() + " has been stunned!");
                }
            }
        }
        

    }
    
    /**
     * Membandingkan dua Monster berdasarkan health
     * 
     * @param other Monster lain yang akan dibandingkan
     * @return nilai negatif jika this < other, 0 jika sama, nilai positif jika this > other
     */
    @Override
    public int compareTo(Monster other) {
        return Integer.compare(this.health, other.health);
    }
    
    /**
     * Representasi string dari Monster
     * 
     * @return String yang merepresentasikan Monster
     */
    @Override
    public String toString() {
        return String.format("%s [Health: %d/%d, Attack: %d%s]", 
                            name, health, enragedThreshold, attackPower, 
                            isEnraged ? ", ENRAGED" : "");
    }
}
