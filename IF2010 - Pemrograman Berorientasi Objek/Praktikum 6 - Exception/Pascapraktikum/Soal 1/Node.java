class Node {
    String id;
    int lastReceived = -1;  // Nilai awal untuk lastReceived (belum ada paket yang diterima)

    public Node(String id) {
        this.id = id;
    }
}