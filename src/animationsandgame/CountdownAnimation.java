package animationsandgame;

import biuoop.DrawSurface;
import collections.SpriteCollection;
import interfaces.Animation;
import interfaces.Sprite;

import java.util.concurrent.TimeUnit;

/**Class CountdownAnimation
 * the animation the the countdown.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class CountdownAnimation implements Animation {
    private  double numOfSeconds; //num of seconds to show the animation
    private int countFrom; //count from which number.
    private int counter; //the counter from countfrom to zero.
    private Sprite background; //the background of the level.
    private SpriteCollection gameScreen; //all the sprites of the game.

    /**
     * Constructor of the class.initializing all the parameters.
     * @param numOfSeconds num of seconds to show the animation
     * @param countFrom count from which number.
     * @param gameScreen all the sprites of the game.
     * @param background the background of the level.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, Sprite background) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.counter = countFrom;
        this.background = background;
    }

    /**
     * what the animation doing in every frame.
     * it is first drawing the sprites and the background
     * and then drawing the needed text for number of seconds.
     * @param d the drawing surface.
     */
    public void doOneFrame(DrawSurface d) {
        background.drawOn(d); //drawing the background of the animation.
        gameScreen.drawAllOn(d); //draws all the sprites.
        d.setColor(java.awt.Color.red);
        //draws the text in red.
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + counter, 80);
        try {
            //sleeping for the needed time.
            TimeUnit.SECONDS.sleep(Math.round(numOfSeconds / countFrom));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter--;
    }

    /**
     * checks if the animation should stop.
     * stops if counter reaches zero.
     * @return true if counter is zero.
     */
    public boolean shouldStop() {
        if (counter < 0) {
            //it is counting till the counter is zero.
            return true;
        }
        return false;
    }
}