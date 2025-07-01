public class TorrentPeer {
    public String name;
    public int[] chunks;

    /**
     * Konstruktor TorrentPeer
     * @param name nama peer
     * @param chunks elemen-elemen chunk yang dimiliki oleh peer
     */
    public TorrentPeer(String name, int[] chunks) {
        this.name = name;
        this.chunks = chunks;
    }

    /**
     * Method untuk mengecek apakah peer mempunyai chunk
     * dengan indeks tertentu
     * @param chunk
     * @return true jika memiliki chunk tersebut, false jika tidak
     */
    public boolean hasChunk(int chunk) {
        for (int c : chunks) {
            if (c == chunk) {
                return true;
            }
        }
        return false;
    }
}