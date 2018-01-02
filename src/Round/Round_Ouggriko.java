/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Round;

import Player.Player;
import Rest.Shuffler;
import Rest.Tile;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Solon
 */
public class Round_Ouggriko extends Round {
    
    public Round_Ouggriko(ArrayList<Player> myPlayers)
    {
        super(myPlayers);
        Shuffler shuffler=new Shuffler();
        ArrayList<Tile> randomTiles=shuffler.shuffle();
        HashSet<Tile> playerHand;
        for(Player player : players)
        {
            
            playerHand=new HashSet<Tile>();
            for(int j=0;j<24/players.size();j++)      
            {
                playerHand.add(randomTiles.get(0));
                randomTiles.remove(0);
            }
            player.setHand(playerHand);
        }
        setPlayerTurn();
    }
    
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
            sum+=playerPoints[i];
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
