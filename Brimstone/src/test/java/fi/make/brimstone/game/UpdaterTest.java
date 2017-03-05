/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.game;

import fi.make.brimstone.game.mapobjects.Enemy;
import fi.make.brimstone.game.mapobjects.Level;
import fi.make.brimstone.game.mapobjects.NCU;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.flames.Flame;
import fi.make.brimstone.game.mapobjects.flames.LeftFlame;
import fi.make.brimstone.gui.DirectionListener;
import fi.make.brimstone.helpers.FlameDirection;
import fi.make.brimstone.helpers.Vector;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author make
 */
public class UpdaterTest {

    Player player;
    Level lvl0;
    List<Enemy> enemies;
    List<NCU> ncus;
    List<Flame> flames;

    /**
     *
     */
    public UpdaterTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
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
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     *
     */
    @Test
    public void firstUpdateReturnsTrue() {
        assertTrue(Updater.update(0, new DirectionListener(new MapController()), enemies, player, lvl0, flames, ncus));
    }

    /**
     *
     */
    @Test
    public void createsNoFlamesWhenPlayerIsStandingStill() {
        ArrayList<Flame> newFlames = Updater.playerFlames(player);
        assertEquals(newFlames.size(), 0);
    }

    /**
     *
     */
    @Test
    public void createsFlamesWhenPlayerIsMoving() {
        player.setSpeed(new Vector(1.5, 1.5));
        player.setFlameLength();
        ArrayList<Flame> newFlames = Updater.playerFlames(player);
        assertEquals(6, newFlames.size());
    }

    /**
     *
     */
    @Test
    public void createsFlamesOfCorrectOrientation() {
        player.setSpeed(new Vector(1.5, 1.5));
        player.setFlameLength();
        player.setFlameDir(FlameDirection.LEFT);
        ArrayList<Flame> newFlames = Updater.playerFlames(player);
        assertEquals(LeftFlame.class, newFlames.get(0).getClass());
    }

    @Test
    public void spawnsNewEnemy() {
        Updater.spawnEnemy(player, enemies);
        assertEquals(5, enemies.size());
    }
}
