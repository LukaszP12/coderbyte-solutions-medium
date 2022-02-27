package JavaRegex;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class NearestSmallerValues6 {

    private static String NearestSmallerValues(int[] arr) {
        List<Integer> li = new ArrayList<>();
        li.add(-1);

        for (int i = 1; i < arr.length; ++i) {

            int lst = -1;
            for (int j = 0; j < i; ++j) {
                if (arr[j] <= arr[i]) {
                    lst = arr[j];
                }
            }
            li.add(lst);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < li.size(); i++) {
            result.append(li.get(i) + " ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        int[] ints1 = {2, 4, 5, 1, 7};

        System.out.println(NearestSmallerValues(ints));

//        Assert.assertEquals(NearestSmallerValues4.NearestSmallerValues(ints), NearestSmallerValues(ints));
//        Assert.assertEquals(NearestSmallerValues4.NearestSmallerValues(ints), NearestSmallerValues(ints1));
    }

}
