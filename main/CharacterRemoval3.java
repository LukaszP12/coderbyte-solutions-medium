package JavaRegex;

public class CharacterRemoval3 {

    private static int CharacterRemoval(String[] inputData) {
        String letters = inputData[0];
        String[] dictionary = inputData[1].split(",");
        int minRemoved = Integer.MAX_VALUE;

        for (String dictionaryEntry : dictionary) {
            int mainIndex = 0;
            int secondaryIndex = 0;
            int removalNumber = 0;

        }

        return 0;
    }

    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(CharacterRemoval(strings));

        String[] strings1 = {"apbpleeeef", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(CharacterRemoval(strings1));
    }
}
