/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import DominoLine.DominoLine;
import DominoLine.DominoLine_2;
import Exceptions_package.HasNoTiles;
import Exceptions_package.MustDraw;
import Exceptions_package.NothingToPlay;
import Exceptions_package.NothingToPlayBot;
import GUI.Ola7_Frame;
import Rest.StackOfTiles;
import Rest.Tile;
import java.util.HashSet;

/**
 *
 * @author Solon
 */
public class Human_withStack extends Human {
    
    public Human_withStack(String name, HashSet<Tile> hand) {
        super(name, hand);
    }
    
     public void addToHand(Tile tile)
    {
        getHand().add(tile);
    }
     
     public void pass(DominoLine_2 DL,StackOfTiles stack,Boolean playedOnce) throws HasNoTiles, NothingToPlay
    {
        int counter=0;
        
        if(hand.size()==0)
            //return true;
            throw new HasNoTiles(this.name);
        for(Tile temp : hand)
            if(DL.whereToAdd(temp)==-1)
                counter++;
        if(counter==hand.size())
        {
            if(stack.getSize()==2)
            {
               throw new NothingToPlay(getName());
            }
            else
            {
                if(playedOnce==false)
                {   
                    Tile tile;
                    do{
                        tile=stack.draw();
                        getHand().add(tile);
                       // System.out.println("daneistika to "+tile.getleft()+""+tile.getright());
                    }
                    while(DL.whereToAdd(tile)==-1 && stack.getSize()>2);
                }
              //  for(Tile tile : hand)
                //{
                //    System.out.println("to hand einai "+tile.getleft()+""+tile.getright());
               // }
              //  throw new MustDraw(tile.getleft()+""+tile.getright());
                //Ola7_Frame.getExtraButtons().
            }
        }
            
              
           
            
        
        
            //throw new NothingToPlay(this.name);
       // else
         //   return false;

    }
    
}
