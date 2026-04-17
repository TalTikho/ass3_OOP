//import biuoop.DrawSurface;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SpriteCollection {
//    private List<Sprite> sprites;
//
//    public SpriteCollection() {
//        this.sprites = new ArrayList<>();
//    }
//
//    public void addSprite(Sprite s) {
//        this.sprites.add(s);
//    }
//
//    public void notifyAllTimePassed() {
//        for (Sprite s : new ArrayList<>(this.sprites)) {
//            s.timePassed();
//        }
//    }
//
//    public void drawAllOn(DrawSurface d) {
//        for (Sprite s : this.sprites) {
//            s.drawOn(d);
//        }
//    }
//}
//
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * The SpriteCollection class manages a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;
    /**
     * Constructor.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }
    /**
     * Add a sprite to the collection.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }
    /**
     * Call drawOn for all sprites in the collection.
     *
     * @param d the DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
    /**
     * Notify all sprites that time has passed.
     */
    public void notifyAllTimePassed() {
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }
    }
}

