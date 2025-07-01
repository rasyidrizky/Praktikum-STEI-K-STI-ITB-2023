class Packet {
    String from; // Pengirim paket
    String to; // Penerima paket
    int timestamp; // Waktu pengiriman paket

    public Packet(String from, String to, int timestamp) {
        this.from = from;
        this.to = to;
        this.timestamp = timestamp;
    }
}