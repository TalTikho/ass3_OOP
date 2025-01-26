/**
 * ass 3
 * Tal Tikhonov
 * 215275512
 */
//public interface Collidable {
//    Rectangle getCollisionRectangle();
//    Velocity hit(Point collisionPoint, Velocity currentVelocity);
//}
/**
 * The Collidable interface represents objects that can be collided with.
 */
public interface Collidable {
    /**
     * Get the collision rectangle.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that it has been hit.
     *
     * @param collisionPoint the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity after the hit
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}

