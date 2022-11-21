package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> list1 = new AListNoResizing<Integer>();
        BuggyAList<Integer> list2 = new BuggyAList<>();
        list1.addLast(4);
        list2.addLast(4);
        list1.addLast(5);
        list2.addLast(5);
        list1.addLast(6);
        list2.addLast(6);

        assertEquals(list1.size(), list2.size());
        assertEquals(list1.removeLast(), list2.removeLast());
        assertEquals(list1.removeLast(), list2.removeLast());
        assertEquals(list1.removeLast(), list2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                assertEquals(L.size(), L2.size());
                if (L.size() > 0 && L2.size() > 0) {
                    assertEquals(L.removeLast(), L2.removeLast());
                }
            } else if (operationNumber == 2) {
                assertEquals(L.size(), L2.size());

                if (L.size() > 0 && L2.size() > 0) {

                    assertEquals(L.getLast(), L2.getLast());
                }
            }
        }
    }
}
