/**
 * Toko.java
 * Memodelkan toko cimol bojot
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */


public class Toko {
    // Deklarasi atribut
    private CimolBojot[] cimolBojotArray;
    private int kas;
    private static final int MAX_CIMOL = 3;
    private int cimolCount;

    public Toko(int initialKas) {
        this.kas = initialKas;
        this.cimolBojotArray = new CimolBojot[MAX_CIMOL];
        this.cimolCount = 0;
    }

    public int getKas() {
        return kas;
    }

    public void addCimolBojot(CimolBojot cimolBojot) {
        if (cimolCount < MAX_CIMOL) {
            cimolBojotArray[cimolCount] = cimolBojot;
            cimolCount++;
        }
    }

    public int findCimolBojotIndexByName(String namaMenu) {
        int i = 0;
        boolean found = false;
        
        while (!found && i < cimolCount) {
            if (namaMenu.equals(cimolBojotArray[i].getNamaMenu())) {
                found = true;
            } else {
                i++;
            }
        }

        return i;
    }

    public String sellCimolBojot(String namaMenu, int quantity) {
        int i = findCimolBojotIndexByName(namaMenu);
        
        if (i < cimolCount) {
            if (cimolBojotArray[i].isHaveEnoughStok(quantity)) {
                cimolBojotArray[i].reduceStok(quantity);
                kas += cimolBojotArray[i].getHarga() * quantity;
                return "Berhasil menjual cimol " + namaMenu + " sebanyak " + quantity + "\nSekarang sisa: " + cimolBojotArray[i].getStok();
            } else {
                return "Waduh stoknya gak cukup\n";
            }
        } else {
            return "Kita gak jual itu kaka\n";
        }
    }
}