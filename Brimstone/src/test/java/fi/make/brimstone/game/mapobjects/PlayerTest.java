package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.game.mapobjects.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.make.brimstone.helpers.Vector;

public class PlayerTest {

    Player p;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new Player(100, 100);
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
    public void updatesXPosition() {
        p.setSpeed(new Vector(1.0, 1.0));
        p.updatePosition(1);
        assertEquals(101.0, p.getX(), 0.001);
    }

    @Test
    public void updatesYPostion() {
        p.setSpeed(new Vector(1.0, 1.0));
        p.updatePosition(1);
        assertEquals(101.0, p.getY(), 0.001);
    }

    @Test
    public void initXCorrect() {
        assertEquals(100, p.getX(), 0.001);
    }

    @Test
    public void initYCorrect() {
        assertEquals(100, p.getY(), 0.001);
    }

    @Test
    public void startsWithNoXSpeed() {
        Player p = new Player(100, 100);
        assertEquals(0, p.getSpeed().x, 0.01);
    }

    @Test
    public void startsWithNoYSpeed() {
        assertEquals(0, p.getSpeed().y, 0.01);
    }

    @Test
    public void getImageDoesNotReturnNull() {
        assertTrue(p.getImage() != null);
    }

    @Test
    public void acceleratesRightCorrectly() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(10, 0, 1);
        assertEquals(0.01, p.getSpeed().x, 0.001);
    }

    @Test
    public void acceleratesLeftCorrectly() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(-10, 0, 1);
        assertEquals(-0.01, p.getSpeed().x, 0.001);
    }

    @Test
    public void acceleratesUpCorrectly() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(0, -10, 1);
        assertEquals(-0.01, p.getSpeed().y, 0.001);
    }

    @Test
    public void acceleratesDownCorrectly() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(0, 10, 1);
        assertEquals(0.01, p.getSpeed().y, 0.001);
    }

    @Test
    public void decelerationReducesMovementSpeedRight() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(1, 0, 1000);
        p.decelerateHorizontal(2000);
        assertEquals(0.8, p.getSpeed().x, 0.001);
    }

    @Test
    public void decelerationReducesMovementSpeedLeft() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(-1, 0, 1000);
        p.decelerateHorizontal(2000);
        assertEquals(-0.8, p.getSpeed().x, 0.001);
    }

    @Test
    public void decelerationReducesMovementSpeedUp() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(0, -1, 1000);
        p.decelerateVertical(2000);
        assertEquals(-0.8, p.getSpeed().y, 0.001);
    }

    @Test
    public void decelerationReducesMovementSpeeDown() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(0, 1, 1000);
        p.decelerateVertical(2000);
        assertEquals(0.8, p.getSpeed().y, 0.001);
    }

    @Test
    public void stopsIfTooSlow() {
        p.setSpeed(new Vector(0, 0));
        p.accelerate(1, 0, 10);
        p.decelerateHorizontal(100);
        assertEquals(0.0, p.getSpeed().x, 0.001);
    }
    
    @Test
    public void roofsPlayerSpeed() {
        p.accelerate(1,-1, 1440);
        assertEquals(2.0,p.getSpeedAbs(),0.01);
    }
}
