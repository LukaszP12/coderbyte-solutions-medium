package JavaRegex;

import java.util.LinkedList;
import java.util.List;

public class CharlietheDog2 {

    public static List<String> bestGlobalPath = null;

    public static boolean[][] clone(boolean[][] input) {
        boolean[][] output = new boolean[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[i][j] = input[i][j];
            }
        }

        return output;
    }

    public static List<String> clone(List<String> input) {
        List<String> output = new LinkedList<String>();
        for (String item : input) {
            output.add("" + item);
        }
        return output;
    }




    public static void main(String[] args) {

    }

}
