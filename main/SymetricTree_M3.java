public class SymetricTree_M3 {


    public static boolean SymmetricTree(String[] strArr) {

        if (strArr.length == 1) {
            return true;
        }

        double sqrt = Math.sqrt(strArr.length);

        int pLevel = 0;
        for (int i = 0; i <= sqrt; i++) {
            int cLevel = (int) Math.pow(2, i);

            String[] level = new String[cLevel];
            int k = 0;
            int j = pLevel;

            for (; j < pLevel + cLevel; j++) {
                level[k] = strArr[j];
                k++;
            }
            if (!isPalidrome(level)) {
                return false;
            }

            pLevel = j;
        }

        return true;
    }

    private static boolean isPalidrome(String[] level) {

        for (int i = 0; i <= level.length / 2; i++) {
            if (level[i] != level[level.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] s = {"4", "3", "4"};
        System.out.println(SymmetricTree(s));

        String[] s2 = {"10", "2", "2", "#", "1", "1", "#"};
        System.out.println(SymmetricTree(s2));

        String[] s3 = {"#"};
        System.out.println(SymmetricTree(s3));
    }

}
