package listeners;

import animationsandgame.Counter;
import animationsandgame.GameLevel;
import interfaces.HitListener;
import shapes.Ball;
import shapes.Block;

/**Class listeners.BlockRemover.
 * in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * constructor to the blockRemover gets the game and the counter from outside function.
     * @param game the game with the balls.
     * @param counter counter of blocks that remains on screen.
     */
    public BlockRemover(GameLevel game, Counter counter) {
        this.game = game;
        remainingBlocks = counter;
    }
    /**
     * makes Blocks that are exist to be removed and remove their listener from the block.
     * @param beingHit block that is being hitted
     * @param hitter the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeFromGame(game);
        beingHit.removeHitListener(this);
    }
}