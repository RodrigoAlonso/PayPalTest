package paypal.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import java.util.List;

import org.junit.Test;

public class PayPalTest {

    static PrintStream ps = System.out;

    @Test
    public void testEmptyResult() {

        int inputArray[] = { 4, 2, 1 };
        List<Quadruplet> result = new NaiveRecursive().findQuadruplets(inputArray, 1);

        assertEquals(result.size(), 0);
    }


    static void printResult(List<Quadruplet> result, boolean justMatches) {

        for (int i = 0; i < result.size(); i++) {

            Quadruplet quadruplet = result.get(i);
            if (!justMatches || justMatches && quadruplet.match)
                ps.printf("% 10d - % 2d % 2d % 2d % 2d ", i+1, quadruplet.i, quadruplet.j, quadruplet.k, quadruplet.l);
            if (quadruplet.match) {
                ps.println(" MATCH");
            } else
            if (!justMatches) {
                ps.println();
            }
        }
    }

    static long countMatches(List<Quadruplet> result) {

        return result.stream().filter(q->q.match==true).count();
    }


    @Test
    public void testMatches() {

        int inputArray[] = { 4, 2, 1, 7, 3, 1, 2, 4 };

        List<Quadruplet> result = new NaiveRecursive().findQuadruplets(inputArray, 11);

        ps.printf("Quadruplets matching: %d\n", countMatches(result));
        printResult(result, false);
        assertEquals(countMatches(result), 8);
    }



    @Test
    public void testBigInput() {

        int inputArray[] = { 4, 2, 1, 7, 3, 1, 2, 4, 8, 2, 1, 7, 8, 2, 1, 10, 2, 4, 7, 8, 9, 1, 4, 2, 5, 3, 9, 8, 2, 1, 5 };

        List<Quadruplet> result = new NaiveRecursive().findQuadruplets(inputArray, 11);

        ps.printf("Quadruplets matching: %d\n", countMatches(result));
        assertEquals(countMatches(result), 1197);
    }
}
