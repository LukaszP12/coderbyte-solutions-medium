import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NearestSmallerValues_M {


    public static String getNearestSmallerValues(int[] arr) {
        List<Integer> results = new LinkedList<>();
        results.add(-1);

        for (int i = 1; i < arr.length; i++) {
            List<Integer> previous = new LinkedList<>();
            previous.add(-1);
            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] <= arr[i]) {
                    previous.add(arr[j]);
                }
            }
            if (previous.size() == 1) {
                results.add(previous.get(0));
            } else {
                results.add(previous.get(1));
            }
        }

        return results.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 1, 9, 7, 3, 4, 1};
        System.out.println(getNearestSmallerValues(ints));

        int[] ints1 = {2, 4, 5, 1, 7};
        System.out.println(getNearestSmallerValues(ints1));
    }
}
