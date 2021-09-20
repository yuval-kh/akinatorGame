package levels;

import animationsandgame.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;

/**Class DirectHitBackground.
 *  background for direct hit level.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class DirectHitBackground implements Sprite {
    /**
     * draws the background on the screen.
     * @param d the drawing surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.black);
        int width = GameLevel.getWIDTH();
        int height = GameLevel.getHEIGHT();
        d.fillRectangle(0, 0, width, height); //makes black background.
        d.setColor(java.awt.Color.BLUE); //draw blue lines and circles.
        int circleX = 415;
        int circleY = 135;
        int smallerRadius = 50;
        d.drawCircle(circleX, circleY, smallerRadius);
        d.drawCircle(circleX, circleY, smallerRadius + 30);
        d.drawCircle(circleX, circleY, smallerRadius + 60);
        d.drawLine(width / 2 - 100, circleY, width / 2 - 5, 135);
        d.drawLine(width / 2 + 10, circleY, width / 2 + 130, 135);
        d.drawLine(circleX, 0, width / 2 + 15, 115);
        d.drawLine(circleX, 125, width / 2 + 15, 250);
    }

    /**
     * what to do as the time passes in the game.
     */
    @Override
    public void timePassed() {

    }
}
