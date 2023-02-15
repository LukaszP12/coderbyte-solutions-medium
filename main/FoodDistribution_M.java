import java.util.ArrayList;
import java.util.List;

public class FoodDistribution_M {

    static int minDiff = Integer.MAX_VALUE;

    public static int getFoodDistribution(int[] arr) {
        int numSand = arr[0];

        List<Integer> sandwiches = new ArrayList<>(arr.length - 1);

        for (int i = 1; i < arr.length; i++) {
            sandwiches.add(arr[i]);
        }

        eatSandwiches(sandwiches, numSand, 1);


        return minDiff;
    }

    private static void eatSandwiches(List<Integer> sandwiches, int numSand, int pos) {

        if (pos == sandwiches.size() || numSand == 0) {
            int diff = getDiff(sandwiches);

            if (diff < minDiff) {
                minDiff = diff;
            }

            return;
        }

        int sandwichesCount = sandwiches.get(pos);

        for (int i = 0; i <= Math.min(sandwichesCount, numSand); i++) {
            sandwiches.remove(pos);
            sandwiches.add(pos, sandwichesCount - i);
            eatSandwiches(sandwiches, numSand - i, pos + 1);
            sandwiches.remove(pos);
            sandwiches.add(pos, sandwichesCount);
        }

    }

    private static int getDiff(List<Integer> sandwiches) {

        int count = 0;

        for (int i = 1; i < sandwiches.size(); i++) {
            count += Math.abs(sandwiches.get(i - 1) - sandwiches.get(i));
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ints = {5, 2, 3, 4, 5};
//        System.out.println(getFoodDistribution(ints));

        int[] ints1 = {3, 2, 1, 0, 4, 1, 0};
//        System.out.println(getFoodDistribution(ints1));

        int[] ints2 = {5, 3, 1, 2, 1};
        System.out.println(getFoodDistribution(ints2));

        int[] ints3 = {1, 5, 4, 1};
        System.out.println(getFoodDistribution(ints3));
    }

}
