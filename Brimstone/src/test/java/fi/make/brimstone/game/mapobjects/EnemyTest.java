/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.game.mapobjects;

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
public class EnemyTest {

    Enemy e;

    public EnemyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        e = new Enemy(100, 100, new Player(1100, 1100));
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
        assertEquals(100, e.getX(), 0.001);
    }

    @Test
    public void initYCorrect() {
        assertEquals(100, e.getY(), 0.001);
    }

    @Test
    public void getImageDoesNotReturnNull() {
        assertTrue(e.getImage() != null);
    }

    @Test
    public void movesCorrectAmount1() {
        e.move(0);
        assertEquals(101.06, e.getX(), 0.01);
    }

    public void movesCorrectAmount2() {
        e.move(0);
        e.move(0);
        e.move(0);
        e.move(0);
        assertEquals(104.24264, e.getX(), 0.001);
    }

    @Test
    public void revertsCorrectly() {
        e.move(0);
        e.revertMove();
        assertEquals(100.0, e.getX(), 0.001);
    }

    @Test
    public void returnsCorrectDistanceToPlayer() {
        assertEquals(1414.21356, e.getDistanceToPlayer(), 0.001);
    }

}
