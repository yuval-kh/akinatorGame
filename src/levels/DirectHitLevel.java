package levels;

import animationsandgame.GameLevel;
import collisionandvelocity.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import shapes.Block;
import shapes.Point;
import shapes.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**Class DirectHitLevel.
 * The first level in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class DirectHitLevel implements LevelInformation {
    private static final int VELOCITY_DX = 3; //velocity of the ball.
    private static final int VELOCITY_DY = 5;
    private static final int PADDLE_SPEED = 10; //paddle speed
    private static final int PADDLE_WIDTH = 70;
    private static final int WIDTH = GameLevel.getWIDTH();

    /**
     * number of balls of this level.
     * @return one ball this level.
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * list of velocities of the balls.
     * @return list with one velocity for the ball.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(VELOCITY_DX, VELOCITY_DY));
        return list;
    }

    /**
     * the speed of the paddle.
     * @return paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * the paddle width.
     * @return paddle width.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /*
     * @return the name of the level.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new DirectHitBackground();
    }

    /**
     * @return list with all the blocks - has only one this level.
     */
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block = new Block(new Rectangle(new Point(WIDTH / 2, 120), 30, 30), java.awt.Color.red);
        list.add(block);
        return list;
    }

    /**
     * number of the blocks the needed to be removed.
     * @return one block this level.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
