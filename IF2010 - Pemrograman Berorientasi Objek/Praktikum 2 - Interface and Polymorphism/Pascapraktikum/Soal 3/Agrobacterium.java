/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Selasa, 17 Juni 2025
    Deskripsi Program       : Membuat kelas Agrobacterium
*/

/**
 * Agrobacterium.java
 * 
 * Implementasi spesifik untuk bakteri Agrobacterium.
 */
public class Agrobacterium extends Bacteria implements AdaptiveResponse, ToxicAttack {
    private int toxinLevel;
    
    /**
     * Constructor untuk Agrobacterium.
     * Name diisi dengan "Agrobacterium"
     * @param growthRate Laju reproduksi
     * @param currentPopulation Populasi bakteri saat ini
     * @param hasKanR true jika resisten terhadap Kanamycin, false jika tidak.
     * @param toxinLevel Level toksin.
     */
    public Agrobacterium(int currentPopulation, double growthRate, boolean hasKanR, int toxinLevel) {
        super("Agrobacterium", currentPopulation, growthRate, hasKanR);
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
     * Implementasi serangan toksik untuk Agrobacterium.
     * Agrobacterium akan menyerang target dengan cara meracuni target dengan toksin yang dimilikinya.
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
     * Implementasi respon adaptif untuk Agrobacterium.
     * Agrobacterium akan meningkatkan growthRate-nya sebesar 1.3 kali dari nilai sebelumnya.
     */
    @Override
    public void doAdaptiveResponse() {
        setGrowthRate(super.getGrowthRate() * 1.3);
    }

    /** 
     * Mengembalikan representasi detail informasi dari Agrobacterium.
     */
    public String toString() {
        return super.toString() + " toxin level: " + toxinLevel;
    }

}
