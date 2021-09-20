package levels;

import animationsandgame.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;

/**Class collections.GameEnvironment.
 * background for final level.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class FinalFourBackground  implements Sprite {
    /**
     * draws the background.
     * @param d the drawing surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int width = GameLevel.getWIDTH();
        int height = GameLevel.getHEIGHT();
        d.setColor(new java.awt.Color(23, 136, 208));
        d.fillRectangle(0, 0, width, height); //the background
        //first rain lines
        d.setColor(java.awt.Color.white);
        for (int i = 0; i < 10; i++) {
            //draw 10 rain lines.
            d.drawLine(80 + 10 * i, height / 2 + 70, 60 + 10 * i, height);
        }
        //second rain lines.
        d.setColor(java.awt.Color.white);
        for (int i = 0; i < 10; i++) {
            //draw 10 more lines for the rain in second cloud.
            d.drawLine(580 + 10 * i, 470, 560 + 10 * i, height);
        }
        //draw all circles of the first cloud
        d.setColor(new java.awt.Color(204, 204, 204));
        d.fillCircle(80, 370, 22);
        d.fillCircle(110, 390, 25);
        d.setColor(new java.awt.Color(187, 187, 187));
        d.fillCircle(120, 350, 30);
        d.setColor(new java.awt.Color(170, 170, 170));
        d.fillCircle(150, 385, 20);
        d.fillCircle(170, 360, 30);
        //draw all circles of the second cloud
        d.setColor(new java.awt.Color(204, 204, 204));
        d.fillCircle(580, 470, 22);
        d.fillCircle(610, 490, 25);
        d.setColor(new java.awt.Color(187, 187, 187));
        d.fillCircle(620, 450, 30);
        d.setColor(new java.awt.Color(170, 170, 170));
        d.fillCircle(650, 485, 20);
        d.fillCircle(670, 460, 30);
    }

    /**
     * what to do as the time passes in game.
     */
    @Override
    public void timePassed() {

    }
}