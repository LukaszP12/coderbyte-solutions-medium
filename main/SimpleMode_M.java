import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SimpleMode_M {

    public static int SimpleMode(int[] arr) {

        Map<Integer, Integer> freqMap = getFreqMap(arr);

        int maxFreq = 0;
        int maxFreqValue = 0;

        for (int a : arr) {
            int value = freqMap.get(a);
            if (value > 1 && maxFreq < value) {
                maxFreq = value;
                maxFreqValue = a;
            }
        }

        return maxFreq != 0 ? maxFreqValue : -1;
    }

    private static Map<Integer, Integer> getFreqMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            Integer value = map.get(key);

            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }

        }

        return map;
    }

    public static void main(String[] args) {
        int[] ints = {5, 5, 2, 2, 1};
        System.out.println(SimpleMode(ints));

        int[] ints1 = {3, 4, 1, 6, 10};
        System.out.println(SimpleMode(ints1));

        int[] ints2 = {0, 0, 0, 1, 2};
        System.out.println(SimpleMode(ints2));
    }
}
