/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.util.LinkedList;

/**
 *
 * @author Solon
 */
public class StackOfTiles {
    
    LinkedList<Tile> stack;
    
    public StackOfTiles()
    {
        stack=new LinkedList<>();
    }
    
    public int getSize()
    {
        return stack.size();
    }
    
    public void add(Tile tile)
    {
        stack.add(tile);
    }
    
    public Tile draw()
    {
        Tile tile=stack.removeFirst();
        return tile;
    }
    
}
