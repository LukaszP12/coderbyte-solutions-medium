public class CoinDeterminer {

    // coins 1, 5, 7, 9, and 11

    public static int getCoinDeterminer(int num) {

        int counter = 0;

        while (num > 0) {
            if (num % 11 == 9 || num % 11 == 7 || num % 11 == 5 || num % 11 == 1) {
                num = num - 11;
                counter++;
            } else if (num % 9 == 7 || num % 9 == 5 || num % 9 == 1) {
                num = num - 9;
                counter++;
            } else if (num % 7 == 5 || num % 7 == 1) {
                num = num - 7;
                counter++;
            } else if (num % 5 == 1) {
                num = num - 5;
                counter++;
            } else {
                num = num - 1;
                counter++;
            }
        }

        return counter;
    }

    public static int getCoinDeterminer2(int num) {
        int Coins = 0;
        while (true) {
            if (num == 11 || num >= 16) {
                num = num - 11;
                Coins++;
            } else if (num == 9 || num >= 14) {
                num = num - 9;
                Coins++;
            } else if ((num >= 7) || num >= 12) {
                num = num - 7;
                Coins++;
            } else if (num >= 5) {
                num = num - 5;
                Coins++;
            } else if (num >= 1) {
                num = num - 1;
                Coins++;
            } else if (num == 0) {
                break;
            }

        }

        return Coins;
    }

    public static int getCoinDeterminer3(int num) {

        int[] coins = {1, 5, 7, 9, 11};
        int[] Min = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            Min[i] = (int) Double.POSITIVE_INFINITY;
            for (int j = 0; j < coins.length - 1; j++) {
                if (i - coins[j] >= 0) {
                    Min[i] = Math.min(Min[i], Min[i - coins[j]] + 1);
                }
            }
        }

        return Min[num];
    }

    public static long getCoinDeterminer4(int num) {
        int[] coins = {11, 9, 7, 5, 1};
        long[] cost = new long[num + 1];
        cost[0] = 0;
        for (int i = 1; i < num + 1; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (cost[i - coins[j]] + 1 < min) {
                        min = cost[i - coins[j]] + 1;
                    }
                }
            }
            cost[i] = min;
        }

        return cost[num];
    }

    public static long getCoinDeterminer5(int num) {
        int coins = 0;
        int rest = 0;
        int[] change = {0, 1, 2, 3, 4, 1, 2, 1, 2, 1, 2, 0, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3};

        coins = num / 11;
        rest = num % 11;

        if (coins >= 1) {
            coins = (coins - 1) + change[rest + 11];
        } else {
            coins = change[rest];
        }

        return coins;
    }

    public static void main(String[] args) {
//        System.out.println(getCoinDeterminer(6));
//        System.out.println(getCoinDeterminer2(6));
//        System.out.println(getCoinDeterminer3(6));
//        System.out.println(getCoinDeterminer4(6));
        System.out.println(getCoinDeterminer5(6));

//        System.out.println(getCoinDeterminer(16));
//        System.out.println(getCoinDeterminer2(16));
//        System.out.println(getCoinDeterminer3(16));
//        System.out.println(getCoinDeterminer4(16));
        System.out.println(getCoinDeterminer5(16));
    }

}
