public class PalindromicSubstring {

    public static String getPalindromicSubstring(String str) {

        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(i);
            if (isPalidrome(substring)) {
                return substring;
            }

            for (int j = substring.length() - 1; j >= 0; j--) {
                String substring2 = substring.substring(0, j);
                if (isPalidrome(substring2)) {
                    return substring2;
                }
            }

        }

        return "none";
    }

    private static boolean isPalidrome(String newStr) {
        int length = newStr.length();

        if (length < 3) {
            return false;
        }

        for (int i = 0; i <= length / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPalindromicSubstring("hellosannasmith"));
        System.out.println(getPalindromicSubstring("abcdefgg"));
    }

}
