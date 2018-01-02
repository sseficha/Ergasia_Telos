/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solo1_package;

import Exceptions_package.InvalidTile;
import Exceptions_package.NotAddableTile;
import Rest.Cmd;
import Rest.Tile;
import DominoLine.DominoLine;
import java.util.ArrayList;

/**
 *Υλοποιει ενα πληρες παιχνιδι Solo1 domino.
 * @author Solon Sefiha,Panos Papastergiou
 */
public class Solo1App {

    /**
     * @param args the command line arguments
     */
    
    /**
     * Δεχεται ενα Tile και γυρναει true αν:
     * 1)Ειναι απο τα τελευταια μια σειρα.
     * 2)Μπορει να μπει στην σειρα Ντομινο.
     * @param tileToCheck
     * @param AT instance of AvailableTiles
     * @param DL instance of DominoLine
     * @param cmd
     * @return 
     */
    public void checkTile(Tile tileToCheck,AvailableTiles AT,DominoLine DL) throws InvalidTile, NotAddableTile
    {
        if(AT.getLine(tileToCheck)==-1)
        {
            //cmd.errorLastColumn();            /cmd
            //return false;  
            throw new InvalidTile();
        }
        else
        {
            if(DL.whereToAdd(tileToCheck)==-1)
            {
               // cmd.errorDoesntFit();         //cmd
                //return false;
                throw new NotAddableTile();
            }
           // else
             //   return true;
        }
    }
     /**
      * Το counter αυξανεται αν εχω αδεια σειρα η το τελευταιο ντομινο της σειρας δεν μπαινει.
      * στην σειρα Ντομινο.
      * @param AT
      * @param DL
      * @return true αν το counter γινει οσο ο αριθμος των σειρων.
      */
     public boolean hasNoTilesToPlay(AvailableTiles AT,DominoLine DL)
     {
        int counter=0; 
        for(int i=0;i<4;i++)
        {
            if(AT.getAllTilesTaken()[i]==true)
                counter++;
            else
            {
                if(DL.whereToAdd(AT.getTableTiles().get(i).get(AT.getTableTiles().get(i).size()-1))==-1)
                {
                    counter++;
                }
            }
                
        }
        if(counter==4)
            return true;
        else
            return false;
    }
    
    /**
     * Eνα παιχνιδι Solo1 
     */
   /* public void playSolo1() {
        // TODO code application logic here
        DominoLine myDominoLine=new DominoLine();
        AvailableTiles myAvailableTiles=new AvailableTiles();
        Cmd myCmd=new Cmd();
        Tile tile;
        boolean bool;
        do
        {
            myCmd.showAvailableTiles(myAvailableTiles);
            tile=myCmd.selectTile();
            bool=checkTile(tile,myAvailableTiles,myDominoLine); //eixe kai cmd
             if(bool==true)
             {
                 myDominoLine.addToDominoLine(tile,"human");    //eixe kai cmd
                 myAvailableTiles.updateTable(myAvailableTiles.getLine(tile));
             }
            myCmd.showDominoLine(myDominoLine);
            
        }
        while(!myAvailableTiles.hasNoMoreTiles() && !hasNoTilesToPlay(myAvailableTiles,myDominoLine));
        
       myCmd.showResult(myAvailableTiles.hasNoMoreTiles());
        
    }*/
    
}