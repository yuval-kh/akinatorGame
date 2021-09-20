package collections;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.List;
/**Class collections.GameEnvironment.
 * maintains a list of all the sprites objects in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class SpriteCollection {
    private List<Sprite> sprites; //list of all the sprites.

    /**
     * initializing the list.
     */
    public SpriteCollection() {
        sprites = new java.util.ArrayList<Sprite>();
    }

    /**
     * add the given sprite to the list.
     * @param s the new sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new java.util.ArrayList<Sprite>(this.sprites);
        for (Sprite s:spritesCopy) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d the drawing surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s:sprites) {
            s.drawOn(d);
        }
    }
    /**
     * removes a sprite from the sprites list.
     * @param s the sprite that is being removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}