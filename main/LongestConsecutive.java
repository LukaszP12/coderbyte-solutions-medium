package JavaRegex;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static int LongestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    private static int LongestConsecutive2(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int result = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == (arr[i] + 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count > result) {
                result = count;
            }
        }

        return result;
    }

    private static int LongestConsecutive3(int[] arr) {
        int counter = 1;
        int maxVal = 1;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                counter++;
                maxVal = Math.max(maxVal, counter);
            } else if (arr[i] != arr[i + 1]) {
                counter = 1;
            }
        }

        return maxVal;
    }

    private static int LongestConsecutive4(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int maxCount = 1;
        int i = 1;

        while (i < arr.length) {
            while (i < arr.length && ((arr[i - 1] + 1) == arr[i] || arr[i] == arr[i - 1])) {
                if (arr[i] == arr[i - 1]) {

                } else {
                    count++;
                }
                i++;
            }

            if (maxCount < count) {
                maxCount = count;
                count = 1;
            }
            i++;
        }

        return maxCount;
    }

    private static int LongestConsecutive5(int[] arr) {
        Arrays.sort(arr);
        int maxLen = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i - 1] == arr[i]) {
                continue;
            }
            if (arr[i - 1] + 1 == arr[i]) {
                curr++;
            } else {
                maxLen = Math.max(curr, maxLen);
                curr = 1;
            }
        }
        return Math.max(curr, maxLen);
    }

    public static int LongestConsecutive6(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : nums) {
            int curr = 1;
            int left = i - 1;
            int right = i + 1;
            while (set.contains(left)) {
                curr++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                curr++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] ints = {6, 7, 3, 1, 100, 102, 6, 12};
        int result = LongestConsecutive(ints);
        System.out.println(result);

        int[] ints1 = {5, 6, 1, 2, 8, 9, 7};
        int result1 = LongestConsecutive(ints1);
        System.out.println(result1);

        int result2 = LongestConsecutive2(ints);
        System.out.println(result2);
        int result3 = LongestConsecutive2(ints1);
        System.out.println(result3);

        Assert.assertEquals(LongestConsecutive3(ints), LongestConsecutive4(ints));
        Assert.assertEquals(LongestConsecutive3(ints1), LongestConsecutive4(ints1));

        System.out.println(LongestConsecutive5(ints));
        System.out.println(LongestConsecutive5(ints1));

        System.out.println(LongestConsecutive6(ints));
        System.out.println(LongestConsecutive6(ints1));

    }

}
