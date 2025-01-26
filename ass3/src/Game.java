/**
 * ass 3
 * Tal Tikhonov
 * 215275512
 */
//import biuoop.GUI;
//import biuoop.DrawSurface;
//import biuoop.Sleeper;
//import biuoop.KeyboardSensor;
//
//import java.awt.*;
//
//public class Game {
//    private SpriteCollection sprites;
//    private GameEnvironment environment;
//    private GUI gui;
//    private Paddle paddle;
//
//    public Game() {
//        this.sprites = new SpriteCollection();
//        this.environment = new GameEnvironment();
//    }
//
//    public void addCollidable(Collidable c) {
//        this.environment.addCollidable(c);
//    }
//
//    public void addSprite(Sprite s) {
//        this.sprites.addSprite(s);
//    }
//
//    public void initialize() {
//        this.gui = new GUI("Arkanoid", 800, 600);
//        KeyboardSensor keyboard = this.gui.getKeyboardSensor();
//
//        // Create blocks and add them to the game
//        Block block1 = new Block(new Rectangle(new Point(100, 100), 20, 20), java.awt.Color.RED);
//        Block block2 = new Block(new Rectangle(new Point(200, 200), 20, 20), java.awt.Color.BLUE);
//        block1.addToGame(this);
//        block2.addToGame(this);
//
//        // Create balls and add them to the game
//        Ball ball1 = new Ball(new Point(50, 50), 5, java.awt.Color.BLACK);
//        ball1.setVelocity(2, 2);
//        ball1.setGameEnvironment(this.environment);
//        ball1.addToGame(this);
//
//        Ball ball2 = new Ball(new Point(60, 60), 5, java.awt.Color.BLACK);
//        ball2.setVelocity(2, 2);
//        ball2.setGameEnvironment(this.environment);
//        ball2.addToGame(this);
//
//        // Create and add the paddle to the game
//        Paddle paddle = new Paddle(new Rectangle(new Point(350, 570), 100, 20), Color.black, keyboard, 0, 800, 5);
//        paddle.addToGame(this);
//        this.paddle = paddle; // Assign to the field
//
//        // Ensure the paddle and balls are added to the game
//        paddle.addToGame(this);
//    }
//
//    public void run() {
//        Sleeper sleeper = new Sleeper();
//        int framesPerSecond = 60;
//        int millisecondsPerFrame = 1000 / framesPerSecond;
//
//        while (true) {
//            long startTime = System.currentTimeMillis();
//
//            DrawSurface d = gui.getDrawSurface();
//            this.sprites.drawAllOn(d);
//            gui.show(d);
//            this.sprites.notifyAllTimePassed();
//
//            long usedTime = System.currentTimeMillis() - startTime;
//            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
//            if (milliSecondLeftToSleep > 0) {
//                sleeper.sleepFor(milliSecondLeftToSleep);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Game game = new Game();
//        game.initialize();
//        game.run();
//    }
//}
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.awt.Color;
/**
 * The Game class manages a game instance.
 */
public class Game {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Sleeper sleeper;
    private KeyboardSensor keyboard;
    /**
     * Constructor.
     */
    public Game() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = new GUI("Game", 800, 600);
        this.sleeper = new Sleeper();
        this.keyboard = gui.getKeyboardSensor();
    }
    /**
     * Add a collidable object to the game.
     *
     * @param c the collidable object
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * Add a sprite to the game.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * Initialize the game: create the Blocks, Ball, Paddle and add them to the game.
     */
    public void initialize() {
        // Create and add paddle
        Paddle paddle = new Paddle(new Rectangle(new Point(350, 592), 100, 8), Color.black, keyboard, 15);
        paddle.addToGame(this);
        //this.paddle = paddle; // Assign to the field
        //addle.addToGame(this);

        // Create and add balls
        Ball ball1 = new Ball(new Point(400, 300), 5, Color.RED);
        ball1.setVelocity(Velocity.fromAngleAndSpeed(45, 5));
        ball1.setGameEnvironment(this.environment);
        ball1.addToGame(this);

        Ball ball2 = new Ball(new Point(450, 350), 5, Color.BLUE);
        ball2.setVelocity(Velocity.fromAngleAndSpeed(-45, 5));
        ball2.setGameEnvironment(this.environment);
        ball2.addToGame(this);

        // Create and add blocks
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.CYAN};
//        int blockWidth = 50;
//        int blockHeight = 20;
//        for (int i = 0; i < colors.length; i++) {
//            for (int j = 0; j < 10; j++) {
//                Block block = new Block(new Rectangle(new Point(20 + j * blockWidth, 50 + i * blockHeight)
//                , blockWidth, blockHeight), colors[i]);
//                block.addToGame(this);
//            }
//        }
        int rowY = 100;
        int maxBlocks = 12; // largest amount of blocks in a row
        for (int i = 0; i < 6; i++, rowY += 20) {
            Color randColor = colors[i];
            for (int j = 0; j < maxBlocks + 1 - i; j++) {
                Block block = new Block(
                        new Rectangle(new Point(800 - j * 50, rowY), 50, 20), randColor);
                block.addToGame(this);
            }
        }
//        int screenwidth = 800;
//        int screenheight = 600;
//        Block screen = new Block(new Rectangle(new Point(0, screenheight), screenwidth, screenheight) , Color.WHITE);
//        screen.addToGame(this);
        //Add border blocks
        Block block1 = new Block(new Rectangle(new Point(0, 0), 800, 0), Color.WHITE);
        Block block2 = new Block(new Rectangle(new Point(0, 0), 0, 600), Color.WHITE);
        Block block3 = new Block(new Rectangle(new Point(0, 600), 800, 0), Color.WHITE);
        Block block4 = new Block(new Rectangle(new Point(800, 0), 0, 600), Color.WHITE);
        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        block4.addToGame(this);
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;

        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            //that sets the color
//            d.setColor(Color.CYAN);
//            d.fillRectangle(0, 0, 800, 600);
            this.sprites.drawAllOn(d);
            gui.show(d);
            this.sprites.notifyAllTimePassed();
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}

