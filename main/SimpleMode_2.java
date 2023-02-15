import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleMode_2 {

    public static int SimpleMode(int[] arr) {
        int largest = 0;
        int bigInt = 0;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer key = arr[i];
            Integer value = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, value);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > largest) {
                largest = entry.getValue();
                bigInt = entry.getKey();
            }
        }
        if (largest == 1) {
            return -1;
        } else {
            return bigInt;
        }
    }

    public static int SimpleMode2(int[] arr) {
        int maxOccurrences = 0;
        int currMax = -1;
        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i];
            int numOccurrences = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == currNum) {
                    numOccurrences += 1;
                }
                if (numOccurrences > maxOccurrences && numOccurrences >= 2) {
                    maxOccurrences = numOccurrences;
                    currMax = currNum;
                }
            }
        }

        return currMax;
    }


    public static int SimpleMode3(int[] arr) {
        Map<Integer, Integer> m = getCharFreq(arr);
        int max = arr[0];
        int c = m.get(arr[0]);
        for (Integer n : arr) {
            if (m.get(n) > c) {
                max = n;
                c = m.get(n);
            }
        }

        return c > 1 ? max : -1;
    }

    public static Map<Integer, Integer> getCharFreq(int[] s) {
        Map<Integer, Integer> charFreq = new HashMap<>();
        if (s != null) {
            for (int c : s) {
                Integer count = charFreq.get(c);
                int newCount = (count == null ? 1 : count + 1);
                charFreq.put(c, newCount);
            }
        }

        return charFreq;
    }

    public static Map.Entry<Integer, Integer> getMax(Map<Integer, Integer> map) {
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }

    public static int SimpleMode4(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 1;
        int valueFinal = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            } else {
                int value = hm.get(arr[i]) + 1;
                if (value > max) {
                    valueFinal = arr[i];
                    max = value;
                }
                hm.put(arr[i], value);
            }
        }

        return valueFinal;
    }

    public static void main(String[] args) {
        int[] ints = {5, 5, 2, 2, 1};
        System.out.println(SimpleMode(ints));
        System.out.println(SimpleMode2(ints));
        System.out.println(SimpleMode4(ints));

        int[] ints1 = {3, 4, 1, 6, 10};
        System.out.println(SimpleMode(ints1));
        System.out.println(SimpleMode2(ints1));
        System.out.println(SimpleMode4(ints1));
    }
}
