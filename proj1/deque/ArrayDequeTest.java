package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayDequeTest {
    @Test
    public void addRemove() {

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertEquals(0, ad.size());
        assertTrue(ad.isEmpty());
        ad.addLast(1);
        assertEquals(1, ad.size());
        assertEquals(1, (int)ad.removeFirst());
        assertTrue(ad.isEmpty());

        ad.addFirst(1);
        assertEquals(1, ad.size());
        assertEquals(1, (int)ad.removeLast());

        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addFirst(0);
        assertEquals(4, ad.size());
        ad.printDeque();

        ad.addLast(4);
        ad.addFirst(-1);

        ad.printDeque();
    }

    @Test
    public void randomTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedList<Integer> C = new LinkedList<>();
        int N = 5000;
        for (int i = 0; i < N; i++) {
            int op = StdRandom.uniform(0, 5);
            int value = StdRandom.uniform(0, 100);

            if (op == 0) {
                L.addFirst(value);
                C.addFirst(value);
            } else if (op == 1) {
                L.addLast(value);
                C.addLast(value);
            } else if (op == 2) {
                if (L.size() > 0 && C.size() > 0) {
                    assertEquals(C.removeFirst(), L.removeFirst());
                }
            } else if (op == 3) {
                if (L.size() > 0 && C.size() > 0) {
                    assertEquals(C.removeLast(), L.removeLast());
                }
            } else if (op == 4) {
                if (L.size() > 0 && C.size() > 0) {
                    int index = StdRandom.uniform(0, L.size());
                    assertEquals(C.get(index), L.get(index));
                }
            }
        }

//        StringBuilder s = new StringBuilder();
//        for (int e : C) {
//            s.append(e);
//            s.append(" ");
//        }
//
//        assertEquals(s.toString(), L.toString());

    }

    @Test
    public void repeatRandomTest() {
        int N = 1000;
        for (int i = 0; i < N; i++) {
            randomTest();
        }
    }

    @Test
    public void testMax() {
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < 1000; i++) {
            maxArrayDeque.addFirst(i);
        }

        assertEquals(999, (int)maxArrayDeque.max());
    }
}
