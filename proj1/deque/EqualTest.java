package deque;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EqualTest {

    private void construct(Deque deque) {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
    }

    @Test
    public void testDeque() {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        ArrayDeque<Integer> a2 = new ArrayDeque<>();
        construct(a1);
        construct(a2);

        assertTrue(a1.equals(a1));
        assertTrue(a1.equals(a2));

        LinkedListDeque<Integer> l1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> l2 = new LinkedListDeque<>();
        construct(l1);
        construct(l2);

        assertTrue(l1.equals(l1));
        assertTrue(l1.equals(l2));

        assertTrue(l1.equals(a1));

    }
}
