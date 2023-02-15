import java.util.HashMap;

public class LetterCount {

    public static String getLetterCount(String str) {
        String[] split = str.split("\\s");

        int max_repeated = 0;
        String max_repeated_string = "";

        for (String s : split) {
            HashMap<Character, Integer> words = wordToMap(s);

            int counter = 0;

            for (Character key : words.keySet()) {
                if (words.get(key) != 1) {
                    counter++;
                }
            }

            if (counter > max_repeated) {
                max_repeated = counter;
                max_repeated_string = s;
            }

        }

        return !max_repeated_string.isEmpty() ? max_repeated_string : "-1";
    }

    private static HashMap<Character, Integer> wordToMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = map.get(c);
            if (value == null) {
                map.put(c, 1);
            } else {
                map.put(c, value + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String s = "Hello apple pie";
        System.out.println(getLetterCount(s));

        String s1 = "No words";
        System.out.println(getLetterCount(s1));
    }
}
