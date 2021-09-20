package interfaces;

import biuoop.DrawSurface;
/**interface interfaces.Sprite.
 * describes a sprite in the game.
 * @author Yuval Khanimov
 * <yuval953@gmail.com>
 * ID 318970902 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the drawing surface.
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}