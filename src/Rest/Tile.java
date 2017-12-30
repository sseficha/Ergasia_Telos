/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

/**
 *Αναπαριστα ενα πλακιδιο.
 * @author Solon Sefiha,Panos Papastergiou
 */
public class Tile {
    private int left;
    private int right;
    
   public Tile(int x,int y)
    {
        left=x;
        right=y;
        
    }
    
    public Boolean equals(Tile b)
    {
        if((left==b.getleft() && right==b.getright()) || (left==b.getright()&& right==b.getleft()))
            return true;
        else
            return false;
    }
    public void reverse()
    {
        int temp=left;
        left=right;
        right=temp;
    }
    public void swap(Tile b)
    {
        Tile temp=new Tile(left,right);
        left=b.left;
        right=b.right;
        b.left=temp.left;
        b.right=temp.right;
    }
    public int getValueOfTile()
    {
        return (right+left);
    }
    
    public int getleft()
    {
        return left;
    }
    public int getright()
    {
        return right;
    }
    public void setleft(int x)
    {
        left=x;
    }
    public void setright(int x)
    {
        right=x;
    }
    
}
