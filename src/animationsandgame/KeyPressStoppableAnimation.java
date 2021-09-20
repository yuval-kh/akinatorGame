package animationsandgame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**Class KeyPressStoppableAnimation.
 * makes an animation to stop when key is pressed.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor ks; //the keyboard sensor for the animation.
    private String key; //the key to stop the animation.
    private Animation animation; //the previous animation.
    private boolean stop; //to stop it or not.
    private boolean isAlreadyPressed; //is the key is pressed before or not.

    /**
     * Constructor of the class.
     * @param sensor the keyboard sensor.
     * @param key needed key.
     * @param animation animation to  stop.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.ks = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        isAlreadyPressed = true;
    }

    /**
     * what to do in one frame of this animation.
     * every frame it checks if the needed key is pressed or not
     * if it is stops the animation.
     * @param d the drawing surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.ks.isPressed(key)) {
            //if the key is not pressed changes the parameter.
            isAlreadyPressed = false;
        }
        if (this.isAlreadyPressed) {
            //if key is already pressed do nothing.
            return;
        }
        if (this.ks.isPressed(key)) {
            //if key is pressed stop the animation.
            this.stop = true;
        }
        animation.doOneFrame(d); //do one frame of the animation that is stopped.
    }

    /**
     * returns true if the animation should stop.
     * @return in this case the stop parameter doing it.
     */
    @Override
    public boolean shouldStop() {
        //returns this.stop to stop the animation in the next frame.
        return this.stop;
    }
}