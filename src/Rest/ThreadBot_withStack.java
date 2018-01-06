/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DominoLine.DominoLine;
import DominoLine.DominoLine_2;
import Exceptions_package.HasNoTiles;
import Exceptions_package.NothingToPlayBot;
import GUI.Ola7_Frame;
import Player.Bot;
import Player.Bot_withStack;
import Player.Player;
import Round.Round;
import Round.Round_Ola7;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Solon
 */
public class ThreadBot_withStack implements Runnable {
    
    Ola7_Frame frame;
  //  ButtonsListener myButtonsListener;
    AtomicInteger counter;
    Bot_withStack bot;
    int place; //place sto myPlayers
    ArrayList<Player> myPlayers;
    ArrayList<ArrayList<JButton>> playerButtons;
    ArrayList<ArrayList<JButton>> extraButtons;
    MessagePanel borrowedMessagePanel;
    DominoLine_2 myDominoLine;
    DominoLinePanel borrowedDominoPanel;
    Round_Ola7 round;
   // JPanel dominoLinePanel;
   public ThreadBot_withStack(Ola7_Frame frame,Round_Ola7 round,AtomicInteger counter,Bot_withStack bot,int place,ArrayList<Player> myPlayers,ArrayList<ArrayList<JButton>> playerButtons,ArrayList<ArrayList<JButton>> extraButtons,MessagePanel borrowedMessagePanel,
          DominoLine_2 myDominoLine,  DominoLinePanel borrowedDominoPanel)

    {
        this.frame=frame;
       // this.myButtonsListener=myButtonsListener
        this.round=round;
        this.counter=counter;
        this.bot=bot;
        this.place=place;
        this.myPlayers=myPlayers;
        this.playerButtons=playerButtons;
        this.extraButtons=extraButtons;
        this.borrowedMessagePanel=borrowedMessagePanel;
        this.myDominoLine=myDominoLine;
        this.borrowedDominoPanel=borrowedDominoPanel;
       
    }
    @Override
    public void run() //throws NothingToPlayBot, HasNoTiles
            
    {
        /*for(int i=0;i<playerButtons.size();i++)
        {
            if(i!=place && myPlayers.get(i) instanceof Bot)
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
        }           */
        try
        {
            boolean playedOnce=false;
            //frame.updateActionListenerBotPlay();


            do
            {
            try {
                System.out.print(bot.getName()+ " To hand einai: ");
                for(Tile tile : bot.getHand())
                {
                    System.out.print(tile.getleft()+""+tile.getright()+"   ");
                }
                System.out.println("");
                    Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                    }
                bot.playBot(myDominoLine,round.getStack(),playedOnce,borrowedMessagePanel);
               
               updateExtra();
                counter.set(0);
                playedOnce=true;
                borrowedMessagePanel.addMessageLabel(bot.getName()+" just placed a Tile");
                borrowedDominoPanel.updateDominoLine(myDominoLine);
                

               // int place=0;
                for(int i=0;i<playerButtons.get(place).size();i++)                //edo prepei na allaxei arithmos JButton
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
                    
//                       string=extraButtons.get(place).get(i).getActionCommand();
  //                      left=Character.getNumericValue(string.charAt(0));
    //                    right=Character.getNumericValue(string.charAt(1));
      //                  tile=new Tile(left,right);
        //                if(myPlayers.get(place).ownsTile(tile)==false)
          //              {
            //                extraButtons.get(place).get(i).setEnabled(false);
              //          }
                    
                }
                for(int i=0;i<extraButtons.get(place).size();i++)
                {
                    if(extraButtons.get(place).get(i).getIcon()==null)
                        break;
                    else
                    {
                        String string=extraButtons.get(place).get(i).getActionCommand();
                        int left=Character.getNumericValue(string.charAt(0));
                        int right=Character.getNumericValue(string.charAt(1));
                        Tile tile=new Tile(left,right); 
                        if(myPlayers.get(place).ownsTile(tile)==false)
                        {
                            //System.out.println(tile.getleft()+" "+tile.getright());
                            extraButtons.get(place).get(i).setEnabled(false);
                        }
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
               Thread.sleep(4000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);}
            counter.set(counter.get()+1);
        }
        catch(HasNoTiles e)
        {
            borrowedMessagePanel.addMessageLabel(e.getMessage());
             try {
               Thread.sleep(4000);
           } catch (InterruptedException ex) {
               Logger.getLogger(ThreadHuman.class.getName()).log(Level.SEVERE, null, ex);}
            //System.out.println("has no tiles");
            counter.set(100);
        }
    }
    
    void updateExtra()
    {
         for(Tile tile : bot.getHand())
                    {
                        boolean bool=false;
                       // String ae;
                        for(int i=0;i<playerButtons.get(place).size();i++)
                        {
                            if(playerButtons.get(place).get(i).getActionCommand().equals(tile.getleft()+""+tile.getright()) || extraButtons.get(place).get(i).getActionCommand().equals(tile.getleft()+""+tile.getright())) 
                                   {
                                       bool=true;
                                       //ae=tile.getleft()+""+tile.getright();
                                      // System.out.println("To "+ae+" yparxei");
                                      // playerButtons.get(place).get(i).setActionCommand(tile.getleft()+""+tile.getright());
                                       break;

                                   }
                                   
                            else if(playerButtons.get(place).get(i).getActionCommand().equals(tile.getright()+""+tile.getleft()) || extraButtons.get(place).get(i).getActionCommand().equals(tile.getright()+""+tile.getleft()))
                           {
                               bool=true;
                             // ae=tile.getright()+""+tile.getleft();
                               //System.out.println("To "+ae+" yparxei");

                              // playerButtons.get(place).get(i).setActionCommand(tile.getright()+""+tile.getleft());
                               break;

                           }
                        }
                        if(bool==false)
                        {
                            
                            for(int i=0;i<extraButtons.get(place).size();i++)
                            {
                                if(extraButtons.get(place).get(i).getActionCommand().equals(tile.getleft()+""+tile.getright()) || extraButtons.get(place).get(i).getActionCommand().equals(tile.getright()+""+tile.getleft())) 
                                    break;
                                
                                if(extraButtons.get(place).get(i).getIcon()==null)
                                {
                                    String imgName=Update.getImgName(place,tile , playerButtons.size());
                                    URL url=getClass().getResource("Tiles/"+imgName);
                                    ImageIcon icon=new ImageIcon(url);
                                    extraButtons.get(place).get(i).setIcon(icon);
                                    extraButtons.get(place).get(i).setVisible(true);
                                    extraButtons.get(place).get(i).setActionCommand(tile.getleft()+""+tile.getright());
                                    borrowedMessagePanel.addMessageLabel("Player "+bot.getName()+"  borrowed Tile: "+tile.getleft()+"-"+tile.getright());
                                  //  try {
                                  //      Thread.sleep(2000);
                                        // extraButtons.get(place).get(i).addActionListener(myButtonsListener);
                                 //   } catch (InterruptedException ex) {
                                 //       Logger.getLogger(ThreadBot_withStack.class.getName()).log(Level.SEVERE, null, ex);
                                 //   }
                                            
                                    break;
                                }
                            }
                        }
                               
                    }
    }
            
            
    
}

