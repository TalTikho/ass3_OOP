//public class Velocity {
//    private double dx;
//    private double dy;
//
//    /**
//     * Constructor for Velocity.
//     *
//     * @param dx the change in x direction
//     * @param dy the change in y direction
//     */
//    public Velocity(double dx, double dy) {
//        this.dx = dx;
//        this.dy = dy;
//    }
//
//    /**
//     * @return the change in x direction
//     */
//    public double getDx() {
//        return dx;
//    }
//
//    /**
//     * @return the change in y direction
//     */
//    public double getDy() {
//        return dy;
//    }
//
//    /**
//     * Returns the speed of the velocity vector.
//     *
//     * @return the speed
//     */
//    public double getSpeed() {
//        return Math.sqrt(dx * dx + dy * dy);
//    }
//
//    /**
//     * Returns a Velocity instance based on an angle and speed.
//     *
//     * @param angle the angle in degrees
//     * @param speed the speed
//     * @return a new Velocity instance
//     */
//    public static Velocity fromAngleAndSpeed(double angle, double speed) {
//        double angleInRadians = Math.toRadians(angle);
//        double dx = speed * Math.sin(angleInRadians);
//        double dy = -speed * Math.cos(angleInRadians);
//        return new Velocity(dx, dy);
//    }
//
//    /**
//     * Applies this velocity to a point, returning a new point.
//     *
//     * @param p the point to which the velocity is applied
//     * @return a new point with the applied velocity
//     */
//    public Point applyToPoint(Point p) {
//        return new Point(p.getX() + dx, p.getY() + dy);
//    }
//}
//
//
/**
 * Represents the velocity of a moving object.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * Constructor.
     *
     * @param dx the change in x
     * @param dy the change in y
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * Get the change in x.
     *
     * @return the change in x
     */
    public double getDx() {
        return dx;
    }
    /**
     * Get the change in y.
     *
     * @return the change in y
     */
    public double getDy() {
        return dy;
    }
    /**
     * Apply the velocity to a point.
     *
     * @param p the point
     * @return the new point after applying the velocity
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }
    /**
     * Get the speed (magnitude) of the velocity.
     *
     * @return the speed
     */
    public double getSpeed() {
        return Math.sqrt(dx * dx + dy * dy);
    }
    /**
     * Create a velocity from an angle and a speed.
     *
     * @param angle the angle in degrees
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleInRadians = Math.toRadians(angle);
        double dx = speed * Math.sin(angleInRadians);
        double dy = -speed * Math.cos(angleInRadians);
        return new Velocity(dx, dy);
    }
}

