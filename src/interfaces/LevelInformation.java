package interfaces;

import collisionandvelocity.Velocity;
import shapes.Block;
import java.util.List;

/**interface LevelInformation.
 * all the information needed for a new level.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public interface LevelInformation {
    /**
     * @return number of balls of the level
     */
    int numberOfBalls();

    /**
     * @return The initial velocity of each ball in list.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * @return The width of the paddle.
     */
    int paddleWidth();

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();
    /**
     * @return the background the the level.
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return list of the blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * @return the number of blocks.
     */
    int numberOfBlocksToRemove();
}