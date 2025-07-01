import java.util.Stack;

public class NotePurry {
    private String text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    /**
     * Constructor sederhana untuk NotePurry
     * 
     * Inisialisasi text dengan string kosong
     * Inisialisasi undoStack dan redoStack dengan Stack kosong
     */
    public NotePurry() {
        this.text = "";
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    /**
     * Constructor untuk NotePurry dengan teks awal
     * 
     * Inisialisasi text dengan teks awal
     * Inisialisasi undoStack dan redoStack dengan Stack kosong
     * 
     * @param text Teks awal yang akan diisi ke NotePurry
     */
    public NotePurry(String text) {
        this.text = text;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    /**
     * Fungsi untuk melihat isi dari text saat ini pada NotePurry
     * 
     * Gunakan System.out.println untuk mencetak teks
     */
    public void print() {
        System.out.println(text);
    }

    /**
     * Fungsi untuk mengembalikan state text ke state sebelumnya
     * 
     * Mengembalikan state text ke state sebelumnya
     * Apabila undoStack kosong, maka keluarkan pesan "Tidak bisa melakukan undo"
     * 
     * Gunakan System.out.println untuk mencetak pesan
     */
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak bisa melakukan undo");
        }
        else {
            redoStack.push(this.text);
            this.text = undoStack.peek();
            undoStack.pop();
        }
    }

    /**
     * Fungsi untuk mengembalikan state text ke state selanjutnya
     * 
     * Mengembalikan state text ke state selanjutnya
     * Apabila redoStack kosong, maka keluarkan pesan "Tidak bisa melakukan redo"
     * 
     * Gunakan System.out.println untuk mencetak pesan
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak bisa melakukan redo");
        }
        else {
            undoStack.push(this.text);
            this.text = redoStack.peek();
            redoStack.pop();
        }
    }

    /**
     * Fungsi untuk menambahkan teks ke NotePurry
     * 
     * @param text Teks yang akan ditambahkan
     */
    public void append(String text) {
        undoStack.push(this.text);
        this.text = this.text + text;
    }

    /**
     * Fungsi untuk menghapus teks dari NotePurry
     * 
     * Jika nilai n lebih besar dari panjang teks
     * maka keluarkan pesan "Tidak dapat menghapus teks"
     * dan tidak dimasukkan ke history undo
     * 
     * Gunakan System.out.println untuk mencetak pesan
     * 
     * @param n Jumlah karakter yang akan dihapus dari akhir teks
     */
    public void delete(int n) {
        if (n > text.length()) {
            System.out.println("Tidak dapat menghapus teks");
        }
        else {
            undoStack.push(text);
            text = text.substring(0, text.length()-n);
        }
    }

    /**
     * Fungsi untuk menghapus semua teks dari NotePurry
     * 
     * Mengosongkan teks dan menyimpan state ke undoStack
     */
    public void clear() {
        undoStack.push(text);
        text = "";
    }
}
