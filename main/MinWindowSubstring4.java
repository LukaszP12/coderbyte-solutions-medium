package JavaRegex;

public class MinWindowSubstring4 {

    public static String MinWindowSubstring(String[] strArr) {

        String str = strArr[0];
        String result = null;
        int length_min = Integer.MAX_VALUE;
        for (int i = 0; i < strArr[0].length(); i++) {
            for (int j = i; j < strArr[0].length(); j++) {
                if (checker(str.substring(i, j + 1), strArr[1])) {
                    if (str.substring(i, j + 1).length() < length_min) {
                        length_min = str.substring(i, j + 1).length();
                        result = str.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }

    public static boolean checker(String s, String s2) {
        StringBuilder sb = new StringBuilder(s);
        int a = s.length();
        char[] ch_2 = s2.toCharArray();
        for (char c : ch_2) {
            if (s.contains(String.valueOf(c))) {
                s = s.replaceFirst(String.valueOf(c), "");
            }
        }
        return a - s2.length() == s.length() ? true : false;
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

        System.out.println(MinWindowSubstring(strings));
    }

}
