
package fi.make.brimstone.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

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
    public void updatesPlayerXPositionCorrectly() {
        Player p = new Player(5, 5);
        p.updatePosition();
        assertEquals(6, p.getX(), 0.001);
    }

    @Test
    public void updatesPlayerYPositionCorrectly() {
        Player p = new Player(5, 5);
        p.updatePosition();
        assertEquals(6, p.getY(), 0.001);
    }
}
