import java.util.HashMap;
import java.util.Map;

public class PermutationStep_M {


    public static int getPermutationStep(int num) {

        int initNum = num;

        while (true) {
            num++;
            if (num > initNum && sameDigits(initNum, num)) {
                return num;
            }
        }

    }

    private static boolean sameDigits(int initNum, int num) {
        Map<Integer, Integer> initMap = numberToMap(initNum);
        Map<Integer, Integer> map = numberToMap(num);

        return initMap.equals(map);
    }

    private static Map<Integer, Integer> numberToMap(int initNum) {

        Map<Integer, Integer> map = new HashMap<>();

        String number = String.valueOf(initNum);

        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - 48;
            Integer value = map.get(digit);
            if (value == null) {
                map.put(digit, 1);
            } else {
                map.put(digit, 1 + value);
            }

        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println(getPermutationStep(11121));
        System.out.println(getPermutationStep(41352));
    }
}
