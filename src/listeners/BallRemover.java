package listeners;

import animationsandgame.Counter;
import animationsandgame.GameLevel;
import interfaces.HitListener;
import shapes.Ball;
import shapes.Block;

/**
 * Class listeners.BallRemover.
 * listeners.BallRemover is a Listener that follows the number of balls in game
 * @author Yuval Khanimov
 * <yuval953@gmail.com>
 * ID 318970902 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor to the ballRemover gets the game and the counter from the game.
     * @param game the game with the balls.
     * @param counter counter of balls.
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        remainingBalls = counter;
    }

    /**
     * what happends to the ball after the hit. it removed from game and the number of ball is decreasing.
     * @param beingHit the block that is being hit
     * @param hitter the block that the ball hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
}