/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.game;

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
public class NCUTest {

    public NCUTest() {
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
        NCU n = new NCU(100, 100);
        assertEquals(100, n.getX(), 0.001);
    }

    @Test
    public void initYCorrect() {
        NCU n = new NCU(100, 100);
        assertEquals(100, n.getY(), 0.001);
    }

    @Test
    public void getImageDoesNotReturnNull() {
        NCU n = new NCU(5, 5);
        assertTrue(n.getImage() != null);
    }
}
