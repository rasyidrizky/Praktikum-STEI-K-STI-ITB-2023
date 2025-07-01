import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkSimulator {
       /**
     * Fungsi untuk mencari node berdasarkan ID (helper function).
     * Sudah diimplementasikan asisten, tidak perlu diubah, tetapi tidak wajib digunakan.
     * 
     * @param nodes daftar node yang terhubung dalam jaringan
     * @param id ID node yang dicari
     * @return Node yang ditemukan, atau null jika tidak ditemukan
     */
    private static Node findNode(List<Node> nodes, String id) {
        for (Node node : nodes) {
            if (node.id.equals(id)) {
                return node;
            }
        }
        return null;
    }
    
/**
     * Fungsi untuk memproses satu paket dan melakukan validasi terhadap aturan jaringan.
     * 
     * @param nodes daftar node yang terhubung dalam jaringan
     * @param transmissionLog mencatat timestamp dan node tujuan untuk setiap paket yang dikirim
     * @param packet paket yang akan dikirim
     * @throws NetworkException jika terjadi pelanggaran protokol jaringan
     * 
     * transmissionLog adalah Map yang menyimpan timestamp dan node tujuan untuk setiap paket yang dikirim.
     * Contoh isi transmissionLog:
     * - "A" -> {10, 20}
     * - "B" -> {15}
     * - "C" -> {5, 30}
     * 
     * Method Map:
     *      transmissionLog.containsKey("B") 
     *      // Output: true jika node "B" sudah pernah menerima paket
     *      
     *      transmissionLog.put("D", new HashSet<>();
     *      // Menambahkan entri baru: "D" -> {}
     *      // Contoh di atas membuat entri D di map transmissionLog dengan nilai awal HashSet kosong, bisa diisi kemudian HashSet-nya
     *            
     *      transmissionLog.get("C")
     *      // Output: Set/HashSet berisi timestamp milik node "C", misalnya [5, 30]
     * 
     * Method HashSet (Set adalah interface, HashSet adalah implementasinya):
     *      Set<Integer> ts = new HashSet<>();
     *      
     *      ts.add(10); 
     *      ts.add(20);
     *      ts.contains(10); // Output: true
     *      ts.add(10);      // Output: false (tidak ditambahkan ulang karena sudah ada)
     * 
     * Hint:
     *  - Jika node sumber atau tujuan tidak ada dalam daftar node, throw NetworkException (tanpa pesan)
     *  - Jika sumber = tujuan, throw LoopbackException
     *  - Jika timestamp <= waktu terakhir diterima oleh tujuan, throw TimeDesyncException
     *  - Jika sudah ada paket lain yang ditujukan ke node tersebut pada timestamp yang sama, throw CollisionException
     *  - Jika semua ketentuan valid, update state node (lastReceived dengan timestamp packet)
     *    dan transmissionLog (tambahkan timestamp ke dalam HashSet node tujuan. Jika node belum pernah tercatat, maka buat dulu node-nya sebagai key
     *    di Map dengan HashSet kosong, baru tambahkan timestamp.)
     */
    public static void validatePacket(List<Node> nodes, Map<String, Set<Integer>> transmissionLog, Packet packet) throws NetworkException {
        // Ambil node sumber dan tujuan
        Node fromNode = findNode(nodes, packet.from);
        Node toNode = findNode(nodes, packet.to);

        // Jika salah satu tidak ditemukan, lempar NetworkException
        if (fromNode == null || toNode == null) {
            throw new NetworkException();
        }

        // 1. Loopback check
        if (packet.from.equals(packet.to)) {
            throw new LoopbackException("Loopback: Node " + packet.from + " tidak boleh mengirim ke dirinya sendiri.");
        }

        // 2. Time desync check
        if (packet.timestamp <= toNode.lastReceived) {
            throw new TimeDesyncException("Time desync: Node " + packet.to + " sudah menerima hingga waktu " + toNode.lastReceived +
                ", tetapi kemudian menerima dari " + packet.from + " dengan waktu " + packet.timestamp);
        }

        // 3. Collision check
        if (transmissionLog.containsKey(packet.to)) {
            Set<Integer> timestamps = transmissionLog.get(packet.to);
            if (timestamps.contains(packet.timestamp)) {
                throw new CollisionException("Collision: Ada lebih dari satu paket ke node " + packet.to + " pada waktu " + packet.timestamp);
            }
        }

        // 4. Jika lolos semua validasi:
        //    a. update lastReceived
        toNode.lastReceived = packet.timestamp;

        //    b. update transmissionLog
        if (!transmissionLog.containsKey(packet.to)) {
            transmissionLog.put(packet.to, new java.util.HashSet<>());
        }

        transmissionLog.get(packet.to).add(packet.timestamp);
    }
}

/**
 * Superclass untuk semua exception terkait jaringan.
 */
class NetworkException extends Exception {
        public NetworkException() {
        super();
    }

    public NetworkException(String message) {
        super(message);
    }
}

/**
 * Exception untuk kasus di mana node mencoba mengirim ke dirinya sendiri.
 * 
 * Contoh pesan: "Loopback: Node B tidak boleh mengirim ke dirinya sendiri."
 */
class LoopbackException extends NetworkException {
    public LoopbackException(String message) {
        super(message);
    }
}


/**
 * Exception untuk kasus node menerima timestamp lebih kecil/sama dari yang sebelumnya.
 * 
 * Contoh pesan: "Time desync: Node A sudah menerima hingga waktu 20, tetapi kemudian menerima dari C dengan waktu 15"
 */
class TimeDesyncException extends NetworkException {
    public TimeDesyncException(String message) {
        super(message);
    }
}

/**
 * Exception untuk kasus dua pengiriman ke node yang sama di waktu yang sama.
 * 
 * Contoh pesan: "Collision: Ada lebih dari satu paket ke node C pada waktu 20"
 */
class CollisionException extends NetworkException {
    public CollisionException(String message) {
        super(message);
    }
}
