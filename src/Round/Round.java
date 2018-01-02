/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Round;

import Rest.Cmd;
import DominoLine.DominoLine;
import Player.Player;
import Rest.Shuffler;
import Rest.Tile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *Υλοποιει ενα γυρο. Κατανεμει τους players σε ArrayList στο οποιο γινονται κυκλοι μεχρι 
 * κανεις να μην μπορει να παιξει αλλο. Υστερα υπολογιζεται οι ποντοι που παιρνουν οι παικτες.
 * @author Solon Sefiha,Panos Papastergiou
 */
public abstract class Round {
    
    protected ArrayList<Player> players;
    
    /**
     * Αξιοποιωντας τον Shuffler "μοιραζει" τα Tile στους παικτες. Υστερα τους οριζει τη σειρα
     * με την οποια θα παιξουν.
     * @param players Δεχεται ενα ArrayList με τους παικτες που θα συμμετεχουν στον γυρο.
     */
    public Round(ArrayList<Player> players)
    {
        this.players=players;
        
    }
    
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    /**
     * Βρισκει τον παικτη με το μεγαλυτερο Tile. Υστερα καθοριζει την σειρα παιξιματος
     * αναλογα με την σειρα με την οποια μπηκαν οι παικτες και τον παικτη με το μεγαλυτερο
     * Tile. Δηλαδη αν οι παικτες ηταν 1-2-3-4 και ο 3 ειχε το μεγαλυτερο Tile η σειρα παει
     * 3-4-1-2. Κανει δηλαδη ενα ειδος ολισθησης.
     */
    public void setPlayerTurn()
    {
        String first=getFirstToPlay();  
        Player last=null; 
        do
        {
            if(!first.equals(players.get(0).getName()))
            {
                last=players.get(players.size()-1);
                for(int i=players.size()-1;i>0;i--)
                {
                    players.set(i, players.get(i-1));
                }
                players.set(0, last);
            }
            else
                break;
        }
        while(true);
    }
    
    public String getFirstToPlay()  //Γυρναει το ονομα του παικτη με το μεγαλυτερο Tile
    {   
        int max=0;
        String maxp=null;
        for(Player player : players)
        {
            System.out.println(player.getHand());
            for(Tile tile : player.getHand())
            {
                if(tile.getValueOfTile()>max)
                {
                    max=tile.getValueOfTile();
                    maxp=player.getName();
                }
            }
        }
        return maxp;
    }
    
    public int[] getPlayerHandPoints()  //Γυρναει ενα πινακα με τους ποντους που εχει καθε παικτης
                                        //στα χερια του
    {
        int[] playerPoints=new int[players.size()];  //points sta xeria tous
        for(int i=0;i<players.size();i++)
        {
            playerPoints[i]=0;
            if(players.get(i).getHand().size()!=0)
            {
                for(Tile tile : players.get(i).getHand())
                    playerPoints[i]+=tile.getValueOfTile();
            }
        }
        return playerPoints;
    }
    
    public int getMin(int[] playerPoints)  //Γυρναει τους λιγοτερους ποντους αναμεσα στα χερια των παικτων.
    {
        int minPoints=playerPoints[0];
        for(int i=1;i<playerPoints.length;i++)
        {
            if(playerPoints[i]<minPoints)
            {
                minPoints=playerPoints[i];
            }
        }
        return minPoints;
    }
    /**
     * Βαζει ποντους στον/ους νικητη/ες. Καθως δεν οριζοταν τι γινεται σε περιπτωση ισοπαλιας,
     * σε αυτη την εκδοση οι νικητες μοιραζονται τους ποντους. Counter ειναι το πληθος των
     * νικητων στον γυρο (δηλαδη οσων οι ποντοι στα χερια ειναι ισα με minPoints). Sum ειναι το 
     * αθροισμα ολων των ποντων που εχουν οι παικτες στα χερια τους. Ετσι αν ενας νικησει παιρνει
     * τους ποντους του χεριου του + τους ποντους στα χερια των αλλων. Αν >1 νικησουν τοτε 
     * μοιραζονται τους ποντους που βρισκονται στα χερια τους (που ειναι ιδιοι) + τους 
     * ποντους των αντιπαλων.
     */
    public abstract void setWinnerPoints();   
 
    public int getMaxPoints()   //Γυρναει τους περισσοτερους ποντους μεταξυ των παικτων.
    {
        int maxPoints=0;
        for(Player player : players)
        {
            if(player.getPoints()>maxPoints)
            {
                maxPoints=player.getPoints();
            }
        }
        return maxPoints;
    }
    
    /**
     * Γυρναει τον/ους παικτη/ες με τους περισσοτερους ποντους
     * @return το/α ονομα/τα των νικητων.
     */
    public ArrayList<String> getWinner()  
    {
        int winnerPoints=getMaxPoints();
        ArrayList<String> winner=new ArrayList<>();
        for(Player player : players)
        {
            if(player.getPoints()==winnerPoints)
            {
                winner.add(player.getName());
            }
        }
        return winner;
    }
     public boolean gameIsOver()
    {
        if(getMaxPoints()>=100)        
            return true;
        else
            return false;
    }
    
    /**
     * Μεσω της συναρτησης αυτη "παιζεται" ενας γυρος. Το counter αυξανεται οταν ενας παικτης
     * δεν μπορει να παιξει (η δεν εχει Tile να παιξει η εχει αδειο χερι η επαιξε και δεν εχει
     * κατι αλλο να παιξει). Το counter μηδενιζεται οταν ενα παικτης παιζει. Η τιμη του bool και 
     * του playedOnce αναπαριστουν τα διαφορα σεναρια που μπορει να βρουμε κατα το παιξιμο και
     * χρησιμοποιουνται κυριως για την εμφανιση των καταλληλων μηνυματων.
     * @param DL
     * @param cmd 
     */
   /* public void playRound(DominoLine DL)
    {
        int counter=0;
        boolean bool;
        boolean playedOnce;
        do
        {
            for(Player player : players)        
            {
                playedOnce=false;   
                do
                {
                    if(player.getHand().size()!=0)  //αν δεν εχει Tile δεν εχω κατι να δειξω
                        //cmd.showPlayerTiles(player);    //cmd
                        //throw
                    bool=player.playPlayer(DL);
                    if(bool==false)
                    {    
                        if(player.getHand().size()==0)
                        {
                            if(playedOnce==false)
                                counter++;
                            cmd.hasNoMoreTiles(player);    //cmd
                            break; 
                        }
                        else
                        {
                            if(playedOnce==false)
                            {
                               counter++;
                               cmd.nothingToPlay(player);      //cmd
                            }
                        }
                    }
                    else
                    {
                        playedOnce=true;
                        counter=0;
                        cmd.showDominoLine(DL);        //cmd


                    }
               }
                while(bool);        //NOTHING ESLE TO PLAY?
                if(playedOnce==true)
                    cmd.nothingElseToPlay(player);          //cmd
                if(counter==players.size()-1)
                    break;
            }  
        }
        while(counter<players.size()-1);
        setWinnerPoints();
        cmd.endOfRound();                           //cmd
    }

*/


}
