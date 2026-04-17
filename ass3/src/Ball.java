//import biuoop.DrawSurface;
//
//public class Ball implements Sprite {
//    private Point center;
//    private int radius;
//    private java.awt.Color color;
//    private Velocity velocity;
//    private GameEnvironment gameEnvironment;
//
//    public Ball(Point center, int r, java.awt.Color color) {
//        this.center = center;
//        this.radius = r;
//        this.color = color;
//    }
//
//    public void setVelocity(Velocity v) {
//        this.velocity = v;
//    }
//
//    public void setVelocity(double dx, double dy) {
//        this.velocity = new Velocity(dx, dy);
//    }
//
//    public void moveOneStep() {
//        // Compute the ball trajectory
//        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
//        // Check for collisions
//        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
//
//        if (collisionInfo != null) {
//            // Move the ball to the collision point but slightly before it
//            Point collisionPoint = collisionInfo.collisionPoint();
//            this.center = new Point(collisionPoint.getX() - this.velocity.getDx() * 0.1,
//                    collisionPoint.getY() - this.velocity.getDy() * 0.1);
//
//            // Update velocity to new velocity after collision
//            this.velocity = collisionInfo.collisionObject().hit(collisionPoint, this.velocity);
//        } else {
//            // Move the ball to the end of the trajectory
//            this.center = this.velocity.applyToPoint(this.center);
//        }
//    }
//
//    @Override
//    public void drawOn(DrawSurface surface) {
//        surface.setColor(this.color);
//        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
//    }
//
//    @Override
//    public void timePassed() {
//        this.moveOneStep();
//    }
//
//    public void setGameEnvironment(GameEnvironment environment) {
//        this.gameEnvironment = environment;
//    }
//
//    public void addToGame(Game game) {
//        game.addSprite(this);
//    }
//}
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * Represents a ball in the game.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    /**
     * Constructor.
     *
     * @param center the center point of the ball
     * @param r the radius of the ball
     * @param color the color of the ball
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }
    /**
     * Set the velocity of the ball.
     *
     * @param v the velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * Set the velocity of the ball.
     *
     * @param dx the change in x
     * @param dy the change in y
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * Set the game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * Calculate the next position of the ball based on its current velocity.
     *
     * @return the next position of the ball
     */
    private Point nextPosition() {
        double dx = velocity.getDx();
        double dy = velocity.getDy();
        double newX = center.getX() + dx;
        double newY = center.getY() + dy;
        return new Point(newX, newY);
    }
    /**
     * Move the ball one step, checking for collisions.
     */
    public void moveOneStep() {
        Line trajectory = new Line(center, nextPosition());
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo == null) {
            center = nextPosition();
        } else {
            double collisionX = collisionInfo.collisionPoint().getX();
            double collisionY = collisionInfo.collisionPoint().getY();
            double dx = velocity.getDx();
            double dy = velocity.getDy();
            center = new Point(collisionX - dx, collisionY - dy);
            velocity = collisionInfo.collisionObject().hit(collisionInfo.collisionPoint(), velocity);
        }
    }
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }
    @Override
    public void timePassed() {
        moveOneStep();
    }
    /**
     * Adding to the game.
     * @param game game
     */
    public void addToGame(Game game) {
        game.addSprite(this);
    }
}

