package shapes; /** @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
import biuoop.DrawSurface;
import collections.GameEnvironment;
import collisionandvelocity.CollisionInfo;
import collisionandvelocity.Velocity;
import animationsandgame.GameLevel;
import interfaces.Collidable;
import interfaces.Sprite;



/**shapes.Ball Class.
 * describes a ball in the 2D space.*/
public class Ball  implements Sprite {
    private Point center;  //the center of the ball.
    private int r;         // //the radius of the ball.
    private java.awt.Color color;  //the color of the ball.
    private Velocity v;    //the velocity of the ball.
    private GameEnvironment game; //the GameEnviroment which includes all the collidables.
    /** Constructor of shapes.Ball.
     * <p>
     * puts the given parameters to the new instance of the class.
     * <p>
     *  sets default value of 0 to the velocity.
     *  @param center the center of the new instance of shapes.Ball.
     *  @param r the radius  of the new instance of shapes.Ball.
     *  @param color the color  of the new instance of shapes.Ball.*/
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.v = new Velocity(0, 0);
        this.r = r;
        this.color = color;
        game = new GameEnvironment();
    }
    /** Constructor of shapes.Ball.
     * <p>
     * puts the given parameters to the new instance of the class.
     * <p>
     *  @param v the velocity of the new instance of shapes.Ball.
     *  @param center the center of the new instance of shapes.Ball.
     *  @param r the radius  of the new instance of shapes.Ball.
     *  @param color the color  of the new instance of shapes.Ball.*/
    public Ball(Point center, int r, java.awt.Color color, Velocity v) {
        this.center = center;
        this.v = v;
        this.r = r;
        this.color = color;
        game = new GameEnvironment();
    }
    /** Constructor of shapes.Ball.
     * <p>
     * puts the given parameters to the new instance of the class.
     * <p>
     *  sets default value of 0 to the velocity.
     *  @param x the X coordinate of the radius.
     *  @param y the Y coordinate of the radius.
     *  @param r the radius  of the new instance of shapes.Ball.
     *  @param color the color  of the new instance of shapes.Ball.*/
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.v = new Velocity(0, 0);
        this.r = r;
        this.color = color;
        game = new GameEnvironment();
    }

    /** gets the value to the X coordinate of the radius.
     * <p>
     *  @return the X coordinate of the radius.*/
    private int getX() {
        return (int) this.center.getX();
    }
    /** gets the value to the Y coordinate of the radius.
     * <p>
     *  @return the Y coordinate of the radius.*/
    private int getY() {
        return (int) this.center.getY();
    }
    /** gets the radius coordinates.
     * <p>
     *  @return the radius point.*/
    public int getSize() {
        return this.r;
    }
    /** gets the color of the ball.
     * <p>
     *  @return the color of the ball.*/
    public java.awt.Color getColor() {
        return this.color;
    }

     /**draw the ball on the given DrawSurface.
     * <p>
     * @param surface the given surface*/
    public void drawOn(DrawSurface surface) {
        surface.setColor(java.awt.Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.r);
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * as the time passes the ball moves.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * adds the ball to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /** sets new value to the velocity of the ball.
     * <p>
     *  @param newV the new velocity of the ball.*/
    public void setVelocity(Velocity newV) {
        this.v = newV;
    }
    /** sets new value to the velocity of the ball.
     * <p>
     *  @param dx the dx of the new velocity.
     *  @param dy the dy of the new velocity.*/
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }
    /** gets the velocity of the ball.
     * <p>
     *  @return the velocity of the ball.*/
    public Velocity getVelocity() {
        return this.v;
    }

    /** apply the velocity to the ball.
     * and checks if the ball is not out of the borders that are given to the function
     * <p>
     *  @param width the upper border that the ball can't cross in the X axe.
     *  @param height the upper border that the ball can't cross in the Y axe.
     *  @param fromWidth the down border that the ball can't cross in the X axe.
     *  @param fromHeight the down border that the ball can't cross in the Y axe.*/
    public void moveOneStep(int width, int height, int fromWidth, int fromHeight) {
        //apply the velocity to the ball.
        this.center = this.getVelocity().applyToPoint(this.center);

        /*if its crossed the one of the borders changes
        the velocity and bring it back to the correct place*/
        if (center.getX() + r + v.getDx() > width) {
            this.v.setDx(-1 * v.getDx());
            center.setX(width - r);
        }
        if (center.getX() - r + v.getDx() < fromWidth) {
            this.v.setDx(-1 * v.getDx());
            center.setX(r + fromWidth);
        }
        if (center.getY() + r + v.getDy() > height) {
            this.v.setDy(-1 * v.getDy());
            center.setY(height - r);
        }
        if (center.getY() - r + v.getDy() < fromHeight) {
            this.v.setDy(-1 * v.getDy());
            center.setY(r + fromHeight);
        }
    }
    /** apply the velocity to the ball.
     * and checks if the ball is not out of the borders of the
     * surface from the beginning of the surface.
     * <p>
     *  @param width the width of the surface.
     *  @param height the height of the surface.*/
    public void moveOneStep(int width, int height) {
        //calls the function with down borders 0,0 to the width and height of the surface.
        moveOneStep(width, height, 0, 0);
    }

    /**
     * sets a new value to the game parameter.
     * @param newGame the new game environment.
     */
    public void setGame(GameEnvironment newGame) {
        this.game = newGame;
    }

    /**
     * creates a one step of the ball.
     */
    public void moveOneStep() {
        Point oldcenter = center;
        //step is the ball's location after the velocity is applied.
        Point step = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(center, step);
        //trajectory is the ball's path.collision is the closest collision point in this path.
        CollisionInfo collision = game.getClosestCollision(trajectory);
        if (collision == null) {
            //if there were no collisions doing this step and ends the function.
            center = step;
            return;
        }
        center = collision.collisionPoint(); //the new center of the ball is right before the collision.
        // hit changes the velocity according to the collision that is made
        this.v = collision.collisionObject().hit(this, collision.collisionPoint(), v);
        center = this.v.applyToPoint(this.center);
        if (!(isBallinsideBlock(game, center))) {
            //if the ball's location after that is inside a collidable -
            // moving the ball the previous place.
            center = oldcenter;
        }

    }

    /**
     * checks if a point is inside a block or not.
     * @param e the GameEnviroment which include all the collidables.
     * @param p the point.
     * @return true if the point in not in a collidable false if not.
     */
    private boolean isBallinsideBlock(GameEnvironment e, Point p) {
        double x, y, width, height;
        for (Collidable c:e.getCollidables()) {
            //for every collidables gets the coordinate and the width and height of it.
             x = c.getCollisionRectangle().getUpperLeft().getX();
             width = c.getCollisionRectangle().getWidth();
             height = c.getCollisionRectangle().getHeight();
             y = c.getCollisionRectangle().getUpperLeft().getY();
            if ((p.getX() >= x) && (p.getX() <= x + width) && (p.getY() >= y) && (p.getY() <= y + height)) {
                //if the point is inside this collidle returns false.
                return false;
            }
        }
        return true; //otherwise return true.
    }

    /**
     * removes a ball from the game.
     * @param myGame the game which it is removed from.
     */
    public void removeFromGame(GameLevel myGame) {
        myGame.removeSprite(this);
    }
}