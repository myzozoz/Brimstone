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
public class MapTest {
    
    public MapTest() {
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
    public void addingEnemiesIncreasesListSize(){
        MapController m = new MapController();
        int size = m.getAllObjects().size();
        m.addEnemy(0, 0);
        assertEquals(1, m.getAllObjects().size() - size);
    }
    
    @Test
    public void addingNCUIncreasesListSize(){
        MapController m = new MapController();
        int size = m.getAllObjects().size();
        m.addNCU(0, 0);
        assertEquals(1, m.getAllObjects().size() - size);
    }
}
