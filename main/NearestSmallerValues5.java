package JavaRegex;

import java.util.Arrays;

public class NearestSmallerValues5 {

    private static String NearestSmallerValues(int[] arr) {
        if (arr.length == 0) return "";

        StringBuilder retStr = new StringBuilder();
        retStr.append("-1" + (arr.length > 1 ? " " : ""));

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int[] subArray = Arrays.copyOfRange(arr, 0, i);
            for (int j = i - 1; j >= 0; j--) {
                if (subArray[j] <= subArray[i]) {
                    retStr.append(subArray[j] + (i < arr.length - 1 ? " " : ""));
                    break;
                } else if (j == 0) {
                    retStr.append("-1" + (i < arr.length - 1 ? " " : ""));
                    break;
                }
            }
        }

        return retStr.toString();
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        int[] ints1 = {2, 4, 5, 1, 7};

        System.out.println(NearestSmallerValues(ints));
        System.out.println(NearestSmallerValues(ints1));
    }

}
