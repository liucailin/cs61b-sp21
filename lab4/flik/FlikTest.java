package flik;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlikTest {
    @Test
    public void testIsSameNumber() {
        assertTrue(Flik.isSameNumber(1, 1));
    }

    @Test
    public void testIsSameNumber128() {
        assertTrue(Flik.isSameNumber(128, 128));
    }

    @Test
    public void testIsSameNumber129() {
        Integer val = new Integer(129);
        assertTrue(Flik.isSameNumber(val, val));
    }
}
