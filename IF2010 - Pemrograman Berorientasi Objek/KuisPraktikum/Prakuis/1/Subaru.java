public class Subaru extends Karakter {
    private int jumlahKematian;
    private String checkpoint;
    
    /*
     * Konstruktor untuk kelas Subaru
     * 
     * Nama karakter adalah "Subaru"
     * Profesi karakter adalah "MC"
     * Jumlah kematian awal adalah 0
     * Checkpoint awal adalah "Toko Apel"
     * 
     * Jangan tambahkan parameter profesi, gunakan pengetahuan kalian untuk
     * mengubahnya
     */
    public Subaru() {
        super("Subaru", "MC");
        this.jumlahKematian = 0;
        this.checkpoint = "Toko Apel";
    }

    /*
     * Metode untuk return by death
     * 
     * Menampilkan pesan dengan format
     * "Subaru mati ke-[jumlahKematian] kali"
     * "Subaru kembali ke checkpoint [checkpoint]"
     * 
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    public void mati() {
        this.jumlahKematian++;
        System.out.println("Subaru mati ke-" + this.jumlahKematian + " kali");
        System.out.println("Subaru kembali ke checkpoint " + this.checkpoint);
    }

    /*
     * Metode untuk return by death dengan checkpoint baru
     * 
     * Menampilkan pesan dengan format
     * "Subaru mati ke-[jumlahKematian] kali"
     * "Subaru kembali ke checkpoint [checkpoint]"
     * 
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    public void mati(String checkpointBaru) {
        this.jumlahKematian++;
        this.checkpoint = checkpointBaru;
        System.out.println("Subaru mati ke-" + this.jumlahKematian + " kali");
        System.out.println("Subaru kembali ke checkpoint " + this.checkpoint);
    }
}
