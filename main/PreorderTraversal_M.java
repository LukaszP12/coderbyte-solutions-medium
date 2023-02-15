public class PreorderTraversal_M {

    static String result = "";

    public static String PreorderTraversal(String[] strArr) {
        traverse(strArr, 0, 0);
        return result;
    }

    private static void traverse(String[] strArr, int index, int level) {

        if (index > strArr.length - 1) {
//            return "" + result;
            return;
        }

        result += !strArr[index].equals("#") ? " " + strArr[index] : "";

//        String traversedL = traverse(strArr, result, level * 2 + 1, ++level);
//        String traversedR = traverse(strArr, traversedL, level * 2 + 2, ++level);

        traverse(strArr, level * 2 + 1, ++level);
        traverse(strArr, level * 2 + 2, ++level);

//        return traversedR;
    }

    public static void main(String[] args) {
        String[] strings = {"4", "1", "5", "2", "#", "#", "#"};
        System.out.println(PreorderTraversal(strings));

        String[] strings1 = {"2", "6", "#"};
        PreorderTraversal(strings1);
    }
}
