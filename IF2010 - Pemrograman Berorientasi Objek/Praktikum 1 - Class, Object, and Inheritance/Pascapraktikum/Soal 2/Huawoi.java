/**
 * Huawoi.java
 * Memodelkan spesifikasi handphone Huawoi
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class Huawoi extends Handphone {
	private Boolean isKW;

	public Huawoi(Boolean isKW) {
		// Sesuai dengan Soal
        super("Huawoi", 5000000, 4);
        
        if (isKW) {
            super.setNama("Huawoi KW");
            super.setHarga(2000000);
            super.setRam(2);
        }
        this.isKW = isKW;
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        if (hargaTawaran <= (1000000 + this.getHarga())) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public void printSpeciality() {
		// Bila isKW = true, Print (tanpa tanda kutip, diakhiri newline) "HPnya murah
		// bos"
		// Bila isKW = false, Print (tanpa tanda kutip, diakhiri newline) "Speknya
		// kenceng bos"
        if (this.isKW) {
            System.out.println("HPnya murah bos");
        } else {
            System.out.println("Speknya kenceng bos");
        }
	}
}