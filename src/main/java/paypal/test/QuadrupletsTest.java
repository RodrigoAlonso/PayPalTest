package paypal.test;

import java.io.PrintStream;
import java.util.List;

public class QuadrupletsTest {

    static PrintStream ps = System.out;

    static void printResult(List<Quadruplet> result) {

        for (int i = 0; i < result.size(); i++) {

            Quadruplet quadruplet = result.get(i);
            ps.printf("% 10d - % 2d % 2d % 2d % 2d ", i+1, quadruplet.i, quadruplet.j, quadruplet.j, quadruplet.l);
            if (quadruplet.match) {
                ps.println(" MATCH");
            } else {
                ps.println();
            }
        }
    }

    public static void main(String args[])
    {

        int inputArray[] = { 4, 2, 1, 7, 3, 1, 2, 4 };
        int sumTotal = 11;

        List<Quadruplet> result;

        ps.println("1st ----------------------------");
        printResult(new NaiveRecursive().findQuadruplets(inputArray, sumTotal));
        ps.println("2nd ----------------------------");
        printResult(new NaiveUnrolled().findQuadruplets(inputArray, sumTotal));
    }
}
