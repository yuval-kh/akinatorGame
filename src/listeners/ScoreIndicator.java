package listeners;

import biuoop.DrawSurface;
import animationsandgame.Counter;
import animationsandgame.GameLevel;
import interfaces.Sprite;
import shapes.Rectangle;

/**Class listeners.ScoreIndicator.
 * keeps the score and changes it in the game.
 * @author Yuval Khanimov
 * <yuval953@gmail.com>
 * ID 318970902 */
public class ScoreIndicator implements Sprite {
    private int xText; //the x coordinate of the score.
    private int yText; //the y coordinate of the score.
    private Rectangle rectangle; //the rectangle that the score is placed on.
    private Counter score; //the score counter,.
    private final java.awt.Color color = java.awt.Color.white; //the color the the rectangle.

    /**
     * Constructor of listeners.ScoreIndicator.
     * @param rectangle gets the rectangle from other function.
     * @param score gets the counter from other function.
     */
    public ScoreIndicator(Rectangle rectangle, Counter score) {
        this.rectangle = rectangle;
        this.score = score;
        //the score text is placed on about the middle of the rectangle.
        xText = (int) rectangle.getWidth() / 2;
        yText = (int) rectangle.getHeight() / 2 + 5;
    }

    /**
     * draws the score on a drawing surface.
     * @param d the drawing surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        //first draws the rectangle in white than the score text on it.
        d.setColor(color);
        rectangle.drawOn(d);
        d.drawText(xText, yText, "Score: " + score.getValue(), 10);
    }

    /**
     * what the score should do as the time passes.
     * in this case - nothing.
     */
    @Override
    public void timePassed() {

    }

    /**
     * adds the score sprite to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
