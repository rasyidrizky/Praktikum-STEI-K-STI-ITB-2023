/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Selasa, 17 Juni 2025
    Deskripsi Program       : Membuat kelas Toxomonas
*/

/**
 * Toxomonas.java
 * 
 * Implementasi spesifik untuk bakteri Toxomonas (bakteri penghasil toksin).
 * Toxomonas memiliki atribut tambahan toxinLevel dan dapat menyerang bakteri lain.
 */
public class Toxomonas extends Bacteria implements ToxicAttack {
    private int toxinLevel;
    
    /**
     * Constructor untuk Toxomonas.
     * Name diisi dengan "Toxomonas"
     * @param currentPopulation Populasi bakteri saat ini
     * @param growthRate Laju reproduksi
     * @param hasKanR true jika resisten terhadap Kanamycin, false jika tidak.
     * @param toxinLevel Level toksin.
     */
    public Toxomonas(int currentPopulation, double growthRate, boolean hasKanR, int toxinLevel) {
        super("Toxomonas", currentPopulation, growthRate, hasKanR);
        this.toxinLevel = toxinLevel;
    }

    /**
     * Mengembalikan level toksin.
     * @return level toksin
     */
    public int getToxinLevel() {
        return toxinLevel;
    }

    /**
     * Mengatur level toksin.
     * @param toxinLevel Level toksin baru.
     */
    public void setToxinLevel(int toxinLevel) {
        this.toxinLevel = toxinLevel;
    }


    /**
     * Implementasi serangan toksik untuk Toxomonas.
     * Toxomonas akan menyerang target dengan cara meracuni target dengan toksin yang dimilikinya.
     * Setiap serangan akan mengurangi populasi target sebanyak toxinLevel.
     * Hint: Nilai populasi tidak boleh kurang dari 0, gunakan metode Math.min() untuk membatasi nilai.
     * @param target Bakteri yang diserang.
     */
    @Override
    public void toxicAttack(BacteriaBehaviour target) {
        int newPopulation = Math.min(target.getCurrentPopulation(), toxinLevel);
        target.setCurrentPopulation(target.getCurrentPopulation() - newPopulation);
    }

    /**
     * Mengembalikan representasi detail informasi dari Toxomonas.
     */
    public String toString() {
        return super.toString() + " toxin level: " + toxinLevel;
    }
}

