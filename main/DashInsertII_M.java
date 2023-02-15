
public class DashInsertII_M {

    public static String getDashInsertII(int num) {

        String number = String.valueOf(num);
        String result = "" + number.charAt(0);

        for (int i = 1; i <= number.length() - 1; i++) {
            int num1 = number.charAt(i - 1) - 48;
            int num2 = number.charAt(i) - 48;

            if (num1 != 0 && num1 % 2 == 0 && num2 != 0 && num2 % 2 == 0) {
                result += "*" + num2;
            } else if (num1 != 0 && num1 % 2 == 1 && num2 != 0 && num2 % 2 == 1) {
                result += "-" + num2;
            } else {
                result += "" + num2;
            }

        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(getDashInsertII(99946));
//        System.out.println(getDashInsertII(10120));
    }
}
