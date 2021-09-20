package levels;

import animationsandgame.GameLevel;
import biuoop.DrawSurface;
import interfaces.Sprite;

/**Class Green3Background.
 * the background for the third level.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Green3Background implements Sprite {
    /**
     * draws the background.
     * @param d the drawing surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int width = GameLevel.getWIDTH();
        int height = GameLevel.getHEIGHT();
        d.setColor(new java.awt.Color(42, 130, 21));
        d.fillRectangle(0, 0, width, height); //draws the solid color.
        d.setColor(java.awt.Color.black);
        d.fillRectangle(50, 400, 100, 200); //draws the building.
        d.setColor(java.awt.Color.white);
        int startX = 55; //X of first window
        int startY = 405; //Y of first window
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                //draws all the windows.
                d.fillRectangle(startX + 20 * j, startY + 30 * i, 10, 25);
            }
        }
        //the two rectangles on the building.
        d.setColor(new java.awt.Color(62, 58, 57));
        d.fillRectangle(85, 350, 30, 50);
        d.setColor(new java.awt.Color(78, 74, 73));
        d.fillRectangle(95,  200,  10,  150);
        d.setColor(new java.awt.Color(216, 172, 102));
        //the light of the building(three circles)
        d.fillCircle(100, 190, 10);
        d.setColor(java.awt.Color.red);
        d.fillCircle(100, 190, 7);
        d.setColor(java.awt.Color.white);
        d.fillCircle(100, 190, 3);
    }

    /**
     * what to do as the time of the game passes.
     */
    @Override
    public void timePassed() {

    }
}