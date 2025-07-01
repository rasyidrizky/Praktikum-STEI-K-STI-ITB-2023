/*
    Nama                    : Rasyid Rizky Susilo Nurdwiputro
    NIM                     : 18223114
    Hari dan tanggal        : Senin, 21 April 2025
    Deskripsi Program       : Membuat kelas abstrak Bike
*/

/**
 * Bike.java
 *
 * Kelas abstrak dasar untuk semua bike.
 */
public abstract class Bike implements Discountable{
    private String name;
    private Number price;
    private Number battery;

    /**
     * Konstruktor untuk Bike.
     *
     * @param name    nama model sepeda
     * @param price   harga dalam USD (any Number subtype)
     * @param battery kapasitas baterai dalam Wh (any Number subtype)
     */
    public Bike(String name, Number price, Number battery) {
        this.name = name;
        this.price = price;
        this.battery = battery;
    }

    /** @return nama model sepeda */
    public String getName() {
        return name;
    }

    /** @param name nama model baru */
    public void setName(String name) {
        this.name = name;
    }

    /** @return harga sepeda sebagai Number */
    public Number getPrice() {
        return price;
    }

    /** @param price harga baru */
    public void setPrice(Number price) {
        this.price = price;
    }

    /** @return kapasitas baterai dalam Wh */
    public Number getBattery() {
        return battery;
    }

    /** @param battery kapasitas baterai baru */
    public void setBattery(Number battery) {
        this.battery = battery;
    }

    /**
     * Mencetak spesifikasi sepeda:
     * "<name> $<price 2 desimal>, <battery 1 desimal>Wh"
     * "Contoh: Wush $1200.00, 400.0Wh"
     */
    public void printSpec() {
        System.out.print(this.name + " $");
        System.out.printf("%.2f", this.price.floatValue());
        System.out.print(", ");
        System.out.printf("%.1f", this.battery.floatValue());
        System.out.println("Wh");
    }

    /**
     * Membandingkan suatu sepeda dengan sepeda lain berdasarkan:
     * 1) battery (lebih besar lebih baik)
     * 2) jika battery sama, bandingkan price (lebih kecil lebih baik)
     *
     * @param otherBike sepeda lain
     * @return true jika sepeda ini lebih baik, selain itu return false
     */
    public boolean isBetterThan(Bike otherBike) {
        if (this.battery.floatValue() > otherBike.battery.floatValue()) {
            return true;
        }
        else if (this.battery.floatValue() == otherBike.battery.floatValue()) {
            return this.price.floatValue() < otherBike.price.floatValue();
        }
        else {
            return false;
        }
    }
}
