package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private final Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (!isEmpty()) {
            T max = get(0);
            for (int i = 1; i < size(); i++) {
                T cur = get(i);
                if (c.compare(cur, max) > 0) {
                    max = cur;
                }
            }
            return max;
        }
        return null;
    }

}
