public class Penyihir extends Karakter {
    protected int mana;
    protected int maksimalMana;

    /*
     * Konstruktor untuk kelas Penyihir
     * 
     * Mengisi nama dan maksimal mana karakter berdasarkan parameter yang diberikan
     * Mana awal sama dengan maksimal mana
     * Profesi karakter adalah "Penyihir"
     * 
     * Jangan tambahkan parameter profesi, gunakan pengetahuan kalian untuk
     * mengubahnya
     */
    public Penyihir(String nama, int maksimalMana) {
        super(nama, "Penyihir");
        this.maksimalMana = maksimalMana;
        this.mana = maksimalMana;
    }

    /*
     * Metode untuk menggunakan sihir
     * 
     * Mengurangi mana karakter berdasarkan parameter yang diberikan
     * Jika mana karakter tidak cukup, tampilkan pesan "Mana [nama] tidak cukup!"
     * Jika mana karakter cukup, tampilkan pesan dengan format
     * "[nama] menggunakan sihir dengan mana sejumlah [jumlah mana]"
     * "Sisa mana: [sisa mana]"
     * 
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    public void gunakanSihir(int mana) {
        if (this.mana < mana) {
            System.out.println("Mana " + nama + " tidak cukup!");
        }
        else {
            this.mana -= mana;
            System.out.println(nama + " menggunakan sihir dengan mana sejumlah " + mana);
            System.out.println("Sisa mana: " + this.mana);
        }
    }

    /*
     * Metode untuk mengisi mana
     * 
     * Menambah mana karakter berdasarkan parameter yang diberikan
     * Jika total mana melebihi maksimal mana, set mana ke maksimal mana
     * Tampilkan pesan dengan format
     * "[nama] mengisi mana sebanyak [jumlah mana]"
     * "Sisa mana: [sisa mana]"
     * 
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    public void mengisiMana(int mana) {
        this.mana += mana;
        if (this.mana > this.maksimalMana) {
            this.mana = this.maksimalMana;
        }
        System.out.println(nama + " mengisi mana sebanyak " + mana);
        System.out.println("Sisa mana: " + this.mana);
    }
}
