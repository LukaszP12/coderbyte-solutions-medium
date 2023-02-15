public class PalindromeCreator_M2 {

    public static String createPalidrome(String str) {

        if (str.length() < 3) {
            return "not possible";
        }

        if (isPalidrome(str)) {
            return "palindrome";
        }

        // we start with removing a single character, as
        // we want to get the longest possible palindromic substring
        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            if (newStr.length() >= 3 && isPalidrome(newStr)) {
                return "" + str.charAt(i);
            }
        }

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            if (newStr.length() >= 3 && isPalidrome(newStr)) {
                return "" + str.charAt(i);
            }

            for (int j = 0; j < newStr.length(); j++) {
                String newStr2 = newStr.substring(0, j) + newStr.substring(j + 1);
                if (newStr2.length() >= 3 && isPalidrome(newStr2)) {
                    result += str.charAt(i) + "" + newStr.charAt(j);
                    return result;
                }
            }
        }

        return "not possible";
    }

    private static boolean isPalidrome(String newStr) {
        int length = newStr.length();

        for (int i = 0; i <= length / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "mmop";
        System.out.println(createPalidrome(str1));

        String str2 = "kjjjhjjj";
        System.out.println(createPalidrome(str2));

        String str3 = "abjchba";
        System.out.println(createPalidrome(str3));

        String str4 = "aaabaaaj";
        System.out.println(createPalidrome(str4));

        String str5 = "annak";
        System.out.println(createPalidrome(str5));
    }
}
