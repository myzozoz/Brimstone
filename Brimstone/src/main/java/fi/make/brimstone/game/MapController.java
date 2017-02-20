package fi.make.brimstone.game;

import java.util.List;
import java.util.ArrayList;
import fi.make.brimstone.gui.DirectionListener;
import fi.make.brimstone.helpers.Vector;

//Container class for all of the map objects
/**
 * Takes care of the level and the objects within it.
 *
 * @author make
 */
public class MapController {

    private Player player;
    private Level lvl0;
    private List<Enemy> enemies;
    private List<NCU> ncus;

    /**
     *
     */
    public MapController() {
        enemies = new ArrayList();
        ncus = new ArrayList();
        //Get the initial locations of all of the MapObjects that already exist
        //TEST
        player = new Player(50, 50);
        lvl0 = new Level(0, 0);
        enemies.add(new Enemy(1000, 100, player));
        enemies.add(new Enemy(50, 1000, player));
        ncus.add(new NCU(100, 200));
        ncus.add(new NCU(100, 300));
        ncus.add(new NCU(100, 400));
        //TEST
    }

    /**
     *
     * @return Returns all MapObjects possessed by the MapController as a List.
     */
    public List<MapObject> getAllObjects() {
        List<MapObject> l = new ArrayList();
        l.add(lvl0);
        l.add(player);
        l.addAll(enemies);
        l.addAll(ncus);
        return l;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addEnemy(int x, int y) {
        enemies.add(new Enemy(x, y, player));
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addNCU(int x, int y) {
        ncus.add(new NCU(x, y));
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @return
     */
    public List<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * This method is called by the general update method possessed by the Game
     * class. It takes care of updating the logic side of the game.
     *
     * @param dTime Time since last update.
     * @param dl Reference to the KeyListener class.
     */
    public void mapUpdate(long dTime, DirectionListener dl) {
        updatePlayer(dTime, dl);
        checkPlayerCollisions();
        updateEnemies(dTime);
    }

    private void updatePlayer(long dTime, DirectionListener dl) {
        if (dl.isKeyDown("W") || dl.isKeyDown("S")) {
            if (dl.isKeyDown("W")) {
                player.accelerate(0d, -1d, dTime);
            }
            if (dl.isKeyDown("S")) {
                player.accelerate(0d, 1d, dTime);
            }
        } else {
            player.decelerateVertical(dTime);
        }

        if (dl.isKeyDown("A") || dl.isKeyDown("D")) {
            if (dl.isKeyDown("A")) {
                player.accelerate(-1d, 0d, dTime);
            }
            if (dl.isKeyDown("D")) {
                player.accelerate(1d, 0d, dTime);
            }
        } else {
            player.decelerateHorizontal(dTime);
        }
    }

    private void checkPlayerCollisions() {
        double speedX = player.getSpeed().x;
        double speedY = player.getSpeed().y;

        //WALLS
        if (player.getX() < 32 || player.getX() > lvl0.getLevelDimensions().x - 64) {
            player.setSpeed(new Vector(-0.5 * speedX, speedY));
        }
        if (player.getY() < 32 || player.getY() > lvl0.getLevelDimensions().y - 64) {
            player.setSpeed(new Vector(speedX, -0.5 * speedY));
        }

        for (Enemy e : enemies) {
            if (e.getX() - player.getX() < 32 && e.getX() - player.getX() > -32
                    && e.getY() - player.getY() < 32 && e.getY() - player.getY() > -32) {
                //TODO Game Over -code
                System.out.println("GAME OVER");
            }
        }
        
        unStickPlayer();
    }

    private void unStickPlayer() {
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
    
    private void updateEnemies(double dTime){
        System.out.println("------------------------");
        for (Enemy e : enemies){
//            Vector dPlayerEnemy = new Vector(plr.getX() - e.getX(), plr.getY() - e.getY());
//            Vector newDirection = new Vector(dPlayerEnemy.x / dPlayerEnemy.getAbs(), dPlayerEnemy.y / dPlayerEnemy.getAbs());
//            e.setDirection(newDirection);
//            e.updatePosition(dTime);
            e.move();
        }
    }
    
    
}
