/**
 * ass 3
 * Tal Tikhonov
 * 215275512
 */
//import java.util.ArrayList;
//import java.util.List;
//
//public class GameEnvironment {
//    private List<Collidable> collidables;
//
//    public GameEnvironment() {
//        this.collidables = new ArrayList<>();
//    }
//
//    public void addCollidable(Collidable c) {
//        this.collidables.add(c);
//    }
//
//    public CollisionInfo getClosestCollision(Line trajectory) {
//        CollisionInfo closestCollision = null;
//        double closestDistance = Double.POSITIVE_INFINITY;
//
//        for (Collidable c : this.collidables) {
//            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
//            if (collisionPoint != null) {
//                double distance = trajectory.start().distance(collisionPoint);
//                if (distance < closestDistance) {
//                    closestCollision = new CollisionInfo(collisionPoint, c);
//                    closestDistance = distance;
//                }
//            }
//        }
//
//        return closestCollision;
//    }
//}
//
import java.util.ArrayList;
import java.util.List;
/**
 * The GameEnvironment class manages all the collidable objects in the game.
 */
public class GameEnvironment {
    private List<Collidable> collidables;
    /**
     * Constructor.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }
    /**
     * Add a collidable to the environment.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    /**
     * Get the closest collision information if a ball were to move along a given trajectory.
     *
     * @param trajectory the line representing the ball's trajectory
     * @return the closest collision information, or null if no collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo closestCollision = null;
        double closestDistance = Double.MAX_VALUE;

        for (Collidable collidable : collidables) {
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (collisionPoint != null) {
                double distance = trajectory.start().distance(collisionPoint);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestCollision = new CollisionInfo(collisionPoint, collidable);
                }
            }
        }

        return closestCollision;
    }
    /**
     * Get the list of collidables.
     *
     * @return the list of collidables
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }
}

