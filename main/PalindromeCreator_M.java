package JavaRegex;

import java.util.ArrayList;
import java.util.Collections;

public class PalindromeCreator_M {

    public static String PalindromeCreator(String str) {

        ArrayList<String> solutions = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            StringBuilder stringBuilder1 = new StringBuilder().deleteCharAt(i);
            if (isPalindrome(stringBuilder1.toString())) {
                solutions.add("" + c1);
                if (stringBuilder1.length() <= 3) continue;
            }
            for (int j = i; j < stringBuilder1.length(); j++) {
                char c2 = stringBuilder1.charAt(j);
                StringBuilder stringBuilder2 = new StringBuilder(stringBuilder1.toString()).deleteCharAt(j);
                if (isPalindrome(stringBuilder2.toString())) solutions.add("" + c1 + c2);
            }
        }
        if (!solutions.isEmpty()) {
            Collections.sort(solutions, (s1, s2) -> new Integer(s1.length()).compareTo(s2.length()));
            return solutions.get(0);
        }

        return "not possible";
    }

    private static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] != chars[str.length() - 1 - i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String result = PalindromeCreator("mmop");
    }
}
