package fi.make.brimstone.game;

import fi.make.brimstone.game.mapobjects.Level;
import fi.make.brimstone.game.mapobjects.Enemy;
import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.flames.Flame;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import fi.make.brimstone.gui.DirectionListener;

//Container class for all of the map objects
/**
 * Takes care of the level and the objects within it. Calls static logic update
 * functions from the Updater -class. This class defines the game mode, other
 * classes are more or less game mode independent.
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
    private DirectionListener dl;
    private int enemiesKilled;
    private int enemiesAllowedOnMap;
    private Random rand;

    /**
     * Initializes the playing field.
     */
    public MapController() {
        rand = new Random();
        flames = new ArrayList();
        enemies = new ArrayList();
        ncus = new ArrayList();
        paused = true;
        player = new Player(50, 50);
        lvl0 = new Level(0, 0);
        enemies.add(new Enemy(2000, 2000, player));
        enemiesAllowedOnMap = 1;
        Updater.initializeWalls(ncus);
    }

    /**
     * This method is called by the GUI for drawing the game.
     *
     * @return Returns all MapObjects possessed by the MapController as a List.
     */
    public List<MapObject> getAllObjects() {
        flames = Updater.playerFlames(player);
        List<MapObject> l = new ArrayList();
        l.add(lvl0);
        l.add(player);
        l.addAll(enemies);
        l.addAll(ncus);
        l.addAll(flames);
        return l;
    }

    /**
     * It is important that this method is called before trying to use the
     * MapController. Can't be set in the constructor, because the
     * DirectionListener class requires a MapController class in its
     * constructor.
     *
     * @param dl The DirectionListener initialized in the Game-class
     */
    public void setDirectionListener(DirectionListener dl) {
        this.dl = dl;
    }

    /**
     * Sets the paused -state on/off.
     */
    public void togglePause() {
        if (paused) {
            paused = false;
        } else {
            paused = true;
        }
    }

    /**
     * Pause state getter.
     *
     * @return Pause status
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Adds an enemy in a specific location.
     *
     * @param x x location.
     * @param y y location.
     */
    public void addEnemy(int x, int y) {
        enemies.add(new Enemy(x, y, player));
    }

    /**
     * Adds an NCU in a specific location.
     *
     * @param x x location.
     * @param y y location.
     */
    public void addNCU(int x, int y) {
        ncus.add(new NCU(x, y));
    }

    /**
     * Player getter.
     * @return Player object.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Enemy getter.
     * @return List of Enemy objects.
     */
    public List<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * This method is called by the general update method possessed by the Game
     * class. It takes care of updating the logic side of the game.
     *
     * @param dTime Time since last update.
     * @return Returning false signals the Game class to stop looping.
     */
    public boolean mapUpdate(long dTime) {
        if (!paused) {
            spawnEnemiesOnMap();
            return Updater.update(dTime, dl, enemies, player, lvl0, flames, ncus);
        }
        return true;
    }

    /**
     * Getter for the amount of living enemies.
     * @return Living Enemy objects as int.
     */
    public int getEnemyAmount() {
        return enemies.size();
    }

    /**
     * Getter for the amount of enemies the player has killed.
     * @return Killed Enemy objects as int.
     */
    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    private void spawnEnemiesOnMap() {
        if (enemies.size() < enemiesAllowedOnMap) {
            Updater.spawnEnemy(player, enemies);
            Updater.spawnEnemy(player, enemies);
            enemiesKilled++;
            enemiesAllowedOnMap++;
        }
    }

}
