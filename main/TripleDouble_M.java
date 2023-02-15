import java.util.HashSet;
import java.util.Set;

public class TripleDouble_M {

    public static int getTripleDouble(int num1, int num2) {

        String s = String.valueOf(num1);
        String s1 = String.valueOf(num2);

        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        boolean tripleTrue = false;

        for (char c : chars) {
            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == c && s.charAt(i + 1) == c && s.charAt(i + 2) == c) {
                    tripleTrue = true;
                }
            }

            for (int i = 0; i < s1.length() - 1; i++) {
                if (tripleTrue && s1.charAt(i) == c && s1.charAt(i + 1) == c) {
                    return 1;
                }
            }
            tripleTrue = false;
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(getTripleDouble(465555, 5579));
//        System.out.println(getTripleDouble(67844, 66237));
        System.out.println(getTripleDouble(556668, 556886));
    }
}
