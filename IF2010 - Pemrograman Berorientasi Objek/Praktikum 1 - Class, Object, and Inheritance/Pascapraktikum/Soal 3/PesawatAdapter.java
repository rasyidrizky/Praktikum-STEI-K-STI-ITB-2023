/**
 * PesawatAdapter.java
 * Memodelkan pesawat adapter
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class PesawatAdapter extends WargaSipil {
    private Pesawat pesawat;

    public PesawatAdapter(Pesawat pesawat, String namaPemesan) {
        // Implementasi sesuai petunjuk soal
        this.pesawat = pesawat;
        super(namaPemesan);
    }

    public void urusAdministrasi() {
        // Implementasi sesuai petunjuk soal
        pesawat.pesanTiket(super.namaPemesan);
    }

    public void cobaKabur() {
        // Implementasi sesuai petunjuk soal
        pesawat.berangkatKeBandara(super.namaPemesan);
        pesawat.checkIn(super.namaPemesan);
    }
    
    public void berhasilKabur() {
        // Implementasi sesuai petunjuk soal
        pesawat.naikPesawat(super.namaPemesan);
        pesawat.boarding();
    }
}
