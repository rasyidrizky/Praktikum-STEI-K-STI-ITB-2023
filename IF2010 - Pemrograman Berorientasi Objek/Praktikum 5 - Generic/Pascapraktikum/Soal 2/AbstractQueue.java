import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQueue<T extends Comparable<T>> {
    protected List<T> elements = new ArrayList<>();

    /**
     * Memeriksa apakah queue kosong
     * 
     * @return true jika queue kosong, false jika tidak
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Mengembalikan jumlah elemen dalam queue
     * 
     * @return jumlah elemen dalam queue
     */
    public int size() {
        return elements.size();
    }

    public abstract void enqueue(T element);
    public abstract T dequeue();
    public abstract T front();
}
