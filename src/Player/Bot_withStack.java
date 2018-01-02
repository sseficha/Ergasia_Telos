/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import DominoLine.DominoLine;
import DominoLine.DominoLine_2;
import Exceptions_package.HasNoTiles;
import Exceptions_package.NothingToPlayBot;
import Rest.MessagePanel;
import Rest.StackOfTiles;
import Rest.Tile;
import java.util.HashSet;

/**
 *
 * @author Solon
 */
public class Bot_withStack extends Bot
{
    public Bot_withStack(String name, HashSet<Tile> hand)
    {
      super(name,hand); 
      //this.stack=stack;
    }
    public void addToHand(Tile tile)
    {
        getHand().add(tile);
    }
    
    public void add(DominoLine DL, Tile tile, StackOfTiles stack) throws NothingToPlayBot 
    {
            if(tile!=null)
            {
                int place=DL.whereToAdd(tile);
                if(place==2)
                {
                    place=0;
                }
                DL.addToDominoLine(tile,place);
                hand.remove(tile);
                //return true;
               
            }
           
    }
    
    public void playBot(DominoLine_2 DL, StackOfTiles stack, boolean playedOnce, MessagePanel borrowedMessagePanel) throws HasNoTiles, NothingToPlayBot
    {
        if(hand.size()==0)
        {
            throw new HasNoTiles(this.name);//throw den exei alla tile
        } 
        Tile tileToAdd=getTileForBot(DL);
        if(tileToAdd==null && playedOnce==false)
        {
            if(stack.getSize()>2)
            {
                int temp=-1;

                do{
                
                    tileToAdd=stack.draw();
                    
                    addToHand(tileToAdd);
                   // System.out.println("Danistike to "+tileToAdd.getleft()+""+tileToAdd.getright());
                    temp=DL.whereToAdd(tileToAdd);
                
            }
            while(temp==-1 && stack.getSize()>2);       //!=0????
            }
                        borrowedMessagePanel.addMessageLabel("Player "+name+"borrowed Tile"+ tileToAdd.getleft()+"-"+tileToAdd.getright());

        }            
        if(tileToAdd!=null)
        {
            add(DL,tileToAdd,stack);
            
        }
        else
        {
            throw new NothingToPlayBot(getName());
        }
        //return bool;
    }
}
