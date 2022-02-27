package JavaRegex;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingWater {

    public static int TrappingWater(int[] arr) {
        int max = 0;
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                total += max - arr[i];
            }
        }

        return total;
    }

    public static int TrappingWater2(int[] arr) {
        // code goes here
        int maxval = Integer.MIN_VALUE, area = 0, len = arr.length;
        int[] left = new int[len], right = new int[len];

        if (len < 3) return area;

        for (int i = 0; i < len; i++) {
            maxval = Math.max(maxval, arr[i]);
            left[i] = maxval;
        }

        maxval = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 0; i--) {
            maxval = Math.max(maxval, arr[i]);
            right[i] = maxval;
        }

        for (int i = 0; i < len; i++) {
            area += Math.min(left[i], right[i]) - arr[i];
        }

        return area;
    }

    public static int TrappingWater3(int[] arr) {
        int trapped = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int index = 0; index < arr.length; index++) {
            while (!stack.isEmpty() && arr[index] >= arr[stack.peek()]) {
                int b = stack.pollFirst(); // 0 [3]
                if (!stack.isEmpty()) {
                    int leftIndex = stack.peek();  // [2]
                    int leftBound = arr[leftIndex]; // 4 [2]
                    int minHeight = Math.min(leftBound, arr[index]) - arr[b]; // Math.min(4,2) - 0 = 2
                    int width = index - leftIndex - 1; // 4 - 2 - 1 = 1
                    trapped += (minHeight * width); // 2 * 1
                }
            }
            stack.addFirst(index);
        }
        return trapped;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 2};
        System.out.println(TrappingWater(ints));

        int[] ints1 = {0, 2, 4, 0, 2, 1, 2, 6};
        System.out.println(TrappingWater(ints1));

        System.out.println(TrappingWater3(ints1));
    }

}
