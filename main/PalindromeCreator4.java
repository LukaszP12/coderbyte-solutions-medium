package JavaRegex;

public class PalindromeCreator4 {

    public static boolean isPalindrome(String input) {
        boolean isPalindrome = input.length() > 0;
        int midPoint = input.length() / 2;
        for (int i = 0; i < midPoint; i++) {
            if (!(input.charAt(i) == input.charAt(input.length() - 1 - i))) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    public static String PalindromeCreator(String str) {

        String twoBest = "";
        if (str.length() > 3) {
            if (isPalindrome(str)) {
                return "palindrome";
            } else {
                for (int i = 0; i < str.length(); i++) {
                    StringBuffer oneRemovedBuff = new StringBuffer(str);
                    oneRemovedBuff.deleteCharAt(i);
                    String oneRemoved = oneRemovedBuff.toString();
                    if (isPalindrome(oneRemoved)) {
                        return str.charAt(i) + "";
                    } else if ((str.length() > 4) && twoBest.length() == 0) {
                        for (int j = 0; j < oneRemoved.length(); j++) {
                            StringBuffer twoRemovedBuff = new StringBuffer(oneRemoved);
                            twoRemovedBuff.deleteCharAt(j);
                            String twoRemoved = twoRemovedBuff.toString();
                            if (isPalindrome(twoRemoved) && twoBest.length() == 0) {
                                twoBest = str.charAt(i) + "" + oneRemoved.charAt(j);
                            }
                        }
                    }
                }
            }
        }

        return twoBest.length() > 0 ? twoBest : "not possible";
    }

    public static void main(String[] args) {
        System.out.println(PalindromeCreator("mmop"));
        System.out.println(PalindromeCreator("kjjjhjjj"));
    }
}
