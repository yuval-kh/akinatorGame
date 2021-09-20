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

/**Class FinalFour.
 *the final level of the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class FinalFourLevel implements LevelInformation {
    private static final int VELOCITY_DX = 3; //velocity of the ball.
    private static final int VELOCITY_DY = 4;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_WIDTH = 70;
    private static final int BLOCK_HEIGHT = 25; //dimensions of the blocks.
    private static final int BLOCK_LENGTH = 50;
    private static final int WIDTH = GameLevel.getWIDTH();

    /**
     * @return number of balls - three balls at this level.
     */
    @Override
    public int numberOfBalls() {
        return 3;
    }

    /**
     * list of balls velocities.
     * @return list with three velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(VELOCITY_DX, VELOCITY_DY));
        list.add(new Velocity(VELOCITY_DX, VELOCITY_DY));
        list.add(new Velocity(VELOCITY_DX, VELOCITY_DY));
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
        return "Final Four";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new FinalFourBackground();
    }

    /**
     * @return list with all the blocks.
     */
    @Override
    public List<Block> blocks() {
        //array of colors- to make colorful blocks.
        java.awt.Color[] colorarr = arrayofColors();
        List<Block> list = new ArrayList<>();
        int startx = WIDTH - BLOCK_HEIGHT - BLOCK_LENGTH; //starting upper left X of the first block.
        int numOfMax = 15; //max blocks at row.
        int ystart = 75; //starting upper left Y of the first block.
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < numOfMax; i++) {
                //every time creates a new rectangle on the needed place
                //and adds the block to the game.
                Rectangle rec = new Rectangle(new Point(startx - i * BLOCK_LENGTH, ystart),
                        BLOCK_LENGTH, BLOCK_HEIGHT);
                Block block = new Block(rec, colorarr[j]);
                list.add(block); //adds every block to the list.

            }
            ystart += BLOCK_HEIGHT; //the new Y coordinate of the next row.
        }
        return list;
    }

    /**
     *make an array with diffrent colors.
     * @return array of colors.
     */
    private java.awt.Color[] arrayofColors() {
        java.awt.Color[] colorarr = new java.awt.Color[7];
        colorarr[0] = java.awt.Color.GRAY;
        colorarr[1] = java.awt.Color.red;
        colorarr[2] = java.awt.Color.yellow;
        colorarr[3] = java.awt.Color.green;
        colorarr[4] = java.awt.Color.white;
        colorarr[5] = java.awt.Color.pink;
        colorarr[6] = java.awt.Color.cyan;
        return colorarr;
    }

    /**
     * @return number of blocks that is needed to be removed.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 120;
    }
}

