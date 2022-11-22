package deque;

public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(int capacity) {
        size = 0;
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque() {
        this(8);
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size += 1;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            int k = Math.floorMod(nextFirst + 1 + i, items.length);
            a[i] = items[k];
        }

        nextFirst = capacity - 1;
        nextLast = size;
        items = a;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int k = Math.floorMod(nextFirst + 1 + i, items.length);
            s.append(items[k]);
            s.append(" ");
        }

        return s.toString();
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            if ((size < items.length / 4) && (size > 4)) {
                resize(size + 1);
            }
            int curFirst = (nextFirst + 1) % items.length;
            T first = items[curFirst];
            items[curFirst] = null;
            nextFirst = curFirst;
            size -= 1;
            return first;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            if ((size < items.length / 4) && (size > 4)) {
                resize(size + 1);
            }
            int curLast = Math.floorMod(nextLast - 1, items.length);
            T last = items[curLast];
            items[curLast] = null;
            nextLast = curLast;
            size -= 1;
            return last;
        }
        return null;
    }

    @Override
    public T get(int index) {
        int k = (nextFirst + 1 + index) % items.length;
        return items[k];
    }
}