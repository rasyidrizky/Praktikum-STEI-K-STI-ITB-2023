interface Pair<K, V> {
    public K getKey();

    public V getValue();
}

public class KeyValuePairGeneric<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public KeyValuePairGeneric(K key, V value) {
        // Konstruktor
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        // Kembalikan nilai key
        return key;
    }

    public V getValue() {
        // Kembalikan nilai value
        return value;
    }

    public String getTypeKeyandValue() {
        // Mencetak tipe data key dan value
        // Contoh "1 memiliki tipe Integer dan value dari key tersebut memiliki tipe
        // String dengan nilai berupa Halo"
        // Format "key memiliki tipe key_type dan value dari key tersebut memiliki tipe
        // value_type dengan nilai berupa value"
        return key + " memiliki tipe " + key.getClass().getSimpleName() + " dan value dari key tersebut memiliki tipe " + value.getClass().getSimpleName() + " dengan nilai berupa " + value;
    }
}