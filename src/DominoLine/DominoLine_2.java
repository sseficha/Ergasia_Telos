/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominoLine;

import Rest.Tile;

/**
 *
 * @author Solon
 */
public class DominoLine_2 extends DominoLine{

    public DominoLine_2()
    {
        super();
    }
    
    public boolean isBalader(Tile tileToAdd)
    {
        if(tileToAdd.getleft()==0 && tileToAdd.getright()==0)
        {
            return true;
        }
        if(tileToAdd.getleft()+tileToAdd.getright()==7)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public int whereToAdd(Tile tileToAdd) 
    {
        if(rowTiles.size()==0)
            return 0;
        if(isBalader(tileToAdd))
            return 2;
        int first=rowTiles.get(0).getleft();
        int last=rowTiles.get(rowTiles.size()-1).getright();
        Tile firstTile=rowTiles.get(0);
        Tile lastTile=rowTiles.get(rowTiles.size()-1);
        //for(int i=0;i<2;i++)
        //{
            
            
            if(tileToAdd.getright()+first==7 && tileToAdd.getleft()+last==7)
            {
                return 2;
                
            }
            else if(tileToAdd.getleft()+first==7 && tileToAdd.getright()+last==7)
            {
                tileToAdd.reverse();
                return 2;
                
            }
            else if(tileToAdd.getright()+first==7)
                return 0;
            else if(tileToAdd.getleft()+first==7)
            {
                tileToAdd.reverse();
                return 0;
            }
            else if(tileToAdd.getleft()+last==7)
                return 1;
            else if(tileToAdd.getright()+last==7)
            {
                tileToAdd.reverse();
                return 1;
            }
       // }
        return -1;
        
    }
    
}
