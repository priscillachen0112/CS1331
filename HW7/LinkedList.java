import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        if (this.isEmpty()) {
            return null;
        }
        return head;
    }

    public Node<T> getTail() {
        if (this.isEmpty()) {
            return null;
        }
        return tail;
    }

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data can't be null");
        }
        Node<T> tmp = new Node<>(data);
        Node<T> current = head;
        if (size == 0) {
            head = tmp;
            head.setNext(head);
        } else if (index == 0) {
            tmp.setNext(head.getNext());
            tmp.setData(head.getData());
            head.setNext(tmp);
            head.setData(data);
        } else if (index == size) {
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(tmp);
            tmp.setNext(head);
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            tmp.setNext(current.getNext());
            current.setNext(tmp);
        }
        size++;
    }

    public T getAtIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        int i = 0;
        while (i < index) {
            head = head.getNext();
            i++;
        }
        return head.getData();
    }

    public T removeAtIndex(int index) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        Node<T> removed = null;
        if (index == 0) {
            removed = head;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                Node<T> current = head;
                for (int i=0; i<size-2; i++) {
                    current = current.getNext();
                }
                current.setNext(null);
                tail = current;
            }
        } else if (index == size-1) {
            removed = tail;
            Node<T> current = head;
            for (int i=0; i<size-2; i++) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        } else {
            Node<T> current = head;
            for (int i=0; i<index-1; i++) {
                current = current.getNext();
            }
            removed = current.getNext();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removed.getData();
    }

    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> prev = head;
        Node<T> removed = null;
        if (prev == null) {
            throw new NoSuchElementException("The data is not present in the list.");
        } else if (prev.getData() == data) {
            removed = prev;
            head = head.getNext();
            size--;
            return removed.getData();
        }
        while (true) {
            Node<T> next = prev.getNext();
            if (next == null) {
                throw new NoSuchElementException("The data is not present in the list.");
            } else if (next.getData() == data) {
                removed = next;
                break;
            }
            prev = next;
        }
        Node<T> next = prev.getNext();
        prev.setNext(next.getNext());
        next.setNext(null);
        size--;
        return removed.getData();
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return size;
    }
}