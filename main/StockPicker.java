package JavaRegex;

public class StockPicker {

    public static int StockPicker(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int profit = arr[j] - arr[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }


        // code goes here
        return max;
    }

    private static int StockPicker2(int[] arr) {
        int max = 0;
        int pozMin = -1;
        int pozMax = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > max) {
                    max = arr[j] - arr[i];
                    pozMin = arr[i];
                    pozMax = arr[j];
                }
            }
        }

        if (max == 0) {
            return -1;
        }

        return max;
    }

    private static int StockPicker3(int arr[]) {
        int prof = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > prof) {
                    prof = arr[j] - arr[i];
                }
            }
        }

        if (prof == 0) {
            prof = -1;
        }

        return prof;
    }


    public static void main(String[] args) {
        int[] ints = {10, 12, 4, 5, 9};
        int[] ints1 = {14, 20, 4, 12, 5, 11};

        System.out.println(StockPicker2(ints));
        System.out.println(StockPicker2(ints1));
    }

}