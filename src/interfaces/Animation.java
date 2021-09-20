package interfaces;

import biuoop.DrawSurface;
/**interface animation.
 * interface for all the animations in game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public interface Animation {
    /**
     * what the animation doing every frame.
     * @param d the drawing surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * true if the animation should stop.
     * @return true if the animation should stop, false to do more frames.
     */
    boolean shouldStop();
}