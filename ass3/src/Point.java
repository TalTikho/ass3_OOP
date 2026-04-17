//public class Point {
//    private double x;
//    private double y;
//
//    public Point(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public double getX() {
//        return this.x;
//    }
//
//    public double getY() {
//        return this.y;
//    }
//
//    public double distance(Point other) {
//        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
//    }
//
//    public boolean equals(Point other) {
//        return this.x == other.x && this.y == other.y;
//    }
//}
//
/**
 * Represents a point in a 2D space.
 */
public class Point {
    private double x;
    private double y;
    /**
     * Constructor.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Get the x-coordinate.
     *
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }
    /**
     * Get the y-coordinate.
     *
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }
    /**
     * Calculate the distance to another point.
     *
     * @param other the other point
     * @return the distance to the other point
     */
    public double distance(Point other) {
        return Math.sqrt((x - other.getX()) * (x - other.getX())
                +
                (y - other.getY()) * (y - other.getY()));
    }
}

