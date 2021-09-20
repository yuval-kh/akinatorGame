package levels;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import java.util.List;

/**Class GameFlow.
 *  making the game play diffrent levels.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class GameFlow {
    private  animationsandgame.AnimationRunner ar; //animation runner to make the animations.
    private KeyboardSensor ks; //keyboard sensor of the game.
    private GUI gui; //the gui of the game.
    private  animationsandgame.Counter score; //the score of the game.

    /**
     * Constructor of GameFlow.
     * initializing all the parameters.
     * @param ar takes the animation runner from other class.
     * @param ks the keyboard sensor.
     * @param gui takes the gui from other class.
     */
    public GameFlow(animationsandgame.AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
        this.score = new  animationsandgame.Counter();
    }

    /**
     * makes the levels run one after other.
     * @param levels the list of the level to be played.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean iswin = true; //is the player winning needed for the animation.
        for (LevelInformation levelInfo : levels) {
            //loop what to do for every level. first initializing it.
            animationsandgame.GameLevel level = new  animationsandgame.GameLevel(levelInfo, ar, ks, gui, score);
            level.initialize();
            //while the player is not lost or won - continue the level(run it).
           while (level.getBalls() > 0 && level.getBlocks() > 0) {
                level.run();
            }
           //if the balls number is 0 the player lost.
            if (level.getBalls() == 0) {
                iswin = false;
                //runs the animation for loosing.
                this.ar.run(new animationsandgame.KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                        new animationsandgame.Winscreen(score.getValue(), false)));
                break;
            }

        }
        if (iswin) {
            //if the player won run the animation for winning.
            this.ar.run(new  animationsandgame.KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                    new  animationsandgame.Winscreen(score.getValue(), true)));
        }
    }
}