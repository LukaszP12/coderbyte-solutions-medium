
public class PalindromeTwo_M {

    public static Boolean getPalindromeTwo(String str) {
        String s = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        return isPalindrome(s);
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i <= length / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "Noel - sees Leon";
        System.out.println(getPalindromeTwo(s));

        String s1 = "A war at Tarawa!";
        System.out.println(getPalindromeTwo(s1));
    }
}
