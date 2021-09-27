package paypal.challenge;

import java.io.PrintStream;
import java.util.List;

public class QuadrupletsChallenge {

    static PrintStream ps = System.out;

    static void printResult(List<Quadruplet> result) {

        for (int i = 0; i < result.size(); i++) {

            Quadruplet quadruplet = result.get(i);
            ps.printf("% 10d - % 2d % 2d % 2d % 2d ", i+1, quadruplet.i, quadruplet.j, quadruplet.k, quadruplet.l);
            if (quadruplet.match) {
                ps.println(" MATCH");
            } else {
                ps.println();
            }
        }
    }

    static long countMatches(List<Quadruplet> result) {

        return result.stream().filter(q->q.match==true).count();
    }

    public static void main(String args[])
    {

        int inputArray[] = { 4, 2, 1, 7, 3, 1, 2, 4 };
        int sumTotal = 11;

        List<Quadruplet> result;

        result = new NaiveRecursive().findQuadruplets(inputArray, sumTotal);
        ps.printf("1st ---------------------------- %d\n", countMatches(result));
        printResult(result);
        ps.printf("2nd ---------------------------- %d\n", countMatches(result));
        printResult(new NaiveUnrolled().findQuadruplets(inputArray, sumTotal));
    }
}
