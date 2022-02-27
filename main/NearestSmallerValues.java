package JavaRegex;

import java.util.ArrayList;
import java.util.List;

public class NearestSmallerValues {

    public static String NearestSmallerValues(int[] arr) {
        List<String> output = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            for (int b = i - 1; b >= -1; b--) {
                if (b == -1) {
                    output.add("" + -1);
                    break;
                }

                int currNum = arr[i];
                int prevNum = arr[b];

                if (prevNum <= currNum) {
                    output.add("" + prevNum);
                    break;
                }
            }
        }

        return String.join(" ", output);
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        int[] ints1 = {2, 4, 5, 1, 7};

        System.out.println(NearestSmallerValues(ints));
        System.out.println(NearestSmallerValues(ints1));
    }

}
