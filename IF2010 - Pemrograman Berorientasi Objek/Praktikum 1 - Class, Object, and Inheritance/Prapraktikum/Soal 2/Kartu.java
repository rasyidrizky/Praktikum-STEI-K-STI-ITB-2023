/**
 * Kartu.java
 * Memodelkan kartu Balalalala
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class Kartu {
    // Deklarasi atribut
    private String suit;
    private String rank;
    private int multiplier;
    private static int jumlahKartu;

    /**
     * Konstruktor
     * 
     * @param suit
     * @param rank
     * @param multiplier
     */
    public Kartu(String suit, String rank, int multiplier) {
        this.suit = suit;
        this.rank = rank;
        this.multiplier = multiplier;
        jumlahKartu++;
    }

    /**
     * Konstruktor
     * 
     * @param suit
     * @param rank
     */
    public Kartu(String suit, String rank) {
        this(suit, rank, 1);
    }

    /**
     * Getter suit
     * 
     * @return suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Getter rank dalam bentuk nilai
     * - king, queen, jack bernilai 10
     * - ace bernilai 11
     * - selainnya bernilai sesuai angka kartu
     * 
     * Gunakan method string1.equals(string2) untuk memastikan nilai dua buah string
     * sama
     * 
     * @return rank
     */
    public int getRank() {
        
        if (rank.equals("ace")) {
            return 11;
        }
        else if (rank.equals("king") || rank.equals("queen") || rank.equals("jack") || rank.equals("10")) {
            return 10;
        }
        else {
            char[] arank = rank.toCharArray();
            return (int) arank[0] - 48;
        }
    }

    /**
     * Getter multiplier
     * 
     * @return multiplier
     */
    public int getMultiplier() {
        return multiplier;
    }

    /**
     * @return total nilai kartu (rank * multiplier)
     */
    public int getKartuValue() {
        return getRank() * multiplier;
    }

    /**
     * Getter jumlahKartu
     * 
     * @return jumlahKartu yang ada
     */
    public static int getJumlahKartu() {
        return jumlahKartu;
    }

    /**
     * Method untuk meningkatkan rank kartu, contohnya:
     * - king akan menjadi ace
     * - ace akan menjadi 2
     * - 10 akan menjadi jack
     */
    public void upgradeKartu() {
        switch (rank) {
            case "king": rank = "ace"; break;
            case "queen": rank = "king"; break;
            case "jack": rank = "queen"; break;
            case "10": rank = "jack"; break;
            case "9": rank = "10"; break;
            case "8": rank = "9"; break;
            case "7": rank = "8"; break;
            case "6": rank = "7"; break;
            case "5": rank = "6"; break;
            case "4": rank = "5"; break;
            case "3": rank = "4"; break;
            case "2": rank = "3"; break;
            case "ace": rank = "2"; break;
        }
    }
}