/**
 * ass 3
 * Tal Tikhonov
 * 215275512
 */
//import biuoop.DrawSurface;
//import biuoop.KeyboardSensor;
//
//import java.awt.Color;
//
///**
// * Represents the paddle in the game.
// * The paddle is controlled by the player using the keyboard.
// */
//public class Paddle implements Sprite, Collidable {
//    private Rectangle rectangle;
//    private Color color;
//    private KeyboardSensor keyboard;
//    private int leftBoundary;
//    private int rightBoundary;
//    private int speed;
//
//    /**
//     * Constructor for the Paddle.
//     *
//     * @param rectangle   the shape of the paddle.
//     * @param color       the color of the paddle.
//     * @param keyboard    the keyboard sensor.
//     * @param leftBoundary the left boundary of the paddle's movement.
//     * @param rightBoundary the right boundary of the paddle's movement.
//     * @param speed       the speed of the paddle.
//     */
//    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboard,
//                  int leftBoundary, int rightBoundary, int speed) {
//        this.rectangle = rectangle;
//        this.color = color;
//        this.keyboard = keyboard;
//        this.leftBoundary = leftBoundary;
//        this.rightBoundary = rightBoundary;
//        this.speed = speed;
//    }
//
//    /**
//     * Moves the paddle left by the speed amount.
//     */
//    public void moveLeft() {
//        double newX = Math.max(leftBoundary, this.rectangle.getUpperLeft().getX() - this.speed);
//        this.rectangle = new Rectangle(new Point(newX, this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight());
//    }
//
//    /**
//     * Moves the paddle right by the speed amount.
//     */
//    public void moveRight() {
//        double newX = Math.min(rightBoundary - this.rectangle.getWidth(), this.rectangle.getUpperLeft().getX() + this.speed);
//        this.rectangle = new Rectangle(new Point(newX, this.rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight());
//    }
//
//    /**
//     * Moves the paddle according to the pressed keys.
//     */
//    @Override
//    public void timePassed() {
//        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
//            moveLeft();
//        }
//        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
//            moveRight();
//        }
//    }
//
//    /**
//     * Draws the paddle on the given DrawSurface.
//     *
//     * @param d the DrawSurface to draw on.
//     */
//    @Override
//    public void drawOn(DrawSurface d) {
//        d.setColor(this.color);
//        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
//                (int) this.rectangle.getUpperLeft().getY(),
//                (int) this.rectangle.getWidth(),
//                (int) this.rectangle.getHeight());
//    }
//
//    /**
//     * Returns the shape of the paddle.
//     *
//     * @return the shape of the paddle.
//     */
//    @Override
//    public Rectangle getCollisionRectangle() {
//        return this.rectangle;
//    }
//
//    /**
//     * Handles the ball hitting the paddle and changes its velocity according to the hit region.
//     *
//     * @param collisionPoint  the point where the collision occurs.
//     * @param currentVelocity the current velocity of the ball.
//     * @return the new velocity of the ball.
//     */
//    @Override
//    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
//        double regionWidth = this.rectangle.getWidth() / 5;
//        double hitX = collisionPoint.getX() - this.rectangle.getUpperLeft().getX();
//
//        if (hitX < regionWidth) {
//            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
//        } else if (hitX < 2 * regionWidth) {
//            return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
//        } else if (hitX < 3 * regionWidth) {
//            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
//        } else if (hitX < 4 * regionWidth) {
//            return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
//        } else {
//            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
//        }
//    }
//
//    /**
//     * Adds the paddle to the game.
//     *
//     * @param game the game to add the paddle to.
//     */
//    public void addToGame(Game game) {
//        game.addSprite(this);
//        game.addCollidable(this);
//    }
//}
//
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * The Paddle class represents the player's paddle in the game.
 */
public class Paddle implements Sprite, Collidable {
    private Rectangle rectangle;
    private Color color;
    private KeyboardSensor keyboard;
    private double speed;
    /**
     * Constructor for Paddle.
     *
     * @param rectangle the rectangle representing the paddle
     * @param color the color of the paddle
     * @param keyboard the keyboard sensor
     * @param speed the speed of the paddle
     */
    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboard, double speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboard;
        this.speed = speed;
    }
    /**
     * Moving left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() <= 0) {
            this.rectangle = new Rectangle(new Point(800 - this.rectangle.getWidth(),
                    this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        } else {
            this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() - speed,
                    this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }
    /**
     * Moving right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() >= 800) {
            this.rectangle = new Rectangle(new Point(0, this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        } else {
            this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() + speed,
                    this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double speed = currentVelocity.getSpeed();
        int region = (int)
                ((collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) / (this.rectangle.getWidth() / 5)) + 1;
        switch (region) {
            case 1:
                return Velocity.fromAngleAndSpeed(300, speed);
            case 2:
                return Velocity.fromAngleAndSpeed(330, speed);
            case 4:
                return Velocity.fromAngleAndSpeed(30, speed);
            case 5:
                return Velocity.fromAngleAndSpeed(60, speed);
            default:
                return new Velocity(dx, -dy);
        }
    }
    @Override
    public void drawOn(DrawSurface surface) {
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, width, height);
        surface.setColor(this.color);
        surface.fillRectangle(x, y, width, height);
    }
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    /**
     * Adding to the game.
     * @param game game
     */
    public void addToGame(Game game) {
        game.addCollidable(this);
        game.addSprite(this);
    }
}

