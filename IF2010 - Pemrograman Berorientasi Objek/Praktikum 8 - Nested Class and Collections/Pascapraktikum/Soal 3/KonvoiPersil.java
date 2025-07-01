import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Kelas KonvoiPersil merepresentasikan sebuah konvoi yang terdiri dari beberapa kendaraan,
 * masing-masing dengan rute yang telah ditentukan.
 */
public class KonvoiPersil {
    private String namaKonvoi;
    private Map<Kendaraan, RuteKonvoi> daftarGrup;

    /**
     * Konstruktor untuk membuat objek KonvoiPersil baru.
     * 
     * @param namaKonvoi Nama yang akan diberikan untuk konvoi ini.
     */
    public KonvoiPersil(String namaKonvoi) {
        this.namaKonvoi = namaKonvoi;
        this.daftarGrup = new HashMap<>();
    }

    /**
     * Mengembalikan nama dari konvoi.
     * 
     * @return String nama konvoi.
     */
    public String getNamaKonvoi() {
        return namaKonvoi;
    }

     /**
     * Mengembalikan peta yang berisi kendaraan dan rute konvoi yang terkait.
     * 
     * @return Map<Kendaraan, RuteKonvoi> daftar grup kendaraan dan rutenya.
     */
    public Map<Kendaraan, RuteKonvoi> getDaftarGrup() {
        return daftarGrup;
    }

    /**
     * Menambahkan sebuah kendaraan beserta rutenya ke dalam konvoi.
     * Jika kendaraan atau rute bernilai null, maka tidak ada yang ditambahkan.
     * 
     * @param kendaraan Objek Kendaraan yang akan ditambahkan.
     * @param rute Objek RuteKonvoi yang akan dilalui oleh kendaraan tersebut.
     */
    public void addGrup(Kendaraan kendaraan, RuteKonvoi rute) {
        if (kendaraan == null || rute == null || daftarGrup.containsKey(kendaraan)) {
            return;
        }
        daftarGrup.put(kendaraan, rute);
    }

    /**
     * Menghitung jumlah total pendukung unik yang ada di semua kendaraan dalam konvoi.
     * Pendukung dihitung unik berdasarkan objeknya.
     * 
     * @return int jumlah total pendukung unik.
     */
    public int hitungTotalPendukungKonvoi() {
        Set<Pendukung> semuaPendukung = new HashSet<>();
        for (Kendaraan k : daftarGrup.keySet()) {
            semuaPendukung.addAll(k.getDaftarPendukung());
        }
        return semuaPendukung.size();
    }

    /**
     * Mencari pendukung tertua dalam sebuah kendaraan tertentu.
     * 
     * @param kendaraan Objek Kendaraan yang akan diperiksa.
     * @return Objek Pendukung yang paling tua dalam kendaraan tersebut, atau null jika kendaraan null atau tidak memiliki pendukung.
     */
    public Pendukung cariPendukungTertuaDalamKendaraan(Kendaraan kendaraan) {
        if (kendaraan == null || !daftarGrup.containsKey(kendaraan) || kendaraan.getDaftarPendukung().isEmpty()) {
            return null;
        }
        else {
            Pendukung cari = null;
            int max = Integer.MIN_VALUE;

            for (Pendukung p : kendaraan.getDaftarPendukung()) {
                if (p.getUmur() > max) {
                    max = p.getUmur();
                    cari = p;
                }
            }

            return cari;
        }
    }

    /**
     * Menampilkan informasi mengenai konvoi, termasuk detail setiap kendaraan dan rutenya.
     * Jika tidak ada kendaraan dalam konvoi, akan ditampilkan pesan yang sesuai.
     */
    public void displayInfo() {
        if (daftarGrup.isEmpty()) {
            System.out.println("Belum ada kendaraan yang ditugaskan dalam konvoi ini.");
        } else {
            int i = 1;
            for (Map.Entry<Kendaraan, RuteKonvoi> entry : daftarGrup.entrySet()) {
                if (i != 1) {
                    System.out.println();
                }
                System.out.println("Mapping grup-kendaraan ke-" + i);
                Kendaraan k = entry.getKey();
                RuteKonvoi r = entry.getValue();

                System.out.println("Kendaraan:");
                k.displayInfo();
                
                System.out.println("\nAkan melalui rute:");
                r.displayInfo();
                i++;
            }
        }
    }
}