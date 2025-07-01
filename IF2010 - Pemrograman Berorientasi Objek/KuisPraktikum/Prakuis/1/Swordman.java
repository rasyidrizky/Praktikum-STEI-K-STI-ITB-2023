public class Swordman extends Karakter {
    protected String namaPedang;

    /*
     * Konstruktor untuk kelas Swordman
     * 
     * Mengisi nama dan nama pedang karakter berdasarkan parameter yang
     * diberikan
     * Profesi karakter adalah "Swordman"
     * 
     * Jangan tambahkan parameter profesi, gunakan pengetahuan kalian untuk
     * mengubahnya
     */
    public Swordman(String name, String namaPedang) {
        super(name, "Swordman");
        this.namaPedang = namaPedang;
    }

    /*
     * Metode untuk menyerang dengan tebasan
     * 
     * Tampilkan pesan dengan format
     * "[nama] menyerang dengan tebasan menggunakan pedang [namaPedang]"
     *  
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    public void tebas() {
        System.out.println(this.nama + " menyerang dengan tebasan menggunakan pedang " + this.namaPedang);
    }
}
