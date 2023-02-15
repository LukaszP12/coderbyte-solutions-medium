
public class PlusMinus_M {

    static String stringResult = "not possible";

    public static String PlusMinus(int num) {
        char[] numbers = String.valueOf(num).toCharArray();

        int sum = 0;

        explore(numbers, sum + Integer.parseInt("" + numbers[0]), 0, "");

        return stringResult;
    }

    private static void explore(char[] numbers, int sum, int i, String result) {

        if ((i == numbers.length - 1)) {
            if (sum == 0) {
                stringResult = result;
            }
            return;
        }

        explore(numbers, sum + Integer.parseInt("" + numbers[i + 1]), i + 1, result + "+");
        explore(numbers, sum - Integer.parseInt("" + numbers[i + 1]), i + 1, result + "-");
    }

    public static void main(String[] args) {
        System.out.println(PlusMinus(199));
//        System.out.println(PlusMinus(26712));
    }

}
