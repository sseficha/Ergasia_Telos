/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominoLine;

import Player.Player;
import Rest.Tile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Αναπαριστα μια σειρα Domino υλοποιωντας την με ενα ArrayList<Tile> rowTiles. Οι λειτουργιες της ειναι
 * η προσθηκη Tile η στο τελος η στην αρχη του ArrayList αναλογα με το που ειναι επιτρεπτο.
 * @author Solon Sefiha,Panos Papastergiou
 */
public abstract class DominoLine {
    
   protected ArrayList<Tile> rowTiles;
    
   public DominoLine()
    {
        rowTiles=new ArrayList<Tile>();
    }
    
   
   /**
    * Ελεγχει που μπορει να μπει το δοθεν tile στο rowTiles.
    * 
    * @param tileToAdd το Tile που θελουμε να ελενξουμε αν μπορει να μπει στο rowTiles.
    * 
    * @return 0 αν μπαινει στην αρχη του rowTiles 1 αν μπαινει στο τελος 2 αν μπαινει και στη αρχη
    * και στο τελος και -1 αν δεν μπαινει πουθενα.
    */
    public abstract int whereToAdd(Tile tileToAdd);  //0 gia arxi 1 gia telos 2 gia epilogi -1 gia pouthena
    
    /**
     * Eπιλεγει ο χρηστης αν το tileToAdd θα μπει στην αρχη η στο τελος οταν μπορει να 
     * μπει και στην αρχη και στο τελος.
     * @param tileToAdd το tile που διαλεγουμε που θα μπει.
     * @param cmd το interface που χρησιμοποιειται.
     */
    
   /* public void choosePlace(Tile tileToAdd)     //open JDialog opou dialegei!       eixe cmd
    {
       String answer;
       do
        {
            answer=Cmd.getChoice();
            if(!answer.equals("arxi") && !answer.equals("telos"))
                cmd.errorChoice();
        }
        while(!answer.equals("arxi") && !answer.equals("telos"));
        if(answer.equals("arxi"))
            rowTiles.add(0, tileToAdd);
        else if(answer.equals("telos"))
            rowTiles.add(tileToAdd);        
     
        
       
    }   */
    
    /**
     * Γινεται η προσθηκη ενος Tile στο rowTiles. Αν μπορει να μπει η στην αρχη η
     * στο τελος στην περιπτωση του human δινεται η επιλογη να διαλεξει ενω στην
     * περιπτωση του bot απλα μπαινει παντα στην αρχη.
     * @param tileToAdd Τile που θα προστεθει.
     * @param property Η ιδιοτητα του player που βαζει το Tile (human or bot)
     * @param cmd το interface που χρησιμοποιειται.
     */
    
    public void addToDominoLine(Tile tileToAdd,int place)
    {
        if(rowTiles.size()==0)
            rowTiles.add(tileToAdd);
       // else
       // {
            //int temp=whereToAdd(tileToAdd);
         //   if(temp==2)
           // {
             //   if(property.equals("human"))
                    
               //     choosePlace(tileToAdd);       //cmd!!!
                //else 
            //    if(property.equals("bot"))
           //         rowTiles.add(0, tileToAdd);
         //   }
            else if(place==0)  
                rowTiles.add(0, tileToAdd);
            else if(place==1)
                rowTiles.add(tileToAdd);
        }
    
        
    
    public ArrayList<Tile> getrowTiles()
    {
        return rowTiles;
    }
    
}

