package JavaRegex;

public class MinWindowSubstring2 {

    public static String MinWindowSubstring(String[] strArr) {
        String n = strArr[0];
        String k = strArr[1];
        String shortest = n;
        for (int i = 0; i < n.length(); i++) {
            for (int j = i + 1; j <= n.length(); j++) {
                String substring = n.substring(i, j);
                if (containsAll(substring, k)) {
                    if (substring.length() < shortest.length()) {
                        shortest = substring;
                    }
                }
            }
        }
        return shortest;
    }

    private static boolean containsAll(String n, String k) {
        for (int i = 0; i < k.length(); i++) {
            int pos = n.indexOf(k.charAt(i));
            if (pos == -1) return false;
            n = remove(n, pos);
        }
        return true;
    }

    private static String remove(String n, int pos) {
        return n.substring(0, pos) + n.substring(pos + 1, n.length());
    }

    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};

        System.out.println(MinWindowSubstring(strings));
    }

}
