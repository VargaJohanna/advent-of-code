package day6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johannavarga on 15/01/2018.
 */
public class TestReallocation {
    MemoryReallocation reallocation = new MemoryReallocation();

    @Test
    public void test1() {
        assertEquals(reallocation.reallocation("0\t2\t7\t0"), 5);
    }

    @Test
    public void test2() {
        assertEquals(reallocation.reallocation("4\t10\t4\t1\t8\t4\t9\t14\t5\t1\t14\t15\t0\t15\t3\t5"), 12841);
    }
}
