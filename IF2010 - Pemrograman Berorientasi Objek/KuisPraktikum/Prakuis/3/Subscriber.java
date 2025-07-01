/*** Interface Subscriber */

/**
 * Diimplementasi oleh kelas yang dapat berlangganan ke Poster.
*/
public interface Subscriber {
    /** Metode yang akan mengembalikan list notification. */
    public String[] getNotifications();

    /** Metode yang akan mengembalikan jumlah notifikasi. */
    public int getNotificationCount();

    /** Metode yang akan mengembalikan nama. */
    public String getName();

    /** 
     * Metode yang akan menambahkan notifikasi baru. Jika notifikasi sudah mencapai maksimum
     * maka tidak akan menambah apa-apa.
     * 
     * @return Notifikasi dari Poster langganan.
     */
    public void addNotification(String notification);

    /**
     * Metode yang akan berlangganan ke Poster
     * 
     * @param poster
     */
    public void subscribeTo(Poster poster);

}
