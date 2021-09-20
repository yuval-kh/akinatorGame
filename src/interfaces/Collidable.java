package interfaces;

import collisionandvelocity.Velocity;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;

/**interface interfaces.Collidable.
 * describes a collidable object in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */

public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     * @return the collision shape.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     * @param collisionPoint the collision point of the object.
     * @param currentVelocity the current velocity of the object.
     * @param hitter the  hitter ball.
     * @return the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}