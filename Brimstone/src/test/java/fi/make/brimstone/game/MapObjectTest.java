/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.game;

//import fi.make.brimstone.game.MapObject;
//import fi.make.brimstone.game.Player;
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
public class MapObjectTest {

    public MapObjectTest() {
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
    public void returnsPlayerXCorrectly() {
        MapObject mo = new Player(1, 2);
        assertEquals(1, mo.getX(), 0.001);
    }

    @Test
    public void returnsPlayerYCorrectly() {
        MapObject mo = new Player(1, 2);
        assertEquals(2, mo.getY(), 0.001);
    }

//    @Test
//    public void returnsEnemyXCorrectly() {
//        MapObject mo = new Enemy(1, 2);
//        assertEquals(1, mo.getX(), 0.001);
//    }

//    @Test
//    public void returnsEnemyYCorrectly() {
//        MapObject mo = new Enemy(1, 2);
//        assertEquals(2, mo.getY(), 0.001);
//    }

    @Test
    public void returnsNCUXCorrectly() {
        MapObject mo = new NCU(1, 2);
        assertEquals(1, mo.getX(), 0.001);
    }

    @Test
    public void returnsNCUYCorrectly() {
        MapObject mo = new NCU(1, 2);
        assertEquals(2, mo.getY(), 0.001);
    }
}
