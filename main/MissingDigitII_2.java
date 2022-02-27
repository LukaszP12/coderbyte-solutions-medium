package JavaRegex;

public class MissingDigitII_2 {

    private static String MissingDigitII(String str) throws Exception {

        for (int i = 0; i < 10; i++) {
            String equation = str.replaceFirst("\\?", "" + i);
            for (int j = 0; j < 10; j++) {
                String equation1 = equation.replaceFirst("\\?", "" + j);
                String[] token = equation1.split(" ");

                int firstNum = Integer.parseInt(token[0]);
                char operator = token[1].trim().charAt(0);
                int secondNum = Integer.parseInt(token[2]);
                int result = Integer.parseInt(token[4]);

                if (result == doMath(firstNum, secondNum, operator)) {
                    return "" + i + " " + j;
                }
            }
        }
        return "0";
    }

    private static int doMath(int i, int j, char operator) {
        switch (operator) {
            case '+':
                return i + j;
            case '-':
                return i - j;
            case '*':
                return i * j;
            case '/':
                if (j == 0) {
                    return 0;
                } else {
                    return i / j;
                }

            default:
                return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "56? * 106 = 5?678";
        String s1 = MissingDigitII(s);

        System.out.println(s1);
    }

}
