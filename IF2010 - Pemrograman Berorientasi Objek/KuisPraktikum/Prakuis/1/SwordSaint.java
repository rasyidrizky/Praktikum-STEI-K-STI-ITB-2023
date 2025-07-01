public class SwordSaint extends Swordman {
    /*
     * Konstruktor untuk kelas SwordSaint
     * 
     * Mengisi nama karakter berdasarkan parameter yang diberikan
     * Profesi karakter adalah "SwordSaint"
     * Nama pedang adalah "Dragon Sword Reid"
     * 
     * Jangan tambahkan parameter profesi dan nama pedang, gunakan
     * pengetahuan kalian untuk mengubahnya
     */
    public SwordSaint(String name) {
        super(name, "Dragon Sword Reid");
        this.profesi = "SwordSaint";
    }

    /*
     * Metode untuk menyerang dengan tebasan
     * 
     * Tampilkan pesan dengan format
     * "[nama] menyerang dengan tebasan yang menggelegar menggunakan
     * pedang [namaPedang] dengan aura yang sangat kuat"
     * 
     * P.S. Ini teks 1 baris jangan tambahkan newline
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    @Override
    public void tebas() {
        System.out.println(this.nama + " menyerang dengan tebasan yang menggelegar menggunakan pedang " + this.namaPedang + " dengan aura yang sangat kuat");
    }
}
