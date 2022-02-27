package JavaRegex;

import java.util.Arrays;

public class NearestSmallerValues2 {

    public static String NearestSmallerValues(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        int[] ints1 = {2, 4, 5, 1, 7};

        System.out.println(NearestSmallerValues(ints));
        System.out.println(NearestSmallerValues(ints1));
    }

}
