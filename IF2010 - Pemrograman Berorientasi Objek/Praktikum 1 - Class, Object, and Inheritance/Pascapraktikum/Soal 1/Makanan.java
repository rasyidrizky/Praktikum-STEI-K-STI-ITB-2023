/**
 * Makanan.java
 * [Jelaskan kegunaan class ini]
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

class Makanan {
    // Deklarasi atribut
    private String lauk;
    private int nasi;
    private String minuman;

    /**
     * Konstruktor
     * @param lauk Lauk dari makanan
     * @param nasi Berat nasi (dalam gram)
     * @param minuman Jenis minuman
     */
    public Makanan(String lauk, int nasi, String minuman) {
        this.lauk = lauk;
        this.nasi = nasi;
        this.minuman = minuman;
    }

    /**
     * Getter atribut lauk
     * @return lauk
     */
    public String getLauk() {
        return lauk;
    }

    /**
     * Getter atribut nasi
     * @return nasi
     */
    public int getNasi() {
        return nasi;
    }

    /**
     * Getter atribut minuman
     * @return minuman
     */
    public String getMinuman() {
        return minuman;
    }

}






