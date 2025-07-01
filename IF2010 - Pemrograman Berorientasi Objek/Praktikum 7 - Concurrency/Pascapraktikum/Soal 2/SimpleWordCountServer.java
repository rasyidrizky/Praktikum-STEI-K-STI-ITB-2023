public class SimpleWordCountServer {
    private int nWorkers;

    /**
     * Constructor untuk simple word count server
     * 
     * @param nWorkers jumlah maximum threads yang tersedia pada server a.k.a thread
     *                 pool
     */
    SimpleWordCountServer(int nWorkers) {
        this.nWorkers = nWorkers;
    }

    /**
     * Ikuti instruksi yang ada di deskripsi soal ya!
     * 1. processRequests akan membuat threads dan memetakan elemen-elemen requests
     * kepada threads tersebut
     * 2. setiap thread kemudian memanggil method countWords
     * 3. main thread (thread yang invoked method ini) akan menunggu semua thread
     * selesai
     * 4. terakhir main thread akan mengembalikan hasil penghitungan kata untuk
     * setiap elemen requests
     * 
     * @param requests array kalimat yang dikirimkan client
     */
    public Integer[] processRequests(String[] requests) throws InterruptedException {
        Integer[] results = new Integer[requests.length];
        Thread[] threads = new Thread[nWorkers];

        for (int i = 0; i < nWorkers; i++) {
            final int workerIndex = i;

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = workerIndex; j < requests.length; j += nWorkers) {
                        results[j] = countWords(requests[j]);
                    }
                }
            });

            threads[i].start();
        }

        // Tunggu semua thread selesai
        for (int i = 0; i < nWorkers; i++) {
            threads[i].join();
        }

        return results;
    }

    /**
     * countWords adalah metode yang mengembalikkan jumlah kata dalam suatu kalimat
     * HINT : beberapa fungsi yang berguna :
     * - trim() : menghilangkan trailing / leading white space
     * - isWhiteSpace() : cek apakah suatu karakter merupakan white space (tab,
     * space atau newline)
     * - isEmpty() : cek apakah suatu string kosong ("") atau tidak
     * seluruh fungsi diatas dapat dipakai dengan namaVariabelString.namaFungsi()
     * misalnya :
     * String s1 = "tomoro"
     * s1.isEmpty() -> akan menghasilkan nilai false
     * - charAt(i) : memberikan karakter pada indeks i.
     * Cara pemakaiannya string.charAt(i) dengan i sebagai indeks.
     * 
     * HINT 2 : Coba iterasi perkarakter di string kalian dan gunakan whitespace
     * sebagai patokan akhir kalimat :D
     * 
     * @param request kalimat yang dikirimkan client
     */
    protected int countWords(String request) {
        request = request.trim();
        if (request.isEmpty()) return 0;

        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < request.length(); i++) {
            char c = request.charAt(i);
            if (Character.isWhitespace(c)) {
                if (inWord) {
                    count++;
                    inWord = false;
                }
            } else {
                inWord = true;
            }
        }

        // Tambah satu jika string berakhir dengan kata
        if (inWord) count++;

        return count;
    }
}
