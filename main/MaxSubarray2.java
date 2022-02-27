package JavaRegex;

public class MaxSubarray2 {

    public static int MaxSubarray2(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];

            if (max < sum) {
                max = sum;
            }

            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static int MaxSubarray3(int[] arr) {
        int maxNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxNumber) {
                    maxNumber = sum;
                }
            }
        }

        return maxNumber;
    }

    public static int MaxSubarray4(int[] arr) {
        int maxSum = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSum = Math.max(maxSum, currMax);
        }

        return maxSum;
    }

    public static int MaxSubarray5(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static int MaxSubarray6(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (arr[i] > maxSum) {
                maxSum = arr[i];
                currentSum = arr[i];
            }
        }
        return maxSum;
    }

    public static int MaxSubarray7(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int prevSum = 0;
            for (int j = i; j < arr.length; j++) {
                int newSum = 0;
                if (i == j) {
                    newSum = arr[j];
                } else {
                    newSum = prevSum + arr[j];
                }
                max = Math.max(max, newSum);
                prevSum = newSum;
            }
        }
        return max;
    }


    public static int MaxSubarray8(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sub = 0;

        for (int i = 0; i < arr.length; i++) {
            sub += arr[i];
            if (sub > maxSum) maxSum = sub;

            if (sub <= 0) sub = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] ints = {1, -2, 0, 3};
        int[] ints1 = {3, -1, -1, 4, 3, -1};

        System.out.println(MaxSubarray2(ints));
        System.out.println(MaxSubarray2(ints1));
    }
}
