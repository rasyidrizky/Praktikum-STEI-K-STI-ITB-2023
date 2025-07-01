public class Blog extends Content {
    private String title;
    private String content;
    
    /** 
     * KONSTRUKTOR - Menciptakan objek Blog baru
     * 
     * @param title: judul blog
     * @param content: konten blog
     */
    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /** Mengembalikan judul dari Blog */
    public String getTitle() {
        return title;
    }

    /** Mengembalikan konten dari Blog */
    public String getContent() {
        return content;
    }

    /** 
     * Metode yang akan mengubah judul blog.
     * 
     * @params newTitle: judul baru blog.
     */
    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    /** 
     * Metode yang akan mengubah konten blog.
     * 
     * @params newContent: konten baru blog.
     */
    public void changeContent(String newContent) {
        this.content = newContent;
    }

    /** 
     * Metode untuk membandingkan apakah konten ini dan konten C bernilai sama. 
     * 
     * Nilai sama dikatakan bila kedua konten bertipe sama DAN 
     *                                 memiliki nilai yang sama untuk SELURUH atribut.
     * 
     * @param c Konten yang ingin dibandingkan.
     * @return TRUE bila sama, FALSE bila tidak
     */
    public boolean isSame(Content c) {
        if (c instanceof Blog) {
            Blog b = (Blog) c;
            return this.title.equals(b.title) && this.content.equals(b.content);
        }
        return false;
    }
}
