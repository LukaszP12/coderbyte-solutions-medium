public class PalindromicSubstring_M {


    public static String getPalindromicSubstring(String str) {
        int longestStringlength = 0;
        String longestString = "none";

        for (int i = 0; i <= str.length(); i++) {

            for (int j = i; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (!substring.isEmpty() && substring.length() > 2 && isPalidrome(substring)) {
                    if (substring.length() > longestStringlength) {
                        longestStringlength = substring.length();
                        longestString = substring;
                    }
                }
            }

        }

        return longestString;
    }

    private static boolean isPalidrome(String substring) {

        for (int i = 0; i <= substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "hellosannasmith";
        System.out.println(getPalindromicSubstring(s1));

        String s2 = "abcdefgg";
        System.out.println(getPalindromicSubstring(s2));
    }
}
