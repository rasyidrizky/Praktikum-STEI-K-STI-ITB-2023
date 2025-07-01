/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Senin, 21 April 2025
    Deskripsi Program       : Membuat kelas Ngeng
*/


/**
 * Ngeng.java
 *
 * Implementasi spesifik untuk model Ngeng.
 */
public class Ngeng extends Bike{
    private static int count = 0; // jumlah instance Ngeng yang dibuat

    /**
     * Konstruktor untuk Ngeng.
     * Inisialisasi: name="Ngeng", price=1100.10, battery=350.1
     * Catat jumlah instance Ngeng yang dibuat.
     */
    public Ngeng() {
        super("Ngeng", 1100.10, 350.1);
        count++;
    }

    /** @return jumlah instance Ngeng yang dibuat */
    public static int getCount() {
        return count;
    }

    /**
     * Ngeng menerima tawaran dengan diskon maksimal 8%.
     *
     * @param yourOffer tawaran harga
     * @return true jika yourOffer >= price * 0.92
     */
    @Override
    public boolean discountOffer(Number yourOffer) {
        return yourOffer.floatValue() >= this.getPrice().floatValue() * 0.92;
    }
}