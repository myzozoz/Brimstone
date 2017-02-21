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

public class Updater {
    public static boolean update(long dTime, DirectionListener dl, List<Enemy> enemies, Player player, Level lvl, List<Flame> flames, List<NCU> ncus) {
        boolean gameContinues = true;
        Updater.updatePlayer(dTime, dl, player);
        gameContinues = Updater.checkPlayerCollisions(enemies, player ,lvl, ncus);
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
            for (Flame f : flames) {
                if (CollisionManager.collides(enemies.get(i), f)) {
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

    public static void playerFlames(Player player, List<Flame> flames) {
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
