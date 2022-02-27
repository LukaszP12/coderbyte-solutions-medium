package JavaRegex;

public class PalindromeCreator2 {

    public static String PalindromeCreator(String str) {
        String newStr = "";

        String[] strArr = str.split("");
        String[] words = new String[strArr.length];

        String leftStr = "";

        if (str.equals(new StringBuffer(str).reverse().toString())) {
            return "palindrome";
        }

        for (int i = 0; i < strArr.length; i++) {
            newStr = "";
            leftStr = "";
            for (int j = 0; j < strArr.length; j++) {
                if (i != j) {
                    newStr += strArr[j];
                }
            }
            words[i] = newStr;

            String palindromeStr = new StringBuffer(words[i]).reverse().toString();
            if (words[i].equals(palindromeStr)) {
                return leftStr;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int idx = 0; idx < words[0].length(); idx++) {
                newStr = "";
                leftStr = "";
                for (int idy = 0; idy < words[0].length(); idy++) {
                    if (idx != idy) {
                        newStr += words[i].charAt(idy);
                    } else {
                        leftStr += words[i].charAt(idy);
                    }
                }
                String leftleft = "";

                String anotherPalindromeStr = new StringBuffer(newStr).reverse().toString();
                if (newStr.equals(anotherPalindromeStr)) {
                    for (int k = 0; k < newStr.length(); k++) {
                        leftleft = str.replaceAll(Character.toString(newStr.charAt(k)), "");
                        str = leftleft;
                    }
                    return leftleft;
                }
            }
        }
        return "not possible";
    }

    public static void main(String[] args) {
        PalindromeCreator("mmop");

    }

}
