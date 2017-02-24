/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.game.mapobjects.Level;
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
public class LevelTest {

    public LevelTest() {
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
    public void initXCorrect() {
        Level l = new Level(0, 0);
        assertEquals(0, l.getX(), 0.001);
    }

    @Test
    public void initYCorrect() {
        Level l = new Level(0, 0);
        assertEquals(0, l.getY(), 0.001);
    }

    @Test
    public void getImageDoesNotReturnNull() {
        Level l = new Level(5, 5);
        assertTrue(l.getImage() != null);
    }

    @Test
    public void returnsCorrectXDimension() {
        Level l = new Level(0,0);
        assertEquals(3000, l.getLevelDimensions().x, 0.001);
    }
    
        @Test
    public void returnsCorrectYDimension() {
        Level l = new Level(0,0);
        assertEquals(3000, l.getLevelDimensions().y, 0.001);
    }
}
