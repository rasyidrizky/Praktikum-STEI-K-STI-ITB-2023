public class Video extends Content {
    private String title; 
    private String fileName;
    private int duration;
    
    /** 
     * KONSTRUKTOR - Menciptakan objek Video baru
     * 
     * @param title: judul video
     * @param fileName: nama file video
     * @param duration: durasi video dalam detik
     */
    public Video(String title, String fileName, int duration) {
        this.title = title;
        this.fileName = fileName;
        this.duration = duration;
    }

    /** 
     * Metode yang akan mengubah judul video.
     * 
     * @params newTitle: judul baru video.
     */
    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    /** 
     * Metode yang akan mengubah nama file video.
     * 
     * @params newFileName: nama file baru video.
     */
    public void changeFileName(String newFileName) {
        this.fileName = newFileName;
    }

    /** 
     * Metode yang akan mengubah durasi video.
     * 
     * @params newDuration: durasi baru video.
     */
    public void changeDuration(int newDuration) {
        this.duration = newDuration;
    }

    /** Mengembalikan judul dari Video */
    public String getTitle() {
        return title;
    }

    /** Mengembalikan nama file dari Video */
    public String getFileName() {
        return fileName;
    }

    /** Mengembalikan durasi dari Video */
    public int getDuration() {
        return duration;
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
        if (c instanceof Video) {
            Video b = (Video) c;
            return this.title.equals(b.title) && this.fileName.equals(b.fileName) && this.duration == b.duration;
        }
        return false;
    }
}
