import java.util.*;
import java.util.stream.Collectors;

public class SimpleMode {

    public static int getSimpleMode(int[] arr) {
        Arrays.sort(arr);

        List<Integer> list = new LinkedList<>();

        for (int a : arr) {
            list.add(a);
        }

        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        System.out.println(collect);

        return 0;
    }

    public static void main(String[] args) {
        int[] ints = {5, 5, 2, 2, 1};
        getSimpleMode(ints);

        int[] ints1 = {3, 4, 1, 6, 10};

    }
}
