public class OffBinary_M {


    public static int getOffBinary(String[] strArr) {

        int number = Integer.parseInt(strArr[0]);

        String binary = toBinary(number);

        return compareDigit(binary, strArr[1]);
    }

    private static int compareDigit(String binary, String s) {

        int digitToChange = 0;

        if (binary.length() == s.length()) {

            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) != s.charAt(i)) {
                    digitToChange++;
                }
            }

        }

        return digitToChange;
    }

    private static String toBinary(int number) {

        String result = "";

        while (number > 0) {
            result += "" + (number % 2);
            number = number / 2;
        }

        return new StringBuilder(result).reverse().toString();
    }


    public static void main(String[] args) {
        String[] strings = {"5624", "0010111111001"};
        System.out.println(getOffBinary(strings));

        String[] strings1 = {"44", "111111"};
        System.out.println(getOffBinary(strings1));
    }
}
