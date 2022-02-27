package JavaRegex;

public class BinaryReversal {

    public static String BinaryReversal(String str) {
        int number = Integer.parseInt(str);

        String result = "";

        while (number > 0) {
            if (number % 2 == 0) {
                result = result + "1";
            } else {
                result = result + "0";
            }
        }

        StringBuilder result1 = new StringBuilder(result);

        if (result1.length() < 8) {

            int length = result1.length();
            while (length < 8) {
                result1.append("0");
                length++;
            }
        }

        return result1.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(BinaryReversal("213"));

        int i = Integer.parseInt("1234567890", 2);
        System.out.println(i);
    }

}
