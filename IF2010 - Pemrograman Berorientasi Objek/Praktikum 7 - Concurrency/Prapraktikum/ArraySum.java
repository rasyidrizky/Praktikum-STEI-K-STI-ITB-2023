package Prapraktikum;
/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class ArraySum extends Thread {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 
    private Thread[] threads;
    private int total = 0;

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = nWorkers;
        this.arr = arr;
        this.threads = new Thread[nWorkers];
    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
        int n = arr.length;

        if (n == 0) return 0;

        int baseSize = n / nWorkers;
        int remainder = n % nWorkers;
        int[] subtotal = new int[nWorkers];

        int start = 0;
        for (int i = 0; i < nWorkers; i++) {
            int chunkSize = baseSize + (i >= (nWorkers - remainder) ? 1 : 0);
            int end = start + chunkSize;
            final int threadIndex = i;
            final int threadStart = start;
            final int threadEnd = end;

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int localsum = partialSum(threadStart, threadEnd);
                    subtotal[threadIndex] = localsum;
                }
            });

            threads[i].start();
            start = end;
        }

        for (Thread t : threads) {
            t.join();
        }

        for (int val : subtotal) {
            total += val;
        }

        return total;
    }

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}