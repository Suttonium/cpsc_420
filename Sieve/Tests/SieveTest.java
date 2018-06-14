import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SieveTest {



    @Test
    public void testRat1() {
        ArrayList<Integer> param =
                new ArrayList<Integer>
                        (Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        assertEquals(param, Sieve.sieve(20));


    }

    @Test
    public void testRat2() {
        ArrayList<Integer> param =
                new ArrayList<Integer>
                        (Arrays.asList());
        assertEquals(param, Sieve.sieve(0));


    }

    @Test
    public void testRat3() {
        ArrayList<Integer> param =
                new ArrayList<Integer>
                        (Arrays.asList());
        assertEquals(param, Sieve.sieve(1));


    }

    @Test
    public void testRat4() {
        ArrayList<Integer> param =
                new ArrayList<Integer>
                        (Arrays.asList(2, 3, 5));
        assertEquals(param, Sieve.sieve(5));


    }

    @Test
    public void testRat5() {
        ArrayList<Integer> param =
                new ArrayList<Integer>
                        (Arrays.asList());
        assertEquals(param, Sieve.sieve(1));


    }

}