import java.util.*;
import java.util.stream.Collectors;

public class StringExpression_M {

    private final static String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", ""};

    public static String getStringExpression(String str) {

        List<String> equation = new LinkedList<>();

        for (int i = 0, j = 0; i < str.length() && j <= str.length(); j++) {
            String number = str.substring(i, j);

            if (number.equals("plus") || number.equals("minus")) {
                equation.add(number.equals("plus") ? "+" : "-");
                i = j;
            }

            int numberInt = getIndexOfNumber(number);
            if (numberInt != -1) {
                equation.add(String.valueOf(numberInt));
                i = j;
            }

        }

        String equationResult = equationToStringResult(equation);
        int resultInt = equationToIntResult(equationResult);
        return resultToString(resultInt);
    }

    private static String resultToString(int equationResult) {

        String s = String.valueOf(equationResult);
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                result += "negative";
            } else {
                result += "" + NUMBERS[s.charAt(i) - 48];
            }
        }

        return result;
    }

    private static int equationToIntResult(String equation) {

        Map<Integer, Character> signIndexes = new HashMap<>();

        for (int i = 0; i < equation.length(); i++) {

            if (equation.charAt(i) == '+') {
                signIndexes.put(i, '+');
            }

            if (equation.charAt(i) == '-') {
                signIndexes.put(i, '-');
            }

        }

        int result = 0;

        List<Integer> indexes = signIndexes.keySet().stream().collect(Collectors.toList());

        List<Integer> numbers = new LinkedList<>();

        numbers.add(Integer.parseInt(equation.substring(0, indexes.get(0))));

        for (int i = 0; i < indexes.size() - 1; i++) {
            int number = Integer.parseInt(equation.substring(indexes.get(i) + 1, indexes.get(i + 1)));
            numbers.add(number);
        }
        numbers.add(Integer.parseInt(equation.substring(indexes.get(indexes.size() - 1) + 1)));

        result += numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int sIndex = indexes.get(i - 1);

            if (equation.charAt(sIndex) == '+') {
                result += numbers.get(i);
            }

            if (equation.charAt(sIndex) == '-') {
                result -= numbers.get(i);
            }

        }

        return result;
    }

    private static String equationToStringResult(List<String> equation) {

        String result = "";

        for (int i = 0; i < equation.size(); i++) {
            if (!equation.get(i).equals("+") && !equation.get(i).equals("-")) {
                result += equation.get(i);
            } else {
                result += "" + equation.get(i);
            }
        }

        return result;
    }

    private static int getIndexOfNumber(String strNumber) {

        int i = 0;

        for (; i <= 10; i++) {
            if (NUMBERS[i].equals(strNumber)) {
                break;
            }
        }

        if (i == 11) {
            return -1;
        }

        return i;
    }

    public static void main(String[] args) {
        String s1 = "onezeropluseight";
        System.out.println(getStringExpression(s1));

        String s2 = "oneminusoneone";
        System.out.println(getStringExpression(s2));

        String s3 = "foursixminustwotwoplusonezero";
        System.out.println(getStringExpression(s3));
    }
}
