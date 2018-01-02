/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ougriko_package;

import Rest.Cmd;
import DominoLine.DominoLine;
import Player.Bot;
import Player.Human;
import Player.Player;
import Rest.Tile;
import Round.Round;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *Υλοποιει ενα πληρες παιχνιδι Ουγγρικου ντομινο.
 * @author Solon Sefiha,Panos Papastergiou
 */
public class OuggrikoApp {

    /**
     * @param args the command line arguments
     */
   
    /**
     * Δημιουργει ενα Hashmap με <ονομα παικτη,ιδιοτητα παικτη>. Παντα ο πρωτος παικτης
     * καταχωρειται ως human και οι υπολοιποι ως bot.
     * @param cmd
     * @return το Hashmap
     */
  /*  public HashMap<String,String> getPlayerInfo(Cmd cmd)
    {
       // int n=cmd.getNofPlayers();
      //  HashMap<String,String> myHashMap=new HashMap<>();
        String name;
     //   String property;
        for(int i=0;i<n;i++)
        {
            name=new String();
            property=new String();
            if(i==0)
            {
                property="human";
                name=cmd.getHumanName();
            }
            else
            {
                property="bot";
                name=cmd.getBotName();
            }
            
            myHashMap.put(name,property);
        }
        return myHashMap;
    }*/
    /**
     * Aξιοποιει τις πληροφοριες που λαμβανει απο την getPlayerInfo και δημιουργει ενα
     * ArrayList με Player. Το hand καταχωρειται ως null γιατι γεμιζεται στην αρχη καθε γυρου
     * απο την Round.
     * @param cmd
     * @return 
     */
    public ArrayList<Player> getPlayers(Cmd cmd)
    {
        String name;
        int n=cmd.getNofPlayers();
        ArrayList<Player> players=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                name=cmd.getHumanName();
                players.add(new Human(name,null));
            }
            else
            {
                name=cmd.getBotName();
                players.add(new Bot(name,null));
            }
            
        }
     //   HashMap<String,String> myPlayerInfo=getPlayerInfo(cmd);
     //   for(String temp : myPlayerInfo.keySet())
     //   {
     //       players.add(new Player(temp,myPlayerInfo.get(temp),null)); 
     //   }
        return players;
    }
    
    public boolean gameIsOver(Round round)
    {
        if(round.getMaxPoints()>=100)        
            return true;
        else
            return false;
    }
    
  
    
   
    //Ενα παιχνιδι Ουγγρικο Ντομινο
 /*   public void playOuggriko() {
        // TODO code application logic here
       Cmd cmd=new Cmd();
       DominoLine DL;
       ArrayList<Player> players=getPlayers(cmd);
       Round round;
       do
       {
           cmd.newRound();
           DL=new DominoLine();
           round=new Round(players);
           round.playRound(DL, cmd);
           cmd.showPlayerPoints(round);
       }
       while(!gameIsOver(round));
       cmd.showWinner(round.getWinner());   
       
  
       
       
    }   */
    
}
