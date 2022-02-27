package JavaRegex;

public class MatrixPath3 {

    public static String MatrixPath(String[] strArr) {
        char[][] a = new char[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            a[i] = strArr[i].toCharArray();
        }

//        if (findPath())

        return "";
    }

    static boolean findPath(char[][] a, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length) return false;
        if (visited[i][j]) return false;

        visited[i][j] = true;
        char c = a[i][j];
        if (c == '0') return false;


        return false;
    }

    public static void main(String[] args) {

    }

}
