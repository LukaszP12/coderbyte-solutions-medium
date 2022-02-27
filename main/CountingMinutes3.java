package JavaRegex;

public class CountingMinutes3 {

    public static int CountingMinutes3(String str) {
        String fTime = str.split("-")[0];
        String lTime = str.split("-")[1];
        int fHours = Integer.parseInt(fTime.split(":")[0]);
        int lHours = Integer.parseInt(lTime.split(":")[0]);
        int fMin = Integer.parseInt(fTime.substring(fTime.length() - 4, fTime.length() - 2));
        int lMin = Integer.parseInt(fTime.substring(lTime.length() - 4, lTime.length() - 2));

        if (fTime.contains("p") && fHours != 12) {
            fHours += 12;
        } else if (fTime.contains("a") && fHours == 12) {
            fHours -= 12;
        }
        if (lTime.contains("p") && lHours != 12) {
            lHours += 12;
        } else if (lTime.contains("a") && lHours == 12) {
            lHours -= 12;
        }

        int tMin = lMin - fMin;
        int tH = lHours - fHours;
        int total = (tH * 60) + tMin;
        if (total < 0) {
            total += (24 * 60);
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(CountingMinutes3("12:30pm-12:00am"));
    }

}
