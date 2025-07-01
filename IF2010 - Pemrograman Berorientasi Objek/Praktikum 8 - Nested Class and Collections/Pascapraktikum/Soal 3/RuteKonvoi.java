import java.util.ArrayList;
import java.util.List;

/**
 * Kelas RuteKonvoi merepresentasikan sebuah rute perjalanan yang akan dilalui oleh konvoi.
 * Sebuah rute terdiri dari beberapa segmen, masing-masing dengan estimasi waktu tempuh.
 */
public class RuteKonvoi {
    private String namaRute;
    private List<SegmenRute> daftarSegmenRute;

    /**
     * Konstruktor untuk membuat objek RuteKonvoi baru.
     *
     * @param namaRute Nama yang akan diberikan untuk rute ini (misalnya, "Rute A").
     */
    public RuteKonvoi(String namaRute) {
        this.namaRute = namaRute;
        this.daftarSegmenRute = new ArrayList<>();
    }

    /**
     * Mengembalikan nama rute konvoi.
     *
     * @return String nama rute.
     */
    public String getNamaRute() {
        return namaRute;
    }

    /**
     * Mengembalikan daftar segmen rute.
     * Daftar ini berisi objek-objek {@link SegmenRute}.
     *
     * @return List<SegmenRute> daftar segmen rute.
     */
    public List<SegmenRute> getDaftarSegmenRute() {
        return daftarSegmenRute;
    }

    /**
     * Menambahkan sebuah segmen baru ke dalam rute konvoi.
     * Segmen hanya akan ditambahkan jika nama segmen valid (tidak null atau kosong)
     * dan estimasi waktu tempuh positif.
     *
     * @param namaSegment Nama deskriptif untuk segmen rute (misalnya, "Alun-alun - Jl. Asia Afrika").
     * @param estimasiWaktuMenit Estimasi waktu tempuh untuk segmen ini dalam satuan menit.
     */
    public void addSegmen(String namaSegment, int estimasiWaktuMenit) {
        if (namaSegment != null && !namaSegment.trim().isEmpty() && estimasiWaktuMenit > 0) {
            daftarSegmenRute.add(new SegmenRute(namaSegment, estimasiWaktuMenit));
        }
    }

    /**
     * Menghitung total estimasi waktu tempuh untuk keseluruhan rute.
     * Total waktu adalah jumlah dari estimasi waktu tempuh setiap segmen dalam rute.
     *
     * @return int total estimasi waktu tempuh dalam menit.
     */
    public int hitungTotalEstimasiWaktu() {
        int total = 0;

        for (SegmenRute i : daftarSegmenRute) {
            total += i.getEstimasiWaktuSegmentMenit();
        }

        return total;
    }

    /**
     * Menampilkan informasi detail mengenai rute konvoi,
     * termasuk nama rute, total estimasi waktu, dan detail setiap segmen rutenya.
     */
    public void displayInfo() {
        System.out.println("Nama rute: " + namaRute);
        System.out.println("Total estimasi waktu: " + hitungTotalEstimasiWaktu() + " menit");
        if (!daftarSegmenRute.isEmpty()) {
            System.out.println("Segmen-segmen rute:");
            for (SegmenRute segment : daftarSegmenRute) {
                segment.displayInfo();
            }
        }
    }
    
    /**
     * Kelas static inner SegmenRute merepresentasikan sebuah bagian atau tahapan dalam {@link RuteKonvoi}.
     * Setiap segmen memiliki nama dan estimasi waktu tempuh sendiri.
     */
    public static class SegmenRute {
        private String namaSegment;
        private int estimasiWaktuSegmentMenit;

        /**
         * Konstruktor untuk membuat objek SegmenRute baru.
         *
         * @param namaSegment Nama segmen (misalnya, "Pintu Tol Pasteur - Gasibu").
         * @param estimasiWaktuSegmentMenit Estimasi waktu tempuh segmen dalam menit.
         */
        public SegmenRute(String namaSegment, int estimasiWaktuSegmentMenit) {
            this.namaSegment = namaSegment;
            this.estimasiWaktuSegmentMenit = estimasiWaktuSegmentMenit;
        }

        /**
         * Mengembalikan nama segmen rute.
         *
         * @return String nama segmen.
         */
        public String getNamaSegment() {
            return namaSegment;
        }

        /**
         * Mengembalikan estimasi waktu tempuh untuk segmen ini dalam menit.
         *
         * @return int estimasi waktu tempuh segmen dalam menit.
         */
        public int getEstimasiWaktuSegmentMenit() {
            return estimasiWaktuSegmentMenit;
        }

        /**
         * Menampilkan informasi detail mengenai segmen rute.
         */
        public void displayInfo() {
            System.out.println("- " + namaSegment + " (Estimasi: " + estimasiWaktuSegmentMenit + " menit)");
        }
    }
}