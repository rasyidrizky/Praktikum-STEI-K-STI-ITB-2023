/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Senin, 21 April 2025
    Deskripsi Program       : Membuat kelas Ultra
*/

/**
 * Ultra.java
 *
 * Implementasi spesifik untuk model Ultra.
 */
public class Ultra extends Bike{
    private static int count = 0; // jumlah instance Ultra yang dibuat

    /**
     * Konstruktor untuk Ultra.
     * Inisialisasi: name="Ultra", price=1500.50, battery=500.4
     * Catat jumlah instance Ultra yang dibuat.
     * Catatan: Ultra tidak memiliki fitur khusus.
     */
    public Ultra() {
        super("Ultra", 1500.50, 500.4);
        count++;
    }

    /** @return jumlah instance Ultra yang dibuat */
    public static int getCount() {
        return count++;
    }

    /**
     * Ultra menerima tawaran jika selisih antara harga yang ditawarkan dengan harga tawaran <= 100.
     *
     * @param yourOffer tawaran harga
     * @return true jika price - yourOffer <= 100
     * Misalnya price=1500.50, yourOffer=1400.50, maka return true.
     */
    @Override
    public boolean discountOffer(Number yourOffer) {
        return this.getPrice().floatValue() - yourOffer.floatValue() <= 100;
    }
}
