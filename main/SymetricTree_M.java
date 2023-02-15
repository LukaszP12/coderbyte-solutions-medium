public class SymetricTree_M {

    public static boolean SymmetricTree_M(String[] strArr) {

        return isSymmetric(strArr, 0, 1);
    }

    private static boolean isSymmetric(String[] strArr, int prevLevel, int i) {

        int level = (int) Math.pow(2, i);

        if (level > strArr.length) {
            return true;
        }

        String result = "";
        for (int j = prevLevel + 1; j <= prevLevel + level; j++) {
            result += "" + strArr[j];
        }

        if (!isPalindrome(result)) {
            return false;
        }

        return isSymmetric(strArr, level, i++);
    }

    private static boolean isPalindrome(String result) {

        for (int i = 0; i < result.length() / 2; i++) {
            if (result.charAt(i) != result.charAt(result.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String[] strings = {"4", "3", "4"};
//        System.out.println(SymmetricTree_M(strings));

        String[] strings1 = {"10", "2", "2", "#", "1", "1", "#"};
//        System.out.println(SymmetricTree_M(strings1));

        String[] strings2 = {"1", "4", "4", "3", "7", "7", "3", "9", "#", "#", "#", "#", "#", "#", "9"};
        System.out.println(SymmetricTree_M(strings2));
    }

}