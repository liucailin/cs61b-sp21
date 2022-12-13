package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node first = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
//        if (first.next == sentinel) {
//            sentinel.prev = first;
//        }
        size += 1;
    }

    public void addLast(T item) {
        Node last = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    public T removeFirst() {
        Node first = sentinel.next;
        if (first != sentinel) {
            first.next.prev = sentinel;
            sentinel.next = first.next;
            size -= 1;
            return first.item;
        }
        return null;
    }

    public T removeLast() {
        Node last = sentinel.prev;
        if (last != sentinel) {
            last.prev.next = sentinel;
            sentinel.prev = last.prev;
            size -= 1;
            return last.item;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.println(getString());
    }

    private String getString() {
        StringBuilder s = new StringBuilder();
        Node p = sentinel.next;
        while (p != sentinel) {
            s.append(p.item);
            s.append(' ');
            p = p.next;
        }
        return s.toString();
    }

    public T get(int index) {
        int i = 0;
        Node p = sentinel.next;
        while (p != sentinel) {
            if (i == index) {
                return p.item;
            }
            p = p.next;
            i += 1;
        }
        return null;
    }


    public T getRecursive(int index) {
        return getRecursiveHelper(0, index, sentinel.next);
    }

    private T getRecursiveHelper(int i, int index, Node p) {
        if (i == index && p != sentinel) {
            return p.item;
        }

        return getRecursiveHelper(i + 1, index, p.next);
    }


    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }

        Deque other = (Deque) o;
        if (size != other.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node current = sentinel;

            @Override
            public boolean hasNext() {
                return current.next != sentinel;
            }

            @Override
            public T next() {
                current = current.next;
                return current.item;
            }
        };
    }

}
