import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MinWindowSubstring_M {

    public static String MinWindowSubstring(String[] strArr) {

        Map<Character, Integer> map = wordToMap(strArr[1]);

        Set<String> results = new TreeSet<String>((str1, str2) -> str1.length() - str2.length());

        String word = strArr[0];

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String substring = word.substring(i, j);
                Map<Character, Integer> wordToMap = wordToMap(substring);
                if (mapContainsMap(map, wordToMap)) {
                    results.add(substring);
                }
            }
        }

        if (!results.isEmpty()) {
            return results.stream().findFirst().get();
        }

        return "false";
    }

    private static boolean mapContainsMap(Map<Character, Integer> map, Map<Character, Integer> subStringMap) {

        for (Character key : map.keySet()) {
            Integer subStringMapValue = subStringMap.get(key);
            if (subStringMapValue == null) {
                return false;
            } else {
                Integer mapValue = map.get(key);
                if (mapValue > subStringMapValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<Character, Integer> wordToMap(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.get(s.charAt(i));
            if (integer == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), integer + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};
        System.out.println(MinWindowSubstring(strings));
//
//        String[] strings2 = {"aaabaaddae", "aed"};
//        System.out.println(MinWindowSubstring(strings2));
//
//        String[] strings3 = {"aaffsfsfasfasfasfasfasfacasfafe", "fafe"};
//        System.out.println(MinWindowSubstring(strings3));

//        String[] strings1 = {"aaffhkksemckelloe", "fhea"};
//        System.out.println(MinWindowSubstring(strings1));

//        String[] strings4 = {"caae", "cae"};
//        System.out.println(MinWindowSubstring(strings4));

    }
}
