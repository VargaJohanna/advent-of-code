package day3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by Johanna on 08/12/2017.
 */
public class TestSpiralMemory {
    SpiralMemory spiralMemory = new SpiralMemory();

    @Test
    public void testInput1() {
       assertEquals(3, spiralMemory.findDistance(12));
    }

    @Test
    public void testInput2() {
        assertEquals(2, spiralMemory.findDistance(23));
    }

    @Test
    public void testInput3() {
        assertEquals(31, spiralMemory.findDistance(1024));
    }

    @Test
    public void testInput4() {
        assertEquals(438, spiralMemory.findDistance(265149));
    }
}
