package paypal.challenge;

import java.util.ArrayList;
import java.util.List;


public class NaiveUnrolled implements QuadrupletFinder {

    private List<Quadruplet> result;
    public List<Quadruplet> findQuadruplets(int[] inputArray, int targetSum) {

        int arrayLength = inputArray.length;

        result = new ArrayList<Quadruplet>();

        if (arrayLength >= 4) {

            int firstIndex, secondIndex, thirdIndex, fourthIndex;

            for(firstIndex = 0; firstIndex < arrayLength - 3; firstIndex++)
            {
                for(secondIndex = firstIndex + 1; secondIndex < arrayLength - 2; secondIndex++)
                {
                    for(thirdIndex = secondIndex + 1; thirdIndex < arrayLength - 1; thirdIndex++)
                    {
                        for(fourthIndex = thirdIndex + 1; fourthIndex < arrayLength; fourthIndex++)
                        {
                            Quadruplet quadruplet = new Quadruplet(firstIndex, secondIndex, thirdIndex, fourthIndex, false);

                            if (inputArray[firstIndex] + inputArray[secondIndex] + inputArray[thirdIndex] + inputArray[fourthIndex] == targetSum) {

                                quadruplet.match = true;
                            }

                            result.add(quadruplet);
                        }
                    }
                }
            }
        }

        return result;
    }
}
