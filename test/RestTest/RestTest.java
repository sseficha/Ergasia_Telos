/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestTest;

import Rest.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Solon Sefiha,Panos Papastergiou
 */
public class RestTest {
    
     public RestTest() {
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

   /**
     * Test of equals method, of class Tile.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Tile b = new Tile(4,5);
        Tile instance = new Tile(5,4);
        Boolean expResult = true;
        Boolean result = instance.equals(b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of reverse method, of class Tile.
     */
    @Test
    public void testReverse() {
        System.out.println("reverse");
        Tile instance = new Tile(6,5);
        instance.reverse();
        int expResult=5;
        assertEquals(expResult,instance.getleft());
        expResult=6;
        assertEquals(expResult,instance.getright());
        
    }

    /**
     * Test of swap method, of class Tile.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Tile b =new Tile(2,3);
        Tile instance = new Tile(0,0);
        instance.swap(b);
        int expResultLeft=2;
        int expResultRight=3;
        assertEquals(expResultLeft,instance.getleft());
        assertEquals(expResultRight,instance.getright());
        
       
    }

    /**
     * Test of getValueOfTile method, of class Tile.
     */
    @Test
    public void testGetValueOfTile() {
        System.out.println("getValueOfTile");
        Tile instance = new Tile(6,5);
        int expResult = 11;
        int result = instance.getValueOfTile();
        assertEquals(expResult, result);
        
        
    }
}
