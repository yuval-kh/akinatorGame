package shapes;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collisionandvelocity.Velocity;
import animationsandgame.GameLevel;
import interfaces.Collidable;
import interfaces.Sprite;

/**Class shapes.Paddle.
 * describes the paddle of the game.
 *  @author Yuval Khanimov
 *  <yuval953@gmail.com>
 *  ID 318970902 */
public class Paddle implements Sprite, Collidable {
    //the step of the paddle at every time the key is pressed
    private static final int PADDLE_STEP = 10;

    private biuoop.KeyboardSensor keyboard; //keyboard sensor for the paddle.
    private Rectangle rectangle; //the rectangle of the paddle.
    private java.awt.Color color; //the color of the paddle.
    private int from;  //the left border that the paddle cant pass.
    private int to;  //the right border that the paddle cant pass.
    private int step;

    /**
     * Constructor of paddle.
     * creates a new paddle using rectangle keyboard and color.
     * @param rectangle the rectangle of the new paddle.
     * @param keyboard the keyboard of the new paddle.
     * @param color the color of the new paddle.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, java.awt.Color color) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.color = color;
        /*initializing from and to variables it to -1 means there will be no use
        in these values, and the paddle can go out of the screen.*/
        this.from = -1;
        this.to = -1;
        this.step = PADDLE_STEP;
    }
    /**
     * Constructor of paddle.
     * creates a new paddle using rectangle keyboard and color.
     * @param rectangle the rectangle of the new paddle.
     * @param keyboard the keyboard of the new paddle.
     * @param color the color of the new paddle.
     * @param step the step of the paddle.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, java.awt.Color color, int step) {
        this(rectangle, keyboard, color);
        this.step = step;
    }

    /**
     * Constructor of paddle.
     * creates a new paddle using rectangle keyboard and color.
     * @param rectangle the rectangle of the new paddle.
     * @param keyboard the keyboard of the new paddle.
     * @param color the color of the new paddle.
     * @param from the left border that the paddle cant pass.
     * @param to the right border that the paddle cant pass.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, java.awt.Color color, int from, int to) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.color = color;
        this.from = from;
        this.to = to;
        this.step = PADDLE_STEP;
    }
    /**
     * Constructor of paddle.
     * creates a new paddle using rectangle keyboard and color.
     * @param rectangle the rectangle of the new paddle.
     * @param keyboard the keyboard of the new paddle.
     * @param color the color of the new paddle.
     * @param from the left border that the paddle cant pass.
     * @param to the right border that the paddle cant pass.
     * @param step the step of the paddle.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, java.awt.Color color, int from, int to, int step) {
        this(rectangle, keyboard, color, from, to);
        this.step = step;
    }
    /**
     * moves the paddle left if the left arrow is pressed.
     */
    public void moveLeft() {
        if (keyboard.isPressed(biuoop.KeyboardSensor.LEFT_KEY)) { //if left arrow is pressed
            rectangle.setUpperLeft(new Point(rectangle.getUpperLeft().getX() - step,
                                       rectangle.getUpperLeft().getY()));
            //the Y of the paddle is the same Y, and the X decreases by the step.
            if (from != -1) { //if there is a use in this variable.
                if (rectangle.getUpperLeft().getX() < from) {
                    rectangle.getUpperLeft().setX(from);
                }
            }
        }
    }

    /**
     * moves the paddle right if the right arrow is pressed.
     */
    public void moveRight() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            rectangle.setUpperLeft(new Point(rectangle.getUpperLeft().getX() + step,
                    rectangle.getUpperLeft().getY()));
            //the Y of the paddle is the same Y, and the X increases by the step.
            if (to != -1) { //if there is a use in this variable.
                if (rectangle.getUpperLeft().getX() + rectangle.getWidth() > to) {
                    rectangle.getUpperLeft().setX(to - rectangle.getWidth());
                }
            }
        }
    }


    /**
     * as the time passes the program always check.
     * if the paddle need to move left or right
     */
    public void timePassed() {
        moveLeft();
        moveRight();
    }

    /**
     * draws the paddle on a drawing surface.
     * @param d the drawing surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        rectangle.drawOn(d);
    }

    /**
     * gets the rectangle of the paddle.
     * @return the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     *  Notify the object that we collided with it at collisionPoint with a given velocity.
     *  The return is the new velocity expected after the hit
     *  depending on the collison area of the paddle.
     * @param collisionPoint the collision point of the object.
     * @param currentVelocity the current velocity of the object.
     * @param hitter The ball hitter .
     * @return the new velocity of the object.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (rectangle.isIntersactWithUpOrDown(collisionPoint)) {
            /*if the ball hits on up or down of the paddle checks on which
            * region it collided and returns the velocity depending on the region.*/
            int region = getCollisionRegion(collisionPoint); //the region of the paddle (1-5).
            currentVelocity = regionTovelocity(region, currentVelocity);
        } else if (rectangle.isIntersactWithLeftOrRight(collisionPoint)) {
            //if the hit is with the sides of the paddle changes only the dx.
            currentVelocity.setDx(-1 * currentVelocity.getDx());
        }
        return  currentVelocity; //returns the new velocity.
    }

    /**
     * gets the region of the paddle using the collision point.
     * @param collisonPoint the collision point with the ball.
     * @return the region of the paddle.
     */
    private int getCollisionRegion(Point collisonPoint) {
        double start = rectangle.getUpperLeft().getX(); //the start of the upper line of the paddle.
        if (collisonPoint.getX() <= start + rectangle.getWidth() / 5) {
            //if its in the first 1/5 of the paddle it's the first region.
            return 1;
        }
        if (collisonPoint.getX() <= start + (2 * rectangle.getWidth() / 5)) {
            //if its in the second 1/5 of the paddle it's the first region.
            return 2;
        }
        if (collisonPoint.getX() <= start + (3 * rectangle.getWidth() / 5)) {
            //if its in the third 1/5 of the paddle it's the first region.
            return 3;
        }
        if (collisonPoint.getX() <= start + (4 * rectangle.getWidth() / 5)) {
            //if its in the fourth 1/5 of the paddle it's the first region.
            return 4;
        }
        if (collisonPoint.getX() <= start + (5 * rectangle.getWidth() / 5)) {
            //if its in the fifth 1/5 of the paddle it's the first region.
            return 5;
        }
        return  -1; //if its not one of the above there is error.
    }

    /**
     * converts region of the paddle to new velocity.
     * @param region the region which the ball hit.
     * @param oldVelocity the old velocity of the ball.
     * @return new velocity.
     */
    private Velocity regionTovelocity(int region, Velocity oldVelocity) {
        if (region == 3) {
            //if its the third region the paddle acts like a block.
            oldVelocity.setDy(oldVelocity.getDy() * -1);
            return oldVelocity;
        }
        if (region < 1) {
            return null; //region cant be smaller than one.
        }
        int flag = 0;
        if (oldVelocity.getDy() < 0) {
            flag = 1; //if it hits the paddle from the down line flag becomes 1.
        }
        int angle = 270 + 30 * region; //the new angle of the velocity.
        double speed = Math.sqrt(oldVelocity.getDx() * oldVelocity.getDx()
                              + oldVelocity.getDy() * oldVelocity.getDy()); //converts the old velocity to speed.
        Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
        if (flag == 1) {
            //if the ball hits the paddle from down it should go to the opposite direction.
            v.setDy(v.getDy() * -1);
        }
        return v; //returns the new velocity of the ball.
    }

    /**
     * Adds this paddle to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        //paddle is a collidable and a sprite.
        //adds it to both lists.
        g.addCollidable(this);
        g.addSprite(this);
    }
}