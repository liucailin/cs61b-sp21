package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

        for (String s: lld1) {
            System.out.println(s);
        }

		System.out.println("Printing out deque: ");
		lld1.printDeque();

        lld1.removeFirst();
        lld1.printDeque();

        lld1.removeLast();
        lld1.printDeque();

        lld1.addFirst("5");
        lld1.printDeque();
        lld1.addLast("6");
        lld1.printDeque();

        for (String s: lld1) {
            System.out.println(s);
        }

        System.out.println("--------------------------");

        for (int i = 0; i < lld1.size(); i++) {
            System.out.println(lld1.getRecursive(i));
        }


    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addLast(5);
		lld1.addFirst(1);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());
        lld1.addFirst(2);
        lld1.addLast(6);
        lld1.addFirst(3);
        lld1.addLast(4);
        assertEquals(4, (int)lld1.removeLast());
		assertEquals(3, (int)lld1.removeFirst());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    public void randomTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
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
}
