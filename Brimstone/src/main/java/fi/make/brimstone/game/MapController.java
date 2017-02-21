package fi.make.brimstone.game;

import fi.make.brimstone.game.mapobjects.Level;
import fi.make.brimstone.game.mapobjects.Enemy;
import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.flames.Flame;
import java.util.List;
import java.util.ArrayList;
import fi.make.brimstone.gui.DirectionListener;

//Container class for all of the map objects
/**
 * Takes care of the level and the objects within it.
 *
 * @author make
 */
public class MapController {

    private boolean paused;
    private Player player;
    private Level lvl0;
    private List<Enemy> enemies;
    private List<NCU> ncus;
    private List<Flame> flames;
    private String printOnScreen;
    private DirectionListener dl;

    /**
     *
     */
    public MapController(DirectionListener dl) {
        //this.dl = dl;
        flames = new ArrayList();
        enemies = new ArrayList();
        ncus = new ArrayList();
        paused = true;
        //Get the initial locations of all of the MapObjects that already exist
        //TEST
        player = new Player(50, 50);
        lvl0 = new Level(0, 0);
        enemies.add(new Enemy(1000, 100, player));
        enemies.add(new Enemy(50, 1000, player));
        enemies.add(new Enemy(2000, 2000, player));
        enemies.add(new Enemy(2000, 200, player));
        ncus.add(new NCU(1000, 200));
        ncus.add(new NCU(1000, 232));
        ncus.add(new NCU(1000, 264));
        ncus.add(new NCU(1032, 264));
        ncus.add(new NCU(1064, 264));
        //TEST
    }

    /**
     *
     * @return Returns all MapObjects possessed by the MapController as a List.
     */
    public List<MapObject> getAllObjects() {
        Updater.playerFlames(player, flames);
        List<MapObject> l = new ArrayList();
        l.add(lvl0);
        l.add(player);
        l.addAll(enemies);
        l.addAll(ncus);
        l.addAll(flames);
        return l;
    }

    public void setDirectionListener(DirectionListener dl) {
        this.dl = dl;
    }

    public void togglePause() {
        if (paused) {
            paused = false;
        } else {
            paused = true;
        }
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
    public boolean mapUpdate(long dTime) {
        if (!paused) {
            return Updater.update(dTime, dl, enemies, player, lvl0, flames, ncus);
        }
        return true;
    }
}
