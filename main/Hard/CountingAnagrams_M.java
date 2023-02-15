package Hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountingAnagrams_M {

    public static int CountingAnagrams(String str) {
        String[] split = str.split("\\s");

        List<String> words = new LinkedList<>();

        for (String s : split) {
            if (s.length() > 1) {
                words.add(s);
            }

        }

        return countEquals(words);
    }

    private static int countEquals(List<String> words) {
        int counter = 0;
        List<Map<Character, Integer>> alreadyCounted = new LinkedList<>();
        List<String> alreadyCountedString;

        for (int i = 0; i < words.size(); i++) {
            alreadyCountedString = new LinkedList<>();
            String word1 = words.get(i);
            for (int j = 0; j < words.size(); j++) {
                String word2 = words.get(j);

                if (i != j && !alreadyCounted.contains(wordToMap(word1)) && wordToMap(word1).equals(wordToMap(word2))) {
                    if (!word1.equals(word2) && !alreadyCountedString.contains(word2)) {
                        alreadyCountedString.add(word2);
                    }
                }
            }
            if (alreadyCountedString.size() > 0) {
                String s = alreadyCountedString.get(0);

                if (!alreadyCounted.contains(wordToMap(s))) {
                    alreadyCounted.add(wordToMap(s));
                    counter += alreadyCountedString.size();
                }
            }
        }

        return counter;
    }

    private static Map<Character, Integer> wordToMap(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : chars) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String s = "aa aa odg dog gdo";
        System.out.println(CountingAnagrams(s));

        String s1 = "a c b c run urn urn";
        System.out.println(CountingAnagrams(s1));

        String s2 = "cars are very cool so are arcs and my os";
        System.out.println(CountingAnagrams(s2));
    }
}
