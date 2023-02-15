import java.util.Stack;

public class PreorderTraversal_M2 {

    public static String PreorderTraversal(String[] strArr) {
        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        return traverse("", stack, strArr);
    }

    private static String traverse(String result, Stack<Integer> stack, String[] strArr) {
        int level = 0;

        while (stack.isEmpty() == false) {
            int index = stack.pop();

            result += " " + strArr[index];

            if ((level * 2) + 2 < strArr.length && !strArr[(level * 2) + 2].equals("#")) {
                stack.add(Integer.parseInt(String.valueOf((level * 2) + 2)));
            }

            if ((level * 2) + 1 < strArr.length && !strArr[(level * 2) + 1].equals("#")) {
                stack.add(Integer.parseInt(String.valueOf((level * 2) + 1)));
            }

            if (strArr[(level * 2) + 1].equals("#") && strArr[(level * 2) + 2].equals("#")) {
                int index1 = stack.pop();
                int index2 = stack.pop();

                result += " " + strArr[index1] + " " + strArr[index2];
                level++;
                continue;
            }

            if (((level + 2) * 2) + 1 >= strArr.length) {
                int index1 = stack.pop();
                int index2 = stack.pop();

                result += " " + strArr[index1] + " " + strArr[index2];
                level++;
                continue;
            }

            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"4", "1", "5", "2", "#", "#", "#"};
//        System.out.println(PreorderTraversal(strings));

        String[] strings1 = {"2", "6", "#"};
//        PreorderTraversal(strings1);
//                            0    1    2    3    4    5    6    7    8    9    10   11   12
        String[] strings2 = {"5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"};
//        System.out.println(PreorderTraversal(strings2));

        String[] strings3 = {"4", "1", "5", "2", "3", "2", "4"};
//        4 1 2 3 5 2 4
        //     4
        //   1    5
        //  2 3  2 4
//        System.out.println(PreorderTraversal(strings3));

//        String[] strings3 = {"4", "1", "5", "2", "3", "2", "4"};
//        System.out.println(PreorderTraversal(strings3));

//      "5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"
        //       5
        //   2      6
        // 1   9   #  8
        //##   ##  4#

//        5 2 1 9 6 8 4


        //      5
        //    2    1
        //   9 6  8 4
        //  ## ## ## ##


        //          5
        //      2         6
        //   1     9    #   8
        //  # #   # #  4#
        String[] strings4 = {"5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"};
        System.out.println(PreorderTraversal(strings4));
//        5 2 1 9 6 8 4
    }
}
