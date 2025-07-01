
import java.util.Collections;


public class MinQueue<T extends Comparable<T>> extends AbstractQueue<T> {
    /**
     * Menambahkan elemen ke dalam queue
     * 
     * @param element elemen yang akan ditambahkan
     */
    @Override
    public void enqueue(T element) {
        elements.add(0, element);
        Collections.sort(elements);
    }

    /**
     * Menghapus elemen dari queue
     * 
     * @return elemen yang dihapus atau null jika queue kosong
     */
    @Override
    public T dequeue() {
        if (elements.isEmpty()) {
            return null;
        }
        else {
            T t = elements.get(0);
            elements.remove(0);
            Collections.sort(elements);
            return t;
        }
    }

    /**
     * Mengembalikan elemen terdepan dari queue
     * 
     * @return elemen teratas atau null jika queue kosong
     */
    @Override
    public T front() {
        if (elements.isEmpty()) {
            return null;
        }
        else {
            return elements.get(0);
        }
    }
}
