package JavaRegex;

import java.util.Arrays;

public class MinWindowSubstring5 {

    public static String MinWindowSubstring(String[] strArr) {
        String str1 = strArr[0];
        String str2 = strArr[1];
        int len = Integer.MAX_VALUE;
        String res = "";
        char[] ch = str2.toCharArray();
        Arrays.sort(ch);
        for (int i = 0; i < str1.length(); i++) {
            String s = str1.substring(i);
            int k = s.length();
            while (k >= 0) {
                if (containsAll(s.substring(0, k), ch)) {
                    if (len > k) {
                        len = k;
                        res = s.substring(0, k);
                    }
                }
                k--;
            }
        }

        return res;
    }

    public static boolean containsAll(String str1, char[] ch2) {
        char[] ch1 = str1.toCharArray();

        Arrays.sort(ch1);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < ch1.length && j < ch2.length) {
            if (ch1[i] == ch2[j]) {
                count++;
                i++;
                j++;
            } else if (ch1[i] < ch2[j]) {
                i++;
            } else {
                j++;
            }
        }
        if (count == ch2.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

        System.out.println(MinWindowSubstring(strings));
    }

}


