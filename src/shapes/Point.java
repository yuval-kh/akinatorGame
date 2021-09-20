package shapes;

/**shapes.Point Class.
 * describes a single point in the space
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Point {
    private double x;    //the X coordinate of the point
    private double y;    //the Y coordinate of the point
    /** The Constructor of point.
     * <p>
     * puts the given x and y to the parameters of the instance of the class
     * <p>
     *  @param x the X of the new point that is created,
     *  @param y the Y of the new point that is created*/
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**returns the distance of this point to other given point.
     * <p>
     *  @param other the other point which from her the distance is measured
     *  @return returns the distance according to the formula of distance between two points*/
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                                + ((this.y - other.getY()) * (this.y - other.getY())));

    }

    /** return true is the points are equal, false otherwise.
     * <p>
     *  @param other the other point which is checked if its equal to the original point.
     *  @return  true is the points, false otherwise.*/
    public boolean equals(Point other) {
        //two points are equal if their X and Y are equal
        if (this.x == other.getX() && this.y == other.getY()) {
            return true;
        }
        return false;
    }
    /** sets new value to the X coordinate.
     * <p>
     *  @param newX the new X coordinate of the point.*/
    public void setX(double newX) {
        this.x = newX;
    }
    /** sets new value to the Y coordinate.
     * <p>
     *  @param newY the new Y coordinate of the point.*/
    public void setY(double newY) {
        this.y = newY;
    }

    /** returns the X coordinate of this point.
     * <p>
     *  @return  the X coordinate.*/
    public double getX() {
        return this.x;
    }
    /** returns the Y coordinate of this point.
     * <p>
     *  @return  the Y coordinate.*/
    public double getY() {
        return this.y;
    }
}