import java.util.Arrays;

public class PlusMinus_M3 {

    public static String PlusMinus_M3(int num) {
        if (num < 10) return "not possible";

        char[] digits = String.valueOf(num).toCharArray();

        return getPlusMinus(digits, 0, digits[0] - 48);
    }

    private static String getPlusMinus(char[] digits, int i, int sum) {

        char[] digits1 = makeNewDigits(digits);
        int currentNum = digits1[0] - 48;

        if (digits.length == 2) {
            if (sum + currentNum == 0) {
                return "+";
            } else if (sum - currentNum == 0) {
                return "-";
            } else {
                return "not possible";
            }
        }

        String plus = getPlusMinus(digits1, i + 1, sum + currentNum);
        String minus = getPlusMinus(digits1, i + 1, sum - currentNum);

        if (!minus.equals("not possible")) {
            return "-" + minus;
        }

        if (!plus.equals("not possible")) {
            return "+" + plus;
        }

        return "not possible";
    }

    private static char[] makeNewDigits(char[] digits) {
        char[] chars1 = Arrays.copyOfRange(digits, 1, digits.length);

        return chars1;
    }

    public static void main(String[] args) {
//        System.out.println(PlusMinus_M3(22));
//        System.out.println(PlusMinus_M3(199));
//        System.out.println(PlusMinus_M3(35132));
        System.out.println(PlusMinus_M3(26712));
    }

}
