public class StringReduction {

    public static int StringReduction(String str) {
        int i = 0;
        while (isReducible(str)) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                str = str.substring(0, i) + reduction(str.charAt(i), str.charAt(i + 1)) + str.substring(i + 2);
            }
            if (i + 3 > str.length()) {
                i = 0;
            } else {
                i++;
            }

        }
        return str.length();
    }


    static boolean isReducible(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    static char reduction(char first, char second) {
        if (first == 'b' && second == 'c') {
            return 'a';
        } else if (first == 'c' && second == 'b') {
            return 'a';
        } else if (first == 'a' && second == 'c') {
            return 'b';
        } else if (first == 'c' && second == 'a') {
            return 'b';
        }

        return 'c';
    }

    public static void main(String[] args) {
        String abcabc = "abcabc";
        System.out.println(StringReduction(abcabc));

        System.out.println(StringReduction("cccc"));
    }

}
