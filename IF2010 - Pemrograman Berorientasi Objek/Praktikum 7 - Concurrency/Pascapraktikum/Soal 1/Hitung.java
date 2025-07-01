public class Hitung {
    static final int NUM_OF_THREAD = 10;

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Lengkapi method ini untuk mencari bilangan prima dari [0, N]. Wajib menggunakan conccurency!

    // Di dalam method run() dalam runnable sertakan pemanggilan ThreadTracker.mark();
    // Jika tidak, atau jika tidak menggunakan conccurency maka kode akan terus runtime error!

    public int hitungPrima(int N) throws InterruptedException {
        int[] hasilThread = new int[NUM_OF_THREAD];

        Thread[] threads = new Thread[NUM_OF_THREAD];

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            final int threadIndex = i;

            threads[i] = new Thread(() -> {
                ThreadTracker.mark();
                int count = 0;

                for (int j = threadIndex + 1; j <= N; j += NUM_OF_THREAD) {
                    if (isPrime(j)) {
                        count++;
                    }
                }

                hasilThread[threadIndex] = count;
            });

            threads[i].start();
        }

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            threads[i].join();
        }

        int total = 0;
        for (int count : hasilThread) {
            total += count;
        }

        return total;
    }
}