import java.util.List;
import java.util.ArrayList;

/**
 * Kelas Kendaraan merepresentasikan sebuah unit kendaraan yang dapat mengangkut pendukung.
 * Setiap kendaraan memiliki plat nomor, jenis, kapasitas maksimum, dan daftar pendukung yang sedang diangkut.
 */
public class Kendaraan {
    private String platNomor;
    private String jenisKendaraan;
    private int kapasitasMaksimum;
    private List<Pendukung> daftarPendukung;

    /**
     * Konstruktor untuk membuat objek Kendaraan baru.
     *
     * @param platNomor Plat nomor unik kendaraan.
     * @param jenisKendaraan Jenis dari kendaraan (misalnya, "Mobil", "Motor").
     * @param kapasitasMaksimum Jumlah maksimum pendukung yang dapat diangkut kendaraan.
     */
    public Kendaraan(String platNomor, String jenisKendaraan, int kapasitasMaksimum) {
        this.platNomor = platNomor;
        this.jenisKendaraan = jenisKendaraan;
        this.kapasitasMaksimum = kapasitasMaksimum;
        this.daftarPendukung = new ArrayList<Pendukung>();
    }

    /**
     * Mengembalikan plat nomor kendaraan.
     *
     * @return String plat nomor.
     */
    public String getPlatNomor() {
        return platNomor;
    }

    /**
     * Mengembalikan jenis kendaraan.
     *
     * @return String jenis kendaraan.
     */
    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    /**
     * Mengembalikan kapasitas maksimum penumpang kendaraan.
     *
     * @return int kapasitas maksimum.
     */
    public int getKapasitasMaksimum() {
        return kapasitasMaksimum;
    }

    /**
     * Mengembalikan daftar pendukung yang ada di dalam kendaraan.
     *
     * @return List objek Pendukung.
     */
    public List<Pendukung> getDaftarPendukung() {
        return daftarPendukung;
    }

    /**
     * Menambahkan objek Pendukung ke dalam daftar pendukung kendaraan.
     * Penambahan hanya berhasil jika objek pendukung tidak null dan kapasitas kendaraan masih mencukupi.
     *
     * @param pendukung Objek Pendukung yang akan ditambahkan.
     * @return boolean true jika pendukung berhasil ditambahkan, false jika gagal.
     */
    public boolean addPendukung(Pendukung pendukung) {
        if (pendukung == null || daftarPendukung.size() >= kapasitasMaksimum) {
            return false;
        }
        else {
            daftarPendukung.add(pendukung);
            return true;
        }
    }

    /**
     * Menghapus objek Pendukung dari daftar pendukung pada kendaraan.
     * Penghapusan didasarkan pada kesamaan referensi objek.
     *
     * @param pendukung Objek Pendukung yang akan dihapus.
     * @return boolean true jika pendukung berhasil dihapus, false jika tidak ditemukan atau pendukung null.
     */
    public boolean removePendukung(Pendukung pendukung) {
        if (pendukung == null || !daftarPendukung.contains(pendukung)) {
            return false;
        }
        else {
            daftarPendukung.remove(pendukung);
            return true;
        }
    }

    /**
     * Menampilkan informasi detail kendaraan, termasuk plat nomor, jenis, kapasitas,
     * jumlah pendukung saat ini, dan detail daftar pendukung di dalamnya.
     */
    public void displayInfo() {
        System.out.println("Plat nomor: " + platNomor + ", Jenis: " + jenisKendaraan + ", Kapasitas: " + kapasitasMaksimum + ", Terisi: " + daftarPendukung.size());
        if (!daftarPendukung.isEmpty()) {
            System.out.println("Daftar pendukung di " + platNomor + ":");
            for (Pendukung p : daftarPendukung) {
                p.displayInfo();
            }
        }
    }
}