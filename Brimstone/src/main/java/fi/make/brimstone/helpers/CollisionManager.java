package fi.make.brimstone.helpers;

import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Level;

/**
 * A helper class for calculating collisions and effects of collisions, in order
 * to make code in the MapController and Updater classes less convoluted.
 *
 * @author make
 */
public class CollisionManager {

    /**
     * Simply calculates whether two MapObjects are colliding. NOTE: Assumes
     * that all MapObjects are 32x32 units large objects.
     *
     * @param a Any object that extends the abstract MapObject class.
     * @param b Any object that extends the abstract MapObject class.
     * @return True if the two pieces collide.
     */
    public static boolean collides(MapObject a, MapObject b) {
        if (b.getX() - a.getX() < 32
                && b.getX() - a.getX() > -32
                && b.getY() - a.getY() < 32
                && b.getY() - a.getY() > -32) {
            return true;
        }
        return false;
    }

    /**
     * Calculates what direction the player takes after hitting the wall. This
     * method does not check for collision, so it assumes collision detection
     * has been made before hand. Direction calculations have been made on the
     * assumption, that all of the NCU's are 32x32 squares. It simply compares
     * the dX and dY values of the player and wall and, due to collision being
     * assumed, the one with the larger absolute value is bound to be the one
     * causing the collision. Then the player's speed in the direction in
     * question gets reversed and halved. (Halved in order to stop endless
     * acceleration in case of close adjacent walls).
     *
     * This method also "unsticks" the player from the wall by pushing him back
     * in the direction he came from.
     *
     * @param p Player object.
     * @param n NCU (Wall) object.
     */
    public static void redirectPlayerFromWall(Player p, NCU n) {
        Vector directionFromWall = new Vector(n.getX() - p.getX(), n.getY() - p.getY());

        if (Math.abs(directionFromWall.x) == Math.abs(directionFromWall.y)) {    //I wanted to handle the off case that the player approaches directly from a corner
            p.setSpeed(new Vector(p.getSpeed().x * -0.5, p.getSpeed().y * -0.5));
        } else {
            if (Math.abs(directionFromWall.x) > Math.abs(directionFromWall.y)) {
                p.setSpeed(new Vector(p.getSpeed().x * -.5, p.getSpeed().y));
                if (directionFromWall.x < 0) {
                    p.setX(n.getX() + 32);
                } else {
                    p.setX(n.getX() - 32);
                }
            } else {
                p.setSpeed(new Vector(p.getSpeed().x, p.getSpeed().y * -.5));
                if (directionFromWall.y < 0) {
                    p.setY(n.getY() + 32);
                } else {
                    p.setY(n.getY() - 32);
                }
            }
        }
    }

    /**
     * Makes sure the player doesn't stick to the level edges due to overlaps.
     *
     * @param player Player object.
     * @param lvl0 Level object.
     */
    public static void unStickPlayer(Player player, Level lvl0) {
        if (player.getX() < 32) {
            player.setX(32);
        } else if (player.getX() > lvl0.getLevelDimensions().x - 64) {
            player.setX(lvl0.getLevelDimensions().x - 64);
        }
        if (player.getY() < 32) {
            player.setY(32);
        } else if (player.getY() > lvl0.getLevelDimensions().y - 64) {
            player.setY(lvl0.getLevelDimensions().y - 64);
        }
    }
}
