package Prapraktikum;
import java.util.ArrayList;

public class ComplexWordCountServer {

    private int nWorkers;

    // masukkan arraylist of string dipastikan berupa alfabet lowercase saja
    private ArrayList<String> array;

    // hasil pada method countSpecialString akan disimpan pada res
    int[] res = new int[26];

    ComplexWordCountServer(int nWorkers, ArrayList<String> array) {
        // Inisialisasi attributes
        this.array = array;
        this.nWorkers = nWorkers;
    }

    public void countSpecialString() throws InterruptedException {
        // calculateSum akan membuat thread untuk setiap string
        // setiap thread kemudian akan memanggil metode characterCountHelper
        // lalu hasil dari Array Mapping yang dikembalikan oleh metode characterCountHelper akan digunakan
        // untuk ditambahkan ke attribut res
        ArrayList<Thread> threads = new ArrayList<>();

        for (String s : array) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int[] localCount = characterCountHelper(s);

                    synchronized (res) {
                        for (int i = 0; i < 26; i++) {
                            res[i] += localCount[i];
                        }
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    protected int[] characterCountHelper(String str) {
        // Menghitung berapa banyak occurence dari suatu karakter pada suatu string
        // lalu dipetakan pada suatu array of integer

        // HINT : untuk memetakan suatu karakter ke array of integer, anda bisa melakukan arr[c-'a']
        // sehingga apabila variable c merupakan karakter 'a', value dari c-'a' menjadi 0, begitupun
        // dengan karakter alfabet lainnya
        int[] charCount = new int[26];
        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }
        return charCount;
    }

    public String toString() {
        // menampilkan berapa banyak kata spesial "one", "two" dan "three"
        // format keluaran dari fungsi ini adalah "one : {one_occurence}, two : {two_occurence}, three : {three_occurence}"
        // lalu diakhiri dengan newline
        int oneCount = 0, twoCount = 0, threeCount = 0;

        while (true) {
            if (res['o' - 'a'] > 0 && res['n' - 'a'] > 0 && res['e' - 'a'] > 0) {
                oneCount++;
                res['o' - 'a']--;
                res['n' - 'a']--;
                res['e' - 'a']--;
            }

            else if (res['t' - 'a'] > 0 && res['w' - 'a'] > 0 && res['o' - 'a'] > 0) {
                twoCount++;
                res['t' - 'a']--;
                res['w' - 'a']--;
                res['o' - 'a']--;
            }

            else if (res['t' - 'a'] > 0 && res['h' - 'a'] > 0 && res['r' - 'a'] > 0 && res['e' - 'a'] >= 2) {
                threeCount++;
                res['t' - 'a']--;
                res['h' - 'a']--;
                res['r' - 'a']--;
                res['e' - 'a'] -= 2;
            }
            else {
                break;
            }
        }

        return "one : " + oneCount + ", two : " + twoCount + ", three : " + threeCount + "\n";
    }
}