/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DominoLine.DominoLine;
import Exceptions_package.HasNoTiles;
import Exceptions_package.NothingToPlay;
import Player.Human;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Solon
 */
public class ThreadHuman implements Runnable {
    
    int place;
    AtomicInteger counter;
    Human human;
    DominoLine myDominoLine;
    MessagePanel borrowedMessagePanel;
    ArrayList<ArrayList<JButton>> playerButtons;
    public ThreadHuman(int place,AtomicInteger counter,Human human, DominoLine myDominoLine,MessagePanel borrowedMessagePanel,ArrayList<ArrayList<JButton>> playerButtons)
    {
        this.place=place;
        this.counter=counter;
        this.human=human;
        this.myDominoLine=myDominoLine;
        this.borrowedMessagePanel=borrowedMessagePanel;
        this.playerButtons=playerButtons;
    }
     @Override
    public void run() 
    {
       /* for(int i=0;i<playerButtons.size();i++)
        {
            if(i!=place)
            {
                for(int j=0;j<playerButtons.get(i).size();j++)
                {
                    playerButtons.get(i).get(j).setVisible(false);
                }
            }
            else
            {
                for(int j=0;j<playerButtons.get(i).size();j++)
                {
                    playerButtons.get(i).get(j).setVisible(true);
                }
            }
        }*/
       try
       {
           do
           {
              // try {
              //   Thread.sleep(1000);
              //   } catch (InterruptedException ex) {
              //      Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);}
                human.pass(myDominoLine);
                counter.set(0);
               try {
                   Thread.sleep(100);
               } catch (InterruptedException ex) {
                   
               }

           }
           while(true);
       }
       catch(HasNoTiles e)
       {
           borrowedMessagePanel.addMessageLabel(e.getMessage());
           try {
               Thread.sleep(4000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);
           }
           counter.set(counter.get()+1);
       }
       catch(NothingToPlay e)
       {
           borrowedMessagePanel.addMessageLabel(e.getMessage());
            try {
               Thread.sleep(4000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);}
           counter.set(counter.get()+1);
       }
       
 

    }

    
}
