public class EvenPairs_M {

    public static boolean getEvenPairs(String str) {

        String s = str.replaceAll("[^0-9]", " ").replaceAll("\\s+", " ").trim();

        if (s.isEmpty()) {
            return false;
        }

        String[] split = s.split("\\s");

        for (String s1 : split) {
            int number = Integer.parseInt(s1);
            if (checkIsEvenPair(number)) {
                return true;
            }
        }

        return false;
    }

    // toDo simplify further
    private static boolean checkIsEvenPair(int number) {
        String numString = String.valueOf(number);

        if (String.valueOf(number).length() == 2) {
            if (isEven(numString.charAt(0) - 48) && isEven(numString.charAt(1) - 48)) {
                return true;
            }
        } else if (String.valueOf(number).length() == 3) {
            String substring = numString.substring(0, 1);
            String substring1 = numString.substring(1);
            if (isEven(Integer.parseInt(substring)) && isEven(Integer.parseInt(substring1))) {
                return true;
            }

            String substring2 = numString.substring(0, 2);
            String substring3 = numString.substring(2);
            if (isEven(Integer.parseInt(substring2)) && isEven(Integer.parseInt(substring3))) {
                return true;
            }
        } else if (String.valueOf(number).length() == 4) {
            String substring = numString.substring(0, 2);
            String substring1 = numString.substring(2);
            if (isEven(Integer.parseInt(substring)) && isEven(Integer.parseInt(substring1))) {
                return true;
            }

            String substring2 = numString.substring(0, 2);
            String substring3 = numString.substring(2);
            if (isEven(Integer.parseInt(substring2)) && isEven(Integer.parseInt(substring3))) {
                return true;
            }

            String substring4 = numString.substring(0, 1);
            String substring5 = numString.substring(1);
            if (isEven(Integer.parseInt(substring4)) && isEven(Integer.parseInt(substring5))) {
                return true;
            }

            String substring6 = numString.substring(0, 3);
            String substring7 = numString.substring(3);
            if (isEven(Integer.parseInt(substring6)) && isEven(Integer.parseInt(substring7))) {
                return true;
            }

        }

        return false;
    }

    private static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        String s = "3gy41d216";
//        System.out.println(getEvenPairs(s));

//        String s1 = "f09r27i8e67";
//        System.out.println(getEvenPairs(s1));

//        String s2 = "f178svg3k19k46";
//        System.out.println(getEvenPairs(s2));

//        String s3 = "5678dddd";
//        System.out.println(getEvenPairs(s3));

//        String s4 = "jfb735f9ph8152";
//        System.out.println(getEvenPairs(s4));

        String s5 = "abc";
        System.out.println(getEvenPairs(s5));
    }

}
