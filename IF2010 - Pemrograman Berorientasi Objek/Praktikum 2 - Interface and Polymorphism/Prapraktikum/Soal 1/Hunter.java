/**
 * Hunter.java
 */
public abstract class Hunter implements Comparable<Hunter> {
    private String name;
    private int health;
    private int attackPower;
    private boolean isStunned;
    private static final int MAX_PARTY_SIZE = 4;
    private static Hunter[] party = new Hunter[MAX_PARTY_SIZE];
    private static int partySize;

    /**
     * Constructor untuk membuat Hunter baru
     * 
     * @param name Nama Hunter
     * @param health Health points Hunter
     * @param attackPower Kekuatan serangan dasar Hunter
     */

    public Hunter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        isStunned = false;
    }

    /**
     * Mendapatkan nama hunter
     * 
     * @return nama hunter
     */
    public String getName() {
        return name;
    }

    /**
     * Mendapatkan health hunter
     * 
     * @return health hunter
     */
    public int getHealth() {
        return health;
    }

    /**
     * Mengatur health hunter
     * 
     * @param health nilai health baru
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Mendapatkan attack power hunter
     * 
     * @return attack power hunter
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Mengatur attack power hunter
     * 
     * @param attackPower nilai attack power baru
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * Mendapatkan status stun hunter
     * 
     * @return true jika hunter stunned, false jika tidak
     */
    public boolean isStunned() {
        return isStunned;
    }

    /**
     * Mengatur status stun hunter
     * 
     * @param stunned status stun baru
     */
    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    /**
     * Menambahkan Hunter ke party
     * 
     * @param hunter Hunter yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika party penuh
     */
    public static boolean addToParty(Hunter hunter) {
        if (partySize < MAX_PARTY_SIZE) {
            party[partySize++] = hunter;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Menghapus Hunter dari party
     * 
     * @param hunter Hunter yang akan dihapus
     * @return true jika hunter ada dalam party dan berhasil dihapus dari party
     */
    public static boolean removeFromParty(Hunter hunter) {
        for (int i = 0; i < partySize; i++) {
            if (party[i] == hunter) {
                for (int j = i; j < partySize - 1; j++) {
                    party[j] = party[j + 1];
                }
                party[partySize - 1] = null; partySize--;
                return true;
            }
        }
        return false;
    }

    /**
     * Mencari monster terlemah (health terendah) untuk diserang
     * 
     * @param monsters Array monster yang akan dicari
     * @return Monster dengan health terendah, atau null jika array kosong
     */
    public static Monster findWeakestMonster(Monster[] monsters) {
        if (monsters.length > 0 || monsters[0] != null) {
            Monster weakestMonster = null;
            for (Monster monster : monsters) {
                if (monster != null && (weakestMonster == null || monster.getHealth() < weakestMonster.getHealth())) {
                    weakestMonster = monster;
                }
            }
            return weakestMonster;
        } else {
            return null;
        }
    }

    /**
     * Semua hunter dalam party akan menyerang monster secara berurutan
     * 
     * @param monster Monster yang akan diserang
     * 
     * Output:
     * - "The party has successfully defeated [Nama Monster]!" jika monster dikalahkan
     * - "[Nama Monster] still has [health] health remaining!" jika monster masih hidup
     */
    public static void partyHunt(Monster monster) {
        for (Hunter hunter : party) {
            if (hunter != null && !hunter.isStunned() && monster.getHealth() > 0) {
                if (hunter instanceof WeaponMaster) {
                    ((WeaponMaster) hunter).specialAttack(monster);
                }
            }
        }

        if (monster.getHealth() <= 0) {
            System.out.println("The party has successfully defeated " + monster.getName() + "!");
        } else {
            System.out.println(monster.getName() + " still has " + monster.getHealth() + " health remaining!");
            monster.areaAttack(party);
        }
    }

    /**
     * Membandingkan dua Hunter berdasarkan attack power-nya
     * 
     * @param other Hunter lain yang akan dibandingkan
     * @return nilai negatif jika this < other, 0 jika sama, nilai positif jika this > other
     */
    @Override
    public int compareTo(Hunter other) {
        return Integer.compare(this.attackPower, other.attackPower);
    }

    /**
     * Representasi string dari Hunter
     * 
     * @return String yang merepresentasikan Hunter
     */
    @Override
    public String toString() {
        return String.format("%s [Health: %d, Attack: %d, %s]", name, health, attackPower, isStunned ? "Stunned" : "Active");
    }
}