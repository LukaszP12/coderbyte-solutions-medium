package JavaRegex;

public class CountingMinutes {

    public static String CountingMinutes(String str) {
        String[] times = str.split("-");
        int startTime = getTimeInMinutes(times[0]);
        int endTime = getTimeInMinutes(times[1]);
        if (endTime < startTime) {
            endTime += 24 * 60;
        }

        return String.valueOf(endTime - startTime);
    }

    static int getTimeInMinutes(String time) {
        boolean isAm = false;
        int index = time.indexOf("am");
        if (index > 0) {
            isAm = true;
        }
        time = time.substring(0, time.length() - 2);

        String[] times = time.split(":");

        int minutes = 60 * Integer.valueOf(times[0]) + Integer.valueOf(times[1]);
        if (!isAm) {
            minutes += 12 * 60;
        }
        return minutes;
    }

    public static void main(String[] args) {

    }

}
