/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Exceptions_package.HasNoTiles;
import Exceptions_package.NothingToPlay;
import Exceptions_package.NothingToPlayBot;
import Rest.Cmd;
import DominoLine.DominoLine;
import Rest.Tile;
import java.util.HashSet;
import javax.swing.JPanel;

/**
 *
 * @author Solon
 */
public class Bot extends Player{
    
    public Bot(String name,HashSet<Tile> hand)
    {
        super(name,hand);
    }
    
    public Tile getTileForBot(DominoLine DL)    //Επιστρεφει το πρωτο Tile που μπορει να μπει στο 
                                                    //DominoLine απο το χερι του bot αλλιως γυρναει null
    {
        for(Tile tile : hand)
        {
            if(DL.whereToAdd(tile)!=-1)
            {
                return tile;
            }
        }
        return null;
    }
    
    @Override
    public void add(DominoLine DL,Tile tileToAdd) throws NothingToPlayBot
        {
            //Tile tileToAdd=getTileForBot(DL);
            if(tileToAdd!=null)
            {
                int place=DL.whereToAdd(tileToAdd);
                if(place==2)
                {
                    place=0;
                }
                DL.addToDominoLine(tileToAdd,place);
                hand.remove(tileToAdd);
                //return true;
               
            }
            else
                //return false;
                throw new NothingToPlayBot(this.name);//throw den exei tile na paixei
        }
    
   // @Override
    public void playBot(DominoLine DL) throws NothingToPlayBot, HasNoTiles
    {
        boolean bool;
        if(hand.size()==0)
        {
            //return false;
            throw new HasNoTiles(this.name);//throw den exei alla tile
        } 
        Tile tileToAdd=getTileForBot(DL);
       // bool=add(DL,tileToAdd);
       add(DL,tileToAdd);
        //return bool;
    }
    
}
