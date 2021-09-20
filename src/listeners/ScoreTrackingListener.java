package listeners;

import animationsandgame.Counter;
import interfaces.HitListener;
import shapes.Ball;
import shapes.Block;

/**Class listeners.ScoreTrackingListener.
 * listener to change the score.
 * @author Yuval Khanimov
 * <yuval953@gmail.com>
 * ID 318970902 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore; //the counter of the score.

    /**
     * Constructor of the class.
     * @param scoreCounter gets the counter from other function.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * as block being hit adds 5 to the score.
     * @param beingHit  the block that's being hit.
     * @param hitter the shapes.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
    currentScore.increase(5);
    }
}