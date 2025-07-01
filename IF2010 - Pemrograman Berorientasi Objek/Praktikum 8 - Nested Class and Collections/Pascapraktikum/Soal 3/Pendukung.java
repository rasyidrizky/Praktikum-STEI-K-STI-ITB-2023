import java.util.*;

/**
 * Kelas Pendukung merepresentasikan seseorang yang menjadi bagian dari konvoi.
 * Setiap pendukung memiliki nama, asal daerah, umur, dan daftar atribut yang dibawa.
 */
public class Pendukung {
    private String nama;
    private String asalDaerah;
    private int umur;
    private HashSet<String> atributYangDibawa;

    /**
     * Konstruktor untuk membuat objek Pendukung baru.
     *
     * @param nama Nama lengkap pendukung.
     * @param asalDaerah Asal daerah pendukung.
     * @param umur Umur pendukung dalam tahun.
     */
    public Pendukung(String nama, String asalDaerah, int umur) {
        this.nama = nama;
        this.asalDaerah = asalDaerah;
        this.umur = umur;
        this.atributYangDibawa = new HashSet<>();
    }

    /**
     * Mengembalikan nama pendukung.
     *
     * @return String nama pendukung.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan asal daerah pendukung.
     *
     * @return String asal daerah pendukung.
     */
    public String getAsalDaerah() {
        return asalDaerah;
    }

    /**
     * Mengembalikan umur pendukung.
     *
     * @return int umur pendukung dalam tahun.
     */
    public int getUmur() {
        return umur;
    }

    /**
     * Mengembalikan HashSet (kumpulan unik) dari atribut yang dibawa pendukung.
     *
     * @return HashSet<String> atribut yang dibawa.
     */
    public HashSet<String> getAtributYangDibawa() {
        return atributYangDibawa;
    }

    /**
     * Menambahkan sebuah atribut ke dalam daftar atribut yang dibawa pendukung.
     * Atribut tidak akan ditambahkan jika null atau string kosong.
     * Jika atribut sudah ada, tidak akan ditambahkan lagi (sifat dari Set).
     *
     * @param atribut String atribut yang akan ditambahkan.
     */
    public void addAtribut(String atribut) {
        if (atribut != null && !atribut.isEmpty()) {
            this.atributYangDibawa.add(atribut);
        }
    }

    /**
     * Menampilkan informasi detail mengenai pendukung, termasuk nama, asal, umur,
     * dan daftar atribut yang dibawa.
     */
    public void displayInfo() {
        System.out.println("Nama: " + nama + ", Asal: " + asalDaerah + ", Umur: " + umur + " tahun");
        System.out.println("Atribut: " + (atributYangDibawa.isEmpty() ? "-" : atributYangDibawa));
    }
}