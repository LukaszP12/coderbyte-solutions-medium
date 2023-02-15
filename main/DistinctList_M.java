import java.util.HashSet;
import java.util.Set;

public class DistinctList_M {

    public static int getDistinctList(int[] arr) {
        Set<Integer> numbers = new HashSet<>();
        int counter = 0;

        for (int i : arr) {
            if (!numbers.contains(i)) {
                numbers.add(i);
            } else {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] ints = {0, -2, -2, 5, 5, 5};
        System.out.println(getDistinctList(ints));

        int[] ints1 = {100, 2, 101, 4};
        System.out.println(getDistinctList(ints1));
    }
}
