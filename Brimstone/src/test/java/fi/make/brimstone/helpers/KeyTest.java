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

/**
 *
 * @author make
 */
public class KeyTest {

    Key k;

    public KeyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        k = new Key("W", 83);
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
    public void returnsCorrectKeyName() {
        assertEquals("W", k.getKeyName());
    }

    @Test
    public void returnsCorrectKeyValue() {
        assertEquals(83, k.getKey());
    }

    @Test
    public void keyIsNotPressedAtStartup() {
        assertFalse(k.isPressed());
    }

    @Test
    public void keySetsPressed() {
        k.press();
        assertTrue(k.isPressed());
    }

    @Test
    public void keyGetsReleased() {
        k.press();
        k.release();
        assertFalse(k.isPressed());
    }
}
