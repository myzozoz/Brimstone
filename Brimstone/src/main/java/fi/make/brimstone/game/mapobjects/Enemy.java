package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.Vector;

/**
 * The Enemy class inherits MapObject, and hence has a drawable image and
 * locations on the x and y axes. The enemy also always contains a player object
 * that it chases.
 *
 * @author make
 */
public class Enemy extends MapObject {

    private Player player;
    private double[] oldLocation;

    /**
     * Calls the super constructor.
     * @param x Initial x location.
     * @param y Initial y location.
     * @param p The player it chases
     */
    public Enemy(double x, double y, Player p) {
        super(x, y, Variables.ENEMY_IMAGE);
        player = p;
        oldLocation = new double[]{x, y};

    }

    /**
     * Moves the enemy towards the player. Also stores previous coordinates in
     * case of collision with a wall-object.
     *
     * @param dTime The movement calculations are performance bound (not
     * real-time-adjusted) due to buggy behavior. This parameter has not been
     * removed due to being benign and being there for future implementation.
     */
    public void move(long dTime) {
        oldLocation[0] = x;
        oldLocation[1] = y;
        Vector toPlayer = new Vector(player.getX() - x, player.getY() - y);
        x += (toPlayer.x / toPlayer.getAbs()) * Variables.ENEMY_DEFAULT_SPEED;
        y += (toPlayer.y / toPlayer.getAbs()) * Variables.ENEMY_DEFAULT_SPEED;
    }

    /**
     * In case of collision with a wall, returns the enemy to its last position
     * in order to avoid sticking to walls.
     */
    public void revertMove() {
        x = oldLocation[0];
        y = oldLocation[1];
    }

    /**
     * Calculates the distance to the player.
     * @return The absolute distance to the player.
     */
    public double getDistanceToPlayer() {
        Vector toPlayer = new Vector(player.getX() - x, player.getY() - y);
        return toPlayer.getAbs();
    }
}
