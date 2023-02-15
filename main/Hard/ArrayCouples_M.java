package Hard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayCouples_M {

    public static String ArrayCouples(int[] arr) {
        List<String> pairs = getPairs(arr);

        List<String> nonDuplicates = removeDuplicates(pairs);

        if (!nonDuplicates.isEmpty()) {
            return nonDuplicates.stream().collect(Collectors.joining(","));
        }

        return "yes";
    }

    private static List<String> removeDuplicates(List<String> pairs) {
        int counts = pairs.size();
        int i = 0;
        List<String> nonDuplicates = new LinkedList<>();

        while (pairs.size() > 0 && pairs.iterator().hasNext()) {
            Iterator<String> iterator = pairs.iterator();

            String s = iterator.next();
            String reversedS = new StringBuilder(s).reverse().toString();

            String[] split = s.split(",");

            if (!split[0].equals(split[1]) && pairs.contains(s) && pairs.contains(reversedS)) {
                pairs.remove(s);
                pairs.remove(reversedS);
            } else {
                nonDuplicates.add(s);
                pairs.remove(s);
            }
            i++;
            if (i == counts) {
                break;
            }

        }

        return nonDuplicates;
    }

    private static List<String> getPairs(int[] arr) {
        List<String> list = new LinkedList<>();

        for (int i = 1; i < arr.length; i = i + 2) {
            String s = arr[i - 1] + "," + arr[i];
            list.add(s);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] ints = {2, 1, 1, 2, 3, 3};
        System.out.println(ArrayCouples(ints));

        int[] ints1 = {5, 4, 6, 7, 7, 6, 4, 5};
        System.out.println(ArrayCouples(ints1));

        int[] ints2 = {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 10};
        System.out.println(ArrayCouples(ints2));
    }
}
