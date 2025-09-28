public class List<T> implements IDataStructure<T> {

    private Node<T> first;

   
    public List<T> insert(T data, int index) {
        Node<T> node = new Node<>(data);

        if (first == null && (index == 0 || index == -1)) {
            first = node;
        } else if (index == 0) {
            insertFirst(node);
        } else if (index == -1) {
            insertLast(node);
        } else if (index > 0) {
            insertAt(node, index);
        } else {
            throw new IndexOutOfBoundsException();
        }

        return this;
    }

    private void insertFirst(Node<T> node) {
        node.setNext(first);
        first = node;
    }

    private void insertLast(Node<T> node) {
        Node<T> last = first;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);
    }

    private void insertAt(Node<T> node, int index) {
        Node<T> current = first;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.getNext();
        }
        if (current == null) throw new IndexOutOfBoundsException();
        node.setNext(current.getNext());
        current.setNext(node);
    }

    
    public List<T> remove(int index) {
        if (first == null) throw new IndexOutOfBoundsException();

        if (index == 0) removeFirst();
        else if (index == -1) removeLast();
        else removeAt(index);

        return this;
    }

    private void removeFirst() {
        first = first.getNext();
    }

    private void removeLast() {
        if (first.getNext() != null) {
            Node<T> current = first;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        } else {
            first = null;
        }
    }

    private void removeAt(int index) {
        Node<T> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
            if (current == null) throw new IndexOutOfBoundsException();
        }
        if (current.getNext() == null) throw new IndexOutOfBoundsException();
        current.setNext(current.getNext().getNext());
    }

  
    public Node<T> getFirst() {
        return first;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return first != null ? first.count() : 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] listData() {
        T[] array = (T[]) new Object[size()];
        Node<T> node = first;
        for (int i = 0; i < array.length; i++) {
            array[i] = node.getData();
            node = node.getNext();
        }
        return array;
    }
}
