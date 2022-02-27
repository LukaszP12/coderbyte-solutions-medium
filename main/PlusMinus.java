package JavaRegex;

public class PlusMinus {

    // num being passed is a combination of 1 or more single digits
    // determine if it's possible to separate the digits with either
    // a plus or minus sign to get the final expression to equal zero
    private static String PlusMinus(int num) {

        String numString = num + "";

        char[] digitChars = numString.toCharArray();
        int first = digitChars[0] - '0';
        String signs = matchSign(digitChars, 1, first);
        return signs;
    }

    private static String matchSign(char[] digits, int index, int total) {
        if (index > digits.length - 1) {
            if (total == 0) {
                return "";
            } else {
                return "not possible";
            }
        }

        int current = digits[index] - '0';
        String plus = matchSign(digits, index + 1, total + current);
        String minus = matchSign(digits, index + 1, total - current);

        if (minus != "not possible" && plus != "not possible") {
            return "-" + minus;
        }
        if (minus != "not possible") {
            return "-" + minus;
        }
        if (plus != "not possible") {
            return "+" + plus;
        }
        return "not possible";

    }

    public static void main(String[] args) {
        System.out.println(PlusMinus(199));
        System.out.println(PlusMinus(26712));
    }
}
