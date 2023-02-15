import java.util.ArrayList;
import java.util.List;

public class OverlappingRectangles_M {

    public static int OverlappingRectangles(String[] strArr) {

        List<Point> points = new ArrayList<>();

        String[] strings = strArr[0].split("\\),");

        for (int i = 0; i < 4; i++) {
            String[] split = strings[i].substring(1).split(",");
            Point p1 = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            points.add(p1);
        }
        Rectangle rectangle = new Rectangle(points);
        points = new ArrayList<>();

        for (int i = 4; i < 7; i++) {
            String[] split = strings[i].substring(1).split(",");
            Point p1 = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            points.add(p1);
        }
        String[] split = strings[7].substring(1, strings[7].length() - 1).split(",");
        points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));

        Rectangle rectangle2 = new Rectangle(points);

        boolean isOverlapping = rectangle.isOverlapping(rectangle2);

        if (!isOverlapping) {
            return 0;
        } else {
            int overlappingArea = rectangle.overlappingArea(rectangle2);

            return overlappingArea != 0 ? (rectangle.getArea() / overlappingArea) : 0;
        }

    }

    public static class Rectangle {
        List<Point> points = new ArrayList<Point>();

        Point bottomLeft;
        Point topRight;

        boolean isOverlapping(Rectangle other) {
            if (this.topRight.y < other.bottomLeft.y ||
                    this.bottomLeft.y > other.topRight.y) {
                return false;
            }

            if (this.topRight.x < other.bottomLeft.x ||
                    this.bottomLeft.x > other.topRight.x) {
                return false;
            }

            return true;
        }

        int getArea() {

            int x1 = topRight.x;
            int y1 = topRight.y;

            int x2 = bottomLeft.x;
            int y2 = bottomLeft.y;

            return (Math.abs(x1 - x2)) * (Math.abs(y1 - y2));
        }

        int overlappingArea(Rectangle other) {

            // intersecting part
            int x_dist = Math.min(this.topRight.x, other.topRight.x)
                    - Math.max(this.bottomLeft.x, other.bottomLeft.x);

            int y_dist = Math.min(this.topRight.y, other.topRight.y)
                    - Math.max(this.bottomLeft.y, other.bottomLeft.y);

            int interArea = 0;
            if (x_dist > 0 && y_dist > 0) {
                interArea = x_dist * y_dist;
            }

            return interArea;
        }

        public Rectangle(List<Point> points) {
            this.points = points;

            bottomLeft = findBottomLeft(points);

            topRight = findTopRight(points);

        }


        private Point findBottomRight(List<Point> points) {
            int x = Integer.MIN_VALUE, y = Integer.MAX_VALUE;

            for (Point point : points) {
                if (point.y < y) {
                    y = point.y;
                    x = point.x;
                }
                if (point.y == y && point.x > x) {
                    y = point.y;
                    x = point.x;
                }
            }

            return new Point(x, y);
        }

        private Point findBottomLeft(List<Point> points) {
            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;

            for (Point point : points) {
                if (point.y < y) {
                    y = point.y;
                    x = point.x;
                }
                if (point.y == y && point.x < x) {
                    y = point.y;
                    x = point.x;
                }
            }

            return new Point(x, y);
        }

        private Point findTopRight(List<Point> points) {
            int x = Integer.MIN_VALUE;
            int y = 0;

            for (Point point : points) {
                if (point.x > x) {
                    x = point.x;
                    y = point.y;
                }
                if (point.x == x && point.y > y) {
                    x = point.x;
                    y = point.y;
                }
            }

            return new Point(x, y);
        }

        private Point findTopLeft(List<Point> points) {
            int x = Integer.MAX_VALUE;
            int y = 0;

            for (Point point : points) {
                if (point.x < x) {
                    x = point.x;
                    y = point.y;
                }
                if (point.x == x && point.y > y) {
                    x = point.x;
                    y = point.y;
                }
            }

            return new Point(x, y);
        }

    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        String[] strings = {"(0,0),(0,-2),(3,0),(3,-2),(2,-1),(3,-1),(2,3),(3,3)"};
        System.out.println(OverlappingRectangles(strings));

        String[] strings1 = {"(0,0),(5,0),(0,2),(5,2),(2,1),(5,1),(2,-1),(5,-1)"};
        System.out.println(OverlappingRectangles(strings1));

        String[] strings2 = {"(0,0),(1,0),(0,1),(1,1),(0,0),(2,0),(0,-1),(2,-1)"};
        System.out.println(OverlappingRectangles(strings2));
    }

}
