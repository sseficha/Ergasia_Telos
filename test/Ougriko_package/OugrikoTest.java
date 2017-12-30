/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ougriko_package;

import Rest.Cmd;
import Rest.DominoLine;
import Rest.Tile;
import java.util.ArrayList;
import java.util.HashSet;
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
public class OugrikoTest {
    
    private Round instance;
    private Player first;
    private Player second;
    
    public OugrikoTest() {
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
     * Test of setHand method, of class Player.
     */
    @Test
    public void testSetHand() {
        System.out.println("setHand");
        HashSet<Tile> hand = null;
        Player instance = new Player(null,null,null);
        instance.setHand(hand);
        assertEquals(null,instance.getHand());
        
    }

    /**
     * Test of pass method, of class Player.
     */
    @Test
    public void testPass() {
        System.out.println("pass");
        DominoLine DL = new DominoLine();
        HashSet<Tile> expHand= new  HashSet<>();
        expHand.add(new Tile(6,5));
        expHand.add(new Tile(4,4));
        expHand.add(new Tile(4,5));
        DL.addToDominoLine(new Tile(1,1),"bot",new Cmd());
        Player instance = new Player(null,"bot",expHand);
        boolean expResult = true;
        boolean result = instance.pass(DL);
        assertEquals(expResult, result);
        
    }

    

    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        HashSet<Tile> expResult= new  HashSet<>();
        expResult.add(new Tile(6,5));
        expResult.add(new Tile(4,4));
        expResult.add(new Tile(4,5));
        Player instance = new Player(null,null,expResult);
        
        HashSet<Tile> result = instance.getHand();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player("Tester",null,null);
        String expResult = "Tester";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addHuman method, of class Player.
     */
    @Test
    public void testAddHuman() {
        System.out.println("addHuman");
        DominoLine DL = new DominoLine();
        HashSet<Tile> hand=new HashSet<>();
        hand.add(new Tile(3,3));
        Tile tileToAdd =new Tile(3,3);
        Cmd cmd = new Cmd();
        Player instance=new Player("tester","human",hand);
        boolean expResult = true;
        boolean result = instance.addHuman(DL, tileToAdd, cmd);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addBot method, of class Player.
     */
    @Test
    public void testAddBot() {
        System.out.println("addBot");
        DominoLine DL = new DominoLine();
        HashSet<Tile> hand=new HashSet<>();
        hand.add(new Tile(3,3));
        Tile tileToAdd =new Tile(3,3);
        Cmd cmd = new Cmd();
        Player instance=new Player("tester","bot",hand);
        boolean expResult = true;
        boolean result = instance.addBot(DL, cmd);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTileForBot method, of class Player.
     */
    @Test
    public void testGetTileForBot() {
        System.out.println("getTileForBot");
        DominoLine DL=new DominoLine();
        HashSet<Tile> hand=new HashSet<>();
        Tile temp=new Tile(3,3);
        hand.add(temp);
        Player instance = new Player("Tester","bot",hand);
        Tile expResult =temp;
        Tile result = instance.getTileForBot(DL);
        assertEquals(expResult, result);
       
    }
    
    
    
     /**
     * Test of getPlayers method, of class Round.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
         ArrayList<Player> players=new ArrayList<>();
        
        
        
        first=new Player("tester1","human",null);
        second= new Player("tester2","bot",null);
        
        players.add(first);
        players.add(second);
        instance = new Round(players);
        
        ArrayList<Player> expResult = new ArrayList<>();
        expResult.add(instance.getPlayers().get(0));
        expResult.add(instance.getPlayers().get(1));
        
        
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        
    }

   

    /**
     * Test of getFirstToPlay method, of class Round.
     */
    @Test
    public void testGetFirstToPlay() {
        System.out.println("getFirstToPlay");
        
         ArrayList<Player> players=new ArrayList<>();
        
       
        
        first=new Player("tester1","human",null);
        second= new Player("tester2","bot",null);
        
        players.add(first);
        players.add(second);
        instance = new Round(players);
        
         ArrayList<Player> getPlayers = instance.getPlayers();
         int max=0;
         String maxp=null;
         for(Player player : getPlayers)
        {
            for(Tile tile : player.getHand())
            {
                if(tile.getValueOfTile()>max)
                {
                    max=tile.getValueOfTile();
                    maxp=player.getName();
                }
            }
        }
         
         
        String expResult = maxp;
        String result = instance.getFirstToPlay();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getPlayerHandPoints method, of class Round.
     */
    @Test
    public void testGetPlayerHandPoints() {
        System.out.println("getPlayerHandPoints");
         ArrayList<Player> players=new ArrayList<>();
        
     
        
        first=new Player("tester1","bot",null);
        second= new Player("tester2","bot",null);
       
        players.add(first);
        players.add(second);
        instance = new Round(players);
        int[] sum=new int[2];
        int[] expResult=new int[2];
        int i=0;
       for(Player player:instance.getPlayers()){
           
           HashSet<Tile> hand=player.getHand();
           for(Tile tile:hand){
               sum[i]+=tile.getValueOfTile();
           }
           i++;
       }
       expResult=sum;
        
       
        int[] result = instance.getPlayerHandPoints();
        assertArrayEquals(expResult,result);
        
        
        
    }

    /**
     * Test of getMin method, of class Round.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
         ArrayList<Player> players=new ArrayList<>();
        
        
        
        first=new Player("tester1","human",null);
        second= new Player("tester2","bot",null);
      
        players.add(first);
        players.add(second);
        instance = new Round(players);
        int expResult;
        int[] playerPoints = new int[2];
        playerPoints[0]=instance.getPlayers().get(0).getPoints();
        playerPoints[1]=instance.getPlayers().get(1).getPoints();
        if(playerPoints[0]<playerPoints[1]){
            expResult=playerPoints[0];
        }else{
            expResult=playerPoints[1];
        }
        
      
        int result = instance.getMin(playerPoints);
        assertEquals(expResult, result);
      
    }

    

    /**
     * Test of getMaxPoints method, of class Round.
     */
    @Test
    public void testGetMaxPoints() {
        System.out.println("getMaxPoints");
        
         ArrayList<Player> players=new ArrayList<>();
        first=new Player("tester1","human",null);
        second= new Player("tester2","bot",null);
        
        players.add(first);
        players.add(second);
        instance = new Round(players);
        int expResult;
        int[] playerPoints = new int[2];
        playerPoints[0]=instance.getPlayers().get(0).getPoints();
        playerPoints[1]=instance.getPlayers().get(1).getPoints();
        if(playerPoints[0]>playerPoints[1]){
            expResult=playerPoints[0];
        }else{
            expResult=playerPoints[1];
        }
        
        int result = instance.getMaxPoints();
        assertEquals(expResult, result);
        
    }
    
    }

    

