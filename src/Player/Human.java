/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Exceptions_package.HasNoTiles;
import Exceptions_package.MustChoose;
import Exceptions_package.NotAddableTile;
import Exceptions_package.NothingToPlay;
import Exceptions_package.OtherPlayerTile;
import Rest.Cmd;
import DominoLine.DominoLine;
import Rest.Tile;
import java.util.HashSet;

/**
 *
 * @author Solon
 */
public class Human extends Player{
    
    int place;
    public Human(String name,HashSet<Tile> hand)
    {
        super(name,hand);
    }
    void setPlace(int x)
    {
        place=x;
    }
    public void pass(DominoLine DL) throws NothingToPlay, HasNoTiles
    {
        int counter=0;
        if(hand.size()==0)
            //return true;
            throw new HasNoTiles(this.name);
        for(Tile temp : hand)
            if(DL.whereToAdd(temp)==-1)
                counter++;
        if(counter==hand.size())
           // return true;
            
            throw new NothingToPlay(this.name);
       // else
         //   return false;

    }
    
    @Override
    public void add(DominoLine DL,Tile tileToAdd) throws NotAddableTile, OtherPlayerTile, MustChoose
        {

            if(ownsTile(tileToAdd)==false)
            {
                throw new OtherPlayerTile();
                  //  cmd.errorDoesNotOwnTile(tileToAdd);
                //return false;
            }
            else if(DL.whereToAdd(tileToAdd)==-1)
            {
                throw new NotAddableTile();
                //cmd.errorDoesntFit();
                //return false;
            }
            else
            {
                place=DL.whereToAdd(tileToAdd);
                if(place==2)
                {
                    throw new MustChoose();
                }
                DL.addToDominoLine(tileToAdd,place);      //eixe cmd
                hand.removeIf(tile -> tile.equals(tileToAdd));
               // return true;
            }

        }
  /*  @Override
    public boolean playPlayer(DominoLine DL,Cmd cmd)
    {
        boolean bool;
        if(pass(DL))
        {
            return false;
        }
        else
        {
            do
            {
                Tile tileToAdd=cmd.selectTile();        //cmd
                bool=add(DL, tileToAdd,cmd);
            }
            while(!bool);
        return true;

        }
    }   */
}
