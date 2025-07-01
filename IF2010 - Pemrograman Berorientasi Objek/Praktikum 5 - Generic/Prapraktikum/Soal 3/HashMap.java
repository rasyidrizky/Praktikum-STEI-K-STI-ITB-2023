class HashMap<K, V> implements Map<K, V> {
    private static final int BUCKET_SIZE = 100;
    @SuppressWarnings("unchecked")
    private LinkedList<KeyValue<K, V>>[] buckets = new LinkedList[BUCKET_SIZE];

    HashMap() {
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<KeyValue<K, V>>();
        }
    }

    public static class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * Hash function untuk Key
     * Gunakan method ini untuk menentukan lokasi penyimpanan Key-Value pada buckets
     * @param key
     * @return nilai hash dari key
     */
    private int getKeyHash(K key) {
        return (key.hashCode() % BUCKET_SIZE + BUCKET_SIZE) % BUCKET_SIZE;
    }

    /**
     * Menyimpan nilai (key, value) ke dalam map
     * Melakukan overwrite jika sudah terdapat elemen dengan key yang sama.
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        int i = getKeyHash(key);
        KeyValue<K,V> newKey = new KeyValue(key, value);
        boolean found = false;

        int j = 0;
        while (j < buckets[i].getSize() && !found) {
            if (buckets[i].get(j).getKey().equals(key)) {
                found = true;
            }
            else {
                j++;
            }
        }

        if (found) {
            buckets[i].set(j, newKey);
        }
        else {
            buckets[i].add(newKey);
        }
    }

    /**
     * Mengembalikan value yang tersimpan untuk key tertentu pada map
     * Mengembalikan null apabila map tidak mengandung key masukan.
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        int i = getKeyHash(key);
        boolean found = false;

        int j = 0;
        while (j < buckets[i].getSize() && !found) {
            if (buckets[i].get(j).getKey().equals(key)) {
                found = true;
            }
            else {
                j++;
            }
        }

        if (found) {
            return buckets[i].get(j).getValue();
        }
        else {
            return null;
        }
    }

    /**
     * @return banyak elemen di dalam map
     */
    @Override
    public int size() {
        int count = 0;

        for (int i = 0; i < BUCKET_SIZE; i++) {
            count += buckets[i].getSize();
        }

        return count;
    }

    /**
     * Menghapus semua elemen yang ada pada map
     */
    @Override
    public void clear() {
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i].clear();
        }
    }

    /**
     * Mengembalikan true apabila terdapat elemen dengan Key = key di dalam map, dan false bila tidak
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        int i = getKeyHash(key);
        boolean found = false;

        int j = 0;
        while (j < buckets[i].getSize() && !found) {
            if (buckets[i].get(j).getKey().equals(key)) {
                found = true;
            }
            else {
                j++;
            }
        }

        return found;
    }

    /**
     * Menghapus elemen dengan Key = key dari map jika ada
     * @param key
     */
    @Override
    public void remove(K key) {
        int i = getKeyHash(key);
        boolean found = false;

        int j = 0;
        while (j < buckets[i].getSize() && !found) {
            if (buckets[i].get(j).getKey().equals(key)) {
                found = true;
            }
            else {
                j++;
            }
        }

        if (found) {
            buckets[i].remove(j);
        }
    }
}