package JavaRegex;

import java.util.Arrays;

public class ArithGeoII {

    public static String ArithGeoII(int[] arr) {
        if (isArith(arr)) {
            return "Arithmetic";
        }

        if (isGeo(arr)) {
            return "Geometric";
        }

        return "-1";
    }

    private static boolean isArith(int[] arr) {
        int diff = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - diff != arr[i - 1]) {
                return false;
            }

        }

        return true;
    }

    private static boolean isGeo(int[] arr) {
        int diff = arr[1] / arr[0];

        int begin = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] / diff != arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 15};
        int[] ints1 = {2, 4, 16, 24};

        System.out.println(ArithGeoII(ints));
        System.out.println(ArithGeoII(ints1));
    }
}
