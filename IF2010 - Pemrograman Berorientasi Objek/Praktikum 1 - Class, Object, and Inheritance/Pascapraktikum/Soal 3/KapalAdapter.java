/**
 * KapalAdapter.java
 * Memodelkan kapal adapter
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class KapalAdapter extends WargaSipil {
    private Kapal kapal;

    public KapalAdapter(Kapal kapal, String namaPemesan) {
        // Implementasi sesuai petunjuk soal
        this.kapal = kapal;
        super(namaPemesan);
    }

    public void urusAdministrasi() {
        // Implementasi sesuai petunjuk soal
        kapal.pesanTiket(super.namaPemesan);
        kapal.pilihKamar(super.namaPemesan);
    }

    public void cobaKabur() {
        // Implementasi sesuai petunjuk soal
        kapal.berangkatKePelabuhan(super.namaPemesan);
        kapal.verifikasiTiket(super.namaPemesan);
    }
    
    public void berhasilKabur() {
        // Implementasi sesuai petunjuk soal
        kapal.naikKapal(super.namaPemesan);
        kapal.berlayar();
    }
}
