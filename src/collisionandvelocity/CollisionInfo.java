package collisionandvelocity;

import interfaces.Collidable;
import shapes.Point;

/**Class collisions.Velocity.
 *All the info of colllision in the game.
 *@author Yuval Khanimov
 *<yuval953@gmail.com>
 *ID 318970902 */
public class CollisionInfo {
    private Point collisionPoint; //the point at which the collision occurs.
    private Collidable collisionObject; //the collidable object involved in the collision.

    /**
     * Constructor of collisions.CollisionInfo.
     * creates a new collision in the game.
     * @param collisionPoint The new collision point
     * @param collisionObject The new collision object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * returns the collision point.
     * @return collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }


    /**
     *  returns the collision object.
     * @return the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}