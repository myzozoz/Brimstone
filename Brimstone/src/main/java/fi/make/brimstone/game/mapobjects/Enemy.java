package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.Vector;

/**
 *
 * @author make
 */
public class Enemy extends MapObject {

    private Player player;
//    private Vector speed;
//    private Vector dir;
//    private double speedAbs;
    private double[] oldLocation;

    /**
     *
     * @param x Initial x location.
     * @param y Initial y location.
     */
    public Enemy(double x, double y, Player p) {
        super(x, y, Variables.ENEMY_IMAGE);
        player = p;
        oldLocation = new double[]{x, y};
//        dir = new Vector(0, 0);
//        speed = new Vector(0, 0);
//        setDefaultSpeed();
    }

    public void move(long dTime) {
        oldLocation[0] = x;
        oldLocation[1] = y;
        Vector toPlayer = new Vector(player.getX() - x, player.getY() - y);
        x += (toPlayer.x / toPlayer.getAbs()) * Variables.ENEMY_DEFAULT_SPEED;
        y += (toPlayer.y / toPlayer.getAbs()) * Variables.ENEMY_DEFAULT_SPEED;
    }

    public void revertMove() {
        x = oldLocation[0];
        y = oldLocation[1];
    }

    public double getDistanceToPlayer() {
        Vector toPlayer = new Vector(player.getX() - x, player.getY() - y);
        return toPlayer.getAbs();
    }
}

//
//    public void updatePosition(double dTime) {
//        x += speed.x * dTime;
//        y += speed.y * dTime;
//    }
//
//    public void setDirection(Vector dir) {
//        //the parameter direction's values are normalized just in case 
//        //it isn't before hand
//        if (this.dir.x == 0 && this.dir.y == 0) {
//            setSpeed(dir);
//            setSpeed(speedAbs);
//        } else if (dir.getAbs() != 1.0) {
//            this.dir.x = dir.x / dir.getAbs();
//            this.dir.y = dir.y / dir.getAbs();
//        } else {
//            this.dir.x = dir.x;
//            this.dir.y = dir.y;
//        }
//        System.out.println("DirParam: " + dir + ", DirVar: " + this.dir);
//        
//    }
//
//    public void setSpeed(Vector speed) {
//        this.speed = speed;
//        this.speedAbs = speed.getAbs();
//        dir.x = speed.x / speedAbs;
//        dir.y = speed.y / speedAbs;
//    }
//
//    public void setSpeed(double speed) {
//        this.speed.x = dir.x * speed;
//        this.speed.y = dir.y * speed;
//    }
//
//    public void setDefaultSpeed() {
//        setSpeed(Variables.ENEMY_DEFAULT_SPEED);
//    }
//
//    public Vector getSpeed() {
//        return this.speed;
//    }
//
//    public Vector getDirection() {
//        if (speed.getAbs() != 0) {
//            return new Vector(speed.x / speed.getAbs(), speed.y / speed.getAbs());
//        } else {
//            return new Vector(0, 0);
//        }
//    }
//    

