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

/**Class Green3level.
 *  The second level of the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Green3Level implements LevelInformation {
    private static final int VELOCITY_DX = 3; //velocity of the ball.
    private static final int VELOCITY_DY = 4;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_WIDTH = 70;
    private static final int BLOCK_HEIGHT = 25; //dimensions of the blocks.
    private static final int BLOCK_LENGTH = 50;
    private static final int WIDTH = GameLevel.getWIDTH();
    private static final int HEIGHT = GameLevel.getHEIGHT();

    /**
     * @return number of the balls in the level - two balls this time.
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }

    /**
     * list of the balls velocities.
     * @return list with two velocities for the balls.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
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

    /*
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * @return name of the level.
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Green3Background();
    }

    /**
     * @return list of the blocks in the game.
     */
    @Override
    public List<Block> blocks() {
        java.awt.Color[] colorarr = arrayofColors(); //array of diffrent colors.
        List<Block> list = new ArrayList<>(); //new list of the blocks.
        int startx = WIDTH - BLOCK_HEIGHT - BLOCK_LENGTH; //starting upper left X of the first block.
        int numOfMax = 10; //max blocks at row.
        int ystart = HEIGHT / 6; //starting upper left Y of the first block.
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < numOfMax; i++) {
                //every time creates a new rectangle on the needed place
                //and adds the block to the game.
                Rectangle rec = new Rectangle(new Point(startx - i * BLOCK_LENGTH, ystart),
                        BLOCK_LENGTH, BLOCK_HEIGHT);
                Block block = new Block(rec, colorarr[j]);
                list.add(block); //afrer blocks is made adds it to the list.

            }
            numOfMax--; //every row has one less block than the upper row.
            ystart += BLOCK_HEIGHT; //the new Y coordinate of the next row.
        }
        return list; //returs the final list.
    }

    /**
     * @return array of diffrent colors to make colorful blocks.
     */
    private java.awt.Color[] arrayofColors() {
        java.awt.Color[] colorarr = new java.awt.Color[5];
        colorarr[0] = java.awt.Color.GRAY;
        colorarr[1] = java.awt.Color.red;
        colorarr[2] = java.awt.Color.yellow;
        colorarr[3] = java.awt.Color.blue;
        colorarr[4] = java.awt.Color.white;
        return colorarr;
    }

    /**
     * @return number of blocks that should be removed.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}

