/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions_package.HasNoTiles;
import Exceptions_package.NothingToPlay;
import Ougriko_package.Human;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Solon
 */
public class ThreadHuman implements Runnable {
    
    AtomicInteger counter;
    Human human;
    DominoLine myDominoLine;
    MessagePanel borrowedMessagePanel;
    public ThreadHuman(AtomicInteger counter,Human human, DominoLine myDominoLine,MessagePanel borrowedMessagePanel)
    {
        this.counter=counter;
        this.human=human;
        this.myDominoLine=myDominoLine;
        this.borrowedMessagePanel=borrowedMessagePanel;
    }
     @Override
    public void run() 
    {
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
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);
           }
           counter.set(counter.get()+1);
       }
       catch(NothingToPlay e)
       {
           borrowedMessagePanel.addMessageLabel(e.getMessage());
            try {
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);}
           counter.set(counter.get()+1);
       }
       
 

    }

    
}
