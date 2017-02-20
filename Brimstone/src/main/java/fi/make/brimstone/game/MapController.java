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

    private Player plr;
    private Level lvl0;
    private List<Enemy> enms;
    private List<NCU> ncus;

    /**
     *
     */
    public MapController() {
        enms = new ArrayList();
        ncus = new ArrayList();
        //Get the initial locations of all of the MapObjects that already exist
        //TEST
        plr = new Player(50, 50);
        lvl0 = new Level(0, 0);
        enms.add(new Enemy(50, 100));
        enms.add(new Enemy(50, 150));
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
        l.add(plr);
        l.addAll(enms);
        l.addAll(ncus);
        return l;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addEnemy(int x, int y) {
        enms.add(new Enemy(x, y));
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
        return plr;
    }

    /**
     *
     * @return
     */
    public List<Enemy> getEnemies() {
        return enms;
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
                plr.accelerate(0d, -1d, dTime);
            }
            if (dl.isKeyDown("S")) {
                plr.accelerate(0d, 1d, dTime);
            }
        } else {
            plr.decelerateVertical(dTime);
        }

        if (dl.isKeyDown("A") || dl.isKeyDown("D")) {
            if (dl.isKeyDown("A")) {
                plr.accelerate(-1d, 0d, dTime);
            }
            if (dl.isKeyDown("D")) {
                plr.accelerate(1d, 0d, dTime);
            }
        } else {
            plr.decelerateHorizontal(dTime);
        }
    }

    private void checkPlayerCollisions() {
        double speedX = plr.getSpeed().x;
        double speedY = plr.getSpeed().y;

        //WALLS
        if (plr.getX() < 32 || plr.getX() > lvl0.getLevelDimensions().x - 64) {
            plr.setSpeed(new Vector(-0.5 * speedX, speedY));
        }
        if (plr.getY() < 32 || plr.getY() > lvl0.getLevelDimensions().y - 64) {
            plr.setSpeed(new Vector(speedX, -0.5 * speedY));
        }

        for (Enemy e : enms) {
            if (e.getX() - plr.getX() < 32 && e.getX() - plr.getX() > -32
                    && e.getY() - plr.getY() < 32 && e.getY() - plr.getY() > -32) {
                //TODO Game Over -code
                System.out.println("GAME OVER");
            }
        }
        
        unStickPlayer();
    }

    private void unStickPlayer() {
        if (plr.getX() < 32) {
            plr.setX(32);
        } else if (plr.getX() > lvl0.getLevelDimensions().x - 64) {
            plr.setX(lvl0.getLevelDimensions().x - 64);
        }
        if (plr.getY() < 32) {
            plr.setY(32);
        } else if (plr.getY() > lvl0.getLevelDimensions().y - 64) {
            plr.setY(lvl0.getLevelDimensions().y - 64);
        }
    }
    
    private void updateEnemies(double dTime){
        System.out.println("------------------------");
        for (Enemy e : enms){
            Vector dPlayerEnemy = new Vector(plr.getX() - e.getX(), plr.getY() - e.getY());
            Vector newDirection = new Vector(dPlayerEnemy.x / dPlayerEnemy.getAbs(), dPlayerEnemy.y / dPlayerEnemy.getAbs());
            System.out.println("nuDir: " + newDirection);
            e.setDirection(newDirection);
            e.updatePosition(dTime);
            System.out.println("speed: " + e.getSpeed());
            System.out.println("dir: " + e.getDirection());
        }
    }
}
