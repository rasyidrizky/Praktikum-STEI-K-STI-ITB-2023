/*** Interface Poster */

/**
 * Diimplementasi oleh kelas yang dapat mem-posting sebuah konten .
*/
public interface Poster {

    /** Metode yang akan mengembalikan list subscriber */
    public Subscriber[] getSubscribers();

    /** Metode yang akan mengembalikan jumlah subscriber. */
    public int getSubscriberCount();

    /** 
     * Metode untuk menambahkan konten baru ke akun dan menotifikasi seluruh subscriber.
     * 
     * @param content: Konten yang akan di-post sesuai tipe akun.
     */
    public void post(Content content);

    /** 
     * Metode untuk mengubah Content yang pernah dibuat dan menotifikasi seluruh subscriber.
     * 
     * @param oldContent: Content lama yang mungkin ada atau tidak ada di list Content.
     * @param newContent: Content yang akan menggantikan Content lama
     */
    public void changePost(Content oldContent, Content newContent);

    /** 
     * Metode yang memungkinkan berlangganan ke Poster ini dengan menambahkan ke list Subscriber.
     * 
     * @param subscriber: Akun yang ingin berlangganan.
     */
    public void subscribe(Subscriber subscriber);
}
