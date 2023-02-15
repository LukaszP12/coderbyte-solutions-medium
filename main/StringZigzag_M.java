import java.util.LinkedList;
import java.util.List;

public class StringZigzag_M {

    public static String getStringZigzag(String[] strArr) {

        int rows = Integer.parseInt(strArr[1]);
        String word = strArr[0];

        String[][] zigZag = new String[rows + 1][rows + 1];

        if (allSame(word)) {
            return word;
        }

        if (rows == 2) {
            return calcLengthTwo(word);
        }

        if (word.length() < rows || rows == 1) {
            return word;
        }


        int peekDistance = rows - 1;
        List<Integer> peeks = getAllPeeks(strArr[0], peekDistance);

        int k = peeks.get(0);
        int j = 0;

        for (int i = 0; i < word.length(); i++) {

            if (k % 2 == 0) {
                zigZag[k][j++] = "" + word.charAt(i);
            } else if (k % 2 == 1) {
                zigZag[k][--j] = "" + word.charAt(i);
            }

            if (i != 0 && peeks.contains(i)) {
                k++;
                if (k % 2 == 1) {
                    --j;
                }
                if (k % 2 == 0) {
                    j++;
                }
            }

        }

        return toStringResult(zigZag, rows);
    }

    private static String calcLengthTwo(String word) {
        String result = "";

        for (int i = 0; i < word.length(); i += 2) {
            result += "" + word.charAt(i);
        }

        for (int i = 1; i < word.length(); i += 2) {
            result += "" + word.charAt(i);
        }

        return result;
    }

    private static boolean allSame(String word) {
        char c = word.charAt(0);

        String s = word.replaceAll("" + c, "");
        if (s.isEmpty()) {
            return true;
        }

        return false;
    }

    private static List<Integer> getAllPeeks(String s, int peekDistance) {
        List<Integer> peeks = new LinkedList<>();

        for (int i = 0; i < s.length(); i += peekDistance) {
            peeks.add(i);
        }

        return peeks;
    }

    private static String toStringResult(String[][] zigZag, int rows) {
        String result = "";


        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                String s = zigZag[j][i];
                if (s != null) {
                    result += s;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String[] strings = {"cat", "5"};
//        System.out.println(getStringZigzag(strings));
//
//        String[] strings1 = {"kaamvjjfl", "4"};
//        System.out.println(getStringZigzag(strings1));
//        System.out.println(getStringZigzag(strings1).equals("kjajfavlm"));
//
//
//        String[] strings4 = {"aaaaaaaaaaaaaaaaaaaa", "4"};
//        System.out.println(getStringZigzag(strings4));


        // k                    j
        //   a              j       f
        //      a       v               l
        //          m
        //
        //  kjajfavlm

//        String[] strings2 = {"coderbyte", "3"};
//        System.out.println(getStringZigzag(strings2));
//        System.out.println(getStringZigzag(strings2).equals("creoebtdy"));

//        String[] strings5 = {"aeettym", "1"};
//        System.out.println(getStringZigzag(strings5));

//        String[] strings4 = {"abcdefghijklm", "5"};
//        System.out.println(getStringZigzag(strings4));

//        String[] strings3 = {"abcdefghijklm", "2"};
//        System.out.println(getStringZigzag(strings3));
//        System.out.println(getStringZigzag(strings3).equals("acegikmbdfhjl"));
//
//        String[] strings6 = {"ababababababa", "2"};
//        System.out.println(getStringZigzag(strings6));

    }
}
