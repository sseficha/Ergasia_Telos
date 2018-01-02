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
public class DominoLine_1 extends DominoLine{
    
    public DominoLine_1()
    {
        super();
    }

    @Override
    public int whereToAdd(Tile tileToAdd) 
    {
        
        if(rowTiles.size()==0)
            return 0;
        int first=rowTiles.get(0).getleft();
        int last=rowTiles.get(rowTiles.size()-1).getright();
       // System.out.println("first is "+first);
       // System.out.println("last is "+last);
       // for(int i=0;i<2;i++)
       // {
            if(tileToAdd.getright()==first && tileToAdd.getleft()==last)
            {
                return 2;
                
            }
            else if(tileToAdd.getleft()==first && tileToAdd.getright()==last)
            {
                tileToAdd.reverse();
                return 2;
                
            }
            else if(tileToAdd.getright()==first)
                return 0;
            else if(tileToAdd.getleft()==first)
            {
                tileToAdd.reverse();
                return 0;
            }
            else if(tileToAdd.getleft()==last)
                return 1;
            else if(tileToAdd.getright()==last)
            {
                tileToAdd.reverse();
                return 1;
            }
      //  }
        return -1;
      
    }
    
    
    
}
