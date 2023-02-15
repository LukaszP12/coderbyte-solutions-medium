import java.util.ArrayList;
import java.util.List;

public class EightQueens_M {

    public static String getEightQueens(String[] strArr) {

        List<Piece> pieces = createPieces(strArr);

        for (int i = 0; i < pieces.size(); i++) {
            Piece piece1 = pieces.get(i);
            for (int j = 0; j < pieces.size(); j++) {
                Piece piece2 = pieces.get(j);

                if (i != j && piece1.getX() == piece2.getX()) {
                    return "(" + piece1.getX() + "," + piece1.getY() + ")";
                }

                if (i != j && piece1.getY() == piece2.getY()) {
                    return "(" + piece1.getX() + "," + piece1.getY() + ")";
                }

                if (i != j && Math.abs(piece1.getX() - piece2.getX()) == Math.abs(piece1.getY() - piece2.getY())) {
                    return "(" + piece1.getX() + "," + piece1.getY() + ")";
                }

            }

        }

        return "true";
    }

    private static List<Piece> createPieces(String[] strArr) {
        List<Piece> pieces = new ArrayList<>();

        for (String s : strArr) {
            String[] split = s.substring(1, s.length() - 1).split(",");
            Piece piece = new Piece(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            pieces.add(piece);
        }

        return pieces;
    }

    static public class Piece {
        int x;
        int y;

        public Piece(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Piece{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

    }

    public static void main(String[] args) {
        String[] strings = {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)", "(5,8)"};
        System.out.println(getEightQueens(strings));

        String[] strings1 = {"(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)", "(7,7)", "(5,8)"};
        System.out.println(getEightQueens(strings1));
    }

}
