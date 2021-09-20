package shapes;

import biuoop.DrawSurface;
import collisionandvelocity.Velocity;
import animationsandgame.GameLevel;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/** Class shapes.Block.
 *  describes a block in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rec; //the rectangle of the block.
    private java.awt.Color color; //the color of the block.
    private List<HitListener> hitListeners; //hitlisteners of this block.

    /**
     * Constructor of block.
     * creating a new block using rectangle and color.
     * @param rec the rectangle of the new block.
     * @param color the color of the new block.
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.hitListeners = new ArrayList<>();
        this.rec = rec;
        this.color = color;
    }

    /**
     * drawing the block on a drawing surface.
     * @param surface the drawing surface.
     */
    public void drawOn(DrawSurface surface) {
       surface.setColor(color); //sets a color of the block.
       rec.drawOn(surface); //drawing the object.
    }

    /**
     * as the time passes the block doing nothing.
     */
    @Override
    public void timePassed() {

    }

    /**
     * adds a new block to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this); //adds the block to the sprite list.
        g.addCollidable(this); //adds the block to the collidables list.
    }

    /**
     * returns the rectangle of the block.
     * @return the rectangle of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rec;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit
     * if the ball hits upper or down line changes the vertical velocity.
     * if the ball hits upper or down line changes the horizontal velocity.
     * @param collisionPoint the collision point of the object.
     * @param currentVelocity the current velocity of the object.
     * @param hitter The hitter Ball.
     * @return the new velocity.
     */
    @Override
        public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (rec.isIntersactWithUpOrDown(collisionPoint)) {
            //if the collision is with upper or down line changes only dy.
            currentVelocity.setDy(-1 * currentVelocity.getDy());
        } else if (rec.isIntersactWithLeftOrRight(collisionPoint)) {
            //if the collision is with upper or down line changes only dy.
            currentVelocity.setDx(-1 * currentVelocity.getDx());
        }
        this.notifyHit(hitter);
        return  currentVelocity; //returns the new velocity.

    }

    /**
     * removes a block from game after being hit.
     * @param game the game that its removed from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * notify of a hit to the listeners.
     * @param hitter the hitter ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * adds a new hit listener to the list.
     * @param hl the new listener of the block.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    /**
     * removes a new hit listener to the list.
     * @param hl the listener of the block that is being removed.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
