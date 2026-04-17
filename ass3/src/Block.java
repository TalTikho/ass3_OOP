import biuoop.DrawSurface;
import java.awt.Color;
/**
 * Represents a block in the game.
 */
public class Block implements Sprite, Collidable {
    private Rectangle rectangle;
    private Color color;
    /**
     * Constructor.
     *
     * @param rectangle the rectangle representing the block
     * @param color the color of the block
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        if ((rectangle.getTopLine().onLine(collisionPoint)) || (rectangle.getBottomLine().onLine(collisionPoint))) {
            dy *= -1;
        }

        if ((rectangle.getRightLine().onLine(collisionPoint)) || (rectangle.getLeftLine().onLine(collisionPoint))) {
            dx *= -1;
        }

        return new Velocity(dx, dy);
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
        // Blocks do not move, so this is empty
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
