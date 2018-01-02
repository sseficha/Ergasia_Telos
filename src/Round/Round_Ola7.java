/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Round;

import Player.Player;
import Rest.Shuffler;
import Rest.StackOfTiles;
import Rest.Tile;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Solon
 */
public class Round_Ola7 extends Round{

    private StackOfTiles stack;

    public Round_Ola7(ArrayList<Player> myPlayers)      //tha dextei omos botwithstack kai hwithstack ara prepei na tous valei to stack
    {
        super(myPlayers);
        Shuffler shuffler=new Shuffler();
        ArrayList<Tile> randomTiles=shuffler.shuffle();
        HashSet<Tile> playerHand;
        
        
            if(myPlayers.size()==2)
            {   for(Player player : players)
                {
            
                    playerHand=new HashSet<Tile>();
                    for(int j=0;j<7;j++)      
                    {
                        playerHand.add(randomTiles.get(0));
                        randomTiles.remove(0);
                    }
                    player.setHand(playerHand);
                    
                }
            }
                
            else
            {   for(Player player : players)
                {
                    
                    playerHand=new HashSet<Tile>();
                    
                    for(int j=0;j<5;j++)      
                    {
                        playerHand.add(randomTiles.get(0));
                        randomTiles.remove(0);
                    }
                    player.setHand(playerHand);
                }
            
            }
        setPlayerTurn();
        stack=new StackOfTiles();
        for(Tile tile : randomTiles)
        {
            stack.add(tile);
        }
        
    }
    public StackOfTiles getStack()
    {
        return stack;
    }
    
    @Override
    public void setWinnerPoints() 
    {
        int[] playerPoints=getPlayerHandPoints();
        int minPoints=getMin(playerPoints);
        int sum=0;  
        int counter=0;  
        for(int i=0;i<playerPoints.length;i++)
        {
            if(playerPoints[i]==minPoints)
            {
                counter++;
            }
            else                    //edo i diafora...den metraei points tou xeriou tou!
            {
                sum+=playerPoints[i];
            }
        }
        for(int i=0;i<players.size();i++)
        {
            if(playerPoints[i]==minPoints)
            {
                players.get(i).addPoints(sum/counter);
            }
        }
    }
    
}
