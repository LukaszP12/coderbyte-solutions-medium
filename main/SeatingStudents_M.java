import java.util.HashSet;
import java.util.Set;

public class SeatingStudents_M {

    public static int SeatingStudents_M(int[] arr) {
        int numDesk = arr[0];
        int possibleCombinations = 0;

        Set<Integer> occupiedDesks = new HashSet<>();

        for (int i = 1; i < arr.length; i++) {
            occupiedDesks.add(arr[i]);
        }

        for (int i = 1; i < numDesk; i += 2) {

            if (!occupiedDesks.contains(i) && !occupiedDesks.contains(i + 1)) {
                possibleCombinations++;
            }

            if ((i < numDesk - 1) && !occupiedDesks.contains(i) && !occupiedDesks.contains(i + 2)) {
                possibleCombinations++;
            }

            if ((i < numDesk - 1) && !occupiedDesks.contains(i + 1) && !occupiedDesks.contains(i + 3)) {
                possibleCombinations++;
            }

        }

        return possibleCombinations;
    }

    public static void main(String[] args) {
        int[] ints = {12, 2, 6, 7, 11};
        System.out.println(SeatingStudents_M(ints));
    }

}
