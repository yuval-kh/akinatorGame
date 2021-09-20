package animationsandgame;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;

/**Class AnimationRunner.
 * the loop of a specific animation
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class AnimationRunner {
    private GUI gui; //the gui of the game.
    private int framesPerSecond; //frames per second of the animation.

    /**
     *  AnimationRunner constructor.
     *  gets the gui from other method and initializing to 60 frames per second.
     * @param gui gets it from other method.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
    }

    /**
     * the loop of an animation.
     * @param animation the animation that is being done.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (!animation.shouldStop()) {
            //runs the animation frame by frame until it should stop.
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d); //one frame of an animation.
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}