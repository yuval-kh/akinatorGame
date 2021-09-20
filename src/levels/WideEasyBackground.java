package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;

/**Class WideEasyBackground.
 * maintains a list of all the collidable objects in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class WideEasyBackground implements Sprite {
    /**
     * draws the background.
     * @param d the drawing surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.white);
        d.fillRectangle(0, 0, 800, 600); //the background color.
        for (int i = 0; i < 150; i++) {
            //draws all the lines going out of the sun.
            d.setColor(new java.awt.Color(239, 231, 176));
            d.drawLine(120, 125, 5 * i, 225);
        }
        //drawing all the circles: from the outer to inner one.
        d.setColor(new java.awt.Color(239, 231, 176));
        d.fillCircle(120, 125, 50);
        d.setColor(new java.awt.Color(255, 219, 3));
        d.fillCircle(120, 125, 40);
        d.setColor(new java.awt.Color(255, 244, 74));
        d.fillCircle(120, 125, 30);
    }

    /**
     * what to do as the time of the level passes.
     */
    @Override
    public void timePassed() {

    }
}
