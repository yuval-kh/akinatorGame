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

/**Class WideEasy.
 * second level in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class WideEasyLevel implements LevelInformation {
    private static final int VELOCITY_DX = 3; //velocity of the ball.
    private static final int VELOCITY_DY = 4;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_WIDTH = 650;
    private static final int BLOCK_HEIGHT = 25; //dimensions of the blocks.
    private static final int BLOCK_LENGTH = 50;
    private static final int WIDTH = GameLevel.getWIDTH();
    private static final int HEIGHT = GameLevel.getHEIGHT();

    /**
     * @return number of balls in the level -level has 10 balls.
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * list of balls velocities.
     * @return list with ten velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //velocity for every ball.
        list.add(new Velocity(VELOCITY_DX, VELOCITY_DY));
        }
        return list;
    }

    /**
     * @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * @return the paddle width.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * @return the name of the level.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new WideEasyBackground();
    }

    /**
     * @return list with all the blocks.
     */
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>(); //array of colors.
        java.awt.Color[] colorarr = arrayofColors();
        int sameY = HEIGHT / 3 + 25; //Y of all the blocks.
        int startX = WIDTH - BLOCK_HEIGHT - BLOCK_LENGTH; //X of the first block.
        for (int i = 0; i < 15; i++) {
            //making every block.
            Block block = new Block(new Rectangle(new Point(startX - i * BLOCK_LENGTH, sameY),
                    BLOCK_LENGTH, BLOCK_HEIGHT), colorarr[i]);
            list.add(block); //adding it to the list.
        }

        return list;
    }

    /**
     *make an array with different colors.
     * @return array of colors.
     */
    private java.awt.Color[] arrayofColors() {
        java.awt.Color[] colorarr = new java.awt.Color[15];
        colorarr[0] = java.awt.Color.cyan;
        colorarr[1] = java.awt.Color.cyan;
        colorarr[2] = java.awt.Color.pink;
        colorarr[3] = java.awt.Color.pink;
        colorarr[4] = java.awt.Color.blue;
        colorarr[5] = java.awt.Color.blue;
        colorarr[6] = java.awt.Color.green;
        colorarr[7] = java.awt.Color.green;
        colorarr[8] = java.awt.Color.green;
        colorarr[9] = java.awt.Color.yellow;
        colorarr[10] = java.awt.Color.yellow;
        colorarr[11] = java.awt.Color.orange;
        colorarr[12] = java.awt.Color.orange;
        colorarr[13] = java.awt.Color.red;
        colorarr[14] = java.awt.Color.red;
        return colorarr;
    }

    /**
     * @return number of blocks that is needed to be removed.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}

