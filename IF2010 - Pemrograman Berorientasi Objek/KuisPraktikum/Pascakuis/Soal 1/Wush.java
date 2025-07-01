/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Senin, 21 April 2025
    Deskripsi Program       : Membuat kelas Ultra
*/

/**
 * Wush.java
 *
 * Implementasi spesifik untuk model Wush dengan opsi subsidized.
 * 
 */
public class Wush extends Bike implements Feature {
    private static int count = 0; // jumlah instance Wush yang dibuat
    /**
     * Konstruktor untuk Wush.
     *
     * @param subsidized true=disubsidi pemerintah,
     *                   false=nonsubsidi.
     * Inisialisasi: name="Wush", price=1200, battery=400
     * Apabila subsidized=true, harga menjadi setengah dari harga standar.
     * Catat jumlah instance Wush yang dibuat.
     */
    public Wush(boolean subsidized) {
        super("Wush", 1200, 400);
        if (subsidized) {
            this.setPrice(this.getPrice().floatValue() / 2);
        }
        count++;
    }

    /** @return jumlah instance Wush */
    public static int getCount() {
        return count;
    }

    /**
     * Wush menerima tawaran dengan diskon maksimal 12%.
     *
     * @param yourOffer tawaran harga
     * @return true jika yourOffer >= price * 0.88
     */
    @Override
    public boolean discountOffer(Number yourOffer) {
        return yourOffer.floatValue() >= this.getPrice().floatValue() * 0.88;
    }

    /**
     * Cetak fitur khusus Wush.
     * Expected: "Wush, Wush, Wush, Yes"
     */
    @Override
    public void printSpecialFeature() {
        System.out.println("Wush, Wush, Wush, Yes");
    }
}
