public class OverlappingRectangles_2 {

    // 1.One of the two rectangles is above the top edge of the other rectangle
    // 2.One of the two rectangles is on the left side of the left edge of the other rectangle

    public static class Rectangle {
        private Point bottomLeft;
        private Point topRight;
        private Point bottomRight;
        private Point topLeft;

        public Rectangle(Point bottomLeft, Point topRight, Point bottomRight, Point topLeft) {
            this.bottomLeft = bottomLeft;
            this.topRight = topRight;
            this.bottomRight = bottomRight;
            this.topLeft = topLeft;
        }

        public Point getBottomLeft() {
            return bottomLeft;
        }

        public void setBottomLeft(Point bottomLeft) {
            this.bottomLeft = bottomLeft;
        }

        public Point getTopRight() {
            return topRight;
        }

        public void setTopRight(Point topRight) {
            this.topRight = topRight;
        }

        public Point getBottomRight() {
            return bottomRight;
        }

        public void setBottomRight(Point bottomRight) {
            this.bottomRight = bottomRight;
        }

        public Point getTopLeft() {
            return topLeft;
        }

        public void setTopLeft(Point topLeft) {
            this.topLeft = topLeft;
        }

        boolean isOverlapping(Rectangle other) {
            if (this.topRight.getY() < other.bottomLeft.getY()
                    || this.bottomLeft.getY() > other.topRight.getY()) {
                return false;
            }
            if (this.topRight.getX() < other.bottomLeft.getX()
                    || this.bottomLeft.getX() > other.topRight.getX()) {
                return false;
            }

            return true;
        }

    }


    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
