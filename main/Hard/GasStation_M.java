package Hard;

public class GasStation_M {

    static int index = -1;

    public static String getGasStation(String[] strArr) {

        int numStations = Integer.parseInt(strArr[0]);
        String[] stations = new String[numStations];

        for (int i = 1; i < strArr.length; i++) {
            stations[i - 1] = strArr[i];
        }

        for (int i = 0; i < stations.length; i++) {
            explore(0, i, stations, i, 0);
        }

        return index == -1 ? "impossible" : ("" + (index + 1));
    }

    private static void explore(int petrol, int i, String[] strArr, int startIndex, int counter) {

        if (counter == strArr.length && i == startIndex && petrol >= 0) {
            if (index == -1) {
                index = startIndex;
            }

            if (index != -1) {
                if (startIndex < index) {
                    index = startIndex;
                }
            }

            return;
        }

        if (counter == strArr.length || petrol < 0 || strArr[i].length() < 2) {
            return;
        }

        int nextDistance = Integer.parseInt(strArr[i].split(":")[1]);

        ++counter;
        explore(petrol + Integer.parseInt(strArr[i].split(":")[0]) - nextDistance, (++i % strArr.length), strArr, startIndex, counter);
    }

    public static void main(String[] args) {
        String[] strings = {"4", "1:1", "2:2", "1:2", "0:1"};
//        System.out.println(getGasStation(strings));

        String[] strings1 = {"4", "0:1", "2:2", "1:2", "3:1"};
//        System.out.println(getGasStation(strings1));

        String[] strings2 = {"3", "2:3", "2:1", "4:4"};
//        System.out.println(getGasStation(strings2));

        String[] strings3 = {"5", "3:3", "1:2", "2:2", "3:2", "4:3"};
//        System.out.println(getGasStation(strings3));

        String[] strings4 = {"5", "0:1", "2:1", "3:2", "4:6", "4:3"};
//        System.out.println(getGasStation(strings4));
    }
}
