/**
 * BowgunHunter.java
 */
public class BowgunHunter extends Hunter implements WeaponMaster {
    private int ammoCount;
    private static final int MAX_AMMO = 15;
    private static final int RELOAD_PENALTY = 5;
    
    /**
     * Constructor untuk membuat BowgunHunter baru
     * 
     * @param name Nama Hunter
     * @param health Health points Hunter
     * @param attackPower Kekuatan serangan dasar Hunter
     */
    public BowgunHunter(String name, int health, int attackPower) {
        super(name, health, attackPower) ;
        this.ammoCount = MAX_AMMO;
    }
    
    /**
     * Mengisi ulang amunisi, dengan penalty pada attack power
     * 
     * Efek:
     * - Mengisi ulang ammoCount ke nilai MAX_AMMO (15)
     * - Mengurangi attackPower sebesar RELOAD_PENALTY (5)
     * - Memastikan attackPower tidak kurang dari 1 (minimum)
     */
    public void reload() {
        ammoCount = MAX_AMMO;
        setAttackPower(getAttackPower() - RELOAD_PENALTY);
        if (getAttackPower() < 1) {
            setAttackPower(1);
        }
    }
    
    /**
     * Melakukan serangan khusus dengan Bowgun
     * 
     * @param monster Monster yang akan diserang
     * 
     * Efek:
     * - Jika Hunter sedang stunned, tidak dapat melakukan serangan
     * - Jika ammoCount > 0:
     *   - Mengurangi ammoCount
     *   - Mengurangi health monster sebesar attackPower * 1.5
     *   - Memicu checkEnrage() pada monster
     *   - Monster melakukan counterAttack jika masih hidup
     * - Jika ammoCount = 0:
     *   - Memanggil metode reload() untuk mengisi ulang amunisi dengan penalty
     * 
     * - "[Nama Hunter] is stunned and cannot attack!" jika hunter stunned
     * - "[Nama Monster] has been defeated!" jika monster mati setelah serangan
     * - "[Nama Hunter] is out of ammo!" jika kehabisan ammo
     */
    @Override
    public void specialAttack(Monster monster) {
        if (isStunned()) {
            System.out.println(getName() + " is stunned and cannot attack!");
        } else {
            if (ammoCount > 0) {
                ammoCount--;
                monster.setHealth(monster.getHealth() - (int) (getAttackPower() * 1.5));
                monster.checkEnrage();
                if (monster.getHealth() <= 0) {
                    System.out.println(monster.getName() + " has been defeated!");
                } else {
                    monster.counterAttack(this);
                }
            } else {
                System.out.println(getName() + " is out of ammo!");
                reload();
            }
        }
    }
    
    /**
     * Menajamkan senjata, meningkatkan attack power sebesar 15%
     */
    @Override
    public void sharpenWeapon() {
        setAttackPower((int) (getAttackPower() * 1.15));
    }
    
    /**
     * Mendapatkan jumlah amunisi yang tersisa
     * 
     * @return jumlah amunisi
     */
    public int getAmmoCount() {
        return ammoCount;
    }
    
    /**
     * Representasi string dari BowgunHunter
     * 
     * @return String yang merepresentasikan BowgunHunter
     */
    @Override
    public String toString() {
        return super.toString() + " [Bowgun] [Ammo: " + ammoCount + "/" + MAX_AMMO + "]";
    }
}
