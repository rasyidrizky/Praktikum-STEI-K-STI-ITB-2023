/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Senin, 21 April 2025
    Deskripsi Program       : Membuat kelas Bim
*/

/**
 * Bim.java
 *
 * Implementasi spesifik untuk model Bim.
 */
public class Bim extends Bike implements Feature {
    private static int count = 0; // jumlah instance Bim yang dibuat

    /**
     * Konstruktor untuk Bim.
     * Inisialisasi: name="Bim", price=700, battery=200.2
     * Catat jumlah instance Bim yang dibuat.
     */
    public Bim() {
        super("Bim", 700, 200.2);
        count++;
    }

    /** @return jumlah instance Bim yang dibuat */
    public static int getCount() {
        return count;
    }

    /**
     * Bim tidak bisa ditawar.
     *
     * @param yourOffer tawaran harga
     * @return selalu false
     */
    @Override
    public boolean discountOffer(Number yourOffer) {
        return false;
    }

    /**
     * Cetak fitur khusus Bim.
     * Expected: "Bim bim bim chota bim chota bim!"
     */
    @Override
    public void printSpecialFeature() {
        System.out.println("Bim bim bim chota bim chota bim!");
    }
}
