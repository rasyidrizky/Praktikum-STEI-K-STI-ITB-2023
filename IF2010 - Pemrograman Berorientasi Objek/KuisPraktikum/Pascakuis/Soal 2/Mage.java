/**
 * Mage.java
 */
public class Mage extends Player {
    private static final int maxHP = 100;
    private static final int maxMana = 200;
    private String ultimate;

    /**
     * Constructor untuk membuat knight baru
     * Nama player adalah "Mage"
     * 
     * @param ultimate Jenis ultimate yang dimiliki mage
     */
    public Mage(String ultimate) {
        super("Mage", maxHP, maxMana);
        this.ultimate = ultimate;
    }

    /**
     * Menjalankan basic attack mage
     * 1. Cetak "Fireball Launched!"
     * 2. HP musuh dikurangi 20
     * 3. Mana mage berkurang 10
     * 
     * @param enemy Musuh yang akan diserang
     */
    @Override
    public void basicAttack(Enemy enemy) {
        System.out.println("Fireball Launched!");
        enemy.setHP(enemy.getHP()-20);
        this.setMana(this.getMana()-10);
    }

    /**
     * Menjalankan ultimate attack mage
     * Hanya ada 2 jenis ultimate yang valid : "Storm" dan "Lightning"
     * Selain 2 opsi tersebut, sistem akan mencetak "Spell doesn't exist!"
     * Apabila mage memiliki ultimate "Storm" :
     * 1. Cetak "STORM INCOMING!"
     * 2. Kurangi HP musuh sebanyak 50
     * 3. Kurangi mana mage sebanyak 25
     * 
     * Apabila mage memiliki ultimate "Lightning :
     * 1. Cetak "LIGHTNING STRIKE!"
     * 2. Kurangi HP musuh sebanyak 30
     * 3. Kurangi mana mage sebanyak 15
     * 
     * @param enemy Musuh yang akan diserang
     */
    @Override
    public void ultimateAttack(Enemy enemy) {
        if (this.ultimate.equals("Storm")) {
            System.out.println("STORM INCOMING!");
            enemy.setHP(enemy.getHP()-50);
            this.setMana(this.getMana()-25);
        }
        else if (this.ultimate.equals("Lighting")) {
            System.out.println("LIGHTING STRIKE!");
            enemy.setHP(enemy.getHP()-30);
            this.setMana(this.getMana()-15);
        }
        else {
            System.out.println("Spell doesn't exist!");
        }
    }

    /**
     * Mencetak status mage pada saat ini
     * Sistem akan mencetak : "<nama> - HP : <current HP> / Mana : <current mana>"
     * Lalu sistem akan mencetak : "Ultimate : <ultimate>"
     */
    @Override
    public void printStatus() {
        System.out.println(this.getName() + " - HP : " + this.getHP() + " / Mana : " + this.getMana());
        System.out.println("Ultimate : " + this.ultimate);
    }

}
