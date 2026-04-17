//public class CollisionInfo {
//    private Point collisionPoint;
//    private Collidable collisionObject;
//
//    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
//        this.collisionPoint = collisionPoint;
//        this.collisionObject = collisionObject;
//    }
//
//    public Point collisionPoint() {
//        return this.collisionPoint;
//    }
//
//    public Collidable collisionObject() {
//        return this.collisionObject;
//    }
//}
//
/**
 * Holds information about a collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * Constructor.
     *
     * @param collisionPoint the point at which the collision occurs
     * @param collisionObject the collidable object involved in the collision
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * Get the collision point.
     *
     * @return the collision point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }
    /**
     * Get the collidable object involved in the collision.
     *
     * @return the collidable object
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}

