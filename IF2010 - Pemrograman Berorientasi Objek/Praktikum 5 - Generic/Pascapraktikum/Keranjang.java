/**
 * Keranjang.java
 */
public class Keranjang<T extends Barang> {
    private T t;
    private String type;

    /**
     * Constructor untuk membuat keranjang baru
     * 
     * @param t Barang yang disimpan keranjang
     */
    public Keranjang(T t) {
        this.t = t;
        this.type = t.getClass().getName();
    }

    /**
     * Mengembalikkan tipe barang
     * 
     * @return tipe barang
     */
    public String getType() {
        return type;
    }

    /**
     * Mengembalikkan barang
     * 
     * @return barang
     */
    public T getBarang() {
        return t;
    }

    /**
     * Mencetak barang dalam format :
     * "<Nama Barang> - <Nilai barang>"
     * Sebagai contoh : "Oppo - HP seharga 20000"
     * 
     * HINT : ingat cara kerja toString!
     */
    public void printBarang() {
        System.out.println(t.getName() + " - " + t.toString());
    }
}

class Barang {
    private String name;

    public Barang(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Baju extends Barang {
    private String color;

    public Baju(String name, String color) {
        super(name);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        return "Baju berwarna " + this.color;
    }
}

class Handphone extends Barang {
    private int price;

    public Handphone(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String toString() {
        return "HP seharga " + this.price;
    }
}