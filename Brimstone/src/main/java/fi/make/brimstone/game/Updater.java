package fi.make.brimstone.game;

import java.util.List;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.Enemy;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Level;
import fi.make.brimstone.game.mapobjects.flames.DownFlame;
import fi.make.brimstone.game.mapobjects.flames.Flame;
import fi.make.brimstone.game.mapobjects.flames.LeftFlame;
import fi.make.brimstone.game.mapobjects.flames.RightFlame;
import fi.make.brimstone.game.mapobjects.flames.UpFlame;
import fi.make.brimstone.gui.DirectionListener;
import fi.make.brimstone.helpers.CollisionManager;
import fi.make.brimstone.helpers.Vector;
import java.util.ArrayList;
import java.util.Random;

/**
 * Updater is a logic class that has no class variables of its own. It takes
 * care of player and enemy movement, and recreating the flame objects for every
 * frame.
 *
 * @author make
 */
public class Updater {

    /**
     * update(...) is a broader method, that edits the status of the items that
     * are simply contained inside the MapController class. Due to being static,
     * receives all of the editable objects as parameters.
     *
     * @param dTime Elapsed time since last update.
     * @param dl DirecionListener.
     * @param enemies List of Enemies
     * @param player The player.
     * @param lvl Current level.
     * @param flames List of flame-objects
     * @param ncus List of walls.
     * @return Returns a boolean that the MapController passes on to Game.
     * Signals Game to stop looping if false.
     */
    public static boolean update(long dTime, DirectionListener dl, List<Enemy> enemies, Player player, Level lvl, List<Flame> flames, List<NCU> ncus) {
        boolean gameContinues = true;
        Updater.updatePlayer(dTime, dl, player);
        gameContinues = Updater.checkPlayerCollisions(enemies, player, lvl, ncus);
        Updater.updateEnemies(dTime, enemies, flames, ncus);
        player.updatePosition(dTime);
        return gameContinues;
    }

    private static void updatePlayer(long dTime, DirectionListener dl, Player player) {
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

    private static boolean checkPlayerCollisions(List<Enemy> enemies, Player player, Level lvl, List<NCU> ncus) {
        double speedX = player.getSpeed().x;
        double speedY = player.getSpeed().y;

        boolean gameContinues = true;

        //OUTER WALLS
        if (player.getX() < 32 || player.getX() > lvl.getLevelDimensions().x - 64) {
            player.setSpeed(new Vector(-0.5 * speedX, speedY));
        }
        if (player.getY() < 32 || player.getY() > lvl.getLevelDimensions().y - 64) {
            player.setSpeed(new Vector(speedX, -0.5 * speedY));
        }

        //ENEMIES
        for (Enemy e : enemies) {
            if (CollisionManager.collides(player, e)) {
                gameContinues = false;

                //TODO: game over
            }
        }

        //NCUs
        for (NCU n : ncus) {
            if (CollisionManager.collides(player, n)) {
                CollisionManager.redirectPlayerFromWall(player, n);
            }
        }

        CollisionManager.unStickPlayer(player, lvl);

        return gameContinues;
    }

    private static void updateEnemies(long dTime, List<Enemy> enemies, List<Flame> flames, List<NCU> ncus) {
        for (int i = 0; i < enemies.size(); i++) {
            for (int f = 0; f < flames.size(); f++) {
                if (CollisionManager.collides(enemies.get(i), flames.get(f))) {
                    enemies.remove(i);
                    return;
                }
            }

            boolean canMove = true;
            for (NCU n : ncus) {
                if (CollisionManager.collides(enemies.get(i), n)) {
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

    /**
     * Calculates the positions and creates new flame -objects of correct
     * orientation. Always clears before recalculating.
     *
     * @param player The player.
     * @return List of flame -objects.
     */
    public static ArrayList<Flame> playerFlames(Player player) {
        ArrayList<Flame> nflames = new ArrayList();
        for (int i = 0; i < player.getFlameLength(); i++) {
            switch (player.getFlameDir()) {
                case UP:
                    nflames.add(new UpFlame(player.getX(), player.getY() - 32 * (i + 1)));
                    break;
                case DOWN:
                    nflames.add(new DownFlame(player.getX(), player.getY() + 32 * (i + 1)));
                    break;
                case RIGHT:
                    nflames.add(new RightFlame(player.getX() + 32 * (i + 1), player.getY()));
                    break;
                case LEFT:
                    nflames.add(new LeftFlame(player.getX() - 32 * (i + 1), player.getY()));
                    break;
            }
        }
        return nflames;
    }

    /**
     * A helper function that creates the walls for the level. Could be changed
     * to read specific wall locations from a file for example.
     *
     * @param walls List of the walls to be used
     */
    public static void initializeWalls(List<NCU> walls) {
        for (int x = 300; x < 1300; x += 32) {
            walls.add(new NCU(x, 300));
            walls.add(new NCU(x, 1200));
            walls.add(new NCU(x, 2100));
            walls.add(new NCU(x, 2700));
        }

        for (int x = 2000; x < 2700; x += 32) {
            walls.add(new NCU(x, 800));
            walls.add(new NCU(x, 1700));
        }

        for (int y = 300; y < 1000; y += 32) {
            walls.add(new NCU(1650, y));
            walls.add(new NCU(1650, y + 1000));
        }
    }

    /**
     * Spawns an enemy in a random location on the map. Rerandoms the location
     * until it's at least 100 units from the player.
     *
     * @param player The player.
     * @param enemies The enemies
     */
    public static void spawnEnemy(Player player, List<Enemy> enemies) {
        Random rand = new Random();
        int x = rand.nextInt(2900) + 50;
        int y = rand.nextInt(2900) + 50;
        while (Math.abs(x - player.getX()) < 100 && Math.abs(y - player.getX()) < 100) {
            x = rand.nextInt(2900) + 50;
            y = rand.nextInt(2900) + 50;
        }
        enemies.add(new Enemy(x, y, player));
    }
}
