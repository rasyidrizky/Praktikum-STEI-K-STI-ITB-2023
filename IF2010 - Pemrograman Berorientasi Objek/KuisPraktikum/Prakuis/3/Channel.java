public class Channel implements Poster {
    private String channelName;
    private int maxVideos = 100;
    private Video videos[];
    private int videoCount = 0;

    private int maxSubscribers = 100;
    private Subscriber[] subscribers;
    private int subscriberCount = 0;

    /** 
     * KONSTRUKTOR - Menciptakan objek Channel baru dengan subscribers kosong.
     * 
     * @param name: Nama dari Channel
     */
    public Channel(String name) {
        this.channelName = name;
        this.videos = new Video[maxVideos];
        this.subscribers = new Subscriber[maxSubscribers];
    }

    /** Metode yang akan mengembalikan list subscriber */
    public Subscriber[] getSubscribers() {
        return subscribers;
    }

    /** Metode yang akan mengembalikan jumlah subscriber. */
    public int getSubscriberCount() {
        return subscriberCount;
    }

    /** Metode yang akan mengembalikan list video milik channel. */
    public Video[] getVideos() {
        return videos;
    }

    /** 
     * Metode untuk menambahkan konten baru ke akun dan menotifikasi seluruh subscriber. Jika video sudah mencapai maksimum
     * maka tidak akan menambah apa-apa.
     * 
     * Notifikasi ke subscriber akan diberikan dalam format berikut:
     * "Channel {channelName} telah mengunggah video baru dengan judul {video.getTitle()}"
     * 
     * @param content: Konten yang akan di-post harus berupa Video.
     */
    public void post(Content video) {
        if (videoCount < maxVideos && video instanceof Video) {
            Video newvideo = (Video) video;
            videos[videoCount++] = newvideo;

            String notification = "Channel " + channelName + " telah mengunggah video baru dengan judul " + newvideo.getTitle();
            for (int i = 0; i < subscriberCount; i++) {
                subscribers[i].addNotification(notification);
            }
        }
    }

    /** 
     * Metode untuk mengubah Video yang pernah dibuat dan menotifikasi seluruh subscriber. Jika
     * Video yang diberikan tidak ada di dalam list video, maka jangan lakukan apapun.
     * 
     * Notifikasi ke subscriber akan diberikan dalam format berikut:
     * "Channel {channelName} telah mengubah video {oldVideo.getTitle()} menjadi {newVideo.getTitle()}"
     * 
     * @param oldVideo: Video lama yang mungkin ada atau tidak ada di list Video.
     * @param newVideo: Video yang akan menggantikan Video lama
     */
    public void changePost(Content oldVideo, Content newVideo) {
        if (!(oldVideo instanceof Video) || !(newVideo instanceof Video)) return;

        for (int i = 0; i < videoCount; i++) {
            if (videos[i].isSame(oldVideo)) {
                videos[i] = (Video) newVideo;

                String notification = "Channel " + channelName + " telah mengubah video " + oldVideo.getTitle() + " menjadi " + newVideo.getTitle();
                for (int j = 0; j < subscriberCount; j++) {
                    subscribers[j].addNotification(notification);
                }
                break;
            }
        }
    }

    /** 
     * Metode yang memungkinkan berlangganan ke Poster ini dengan menambahkan ke list Subscriber. Jika subscriber sudah mencapai maksimum
     * maka tidak akan menambah apa-apa.
     * 
     * @param subscriber: Akun yang ingin berlangganan.
     */
    public void subscribe(Subscriber s) {
        if (subscriberCount < maxSubscribers) {
            subscribers[subscriberCount++] = s;
        }

    }
}
