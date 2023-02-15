import java.util.Arrays;

public class FoodDistribution_M2 {

    static int minDiff = Integer.MAX_VALUE;

    public static int getFoodDistribution(int[] arr) {
        int numSandwiches = arr[0];

        int[] sandwiches = Arrays.copyOfRange(arr, 1, arr.length);

        if (getDiff(sandwiches) < minDiff) {
            minDiff = getDiff(sandwiches);
        }

        eatSandwiches(numSandwiches, sandwiches, 0);

        return minDiff;
    }

    private static void eatSandwiches(int numSandwiches, int[] sandwiches, int i) {

        if (numSandwiches == 0 || getDiff(sandwiches) == 0) {
            int diff = getDiff(sandwiches);
            if (diff < minDiff) {
                minDiff = diff;
            }

            return;
        }

        for (; i < sandwiches.length; i++) {
            int avlSandwiches = Math.min(sandwiches[i], numSandwiches);
            for (int j = 1; j <= avlSandwiches; j++) {
                int[] newSandwiches = Arrays.copyOfRange(sandwiches, 0, sandwiches.length);
                newSandwiches[i] = sandwiches[i] - j;

                if (numSandwiches - j > -1) {
                    eatSandwiches(numSandwiches - j, newSandwiches, i);
                }
            }

        }


        return;
    }

    private static int getDiff(int[] sandwiches) {
        int diff = 0;

        for (int i = 1; i < sandwiches.length; i++) {
            diff += Math.abs(sandwiches[i - 1] - sandwiches[i]);
        }

        return diff;
    }

    public static void main(String[] args) {
//        int[] ints = {5, 2, 3, 4, 5};
//        System.out.println(getFoodDistribution(ints));

//        int[] ints1 = {3, 2, 1, 0, 4, 1, 0};
//        System.out.println(getFoodDistribution(ints1));

        // wrongs cases
        int[] ints2 = {5, 3, 1, 2, 1};
        System.out.println(getFoodDistribution(ints2));

    }
}
