import java.util.HashMap;
import java.util.Map;

public class StringScramble_M {

    public static boolean getStringScramble(String str1, String str2) {

        Map<Character, Integer> words = wordToMap(str1);
        Map<Character, Integer> base = wordToMap(str2);

        if (words.equals(base)) {
            return true;
        }

        return wordsContain(words, base);
    }

    private static boolean wordsContain(Map<Character, Integer> words, Map<Character, Integer> base) {

        for (Character key : base.keySet()) {

            Integer wordsValue = words.get(key);
            if (wordsValue == null) {
                return false;
            } else {
                Integer baseValue = base.get(key);
                if (wordsValue < baseValue) {
                    return false;
                }
            }

        }

        return true;
    }

    private static Map<Character, Integer> wordToMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            Integer value = map.get(c);
            if (value == null) {
                map.put(c, 1);
            } else {
                map.put(c, 1 + value);
            }

        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println(getStringScramble("cdore", "coder"));
        System.out.println(getStringScramble("h3llko", "hello"));
    }
}
