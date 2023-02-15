public class StringReduction_M {

    public static int getStringReduction(String str) {

        while (isReducible(str)) {
            for (int i = 1; i < str.length(); i++) {
                char charAt = str.charAt(i);
                char charAt1 = str.charAt(i - 1);
                if (charAt == charAt1) {
                    continue;
                }
                String replaced = replace(charAt, charAt1);

                str = str.substring(0, i - 1) + replaced + str.substring(i + 1);
            }
        }

        return str.length();
    }

    private static String replace(char charAt, char charAt1) {

        if ((charAt == 'b' && charAt1 == 'c') || (charAt == 'c' && charAt1 == 'b')) {
            return "a";
        }

        if ((charAt == 'a' && charAt1 == 'c') || (charAt == 'c' && charAt1 == 'a')) {
            return "b";
        }

        if ((charAt == 'a' && charAt1 == 'b') || (charAt == 'b' && charAt1 == 'a')) {
            return "c";
        }

        return "";
    }

    private static boolean isReducible(String str) {
        char initChar = str.charAt(0);

        String s = str.replaceAll("" + initChar, "");

        return !s.isEmpty();
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(getStringReduction(s));

        String s1 = "cccc";
        System.out.println(getStringReduction(s1));
    }
}
