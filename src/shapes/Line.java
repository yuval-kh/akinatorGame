package shapes;

/**shapes.Line Class.
 * describes a line in the space
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Line {
    private  Point start;   //starting point of the line
    private  Point end;     //ending point of the line
    /** The Constructor of line.
     * <p>
     * puts the given start point and ending point to the new instance of the class
     * <p>
     *  @param newStart the starting point the new line that is created.
     *  @param newEnd the ending point the new line that is created.*/
    public Line(Point newStart, Point newEnd) {
        this.start = newStart;
        this.end = newEnd;
    }
    /** Constructor of line.
     * <p>
     * puts the given 4 coordinates to the new instance of the class.
     * <p>
     *  @param x1 the X coordinate of the starting point.
     *  @param y1 the Y coordinate of the starting point.
     *  @param x2 the X coordinate of the ending point.
     *  @param y2 the Y coordinate of the ending point.*/
    public Line(double x1, double y1, double x2, double y2) {
        Point newStart = new Point(x1, y1);
        Point newEnd = new Point(x2, y2);
        this.start = newStart;
        this.end = newEnd;
    }

    /** returns the length of the line.
     * <p>
     *  @return return the length of the line.
     *  which is the distance between starting and ending point.*/
    public double length() {
        return this.start.distance(this.end);
    }

    /** Returns the middle point of the line.
     * <p>
     *  @return return the middle point of the line*/
    public Point middle() {
        //the x and y of this point is average between staring and ending point.
        double midx = (this.start.getX() + this.end.getX()) / 2;
        double midy = (this.start.getY() + this.end.getY()) / 2;
        Point mid = new Point(midx, midy);
        return mid;
    }

    /** Returns the start point of the line.
     * <p>
     *  @return return the starting point*/
    public Point start() {
        return this.start;
    }

    /** Returns the ending point of the line.
     * <p>
     *  @return return the ending point*/
    public Point end() {
        return this.end;
    }

    /** Returns true if the lines intersect, false otherwise.
     * <p>
     *  The function using intersectionWith function.
     *  if it is returning a point and not null-the two lines are intersecting.
     *  <p>
     *  @param other the other line which is checked if its being intersected.
     *  @return true if the two lines intersecting false otherwise.*/
    public boolean isIntersecting(Line other) {
        Point p = intersectionWith(other);
        if (p == null) {
            return false;
        }
        return true;
    }

    /** Returns the intersection point if the lines intersect,and null otherwise.
     * <p>
     *  The function using the formula y=mx+n to check intersection.
     *  if the slope of the line (m in the formula) cant be defined or the
     *  starting point and ending point are equal-it checks it separately
     *  <p>
     *  @param other the other line which is checked if its being intersected.
     *  @return the intersection point between two lines.*/
    public Point intersectionWith(Line other) {
        //the M parameter of this line according to the formula y=Mx+n
        double thisM = this.calculateSlope();
        //the N parameter of this line according to the formula y=mx+N
        double thisN = this.calculateN(thisM);
        // the m and n of the other line
        double otherM = other.calculateSlope();
        double otherN = other.calculateN(otherM);
        /*if the difference between staring and ending
         point the slope is not defined, and the formula is not relevant.*/
        boolean isThisMdefined = !(this.start.getX() == this.end.getX());
        boolean isOtherMdefined = !(other.start.getX() == other.end.getX());
        if (isThisMdefined && !isOtherMdefined) {      //if the formula can be used on this line but not the other
            double interY = thisM * other.start.getX() + thisN;  //intersection Y coordinate is m*x+n of this line
            Point interp = new Point(other.start.getX(), interY);  //intersection point
            if (this.isPointInSegment(interp) && other.isPointInSegment(interp)) {
                /*checks if the point in the two segments if it is,
                 the point is intersection point otherwise its not*/
                return interp;
            }
            return null;
        }
        if (!isThisMdefined && isOtherMdefined) { // //if the formula can be used on other line but not this line
            double interY = otherM * this.start.getX() + otherN; //intersection Y coordinate is m*x+n of this line
            Point interp = new Point(this.start.getX(), interY); //intersection point
            if (this.isPointInSegment(interp) && other.isPointInSegment(interp)) {
                /*checks if the point in the two segments if it is,
                 the point is intersection point otherwise its not*/
                return interp;
            }
            return null;
        }
        if (!isThisMdefined) { //if both slopes are not defined
            if (other.isLineAPoint() && (this.isLineAPoint())) {
                /*if the two lines are points(starting and ending point are equal)
                 checks only if it is the same point*/
                if (this.start.equals(other.start)) {
                    return this.start;
                }
            }
            if (this.isLineAPoint()) {   //if this line a point but the other not
                if (other.isPointInSegment(this.start)) {
                    //if this line is in the second Segment return the point of this line
                    return this.start;
                }
            }
            if (other.isLineAPoint()) {  //if other line is a point but this is not
                if (this.isPointInSegment(other.start)) {
                    //if other line is in this Segment return the point of other line
                    return other.start;
                }
            }
                return null;
        }
        //only if the two slopes defined the program will go here
        if (thisM - otherM == 0) { // if the difference between two slopes is 0 the lines are parallel.
            return null;
        }
        double intersecX = (thisN - otherN) / (otherM - thisM);  //intersection X between two lines.
        double intersecY = (thisM * intersecX) + thisN; //intersection Y between two lines.
        Point interpoint = new Point(intersecX, intersecY);
        if (this.isPointInSegment(interpoint) && other.isPointInSegment(interpoint)) {
            //if the intersection point is in two segments this is the intersection point.
            return interpoint;
        }
        //otherwise, there is no intersection point
        return null;
        }

    /**equals return true is the lines are equal, false otherwise
     * <p>
     *  The lines are equal if they have the same starting and ending point, or
     *   the starting point of one is the ending point of the second and in the opposite.
     *  <p>
     *  @param other the other line which is checked if its equal to this.
     *  @return true is the lines are equal, false otherwise.*/
    public boolean equals(Line other) {
        //checks if they have the same starting and ending point.
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        //checks if the starting point of one is the ending point of the second.
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        //if not the lines are not equal.
        return false;
    }
    /**calculate the slope of a line.
     * <p>
     * using the formula: (y1-y2)/(x1-x2).
     *  <p>
     *  @return the slope of this line*/
    private double calculateSlope() {
        return (this.end.getY() - this.start.getY())
                / (this.end.getX() - this.start.getX());
    }
    /**calculate the N of a line.in the formula y=mx+n.
     * <p>
     * using the formula: n=y-m*x.
     *  <p>
     *  @param m the slope of the line.
     *  @return the n parameter*/
    private double calculateN(double m) {
        return this.start.getY() - (m * this.start.getX());
    }
    /**checks if this line is actually a point.
     * <p>
     * it is a point if the starting and ending point are equal.
     *  <p>
     *  @return true if the line is a point false otherwise.*/
    private boolean isLineAPoint() {
        return this.start.equals(this.end);
    }
    /**checks if given point is in this segment or in the continuation of the line.
     * <p>
     * the given point must be in the line.
     *  <p>
     *  @param p the given point
     *  @return true if the point in the segment false otherwise.*/
    private boolean isPointInSegment(Point p) {
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minY = Math.min(this.start.getY(), this.end.getY());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        return p.getX() >= minX && p.getX() <= maxX && p.getY() >= minY && p.getY() <= maxY;
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     * <p>
     * @param rect the rectangle that checked if its intersect with the given line or not
     * @return the closest collision point to the start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //creates a new list of all the intersection points with the rectangle.
        java.util.List<Point> list;
        list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null; //if the list is Empty there are not intersection points.
        }
        Point closest = list.get(0); //initializing the closest point to the first in the list.
        for (Point p:list) {
            if (this.start.distance(p) < this.start.distance(closest)) {
                /*for every point in the list if its closer to the
                  start than the closest point  it's the new closet point
                 */
                closest = p;
            }
        }
        return  closest; //returns the closest point in the list.
    }
}