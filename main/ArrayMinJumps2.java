package JavaRegex;

class ArrayMinJumps2 {
    static int minimumJumpNumber = Integer.MAX_VALUE;

    public static int ArrayMinJumps2(int[] inputArray) {
        schemesOfJump(inputArray, 0, 0);

        return (minimumJumpNumber < Integer.MAX_VALUE) ? minimumJumpNumber : -1;
    }

    public static void schemesOfJump(int[] inputArray, int index, int count) {
        if (index >= inputArray.length - 1) {
            if (count < minimumJumpNumber)
                minimumJumpNumber = count;

            return;
        }

        for (int secondaryIndex = index + 1; secondaryIndex <= index + inputArray[index]; ++secondaryIndex)
            schemesOfJump(inputArray, secondaryIndex, count + 1);
    }

    public static void main(String[] args) {
        int[] ints1 = {3, 4, 2, 1, 1, 100};
        int[] ints2 = {1, 3, 6, 8, 2, 7, 1, 2, 1, 2, 6, 1, 2, 1, 2};

        System.out.println(ArrayMinJumps2(ints1));
        System.out.println(ArrayMinJumps2(ints2));
    }
}