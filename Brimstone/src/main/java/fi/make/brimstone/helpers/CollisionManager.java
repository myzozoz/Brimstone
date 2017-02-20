package fi.make.brimstone.helpers;

import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Enemy;
import fi.make.brimstone.game.mapobjects.Level;

public class CollisionManager {

    public static boolean collides(MapObject a, MapObject b) {
        if (b.getX() - a.getX() < 32
                && b.getX() - a.getX() > -32
                && b.getY() - a.getY() < 32
                && b.getY() - a.getY() > -32) {
            return true;
        }
        return false;
    }

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
    
    public static void unStickEnemy(Enemy e){
        
    }

}
