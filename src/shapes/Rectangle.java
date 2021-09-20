package shapes;

import biuoop.DrawSurface;
import java.util.ArrayList;
/**Class shapes.Rectangle.
 * describes the rectangles in the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Rectangle {
    private Point upperLeft;  //the upper left point of the rectangle.
    private double width;   //the width of the rectangle.
    private double height;  //the height of the rectangle.

    /**
     * Constractor of shapes.Rectangle.
     * <p>
     * creates a new rectangle in the game by upper left point height and width.
     * @param upperLeft the upper left point of the  new rectangle.
     * @param width the width of the new rectangle.
     * @param height the height of the new rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * changes the upper left point of the rectangle.
     * @param newupperLeft the new upper left point.
     */
    public void setUpperLeft(Point newupperLeft) {
        this.upperLeft = newupperLeft;
    }

    /**
     * Return a List of intersection points with the specified line and the rectangle.
     * @param line the line that is checked the intersection points with him.
     * @return list of intersection points with the line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> list = new ArrayList<>(); //create a new list of collision points
        Line upperLine = new Line(upperLeft, upperRight()); //the upper line of the rectangle
        Point collisionUp = upperLine.intersectionWith(line);
        if (collisionUp != null) {
            //if there is a collision with the upper line add it to the list
            list.add(collisionUp);
        }
        Line leftLine = new Line(upperLeft, downLeft());
        Point collisionLeft = leftLine.intersectionWith(line);
        if (collisionLeft != null) {
            //if there is a collision with the left line add it to the list
            list.add(collisionLeft);
        }
        Line downLine = new Line(downLeft(), downRight());
        Point collisionDown = downLine.intersectionWith(line);
        if (collisionDown != null) {
            //if there is a collision with the down line add it to the list
            list.add(collisionDown);
        }
        Line rightLine = new Line(upperRight(), downRight());
        Point collisionRight = rightLine.intersectionWith(line);
        if (collisionRight != null) {
            //if there is a collision with the right line add it to the list
            list.add(collisionRight);
        }
        return list; //returns the list with the collision points
    }

    /**
     * returns the upper right point of the rectangle.
     * the X of it is the X of the upper left point plus the width of the rectangle
     * the Y of it is the Y of the upper left point
     * @return the upper right point of the rectangle.
     */
    private Point upperRight() {
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        return upperRight;
    }
    /**
     * returns the down left point of the rectangle.
     * the X of it is the X of the upper left point
     * the Y of it is the Y of the upper left point plus the height of the rectangle
     * @return the down left point of the rectangle.
     */
    private Point downLeft() {
        Point downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        return downLeft;
    }
    /**
     * returns the down right point of the rectangle.
     * the X of it is the X of the upper left point plus the width of the rectangle
     * the Y of it is the Y of the upper left point plus the height of the rectangle
     * @return the down right point of the rectangle.
     */
    private Point downRight() {
        double x = upperLeft.getX() + width;
        double y = upperLeft.getY() + height;
        Point downRight = new Point(x, y);
        return downRight;
    }

    /**
     * checks if a point intersects with the down or up lines or not.
     * @param p the intersection point.
     * @return true if the point is intersects with the upper or down line.
     * false if not.
     */
    public boolean isIntersactWithUpOrDown(Point p) {
        if (!isPointinrec(p)) {
            return false; //if the point is not in the rectangle return false.
        }
        if (Math.abs(p.getY() - upperLeft.getY()) <= 0.00001) {
            //if the Y of the point is the Y of the upper left point return true
            return true;
        }
        if (Math.abs(p.getY() - downLeft().getY()) <= 0.0001) {
            //if the Y of the point is the Y of the down left point return true
            return true;
        }
        return false; //if the Y is not equal return false.
    }

    /**
     * checks if a point intersects with the left or right lines or not.
     * @param p the intersection point.
     * @return true if the point is intersects with the upper or down line.
     *  false if not.
     */
    public boolean isIntersactWithLeftOrRight(Point p) {
        if (!isPointinrec(p)) {
            //if the point is not in the rectangle return false.
            return false;
        }
        if (Math.abs(p.getX() - upperLeft.getX()) <= 0.0001) {
            //if the X of the point is the X of the upper left point return true
            return true;
        }
        if (Math.abs(p.getX() - upperRight().getX()) <= 0.0001) {
            //if the X of the point is the X of the upper right point return true
            return true;
        }
        return false;  //if the X is not equal return false.
    }

    /**
     * checks if a point in the rectangle or not.
     * @param p the point
     * @return true if the point in the rectangle false if not.
     */
    private boolean isPointinrec(Point p) {
        if (p.getX() >= upperLeft.getX() && p.getX() <= upperRight().getX()
                && p.getY() >= upperLeft.getY() && p.getY() <= downLeft().getY()) {
            /*if the X of the point is between the upper left and upper right point and
             Y beteen the upper left and down left point return true.else return false.*/
            return true;
        }
        return false;
    }
    // Return the width and height of the rectangle

    /**
     * returns the width of the rectangle.
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * returns the height of the rectangle.
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * draws the rectangle on a drawing surface.
     * @param surface the drawing surface
     */
    public void drawOn(DrawSurface surface) {
        //draws the rectangle in the needed color and the lines in black.
        surface.fillRectangle((int) getUpperLeft().getX(), (int) upperLeft.getY(), (int) width, (int) height);
        surface.setColor(java.awt.Color.BLACK);
        surface.drawRectangle((int) getUpperLeft().getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    /**
     * Returns the upper-left point of the rectangle.
     * @return  the upper-left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}