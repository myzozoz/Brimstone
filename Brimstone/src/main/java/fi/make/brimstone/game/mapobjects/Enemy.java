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

