public class Karakter {
    protected String nama;
    protected String profesi;
    
    /*
     * Konstruktor untuk kelas Karakter
     * 
     * Mengisi nama dan profesi karakter berdasarkan parameter yang diberikan
     */
    public Karakter(String nama, String profesi) {
        this.nama = nama;
        this.profesi = profesi;
    }

    /*
     * Metode untuk memperkenalkan karakter
     * 
     * Menampilkan nama dan profesi karakter ke layar dengan format
     * "Nama saya adalah [nama]"
     * "Profesi saya adalah [profesi]"
     * 
     * Gunakan System.out.println() untuk menampilkan informasi
     * Jangan gunakan System.out.printf atau System.out.print
     */
    public void perkenalan() {
        System.out.println("Nama saya adalah " + nama);
        System.out.println("Profesi saya adalah " + profesi);
    }
}