public abstract class Content {
    protected String title; // Judul dari konten
    
    /** 
     * Metode yang akan mengubah judul konten.
     * 
     * @params newTitle: judul baru konten.
     */
    abstract public void changeTitle(String newTitle);

    /** Mengembalikan judul dari konten */
    abstract public String getTitle();

    /** 
     * Metode untuk membandingkan apakah konten ini dan konten C bernilai sama. 
     * 
     * Nilai sama dikatakan bila kedua konten bertipe sama DAN 
     *                                 memiliki nilai yang sama untuk SELURUH atribut.
     * 
     * @param c Konten yang ingin dibandingkan.
     * @return TRUE bila sama, FALSE bila tidak
     */
    abstract public boolean isSame(Content c);
}
