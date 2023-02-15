public class PlusMinus_M2 {

    public static String PlusMinus_M2(int num) {
        if (num < 10) return "not possible";

        char[] numbers = String.valueOf(num).toCharArray();

        return explore(numbers, 0, Integer.parseInt("" + numbers[0]));
    }

    private static String explore(char[] numbers, int i, int sum) {

        if (numbers.length - 2 == i) {
            if (sum - Integer.parseInt("" + numbers[i + 1]) == 0) {
                return "-";
            } else if (sum + Integer.parseInt("" + numbers[i + 1]) == 0) {
                return "+";
            } else {
                return "not possible";
            }
        }

        int curNumber = Integer.parseInt("" + numbers[i + 1]);
        String plus = explore(numbers, i + 1, sum + curNumber);
        String minus = explore(numbers, i + 1, sum - curNumber);

        if (!minus.equals("not possible")) return "-" + minus;
        if (!plus.equals("not possible")) return "+" + plus;
        return "not possible";
    }

    public static void main(String[] args) {
        System.out.println(PlusMinus_M2(22));
        System.out.println(PlusMinus_M2(199));
        System.out.println(PlusMinus_M2(26712));
        System.out.println(PlusMinus_M2(35132));
    }

}
