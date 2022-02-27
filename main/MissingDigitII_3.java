package JavaRegex;

public class MissingDigitII_3 {

    public static String MissingDigitII(String str) {

        String[] ar = str.split("=");
        String trim = ar[1].trim();

        char op = 0;
        String oprand1 = "";
        String oprand2 = "";
        for (int i = 0; i < ar[0].length(); i++) {
            char c = ar[0].charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                op = c;
                oprand1 = ar[0].substring(0, i).trim();
                oprand2 = ar[0].substring(i + 1).trim();
            }
        }

        return "";
    }

    public static void main(String[] args) {

    }

}
