package collections;

import collisionandvelocity.CollisionInfo;
import interfaces.Collidable;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.util.List;

/**Class collections.GameEnvironment.
 * maintains a list of all the collidable objects in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class GameEnvironment {
    private java.util.List<Collidable> collidables; //list of all the collidables.

    /**
     * initializing a new list of collidables.
     */
    public GameEnvironment() {
        collidables = new java.util.ArrayList<Collidable>();
    }

    /**
     * return the collidables list.
     * @return the list collidables.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * add the given collidable to the list.
     * @param c the new collidable which is added.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }


    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory the path of the moving object.
     * @return information about the closest collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle r;
        Point start = trajectory.start();
        Point minPoint = null, collision;
        Collidable minc = null;
        if (collidables == null) {
            return null; //if there are no collision return null.
        }
        for (Collidable c : collidables) {
            //c is the current rectangle .
            //collision is the collision point of this rectangle.
            r = c.getCollisionRectangle();
            collision = trajectory.closestIntersectionToStartOfLine(r);
            if (collision != null) {
                if (minPoint == null) {
                    //if the minpoint is null it is the first recognized cillision.
                minc = c;
                minPoint = collision;
                } else {
                    //if minpoint is not null-checks if the collision is
                    // smaller than the current mincollision.
                  double dist = start.distance(collision);
                  if (dist < start.distance(minPoint)) {
                      minPoint = collision;
                      minc = c;
                    }
            }
            }
        }
        if (minc == null) { //if there were not collisions return null.
            return null;
        }
        CollisionInfo col = new CollisionInfo(minPoint, minc); //if not return the min collision.
        return col;
    }
}