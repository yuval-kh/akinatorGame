package animationsandgame;

import biuoop.DrawSurface;
import interfaces.Animation;

/**Class PauseScreen.
 * creates the animation of the pause screen.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class PauseScreen implements Animation {
    /**
     * do one frame of the animation- drawing the text.
     * @param d the drawing surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);

    }

    /**
     * when the animation should stop.
     * @return false - it never stops (till other method stops it)
     */
    public boolean shouldStop() {
        return false;
    }
}