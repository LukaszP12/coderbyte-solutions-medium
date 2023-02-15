public class HistogramArea_M {

    public static int getHistogramArea(int[] arr) {

        int max_area = 0;
        int current_height = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int height = Math.min(arr[i], current_height);

            int area = height * (i + 1);
            if (area > max_area) {
                max_area = area;
            }

            current_height = height;
        }


        for (int i = 0; i < arr.length; i++) {

            current_height = arr[i];

            for (int j = i; j < arr.length; j++) {
                int height = Math.min(arr[j], current_height);

                int area = height * (j + 1 - i);
                if (area > max_area) {
                    max_area = area;
                }

                current_height = height;
            }

        }

        return max_area;
    }

    public static void main(String[] args) {
        int[] ints = {6, 3, 1, 4, 12, 4};
        System.out.println(getHistogramArea(ints));

        int[] ints1 = {5, 6, 7, 4, 1};
        System.out.println(getHistogramArea(ints1));
    }
}
