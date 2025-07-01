/**
 * Pipo.java
 * Memodelkan spesifikasi handphone Pipo
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class Pipo extends Handphone {
	private String camera;

	public Pipo(String camera) {
		// Sesuai dengan Soal
        super("Pipo", 3000000, 3);
        this.camera = camera;
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        if (hargaTawaran >= 2500000) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public void printSpeciality() {
		// Print (tanpa tanda kutip, diakhiri newline):
		// "Kamera ni HP " + camera
        System.out.println("Kamera ni HP " + this.camera);
	}
}