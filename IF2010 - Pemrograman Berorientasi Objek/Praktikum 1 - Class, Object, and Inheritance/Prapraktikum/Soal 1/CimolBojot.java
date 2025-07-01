/**
 * CimolBojot.java
 * Memodelkan menu cimol bojot
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class CimolBojot {
    // Deklarasi atribut
    private String namaMenu;
    private int harga;
    private int stok;

    // Konstruktor
    public CimolBojot(String namaMenu, int harga, int stok) {
        this.namaMenu = namaMenu;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter and setter
    public String getNamaMenu() {
        return namaMenu;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setNamaMenu(String namaMenuBaru) {
        namaMenu = namaMenuBaru;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public boolean isHaveEnoughStok(int amount) {
        return stok>=amount;
    }

    public void reduceStok(int amount) {
        if (isHaveEnoughStok(amount)) {
            stok -= amount;
        }
    }
}