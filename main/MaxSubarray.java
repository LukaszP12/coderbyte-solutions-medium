package JavaRegex;

public class MaxSubarray {

    public static int MaxSubarray(int[] arr) {
        // Brute Force Implementation
        // 1. Find all subarrays
        // 2. Get sum of subarray
        // 3. Find max sum
        int max = arr[0];
        int maxVal = arr[0];
        int[] sum = new int[arr.length];
        sum[0] = arr[0] < 0 ? 0 : arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum[i - 1] + arr[i] < 0) {
                sum[i] = 0;
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
            max = Math.max(max, sum[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }

        return maxVal < 0 ? maxVal : max;
    }

    public static void main(String[] args) {
        int[] ints = {1, -2, 0, 3};
        int[] ints1 = {3, -1, -1, 4, 3, -1};

        System.out.println(MaxSubarray(ints));
        System.out.println(MaxSubarray(ints1));
    }
}
