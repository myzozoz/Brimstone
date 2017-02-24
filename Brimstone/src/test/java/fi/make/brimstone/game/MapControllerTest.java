/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.make.brimstone.game;

import fi.make.brimstone.gui.DirectionListener;
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
public class MapControllerTest {
    MapController m;
    
    public MapControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        m = new MapController();
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
    public void addingEnemiesIncreasesListSize() {
        int size = m.getAllObjects().size();
        m.addEnemy(0, 0);
        assertEquals(1, m.getAllObjects().size() - size);
    }

    @Test
    public void addingNCUIncreasesListSize() {
        int size = m.getAllObjects().size();
        m.addNCU(0, 0);
        assertEquals(1, m.getAllObjects().size() - size);
    }

    @Test
    public void isPausedInTheBeginning() {
        assertTrue(m.isPaused());
    }
    
    @Test
    public void unPauses() {
        m.togglePause();
        assertFalse(m.isPaused());
    }
    
    @Test
    public void rePauses() {
        m.togglePause();
        m.togglePause();
        assertTrue(m.isPaused());
    }
    
    @Test
    public void mapUpdateReturnsTrueIfPaused() {
        assertTrue(m.mapUpdate(0));
    }
    
}
