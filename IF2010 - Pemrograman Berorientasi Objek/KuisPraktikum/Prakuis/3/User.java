public class User implements Subscriber {
    private String name;
    private int maxNotification = 100;
    private String[] notifications;
    private int notificationCount = 0;

    /** 
     * KONSTRUKTOR -  Menciptakan objek User baru dengan notification kosong.
     * 
     * @param name: Nama dari user
     */
    public User(String name) {
        this.name = name;
        this.notifications = new String[maxNotification];
    }

    /** Metode yang akan mengembalikan list notification. */
    public String[] getNotifications() {
        return notifications;
    }

    /** Metode yang akan mengembalikan jumlah notifikasi. */
    public int getNotificationCount() {
        return notificationCount;
    }

    /** Metode yang akan mengembalikan nama. */
    public String getName() {
        return name;
    }

    /** 
     * Metode yang akan menambahkan notifikasi baru. Jika notifikasi sudah mencapai maksimum
     * maka tidak akan menambah apa-apa.
     * 
     * @return Notifikasi dari Poster langganan.
     */
    public void addNotification(String notification) {
        if (notificationCount < maxNotification) {
            notifications[notificationCount] = notification;
            notificationCount++;
        }
    }

    /**
     * Metode yang akan berlangganan ke Poster
     * 
     * @param poster
     */
    public void subscribeTo(Poster poster) {
        if (poster instanceof Blogger) {
            ((Blogger) poster).subscribe(this);
        } else if (poster instanceof Channel) {
            ((Channel) poster).subscribe(this);
        }
    }
}
