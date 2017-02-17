package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.Variables;

/**
 *
 * @author make
 */
public class Player extends MapObject {

    private Vector speed;
    private double accelConst;
    private double decelConst;

    /**
     *
     * @param x Initial location on x-axis.
     * @param y Initial location on y-axis.
     */
    public Player(double x, double y) {
        super(x, y, Variables.PLAYER_IMAGE);
        accelConst = Variables.ACCELERATION_MULTIPLIER;
        decelConst = Variables.DECELERATION_MULTIPLIER;
        speed = Variables.PLAYER_SPEED;
    }

    /**
     *
     * @param dTime Time since last update (ms).
     */
    public void updatePosition(long dTime) {
        x += speed.x * dTime;
        y += speed.y * dTime;
    }

    /**
     *
     * @param x Direction on the x-axis.
     * @param y
     * @param dTime Time since last update (ms).
     */
    public void accelerate(double x, double y, long dTime) {
//        System.out.println("ACCELERATING");
        speed.x += x * accelConst * dTime;
        speed.y += y * accelConst * dTime;
    }

    /**
     * Decelerates the player. Stops him at 0.
     * 
     * @param dTime Time since last update (ms).
     */
    public void decelerateVertical(long dTime) {
        //System.out.println("DECEL_VERT");
        if (speed.y > 0) {
            if (speed.y - decelConst * dTime < 0) {
                speed.y = 0;
            } else {
                speed.y -= decelConst * dTime;
            }
        } else if (speed.y < 0) {
            if (speed.y + decelConst * dTime > 0) {
                speed.y = 0;
            } else {
                speed.y += decelConst * dTime;
            }
        }
    }

    /**
     *
     * @param dTime Time since last update (ms).
     */
    public void decelerateHorizontal(long dTime) {
        //System.out.println("DECEL_HORI");
        if (speed.x > 0) {
            if (speed.x - decelConst * dTime < 0) {
                speed.x = 0;
            } else {
                speed.x -= decelConst * dTime;
            }
        } else if (speed.x < 0) {
            if (speed.x + decelConst * dTime > 0) {
                speed.x = 0;
            } else {
                speed.x += decelConst * dTime;
            }
        }
    }

    /**
     *
     * @return
     */
    public Vector getSpeed() {
        return speed;
    }
    
    /**
     *
     * @param newSpeed
     */
    public void setSpeed(Vector newSpeed) {
        speed = newSpeed;
    }
    
    /**
     *
     * @param x
     */
    public void setX(double x){
        this.x = x;
    }
    
    /**
     *
     * @param y
     */
    public void setY(double y){
        this.y = y;
    }

}
