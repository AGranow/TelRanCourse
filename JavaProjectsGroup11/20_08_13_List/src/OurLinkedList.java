import java.util.Comparator;
import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {

    private int size;
    Node<T> first;
    Node<T> last;

    @Override
    public int size() {
        return size;
    }


    @Override
    public void add(T elt) {
        Node<T> newNode = new Node<>(elt, null, last);

        if (size == 0) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    @Override
    public void set(int index, T elt) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> needle = getNode(index);
        needle.elt = elt;
    }

    private Node<T> getNode(int index) {
        Node<T> needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }

        return needle;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> needle = getNode(index);
        return needle.elt;
    }

    @Override
    public boolean contains(T elt) {
        Node<T> current = first;

        for (int i = 0; i < size; i++) {
            if (elt.equals(current.elt)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        if (size == 1) {
            T elt = first.elt;
            first.elt = null;
            first = null;
            last = null;
            size--;
            return elt;
        }

        Node<T> nodeToRemove = getNode(index);
        Node<T> left = nodeToRemove.prev;
        Node<T> right = nodeToRemove.next;
        T elt = nodeToRemove.elt;

        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.elt = null;

        if (index > 0 && index < size - 1) {
            left.next = right;
            right.prev = left;
        } else if (index == 0) {
            right.prev = null;
            first = right;
        } else {
            left.next = null;
            last = left;
        }
        size--;
        return elt;
    }

    @Override
    public boolean remove(T elt) {
        Node<T> current = first;

        for (int i = 0; i < size; i++) {
            if (elt.equals(current.elt)) {
                remove(i);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<T> comparator) {
    }



    @Override
    public Iterator<T> iterator() {
//        return new Iterator<>() {
//
//            int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < size;
//            }
//
//            @Override
//            public T next() {
//                return (T) source[currentIndex++];
//            }
//        };
        return new OurLinkedList.DefaultIterator();
    }

    class DefaultIterator implements Iterator<T> {

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
           return true ;
        }

        @Override
        public T next() {
     //       return (T) source[currentIndex++];
            return null;
        }
    }


    private static class Node<T> {

        public Node(T elt, Node<T> next, Node<T> prev) {
            this.elt = elt;
            this.next = next;
            this.prev = prev;
        }

        T elt;
        Node<T> next;
        Node<T> prev;

    }
}