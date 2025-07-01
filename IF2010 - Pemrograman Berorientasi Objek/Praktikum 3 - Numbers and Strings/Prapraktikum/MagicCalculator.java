public class MagicCalculator {
    /**
     * Menjalankan metode calculate untuk MagicCalculator
     * lihat deskripsi soal untuk cara kerja metode calculate
     * 
     * @param array Number
     */
    public void calculate(Number[] arr) {
        System.out.println("=== MULAI KALKULASI ===");
        for (Number i : arr) {
            if (i instanceof Integer) {
                System.out.println(i + " adalah tipe integer");
                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);
            }

            else if (i instanceof Byte) {
                System.out.println(i + " adalah tipe byte");
                System.out.println(Byte.MAX_VALUE);
                System.out.println(Byte.MIN_VALUE);
            }

            else if (i instanceof Double) {
                System.out.println(i + " adalah tipe double");
                System.out.println(Double.MAX_VALUE);
                System.out.println(Double.MIN_VALUE);
                System.out.println(Double.isInfinite((double) i));
            }

            else if (i instanceof Float) {
                System.out.println(i + " adalah tipe float");
                System.out.println(Float.MAX_VALUE);
                System.out.println(Float.MIN_VALUE);
                System.out.println(Float.isInfinite((float) i));
            }

            else if (i instanceof Short) {
                System.out.println(i + " adalah tipe short");
                System.out.println(Short.MAX_VALUE);
                System.out.println(Short.MIN_VALUE);
            }

            else if (i instanceof Long) {
                System.out.println(i + " adalah tipe long");
                System.out.println(Long.MAX_VALUE);
                System.out.println(Long.MIN_VALUE);
            }
        }

        System.out.println("=== KALKULASI SELESAI ===");
    }
}