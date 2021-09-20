package interfaces;

import shapes.Ball;
import shapes.Block;

/**Class interfaces.HitListener.
 * Hit listener interface for the blocks.
 * describers what happened after a block is being hit.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit  the block that's being hit.
     * @param hitter the shapes.Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}