public class Arith_Geo_II_M {

    public static String getArithGeoII(int[] arr) {

        if (isArith(arr)) {
            return "Arithmetic";
        }

        if (isGeo(arr)) {
            return "Geometric";
        }

        return "-1";
    }

    private static boolean isGeo(int[] arr) {
        int diff = arr[1] / arr[0];

        for (int i = 1; i < arr.length; i++) {
            int sequenceDiff = arr[i] / arr[i - 1];
            if (sequenceDiff != diff) {
                return false;
            }
        }

        return true;
    }

    private static boolean isArith(int[] arr) {

        int diff = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {
            int sequenceDiff = arr[i] - arr[i - 1];
            if (sequenceDiff != diff) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 15};
        System.out.println(getArithGeoII(ints));

        int[] ints1 = {2, 4, 16, 24};
        System.out.println(getArithGeoII(ints1));
    }

}
