/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions_package.HasNoTiles;
import Exceptions_package.NothingToPlay;
import Exceptions_package.NothingToPlayBot;
import Ougriko_package.Bot;
import Ougriko_package.Human;
import Ougriko_package.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 *
 * @author Solon
 */
public class ThreadBot implements Runnable {
    
    AtomicInteger counter;
    Bot bot;
    int place; //place sto myPlayers
    ArrayList<Player> myPlayers;
    ArrayList<ArrayList<JButton>> playerButtons;
    MessagePanel borrowedMessagePanel;
    DominoLine myDominoLine;
    DominoLinePanel borrowedDominoPanel;
   // JPanel dominoLinePanel;
   public ThreadBot(AtomicInteger counter,Bot bot,int place,ArrayList<Player> myPlayers,ArrayList<ArrayList<JButton>> playerButtons,MessagePanel borrowedMessagePanel,
          DominoLine myDominoLine,  DominoLinePanel borrowedDominoPanel)

    {
        this.counter=counter;
        this.bot=bot;
        this.place=place;
        this.myPlayers=myPlayers;
        this.playerButtons=playerButtons;
        this.borrowedMessagePanel=borrowedMessagePanel;
        this.myDominoLine=myDominoLine;
        this.borrowedDominoPanel=borrowedDominoPanel;
       
    }
    @Override
    public void run() //throws NothingToPlayBot, HasNoTiles
    {
        try
        {

            do
            {
            try {
                    Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                    }
                bot.playBot(myDominoLine);
                counter.set(0);
                borrowedMessagePanel.addMessageLabel(bot.getName()+" just placed a Tile");
                borrowedDominoPanel.updateDominoLine(myDominoLine);

               // int place=0;
                for(int i=0;i<playerButtons.get(place).size();i++)
                {
                    String string=playerButtons.get(place).get(i).getActionCommand();
                    int left=Character.getNumericValue(string.charAt(0));
                    int right=Character.getNumericValue(string.charAt(1));
                    Tile tile=new Tile(left,right); 
                    if(myPlayers.get(place).ownsTile(tile)==false)
                    {
                        //System.out.println(tile.getleft()+" "+tile.getright());
                        playerButtons.get(place).get(i).setEnabled(false);
                    }
                }
               // if(!player.getHand().contains(this))
               // System.out.println("epaixe o "+player.getName());


            }
            while(true);
        }

       catch(NothingToPlayBot e)
        {

            //System.out.println("nothing to play bot");
            borrowedMessagePanel.addMessageLabel(e.getMessage());
             try {
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);}
            counter.set(counter.get()+1);
        }
        catch(HasNoTiles e)
        {
            borrowedMessagePanel.addMessageLabel(e.getMessage());
             try {
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);}
            //System.out.println("has no tiles");
            counter.set(counter.get()+1);
        }
    }
    
}
