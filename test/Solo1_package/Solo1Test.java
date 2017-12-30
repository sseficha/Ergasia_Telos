/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solo1_package;

import Rest.Tile;
import java.util.ArrayList;
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
public class Solo1Test {
    
      public Solo1Test() {
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
     * Test of getTableTiles method, of class AvailableTiles.
     * den exei nohma na kanw test edw
     */
    @Test
    public void testGetTableTiles() {
        System.out.println("getTableTiles");
        AvailableTiles instance = new AvailableTiles();
        ArrayList<ArrayList<Tile>> expResult =instance.getTableTiles();
        ArrayList<ArrayList<Tile>> result = instance.getTableTiles();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getLine method, of class AvailableTiles.
     */
    @Test
    public void testGetLine() {
        System.out.println("getLine");
        Tile tile = new Tile(6,5);
        AvailableTiles instance = new AvailableTiles();
        int expResult = instance.getLine(tile);
        int result = instance.getLine(new Tile(6,5));
        assertEquals(expResult, result);
       
    }

    /**
     * Test of updateTable method, of class AvailableTiles.
     */
    @Test
    public void testUpdateTable() {
        System.out.println("updateTable");
        int line = 0;
        AvailableTiles instance = new AvailableTiles();
        ArrayList<ArrayList<Tile>> temp=new ArrayList<>();
        temp=instance.getTableTiles();
        temp.get(0).remove(6);
        instance.updateTable(line);
        ArrayList<Tile> expResult=new ArrayList<>();
        expResult=temp.get(0);
        assertEquals(expResult,instance.getTableTiles().get(0));
       
       
    }

    /**
     * Test of getAllTilesTaken method, of class AvailableTiles.
     */
    @Test
    public void testGetAllTilesTaken() {
        System.out.println("getAllTilesTaken");
        AvailableTiles instance = new AvailableTiles();
        Boolean[] expResult = {false,false,false,false};
        Boolean[] result = instance.getAllTilesTaken();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of setAllTilesTaken method, of class AvailableTiles.
     */
    @Test
    public void testSetAllTilesTaken() {
        System.out.println("setAllTilesTaken");
       
        AvailableTiles instance = new AvailableTiles();
        for(int i=0;i<4;i++){
            instance.setAllTilesTaken(i);
        }
        Boolean[] expResult={true,true,true,true};
        assertArrayEquals(expResult,instance.getAllTilesTaken());
       
    }

    /**
     * Test of hasNoMoreTiles method, of class AvailableTiles.
     */
    @Test
    public void testHasNoMoreTiles() {
        System.out.println("hasNoMoreTiles");
        AvailableTiles instance = new AvailableTiles();
        boolean expResult = false;
        boolean result = instance.hasNoMoreTiles();
        assertEquals(expResult, result);
        for(int i=0;i<4;i++){
            instance.setAllTilesTaken(i);
        }
        result=instance.hasNoMoreTiles();
       assertEquals(true,result);
    }
    /*
    *Test of tile values ,right-left,valuse must be 0-6
    
    */
    @Test
    public void testTableTiles(){
        System.out.println("TableTiles");
        AvailableTiles instance=new AvailableTiles();
        int sum=0;
        for(ArrayList<Tile> array:instance.getTableTiles()){
            for(Tile tile:array){
                if(tile.getleft()>6 || tile.getleft()<0){
                    sum++;
                }
                if(tile.getright()>6 || tile.getleft()<0){
                    sum++;
                }
            }
        }
        int expResult=0;
        assertEquals(expResult,sum);
        
    }
}
