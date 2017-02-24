/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.helpers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import fi.make.brimstone.game.mapobjects.Level;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.NCU;

/**
 *
 * @author make
 */
public class CollisionManagerTest {

    public CollisionManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void returnsTrueOnCollidingObjects() {
        assertTrue(CollisionManager.collides(new Player(100, 100), new NCU(100, 100)));
    }

    @Test
    public void returnsTrueOnNarrowlyCollidingObjects() {
        assertTrue(CollisionManager.collides(new Player(100, 100), new NCU(131, 131)));
    }

    @Test
    public void returnsFalseWhenAlmostCollidingOnX() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(133, 100)));
    }

    @Test
    public void returnsFalseWhenAlmostCollidingOnY() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(100, 133)));
    }

    @Test
    public void returnsFalseWhenTouchingButNotCollidingOnXPos() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(132, 100)));
    }

    @Test
    public void returnsFalseWhenTouchingButNotCollidingOnXNeg() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(68, 100)));
    }

    @Test
    public void returnsFalseWhenTouchingButNotCollidingOnYPos() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(100, 132)));
    }

    @Test
    public void returnsFalseWhenTouchingButNotCollidingOnYNeg() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(100, 68)));
    }

    @Test
    public void returnsFalseWhenNotColliding() {
        assertFalse(CollisionManager.collides(new Player(100, 100), new NCU(800, 800)));
    }

    @Test
    public void redirectsPlayerCorrectlyWhenApproachingFromLeft() {
        Player p = new Player(99, 100);
        p.setSpeed(new Vector(1.0, 0));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(-0.5, p.getSpeed().x, 0.001);
        assertEquals(0, p.getSpeed().y, 0.001);
    }

    @Test
    public void redirectsPlayerCorrectlyWhenApproachingFromMiddleUpperRight() {
        Player p = new Player(120, 90);
        p.setSpeed(new Vector(-1.0, 0.5));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(0.5, p.getSpeed().x, 0.001);
        assertEquals(0.5, p.getSpeed().y, 0.001);
    }

    @Test
    public void redirectsPlayerCorrectlyWhenApproachingFromExactLowerRight() {
        Player p = new Player(120, 120);
        p.setSpeed(new Vector(-1.32, -1.32));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(0.66, p.getSpeed().x, 0.001);
        assertEquals(0.66, p.getSpeed().y, 0.001);
    }

    @Test
    public void redirectsPlayerCorrectlyWhenApproachingFromExactLowerLeft() {
        Player p = new Player(80, 120);
        p.setSpeed(new Vector(0.89, -0.89));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(-0.445, p.getSpeed().x, 0.001);
        assertEquals(0.445, p.getSpeed().y, 0.001);
    }

    @Test
    public void redirectsPlayerCorrectlyWhenApproachingFromTop() {
        Player p = new Player(100, 80);
        p.setSpeed(new Vector(0, 1));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(0, p.getSpeed().x, 0.001);
        assertEquals(-0.5, p.getSpeed().y, 0.001);
    }

    @Test
    public void goingUpWhenCollidingOnSidesDoesNotChangeDirection() {
        Player p = new Player(120, 100);
        p.setSpeed(new Vector(0, -0.8));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(0, p.getSpeed().x, 0.001);
        assertEquals(-0.8, p.getSpeed().y, 0.001);
    }

    @Test
    public void collisionAlsoUnsticksPlayerOnXPos() {
        Player p = new Player(120, 100);
        p.setSpeed(new Vector(-1, 0));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(132, p.getX(), 0.001);
        assertEquals(100, p.getY(), 0.001);
    }

    @Test
    public void collisionAlsoUnsticksPlayerOnXNeg() {
        Player p = new Player(80, 100);
        p.setSpeed(new Vector(1, 0));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(68, p.getX(), 0.001);
        assertEquals(100, p.getY(), 0.001);
    }

    @Test
    public void collisionAlsoUnsticksPlayerOnYPos() {
        Player p = new Player(100, 101);
        p.setSpeed(new Vector(0, -1));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(100, p.getX(), 0.001);
        assertEquals(132, p.getY(), 0.001);
    }

    @Test
    public void collisionAlsoUnsticksPlayerOnYNeg() {
        Player p = new Player(100, 80);
        p.setSpeed(new Vector(-1, 0));
        NCU n = new NCU(100, 100);

        CollisionManager.redirectPlayerFromWall(p, n);
        assertEquals(100, p.getX(), 0.001);
        assertEquals(68, p.getY(), 0.001);
    }

    @Test
    public void unsticksPlayerFromLevelTopEdge() {
        Player p = new Player(100, 31);
        Level lvl = new Level(0, 0);
        CollisionManager.unStickPlayer(p, lvl);

        assertEquals(100, p.getX(), 0.001);
        assertEquals(32, p.getY(), 0.001);
    }

    @Test
    public void unsticksPlayerFromLevelBotEdge() {
        Player p = new Player(100, 2937);
        Level lvl = new Level(0, 0);
        CollisionManager.unStickPlayer(p, lvl);

        assertEquals(100, p.getX(), 0.001);
        assertEquals(2936, p.getY(), 0.001);
    }

    @Test
    public void unsticksPlayerFromLevelLeftEdge() {
        Player p = new Player(31, 100);
        Level lvl = new Level(0, 0);
        CollisionManager.unStickPlayer(p, lvl);

        assertEquals(32, p.getX(), 0.001);
        assertEquals(100, p.getY(), 0.001);
    }

    @Test
    public void unsticksPlayerFromLevelRightEdge() {
        Player p = new Player(2937, 100);
        Level lvl = new Level(0, 0);
        CollisionManager.unStickPlayer(p, lvl);

        assertEquals(2936, p.getX(), 0.001);
        assertEquals(100, p.getY(), 0.001);
    }

    @Test
    public void unstickDoesNotMovePlayerIfInsideBounds() {
        Player p = new Player(32, 32);
        Level lvl = new Level(0, 0);
        CollisionManager.unStickPlayer(p, lvl);

        assertEquals(32, p.getX(), 0.001);
        assertEquals(32, p.getY(), 0.001);
    }

}
