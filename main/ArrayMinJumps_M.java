public class ArrayMinJumps_M {

    public static int ArrayMinJumps(int[] strArr) {

        int counter = 0;
        int max_counter = 0;

        for (int i = 0; i < strArr.length; i++) {
            int nextStep = i + strArr[i];
            while (nextStep < strArr.length) {
                for (int j = 0; j < nextStep + strArr[nextStep]; j++) {
                    nextStep = nextStep + strArr[nextStep];
                    counter++;
                }

            }
            if (counter > max_counter) {
                max_counter = counter;
            }

            counter = 0;
        }

        return max_counter;
    }

    public static void main(String[] args) {
        int[] ints = {3, 4, 2, 1, 1, 100};
        System.out.println(ArrayMinJumps(ints));

        int[] ints1 = {1, 3, 6, 8, 2, 7, 1, 2, 1, 2, 6, 1, 2, 1, 2};
        System.out.println(ArrayMinJumps(ints1));
    }
}
