package JavaRegex;

import java.util.Arrays;

public class NearestSmallerValues4 {

    public static String NearestSmallerValues(int[] arr) {

        int[] results = new int[arr.length];
        Arrays.fill(results, -1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j]) {
                    results[i] = arr[j];
                    break;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < results.length; i++) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(results[i]);
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
