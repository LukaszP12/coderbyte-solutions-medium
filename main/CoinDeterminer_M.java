public class CoinDeterminer_M {

    public static int CoinDeterminer(int num) {
        int[] coins = {11, 9, 7, 5, 1};

        int[] counts = new int[num + 1];
        counts[0] = 0;

        for (int i = 1; i <= num; i++) {

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int rest = i - coins[j];
                    int newCount = counts[rest] + 1;

                    if (counts[i] == 0) {
                        counts[i] = newCount;
                    } else if (newCount < counts[i]) {
                        counts[i] = newCount;
                    }

                }
            }
        }

        return counts[num];
    }

    public static void main(String[] args) {
//        System.out.println(CoinDeterminer(1));
//        System.out.println(CoinDeterminer(2));
//        System.out.println(CoinDeterminer(3));

//        System.out.println(CoinDeterminer(6));
//        System.out.println(CoinDeterminer(16));

        System.out.println(CoinDeterminer(25));
        System.out.println(CoinDeterminer(37));
        System.out.println(CoinDeterminer(14));
    }
}
