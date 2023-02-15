import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutive_M {

    public static int getLongestConsecutive(int[] arr) {

        Set<Integer> integers = new TreeSet<>();

        int longest = 0;

        for (int i = 0; i < arr.length; i++) {
            integers.add(arr[i]);
        }

        Iterator<Integer> iterator = integers.iterator();
        List<Integer> list = new LinkedList<>();

        while (iterator.hasNext()) {
            int next = iterator.next();
            list.add(next);
        }

        int count = 1;

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff == 1) {
                count++;
            } else {
                if (count > longest) {
                    longest = count;
                }
                count = 1;
            }

        }

        if (count > longest) {
            longest = count;
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] ints = {6, 7, 3, 1, 100, 102, 6, 12};
        System.out.println(getLongestConsecutive(ints));

        int[] ints1 = {5, 6, 1, 2, 8, 9, 7};
        System.out.println(getLongestConsecutive(ints1));
    }
}
