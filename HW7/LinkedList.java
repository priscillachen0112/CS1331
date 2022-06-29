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
        } else if (data == null) {
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
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        T tmp;
        Node<T> current = head;
        if (index == 0) {
            tmp = head.getData();
            head.setData(head.getNext().getData());
            head.setNext(head.getNext().getNext());
        } else if (index == size) {
            while (current.getNext().getNext() != head) {
                current = current.getNext();
            }
            tmp = current.getNext().getData();
            current.setNext(head);
        } else {
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            tmp = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        if (--size == 0) {
            head = null;
        }
        return tmp;
    }

    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> current = head;
        Node<T> removed = null;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getData() == data) {
                removed = current.getNext();
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
            size--;
        }
        if (removed == null) {
            throw new NoSuchElementException("The data is not present in the list.");
        }
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