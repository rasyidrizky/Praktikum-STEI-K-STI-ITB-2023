public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public Node<T> getNode(int position) { // zero indexing
        if (position < 0 || size <= position) return null;

        Node<T> cur = head;
        int curPos = 0;
        while (curPos < position && cur.getNext() != null) {
            cur = cur.getNext();
            curPos++;
        }
        if (curPos == position) {
            return cur;
        }
        return null;
    }

    public void add(T item) {
        if (size == 0) {
            head = new Node<>(item);
            tail = head;
            size++;
            return;
        }
        tail.setNext(new Node<>(item, tail, null));
        tail = tail.getNext();
        size++;
    }

    public T get(int position) {
        Node<T> node = getNode(position);
        if (node != null) {
            return node.getInfo();
        }
        return null;
    }

    public void set(int position, T item) {
        Node<T> node = getNode(position);
        if (node != null) {
            node.setInfo(item);
        }
    }

    public void remove(int position) {
        Node<T> node = getNode(position);
        if (node != null) {
            size--;
            if (node.getPrev() == null) {
                if (node.getNext() == null) {
                    head = null;
                    tail = null;
                } else {
                    head = node.getNext();
                    head.setPrev(null);
                }
            } else if (node.getNext() == null) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
}