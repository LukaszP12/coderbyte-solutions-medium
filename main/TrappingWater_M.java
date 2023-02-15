public class TrappingWater_M {

    public static int getTrappingWater(int[] arr) {

        int sum = 0;

        int[] leftSide = new int[arr.length];
        int maxLeft = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxLeft) {
                maxLeft = arr[i];
            }
            leftSide[i] = maxLeft;
        }

        int[] rightSide = new int[arr.length];
        int maxRight = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
            }
            rightSide[i] = maxRight;
        }

        for (int i = 0; i < arr.length; i++) {
            int height = Math.min(leftSide[i], rightSide[i]);
            int diff = height - arr[i];
            sum += diff;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 2};
        System.out.println(getTrappingWater(ints));

        int[] ints1 = {0, 2, 4, 0, 2, 1, 2, 6};
        System.out.println(getTrappingWater(ints1));
    }

}
