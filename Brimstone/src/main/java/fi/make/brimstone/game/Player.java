package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.Variables;

public class Player extends MapObject {

    private Vector speed;
    private double accelConst;
    private double decelConst;

    public Player(double x, double y) {
        super(x, y, Variables.PLAYER_IMAGE);
        accelConst = Variables.ACCELERATION_MULTIPLIER;
        decelConst = Variables.DECELERATION_MULTIPLIER;
        speed = Variables.PLAYER_SPEED;
    }

    public void updatePosition(long dTime) {
        x += speed.x * dTime;
        y += speed.y * dTime;
    }

    public void accelerate(double x, double y, long dTime) {
        System.out.println("ACCELERATING");
        speed.x += x * accelConst * dTime;
        speed.y += y * accelConst * dTime;
    }

    public void decelerateVertical(long dTime) {
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

    public void decelerateHorizontal(long dTime) {
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

    public Vector getSpeed() {
        return speed;
    }

}
