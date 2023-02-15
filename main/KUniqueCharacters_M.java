import java.util.HashSet;
import java.util.Set;

public class KUniqueCharacters_M {

    public static String getKUniqueCharacters(String str) {
        int digit = str.charAt(0) - 48;

        String substring = str.substring(1);

        String longestString = "";
        int maxCount = 0;

        for (int i = 0; i <= substring.length(); i++) {
            for (int j = i; j <= substring.length(); j++) {
                String sub = substring.substring(i, j);
                int uniqueChars = getUniqueChars(sub);
                if (uniqueChars == digit && sub.length() > maxCount) {
                    maxCount = sub.length();
                    longestString = sub;
                }
            }
        }


        return longestString;
    }

    private static int getUniqueChars(String sub) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sub.length(); i++) {
            set.add(sub.charAt(i));
        }

        return set.size();
    }

    public static void main(String[] args) {
        String s1 = "2aabbcbbbadef";
        System.out.println(getKUniqueCharacters(s1));

        // wrong cases
        String s = "3aabacbebebe";
        System.out.println(getKUniqueCharacters(s));

        String s2 = "3aabbaacceeeeeaa";
        System.out.println(getKUniqueCharacters(s2));
    }
}
