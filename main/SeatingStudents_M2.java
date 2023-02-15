import java.util.Arrays;

public class SeatingStudents_M2 {

    public static int getSeatingStudents(int[] arr) {
        int desks = arr[0];

        boolean[] occupied = new boolean[desks];
        Arrays.fill(occupied, false);

        for (int i = 1; i < arr.length; i++) {
            occupied[arr[i] - 1] = true;
        }

        int combinations = 0;

        for (int i = 0; i < occupied.length; i++) {
            if (i % 2 == 0) {
                if (!occupied[i] && !occupied[i + 1]) {
                    combinations++;
                }
                if (i >= 2 && !occupied[i] && !occupied[i - 2]) {
                    combinations++;
                }

            } else if (i % 2 == 1) {
                if (i >= 3 && !occupied[i] && !occupied[i - 2]) {
                    combinations++;
                }
            }

        }

        return combinations;
    }

    public static void main(String[] args) {
        int[] ints = {6, 4};
        System.out.println(getSeatingStudents(ints));

        int[] ints1 = {8, 1, 8};
        System.out.println(getSeatingStudents(ints1));
    }
}
