import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CharacterRemoval_M {

    public static int getCharacterRemoval(String[] strArr) {

        String baseWord = strArr[0];
        String[] splitWords = strArr[1].split(",");

        Map<Character, Integer> baseMap = toMapChar(baseWord);

        int maxDiff = Integer.MAX_VALUE;

        List<String> words = new ArrayList<>();

        for (int i = 0; i < splitWords.length; i++) {
            words.add(splitWords[i]);
        }

        for (String s : words) {
            // if dictionary word contains a letter which base word does not have
            if (!wordIsPossible(baseMap, toMapChar(s))) {
                continue;
            }

            int diff = getDiff(baseMap, toMapChar(s));
            if (isRightOrder(baseWord, s) && maxDiff > diff && diff > -1) {
                maxDiff = diff;
            }
        }

        return maxDiff != 2147483647 ? maxDiff : -1;
    }

    private static boolean wordIsPossible(Map<Character, Integer> baseMap, Map<Character, Integer> dictionaryWord) {
        Set<Character> baseLetters = baseMap.keySet();

        for (Character letter : dictionaryWord.keySet()) {
            if (!baseLetters.contains(letter)) {
                return false;
            }
        }

        return true;
    }

    private static int getDiff(Map<Character, Integer> baseMap, Map<Character, Integer> wordMap) {
        int counter = 0;

        for (Character key : baseMap.keySet()) {
            Integer wordValue = wordMap.get(key);
            Integer baseValue = baseMap.get(key);

            if (wordValue == null) {
                counter += baseValue;
                continue;
            }

            int wordDiff = baseValue - wordValue;
            if (wordDiff > 0) {
                counter += wordDiff;
            }
        }
        return counter;
    }

    private static Map<Character, Integer> toMapChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);

            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }

        return map;
    }

    private static boolean isRightOrder(String baseWord, String s) {
        int i = 0;
        int j;
        int jLast = -1;

        for (; i < s.length(); i++) {
            if (jLast == baseWord.length() - 1 && i != s.length() - 1) {
                return false;
            }

            char c = s.charAt(i);
            for (j = jLast + 1; j < baseWord.length(); j++) {
                char c1 = baseWord.charAt(j);
                if (c == c1) {
                    jLast = j;
                    break;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
//        System.out.println(getCharacterRemoval(strings));
//
//        String[] strings1 = {"apbpleeeef", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
//        System.out.println(getCharacterRemoval(strings1));

//        String[] strings2 = {"apbpleeeef", "a,abc,abcg,b,c,dog,e,efd,zzzz"};
//        System.out.println(getCharacterRemoval(strings2));

//        String[] strings3 = {"wordlmae", "a,b,c,d,ap,apple,bar,bat,cat,hello,yellow,why,wo,world,wordlmae"};
//        System.out.println(getCharacterRemoval(strings3));

//        String[] strings5 = {"abbb", "c,d,e,f,g,h,i,j,k,yyyy,zzzzzzzz"};
//        System.out.println(getCharacterRemoval(strings5));

//        String[] strings4 = {"wrdlmaeo", "a,b,c,d,ap,apple,bar,bat,cat,hello,y,yellow,w,wo,world,worr"};
//        System.out.println(getCharacterRemoval(strings4));
    }
}
