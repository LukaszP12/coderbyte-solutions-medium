package JavaRegex;

public class MinWindowSubstring6 {

    static final int min_len = Integer.MAX_VALUE;

    public static String MinWindowSubstring(String[] strArr) {
        String fullString = strArr[0];
        String kString = strArr[1];

        if (fullString.length() < kString.length()) {
            System.out.println("No such window exists");
            return "";
        }

        String result = "";
        int resultLen = min_len;

        for (int i = 0; i < fullString.length(); i++) {
            for (int j = i + 1; j <= fullString.length(); j++) {
                String substring = fullString.substring(i, j);
                if (containsAll(substring, kString)) {
                    if (substring.length() < resultLen) {
                        result = fullString.substring(i, j);
                        resultLen = result.length();
                    }
                }
            }
        }

        return result;
    }

    public static boolean containsAll(String str1, String str2) {
        char[] chars = str2.toCharArray();

        int length = str1.length();

        for (char c : chars) {
            if (str1.contains(String.valueOf(c))) {
                str1 = str1.replaceFirst(String.valueOf(c), "");
            }
        }

        return length - str1.length() == str2.length() ? true : false;
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

//        boolean b = containsAll(strings[0], strings[1]);
//        System.out.println(b);

        System.out.println(MinWindowSubstring(strings));


        // wrong result
        String[] strings1 = {"aaabaaddae", "aed"};
        System.out.println(MinWindowSubstring(strings1));

    }

}
