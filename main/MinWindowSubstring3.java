package JavaRegex;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring3 {

    public static String MinWindowSubstring(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];

        // a map for all characters in K
        Map<Character, Integer> kMap = new HashMap<>();
        for (Character c : K.toCharArray()) {
            kMap.put(c, kMap.containsKey(c) ? kMap.get(c) + 1 : 1);
        }

        String shortestMatch = N + "";
        // iterate over all substrings of N
        for (int i = 0; i < N.length(); i++) {
            subStringLoop:
            for (int j = i; j < N.length(); j++) {
                String substring = N.substring(i, j + 1);
                // create a map for all characters in substring
                Map<Character, Integer> subMap = new HashMap<>();
                for (Character c : substring.toCharArray()) {
                    subMap.put(c, subMap.containsKey(c) ? subMap.get(c) + 1 : 1);
                }
                // Now verify that all characters in K occur in substring
                for (Map.Entry<Character, Integer> entry : kMap.entrySet()) {
                    if (!subMap.containsKey(entry.getKey()) || entry.getValue() > subMap.get(entry.getKey())) {
                        continue subStringLoop; // not a valid match
                    }
                }
                if (shortestMatch.length() > substring.length()) {
                    shortestMatch = substring;
                }
            }
        }

        return shortestMatch;
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

        System.out.println(MinWindowSubstring(strings));
    }

}
