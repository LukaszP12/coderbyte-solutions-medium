import java.util.HashSet;
import java.util.Set;

public class MatchingCharacters_M {

    public static int getMatchingCharacters(String str) {

        int maxCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            for (int j = i + 1; j < str.length(); j++) {
                char c1 = str.charAt(j);

                if (c == c1 && i + 1 != j) {
                    String substring = str.substring(i+1, j);
                    int counts = countUnique(substring);
                    if (counts > maxCount) {
                        maxCount = counts;
                    }
                }

            }

        }

        return maxCount;
    }

    private static int countUnique(String substring) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < substring.length(); i++) {
            set.add("" + substring.charAt(i));
        }

        return set.size();
    }

    public static void main(String[] args) {
        String s = "mmmerme";
        System.out.println(getMatchingCharacters(s));

        String s1 = "abccdefghi";
        System.out.println(getMatchingCharacters(s1));

        // wrong cases
        String s2 = "ahyjakh";
        System.out.println(getMatchingCharacters(s2));
    }
}
