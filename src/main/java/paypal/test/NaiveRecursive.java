package paypal.test;

import java.util.ArrayList;
import java.util.List;


public class NaiveRecursive implements QuadrupletFinder {

    private List<Quadruplet> result;
    private void findMatchingQuadruplets(int[] inputArray, int firstIndex, int numIndex, int targetSum) {

        if (numIndex == 4) {

            numtest++;
            Quadruplet quadruplet = new Quadruplet(indices[0], indices[1], indices[2], indices[3], false);
            if (inputArray[indices[0]] + inputArray[indices[1]] + inputArray[indices[2]] + inputArray[indices[3]] == targetSum) {
                quadruplet.match = true;
            }

            result.add(quadruplet);

        } else {

            for(int i = firstIndex; i < inputArray.length - (3-numIndex); i++) {

                indices[numIndex] = i;
                findMatchingQuadruplets(inputArray, i+1, numIndex+1, targetSum);
            }
        }
    }


    int[] indices = new int[4];
    int numtest = 0;
    public List<Quadruplet> findQuadruplets(int[] inputArray, int targetSum) {

        numtest = 0;
        result = new ArrayList<Quadruplet>();
        findMatchingQuadruplets(inputArray, 0, 0, targetSum);
        return result;
    }
}
