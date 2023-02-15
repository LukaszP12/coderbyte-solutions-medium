public class MaxSubarray_M {

    public static int getMaxSubarray(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int sum;

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] ints = {1, -2, 0, 3};
        System.out.println(getMaxSubarray(ints));

        int[] ints1 = {3, -1, -1, 4, 3, -1};
        System.out.println(getMaxSubarray(ints1));

        int[] ints2 = {-4, -5, -6};
        System.out.println(getMaxSubarray(ints2));
    }
}
