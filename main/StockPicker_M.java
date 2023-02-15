
public class StockPicker_M {

    public static int getStockPicker(int[] arr) {
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int profit = arr[j] - arr[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit != 0 ? maxProfit : -1;
    }

    public static void main(String[] args) {
        int[] ints = {10, 12, 4, 5, 9};
        System.out.println(getStockPicker(ints));

        int[] ints1 = {14, 20, 4, 12, 5, 11};
        System.out.println(getStockPicker(ints1));
    }
}
