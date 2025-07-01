/**
 * Knight.java
 */
public class Knight extends Player {
    private static final int maxHP = 150;
    private static final int maxMana = 50;
    private int sharpness;

    /**
     * Constructor untuk membuat knight baru
     * Nama player adalah "Knight"
     * nilai awal sharpness adalah 5
     */
    public Knight() {
        super("Knight", maxHP, maxMana);
        this.sharpness = 5;
    }

    /**
     * Menjalankan basic attack knight
     * 1. Cetak "The knight swung his sword!"
     * 2. HP musuh dikurangi sharpness dari knight
     * 
     * @param enemy Musuh yang akan diserang
     */
    @Override
    public void basicAttack(Enemy enemy) {
        System.out.println("The knight swung his sword!");
        enemy.setHP(enemy.getHP()-this.sharpness);
    }

    /**
     * Menjalankan ultimate attack knight
     * 1. Cetak "I will not falter!"
     * 2. HP musuh dikurangi sharpness dikali 10
     * 
     * @param enemy Musuh yang akan diserang
     */
    @Override
    public void ultimateAttack(Enemy enemy) {
        System.out.println("I will not falter!");
        enemy.setHP(enemy.getHP()-(this.sharpness*10));
    }

    /**
     * Mencetak status knight pada saat ini
     * Sistem akan mencetak : "<nama> - HP : <current HP> / Mana : <current mana>"
     * Lalu sistem akan mencetak : "Sharpness : <sharpness>"
     */
    @Override
    public void printStatus() {
        System.out.println(this.getName() + " - HP : " + this.getHP() + " / Mana : " + this.getMana());
        System.out.println("Sharpness : " + this.sharpness);
    }

    /**
     * Enchant pedang knight
     * Apabila mana knight kurang dari 10, cetak "Not enough mana!"
     * Apabila mana mencukupi :
     * 1. cetak "Enchant Sword!"
     * 2. sharpness menjadi 4 kali sharpness awal
     * 3. mana dikurangi 10
     */
    public void enchantSword() {
        if (this.getMana() < 10) {
            System.out.println("Not enough mana!");
        }
        else {
            System.out.println("Enchant Sword!");
            this.sharpness = this.sharpness * 4;
            this.setMana(this.getMana()-10);
        }
    }
}
