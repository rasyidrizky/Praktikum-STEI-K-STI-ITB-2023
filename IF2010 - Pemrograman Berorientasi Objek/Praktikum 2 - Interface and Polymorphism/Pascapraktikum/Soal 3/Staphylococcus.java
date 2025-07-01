/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Selasa, 17 Juni 2025
    Deskripsi Program       : Membuat kelas Staphylococcus
*/

/**
 * Staphylococcus.java
 * 
 * Implementasi spesifik untuk bakteri Staphylococcus.
 * Staphylococcus dapat resisten terhadap Kanamycin.
 */
public class Staphylococcus extends Bacteria implements AdaptiveResponse {
    /**
     * Constructor untuk Staphylococcus.
     * Name diisi dengan "Staphylococcus"
     * @param growthRate Laju reproduksi
     * @param currentPopulation Populasi bakteri saat ini
     * @param hasKanR true jika resisten terhadap Kanamycin, false jika tidak.
     */
        public Staphylococcus(double growthRate, int currentPopulation, boolean hasKanR) {
            super("Staphylococcus", currentPopulation, growthRate, hasKanR);
        }

    /**
     * Implementasi respon adaptif untuk Staphylococcus.
     * Staphylococcus akan melakukan respon adaptif dengan cara "menelan" plasmid berisi gen resistensi Kanamycin
     * dari bakteri lain sehingga menjadi resisten terhadap Kanamycin (punya gen kanR).
     */
    @Override
    public void doAdaptiveResponse() {
        super.setKanR(true);
    }

    /** 
     * Mengembalikan representasi detail informasi dari Staphylococcus.
     */
    public String toString() {
        return super.toString();
    }
        
}
