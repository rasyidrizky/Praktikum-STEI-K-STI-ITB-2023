/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Selasa, 17 Juni 2025
    Deskripsi Program       : Interface BacteriaBehaviour sebagai blueprint
*/

/**
 * BacteriaBehaviour.java
 * 
 * Interface untuk mendefinisikan perilaku dasar bakteri.
 */
public interface BacteriaBehaviour {
    String getName();
    int getCurrentPopulation();
    double getGrowthRate();
    boolean hasKanR();
    
    void setCurrentPopulation(int population);
    void setGrowthRate(double growthRate);
    void setKanR(boolean resistant);
    void reproduce(int days, double effectiveModifier);
}
