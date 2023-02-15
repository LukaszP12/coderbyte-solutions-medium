public class OverlappingRectangles {

    static class Point {
        int x, y;
    }

    static boolean doOverlap(Point l1, Point l2, Point r1, Point r2) {

        // if rectangle has area 0, no overlap
        if (l1.x == r1.x || l1.y == r1.y || r2.x == l2.x || l2.y == r2.y) {
            return false;
        }

        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }

        // If one rectangle is above other
        if (r1.y > l2.y || r2.y > l1.y) {
            return false;
        }


        return true;
    }

    public static void main(String[] args) {
        Point l1 = new Point();
        Point r1 = new Point();
        Point l2 = new Point();
        Point r2 = new Point();

        l1.x = 0;
        l1.y = 10;
        r1.x = 10;
        r1.y = 0;
        l2.x = 5;
        l2.y = 5;
        r2.x = 15;
        r2.y = 0;

        if (doOverlap(l1, r1, l2, r2)) {
            System.out.println("Rectangles Overlap");
        } else {
            System.out.println("Rectangles Don't Overlap");
        }

    }
}
