import java.util.TreeSet;

public class Consecutive_M {

    public static int getConsecutive(int[] arr) {

        TreeSet<Integer> set = new TreeSet<>();

        for (int a : arr) {
            set.add(a);
        }

        int first = set.first();
        int last = set.last();

        int diff = last - first;

        return diff - (set.size() - 1);
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 15};
        System.out.println(getConsecutive(ints));

        int[] ints1 = {-2, 10, 4};
        System.out.println(getConsecutive(ints1));
    }
}
