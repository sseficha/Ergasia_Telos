/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.util.ArrayList;
import java.util.Random;

/**
 *Η κλαση υλοποιει την ιδεα ενος Shuffler. Δηλαδη δημιουργει το πληθος των Tile που απαιτουνται στο παιχνιδι
 * με random σειρα. Το πληθος των Tiles υλοποιεται ως ενα ArrayList<Tile> που ονομαζεται randomizedTiles.
 * @author Solon Sefiha,Panos Papastergiou
 */
public class Shuffler {
    
    /** Το ArrayList που αναπαριστα το πληθος των Tile που θα ανακατεψουμε.*/
    private ArrayList<Tile> randomizedTiles;
    
    /**
     * Προσθετει ολα τα Tile με αυξουσα σειρα στο randomizedTiles.(0:0,0:1,...,6:6).
     */
    public Shuffler()
    {
        randomizedTiles=new ArrayList<Tile>();
        for(int i=0;i<7;i++)
            for(int j=i;j<7;j++)
            {
                randomizedTiles.add(new Tile(i,j));
            }
    }
    
    /**
     * Παιρνει 1-1 τα Tile στο randomizedTiles και κανει swap με οποιοδηποτε απο τα αλλα
     * που βρισκονται στο randomizedTiles. Υστερα επιστρεφει το randomizedTiles.
     * @return το πλεον randomized randomizedTiles.
     */
    public ArrayList<Tile> shuffle()
    {
        int random;
        Random randomer=new Random(); 
        for(int i=0;i<=27;i++)
        {
            random=randomer.nextInt(27);
            //swap(randomizedTiles.get(i),randomizedTiles.get(random));
            randomizedTiles.get(i).swap(randomizedTiles.get(random));
          
        }
        return randomizedTiles;
    }   
    
}   