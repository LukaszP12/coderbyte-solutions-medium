package JavaRegex;

import java.util.Arrays;

public class MissingDigitII {

    public static String MissingDigitII(String str) {
        String[] parts = str.split(" ");
        for (int d1 = 0; d1 < 10; d1++) {
            for (int d2 = 0; d2 < 10; d2++) {
                String initial = parts[0].replace("?", String.valueOf(d1));
                String answer = parts[4].replace("?", String.valueOf(d2));
                if (Arrays.asList(parts).contains("*") && Integer.parseInt(initial) * Integer.parseInt(parts[2]) == Integer.parseInt(answer))
                    return String.valueOf(d1) + " " + String.valueOf(d2);
                if (Arrays.asList(parts).contains("+") && Integer.parseInt(initial) + Integer.parseInt(parts[2]) == Integer.parseInt(answer))
                    return String.valueOf(d1) + " " + String.valueOf(d2);
                if (Arrays.asList(parts).contains("-") && Integer.parseInt(initial) - Integer.parseInt(parts[2]) == Integer.parseInt(answer))
                    return String.valueOf(d1) + " " + String.valueOf(d2);
                if (Arrays.asList(parts).contains("/") && Integer.parseInt(initial) / Integer.parseInt(parts[2]) == Integer.parseInt(answer))
                    return String.valueOf(d1) + " " + String.valueOf(d2);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "56? * 106 = 5?678";
        String s1 = MissingDigitII(s);

        System.out.println(s1);
    }

}
