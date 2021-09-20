package animationsandgame;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collections.GameEnvironment;
import collections.SpriteCollection;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreIndicator;
import listeners.ScoreTrackingListener;
import shapes.Block;
import shapes.Paddle;
import shapes.Point;
import shapes.Rectangle;
import shapes.Ball;
import java.util.List;


/**Class game_and_main.Game.
 * maintains all the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class GameLevel implements Animation {
    //all the constants of the game.
    private static final int WIDTH = 800; //the width of the giu
    private static final int HEIGHT = 600; //the height of the giu
    private static final int RADIUS = 8; //radius of the ball.
    private static final int BLOCK_HEIGHT = 25; //dimensions of the blocks.
    private static final int PADDLE_HEIGHT = 10; //paddle height
    private SpriteCollection sprites; //the collection of all the sprites in the game.

    private GameEnvironment environment;  //the collection of all the collidbles in the game.
    private GUI gui; //the gui of the screen.
    private Paddle p; //the paddle of the game.
    private Counter blockCounter; //counter of the remaining blocks
    private Counter ballCounter; //counter for remaining balls.
    private Counter score; //The score of the game.
    private biuoop.KeyboardSensor keyboard; //the keyboard sensor of the level.
    private AnimationRunner runner; //the animation runner loop.
    private boolean running;
    private LevelInformation level; //the level information of each level.
    /**
     * Constructor of game_and_main.Game.
     * initializing the sprites and enviroment lists.
     * and all the counters.
     * @param level The level information.
     * @param runner The animation runner.
     * @param sensor The keyboard sensor.
     * @param gui The gui of the game.
     * @param score The score.
     */
    public GameLevel(LevelInformation level, AnimationRunner runner, KeyboardSensor sensor, GUI gui, Counter score) {
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        this.running = true;
        this.level = level;
        this.keyboard = sensor;
        this.runner = runner;
        this.gui = gui;
        this.score = score;
    }

    /**
     * adds a new collidable to the collections.GameEnvironment.
     * @param c the new collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * adds a new sprite to the game.
     * @param s the new sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * initializing the game ,creating the ball and the
     * blocks and adds them to the needed lists.
     */
    public void initialize() {
        //initializing the listeners.
        BlockRemover blockRemover = new BlockRemover(this, blockCounter);
        BallRemover ballRemover = new BallRemover(this, ballCounter);
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(score);
        int startx = 100;
        int starty = 300;

        Rectangle rec = new Rectangle(new Point(WIDTH / 7, HEIGHT - BLOCK_HEIGHT - PADDLE_HEIGHT),
                                                                   level.paddleWidth(), PADDLE_HEIGHT);
        p = new Paddle(rec, keyboard, new java.awt.Color(255, 200, 0),
                      BLOCK_HEIGHT, WIDTH - BLOCK_HEIGHT, level.paddleSpeed());
        p.addToGame(this);
        blocksAtEdge(ballRemover); //creating the blocks at the edge of the gui.
        blockAtRows(blockRemover, scoreListener); //creating all the rest of the blocks.

        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            //creating balls and adding them to game.
            Ball b = new Ball(new Point(startx + 20 * i, starty + 20 * i), RADIUS, java.awt.Color.white,
                    level.initialBallVelocities().get(i));
            b.addToGame(this);
            ballCounter.increase(1);
            b.setGame(environment);
        }

    }

    /**
     * creating the blocks at the middle of the gui with diffrent colors.
     * @param blockRemoverListener the block remover listener to add to every block.
     * @param scoreListener the score tracking listener to add to every block.
     */
    private void blockAtRows(BlockRemover blockRemoverListener, ScoreTrackingListener scoreListener) {
        List<Block> list = level.blocks();
        for (Block block:list) {
            block.addToGame(this);
            block.addHitListener(blockRemoverListener); //adds the needed listeners to the nlocks in the middle.
            block.addHitListener(scoreListener);
            blockCounter.increase(1); //increases the counter for every block.
        }

    }
    /**
     * creating the 4 blocks at the edge of the gui.
     * @param ballRemoverListener the ball remover listener to add to the down block.
     */
    private void blocksAtEdge(BallRemover ballRemoverListener) {
        int reclen = BLOCK_HEIGHT;
        int height = HEIGHT;
        int width = WIDTH;
        //the first block at the down edge.
        Rectangle rec = new Rectangle(new Point(0, height - reclen), width, reclen);
        Block block = new Block(rec, java.awt.Color.gray);
        block.addToGame(this);
        block.addHitListener(ballRemoverListener); //adds listener to the down block.
        //the block at the right edge.
        rec = new Rectangle(new Point(width - reclen, 0), reclen, height);
        block = new Block(rec, java.awt.Color.gray);
        block.addToGame(this);
        //the block at the left edge.
        rec = new Rectangle(new Point(0, 0), reclen, height);
        block = new Block(rec, java.awt.Color.gray);
        block.addToGame(this);
        //the block at the upper edge.
        rec = new Rectangle(new Point(0, 0), width, reclen);
        block = new Block(rec, java.awt.Color.gray);
        block.addToGame(this);
        rec = new Rectangle(new Point(0, 0), width, reclen - 10);
        ScoreIndicator scoreIndicator = new ScoreIndicator(rec, score);
        scoreIndicator.addToGame(this);

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        //runs the countdown loop and then the animation of this class.
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, level.getBackground()));
        this.runner.run(this);
    }

    /**
     * removes a collidable from the collidables list.
     * @param c the collidable that is being removed.
     */
    public void removeCollidable(Collidable c) {
        environment.getCollidables().remove(c);
    }

    /**
     * removes a sprite from the sprites list.
     * @param s the sprite that is being removed.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * doing one frame in the game level.
     * drawing all the sprites and the background first.
     * than, changes the "running" parameter if there are no balls all blocks left.
     * @param d the drawing surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        level.getBackground().drawOn(d); //draws the background.
        this.sprites.drawAllOn(d); //drawing all the sprites.
        this.sprites.notifyAllTimePassed(); //moving all the objects.
        if (blockCounter.getValue() == 0 || ballCounter.getValue() == 0) {
            //if all the blocks are removed or there are no balls the game stops.
            if (blockCounter.getValue() == 0) {
                //if there are no blocks the score increases by 100.
                score.increase(100);
            }
            this.running = false;
            return;
        }
        if (this.keyboard.isPressed("p")) {
            //if p is pressed runs the KeyPressStoppable animation.
            this.runner.run(new KeyPressStoppableAnimation(keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        //draws the level name.
        d.setColor(java.awt.Color.black);
        d.drawText((int) (WIDTH * 0.75), 12, "Level Name: " + level.levelName(), 12);
    }

    /**
     * returns true if the animation should stop.
     * @return in this case it is always "!running" parameter.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * gets the number of blocks.
     * @return number of blocks.
     */
    public int getBlocks() {
        return blockCounter.getValue();
    }

    /**
     * gets the number of balls.
     * @return the number of balls.
     */
    public int getBalls() {
        return ballCounter.getValue();
    }

    /**
     * @return gets the width of screen
     */
    public static int getWIDTH() {
        return WIDTH;
    }

    /**
     * @return gets the Hieght of screen.
     */
    public static int getHEIGHT() {
        return HEIGHT;
    }
}