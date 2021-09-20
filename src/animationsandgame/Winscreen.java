package animationsandgame;

import biuoop.DrawSurface;
import interfaces.Animation;

/**Class WinScreen.
 * shows the winning screen and the loosing screen.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Winscreen implements Animation {
    private int score; //the current score.
    private boolean isWin; //is the player winning

    /**
     * Constuctor of the method.
     * @param score the current score.
     * @param winorloose is the player winning or loosing.
     */
    public Winscreen(int score, boolean winorloose) {
        this.score = score; //gets the score.
        this.isWin = winorloose;
    }

    /**
     * one frame of the method.
     * shows the needed text.
     * @param d the drawing surface.
     */
    public void doOneFrame(DrawSurface d) {
        String text; //text to show
        if (isWin) {
            //text if the player won.
            text = "You Win! Your Score is " + score;
        } else {
            //text if he lost.
            text = "Game Over. Your score is " + score;
        }
        //the place of that text on the screen.
        d.drawText(d.getWidth() / 3, d.getHeight() / 2, text, 32);
    }
    /**
     * true if the animation should stop.
     * @return false - it never stops.(till other method not stops it)
     */
    public boolean shouldStop() {
        return false;
    }
}