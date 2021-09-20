package collisionandvelocity;

import shapes.Point;

/**Class collisions.Velocity.
 * describes the velocity of some given point.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Velocity {
    private double dx;      //the velocity in the X axe of the point.
    private double dy;     //the velocity in the X axe of the point.
    /** Constructor of collisions.Velocity.
     * <p>
     * puts the given dx and dy to the new instance of the class.
     * <p>
     *  @param dx the dx  of the new instance of velocity.
     *  @param dy the dy  of the new instance of velocity.*/
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /** Returns the dx of the velocity.
     * <p>
     *  @return return the dx*/
    public double getDx() {
        return dx;
    }
    /** sets new value to the dx of the velocity.
     * <p>
     *  @param newDx the new dx of the velocity.*/
    public void setDx(double newDx) {
        this.dx = newDx;
    }
    /** sets new value to the dy of the velocity.
     * <p>
     *  @param newDy the new dy of the velocity.*/
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /** Returns the dy of the velocity.
     * <p>
     *  @return return the dy*/
    public double getDy() {
        return dy;
    }
    /** Take a point with position (x,y) and
     * return a new point with position (x+dx, y+dy).
     * <p>
     *  @param p the point before the velocity applied.
     *  @return the point after the velocity is applied.*/
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }
    /** converts velocity that given by an angel and speed to dx and dy.
     * <p>
     * using trigonometric basic formulas.
     * <p>
     *  @param angle the given angle of the velocity
     *  @param speed the given speed of the velocity.
     *  @return the new velocity after according to dx and dy.*/
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRadians = Math.toRadians(angle);
        double dy  = -Math.cos(angleRadians) * speed;
        double dx = Math.sin(angleRadians) * speed;
        return new Velocity(dx, dy);
    }
}