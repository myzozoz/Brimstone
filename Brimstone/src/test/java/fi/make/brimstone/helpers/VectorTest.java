/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.helpers;

import fi.make.brimstone.helpers.Vector;
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
public class VectorTest {

    public VectorTest() {
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
    public void setsXCorrectly() {
        Vector v = new Vector(2.5, 3.0);
        assertEquals(2.5, v.x, 0.001);
    }

    @Test
    public void setsYCorrectly() {
        Vector v = new Vector(2.5, 3.0);
        assertEquals(3.0, v.y, 0.001);
    }

    @Test
    public void returnsCorrectString() {
        Vector v = new Vector(2.5, 3.0);
        assertEquals("( 2.5, 3.0)", v.toString());
    }
}
