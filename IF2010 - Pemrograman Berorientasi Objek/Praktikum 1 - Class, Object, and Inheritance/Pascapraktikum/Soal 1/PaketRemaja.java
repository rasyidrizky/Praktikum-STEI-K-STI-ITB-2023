public class PaketRemaja extends Makanan {
    private String buah;
    /**
     * Konstruktor
     * @param buah buah yang dipilih pada Paket Remaja
     */
    public PaketRemaja(String buah) {
        super("Ayam Goreng", 200, "Susu");
        this.buah = buah;
    }

    /**
     * Getter buah
     * @return buah
     */
    public String getBuah() {
        return buah;
    }
}