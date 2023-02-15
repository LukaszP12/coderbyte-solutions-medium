public class MissingDigit_M {

    public static int getMissingDigit(String str) {
        String[] equation = str.split("\\s");

        String value1 = equation[0];

        String mark = equation[1];

        String value2 = equation[2];

        String result = equation[4];

        if (result.equals("x")) {
            return getResult(value1, value2, mark);
        }

        if (value1.contains("x")) {
            return toEquate(value1, value2, result, mark);
        }

        if (value2.contains("x")) {
            return toEquate(value2, value1, result, mark);
        }

        return -1;
    }

    private static int toEquate(String missingValue, String presentValue, String result, String mark) {

        int otherValue = 0;
        int resultEquation = 0;

        switch (mark) {
            case "+":
                otherValue = Integer.parseInt(result) - Integer.parseInt(presentValue);
                resultEquation = compareValues(missingValue, otherValue);
                break;
            case "-":
                otherValue = Integer.parseInt(result) + Integer.parseInt(presentValue);
                resultEquation = compareValues(missingValue, otherValue);
                break;
            case "*":
                otherValue = Integer.parseInt(result) / Integer.parseInt(presentValue);
                resultEquation = compareValues(missingValue, otherValue);
                break;
            case "/":
                otherValue = Integer.parseInt(result) * Integer.parseInt(presentValue);
                resultEquation = compareValues(missingValue, otherValue);
                break;
        }

        return resultEquation;
    }

    private static int compareValues(String missingValue, int otherValue) {

        String otherValueS = String.valueOf(otherValue);

        int indexOfMissing = missingValue.indexOf("x");

        if (indexOfMissing != -1) {
            char charAtS = otherValueS.charAt(indexOfMissing);
            return charAtS - 48;
        }

        return 0;
    }

    private static int getResult(String value1, String value2, String mark) {

        int val1 = Integer.parseInt(value1);
        int val2 = Integer.parseInt(value2);

        int result = 0;

        switch (mark) {
            case "-":
                result = val1 - val2;
                break;
            case "+":
                result = val1 + val2;
                break;
            case "*":
                result = val1 * val2;
                break;
            case "/":
                result = val1 / val2;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "4 - 2 = x";
        System.out.println(getMissingDigit(s));

        String s1 = "1x0 * 12 = 1200";
        System.out.println(getMissingDigit(s1));

        String s2 = "4356 * 23 = 1001x8";
        System.out.println(getMissingDigit(s2));

        String s3 = "10 - x = 10";
        System.out.println(getMissingDigit(s3));
    }
}
