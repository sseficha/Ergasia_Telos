/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solo1_package;

import Rest.Tile;
import Rest.Shuffler;
import java.util.ArrayList;

/**
 * Αναπαριστα τον πινακα 4x7 με Tiles υλοποιωντας τον με εμφωλευμενο ArrayList<ArrayList<Tile>> tableTiles.
 * Χρησιμοποιει ενα παραλληλο πινακα Boolean allTilesTaken του οποιου μια σειρα γινεται true, οταν η 
 * αντιστοιχη σειρα στο tableTiles εχει αδειασει απο Tiles.
 * @author Solon Sefiha,Panos Papastergiou
 */
public class AvailableTiles {
    
   private ArrayList<ArrayList<Tile>> tableTiles;
   private Boolean[] allTilesTaken;
    
   /**
    * Γεμιζει το tableTiles με random τιμες απο Tile αξιοποιωντας τον Shuffler.
    */ 
   
   public AvailableTiles()
    {
        tableTiles=new  ArrayList<ArrayList<Tile>>();
        for(int i=0;i<4;i++)
        {
            tableTiles.add(new ArrayList<Tile>());
        }
        allTilesTaken=new Boolean[4];
        for(int i=0;i<4;i++)
            allTilesTaken[i]=false;
        Shuffler myShuffler=new Shuffler();
        ArrayList<Tile> randomTiles=myShuffler.shuffle();
        int counter=0;
        for(int i=0;i<4;i++)
            for(int j=0;j<7;j++)
            {
                tableTiles.get(i).add(randomTiles.get(counter));          //EDO!!!!!!!!!!!!!!!!
                counter++;
            }
        
    }
    public ArrayList<ArrayList<Tile>> getTableTiles()
    {
        return tableTiles;
    }
    
    public Tile getTile(int x,int y)
    {
        return tableTiles.get(x).get(y);
    }
    
    /**
     * Δεχεται το tile και αμα ειναι ενα απο τα τελευταια σε σειρα γυρναει σε ποια σειρα ειναι
     * αλλιως γυρναει -1.
     * @param tile
     * @return αριθμο σειρας αλλιως -1.
     */
    public int getLine(Tile tile)
    {
        int line=-1;
        for(int i=0;i<4;i++)
        {
            if(allTilesTaken[i]!=true)
            {
                Tile lastTile=tableTiles.get(i).get(tableTiles.get(i).size()-1);
                if(lastTile.equals(tile))
                    line=i;
            }
        }
        return line;
    }  
    
    /**
     * Δεχεται ως παραμετρο μια σειρα line και παει και αφαιρει το τελευταιο στοιχειο της σειρα
     * απο το tableTiles.
     * @param line 
     */
    public void updateTable(int line)
    {
        ArrayList<Tile> lineToUpdate=tableTiles.get(line);
        lineToUpdate.remove(lineToUpdate.size()-1);
        if(lineToUpdate.size()==0)
            setAllTilesTaken(line);
    } 
    
    public Boolean[] getAllTilesTaken()
    {
        return allTilesTaken;
    }
    
    public void setAllTilesTaken(int i)
    {
        allTilesTaken[i]=true;
    }
    public boolean hasNoMoreTiles()     //true αμα αδειασε ο πινακας
    {
        int counter=0;
        for(int i=0;i<4;i++)
        {
            if(allTilesTaken[i]==true)
                counter++;
        }
        if(counter==4)
            return true;
        else
            return false;
    }
    
}
