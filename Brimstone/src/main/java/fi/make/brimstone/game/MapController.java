package fi.make.brimstone.game;

import fi.make.brimstone.game.mapobjects.Level;
import fi.make.brimstone.game.mapobjects.Enemy;
import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.flames.Flame;
import fi.make.brimstone.game.mapobjects.flames.DownFlame;
import fi.make.brimstone.game.mapobjects.flames.LeftFlame;
import fi.make.brimstone.game.mapobjects.flames.RightFlame;
import fi.make.brimstone.game.mapobjects.flames.UpFlame;
import java.util.List;
import java.util.ArrayList;
import fi.make.brimstone.gui.DirectionListener;
import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.CollisionManager;
import fi.make.brimstone.helpers.FlameDirection;

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
    private List<Flame> flames;
    private String printOnScreen;

    /**
     *
     */
    public MapController() {
        flames = new ArrayList();
        enemies = new ArrayList();
        ncus = new ArrayList();
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
        playerFlames();
        List<MapObject> l = new ArrayList();
        l.add(lvl0);
        l.add(player);
        l.addAll(enemies);
        l.addAll(ncus);
        l.addAll(flames);
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

        //OUTER WALLS
        if (player.getX() < 32 || player.getX() > lvl0.getLevelDimensions().x - 64) {
            player.setSpeed(new Vector(-0.5 * speedX, speedY));
        }
        if (player.getY() < 32 || player.getY() > lvl0.getLevelDimensions().y - 64) {
            player.setSpeed(new Vector(speedX, -0.5 * speedY));
        }

        //ENEMIES
        for (Enemy e : enemies) {
            if (CollisionManager.collides(player, e)) {
//                System.out.println("GAME OVER");
                //TODO: game over
            }
        }

        //NCUs
        for (NCU n : ncus) {
            if (CollisionManager.collides(player, n)) {
                this.printOnScreen = "hitting wall\n";
                CollisionManager.redirectPlayerFromWall(player, n);
            }
        }

        CollisionManager.unStickPlayer(player, lvl0);
    }

    private void updateEnemies(long dTime) {
        for (int i = 0; i < enemies.size(); i++) {
            for (Flame f : flames){
                if (CollisionManager.collides(enemies.get(i), f)){
                    enemies.remove(i);
                    return;
                }
            }
            
            boolean canMove = true;
            for (NCU n : ncus) {
                if (CollisionManager.collides(enemies.get(i), n)) {
                    printOnScreen = "Enemy hitting wall";
                    canMove = false;
                }
            }

            //takes care of enemy collision by stopping the one further away from the player
            for (int a = 0; a < enemies.size(); a++) {
                if (a != i && CollisionManager.collides(enemies.get(a), enemies.get(i))) {
                    if (enemies.get(i).getDistanceToPlayer() > enemies.get(a).getDistanceToPlayer()) {
                        canMove = false;
                    }
                }
            }
            if (canMove) {
                enemies.get(i).move(dTime);
            } else {
                enemies.get(i).revertMove();
            }
        }
    }

    public String getScreenPrint() {
        return this.printOnScreen;
    }

    private void playerFlames() {
        flames.clear();
        for (int i = 0; i < player.getFlameLength(); i++) {
            switch (player.getFlameDir()) {
                case UP:
                    flames.add(new UpFlame(player.getX(), player.getY() - 32 * (i + 1)));
                    break;
                case DOWN:
                    flames.add(new DownFlame(player.getX(), player.getY() + 32 * (i + 1)));
                    break;
                case RIGHT:
                    flames.add(new RightFlame(player.getX() + 32 * (i + 1), player.getY()));
                    break;
                case LEFT:
                    flames.add(new LeftFlame(player.getX() - 32 * (i + 1), player.getY()));
                    break;
            }
        }
    }

}
