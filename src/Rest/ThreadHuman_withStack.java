/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DominoLine.DominoLine;
import DominoLine.DominoLine_2;
import Exceptions_package.HasNoTiles;
import Exceptions_package.MustDraw;
import Exceptions_package.NothingToPlay;
import GUI.Ola7_Frame;
import Player.Human;
import Player.Human_withStack;
import Round.Round_Ola7;
import java.awt.event.ActionListener;
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
public class ThreadHuman_withStack implements Runnable {
    
    int place;
    Ola7_Frame frame;
    Round_Ola7 round;
    ActionListener myButtonsListener;
    ActionListener myButtonsListenerExtra;
    AtomicInteger counter;
    Human_withStack human;
    DominoLine_2 myDominoLine;
    MessagePanel borrowedMessagePanel;
    ArrayList<ArrayList<JButton>> playerButtons;
    ArrayList<ArrayList<JButton>> extraButtons;
    public ThreadHuman_withStack(Ola7_Frame frame,ActionListener myButtonsListener,ActionListener myButtonsListenerExtra,Round_Ola7 round,int place,AtomicInteger counter,Human_withStack human, DominoLine_2 myDominoLine,MessagePanel borrowedMessagePanel,ArrayList<ArrayList<JButton>> playerButtons,ArrayList<ArrayList<JButton>> extraButtons)
    {
        this.round=round;
        this.frame=frame;
        this.myButtonsListener=myButtonsListener;
                this.myButtonsListenerExtra=myButtonsListenerExtra;
        this.place=place;
        this.counter=counter;
        this.human=human;
        this.myDominoLine=myDominoLine;
        this.borrowedMessagePanel=borrowedMessagePanel;
        this.playerButtons=playerButtons;
        this.extraButtons=extraButtons;
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
           Boolean playedOnce=false;
        //   frame.updateActionListenerHumanPlay(place);
           do
           {
              // try {
              //   Thread.sleep(1000);
              //   } catch (InterruptedException ex) {
              //      Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);}
               // try{
                    human.pass(myDominoLine,round.getStack(),playedOnce);
                    playedOnce=true;
                    
                    
                   updateExtra();
                    
               // }
              /*  catch(MustDraw e)
                {
                    for(int i=0;i<extraButtons.get(place).size();i++)
                    {
                        if(extraButtons.get(place).get(i).getIcon()==null)
                        {
                            if(place==0 || place==2)
                                Strin
                        }
                    }
                }*/
                counter.set(0);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException ex) {
                   throw new InterruptedException();
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
           counter.set(100);
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
       catch(InterruptedException e)
       {
           borrowedMessagePanel.addMessageLabel("You passed!");

           
       }
    }
       public void updateExtra()
       {
            for(Tile tile : human.getHand())
           // for(int i=human.getHand().size()-1;i>=0;i--)
                    {
                        boolean bool=false;
                        String ae;
                        for(int i=0;i<playerButtons.get(place).size();i++)
                        {
                            if(playerButtons.get(place).get(i).getActionCommand().equals(tile.getleft()+""+tile.getright()) || extraButtons.get(place).get(i).getActionCommand().equals(tile.getleft()+""+tile.getright())) 
                                   {
                                       bool=true;
                                       //ae=tile.getleft()+""+tile.getright();
                                       //System.out.println("To "+ae+" yparxei");
                                      // playerButtons.get(place).get(i).setActionCommand(tile.getleft()+""+tile.getright());
                                       break;

                                   }
                                   
                            else if(playerButtons.get(place).get(i).getActionCommand().equals(tile.getright()+""+tile.getleft()) || extraButtons.get(place).get(i).getActionCommand().equals(tile.getright()+""+tile.getleft()))
                           {
                               bool=true;
                              //ae=tile.getright()+""+tile.getleft();
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
                                   {
                                       //bool=true;
                                       //ae=tile.getleft()+""+tile.getright();
                                       //System.out.println("To "+ae+" yparxei");
                                      // playerButtons.get(place).get(i).setActionCommand(tile.getleft()+""+tile.getright());
                                       break;

                                   }
                                   
                           
                               //bool=true;
                              //ae=tile.getright()+""+tile.getleft();
                               //System.out.println("To "+ae+" yparxei");

                              // playerButtons.get(place).get(i).setActionCommand(tile.getright()+""+tile.getleft());
                              // break;

                                if(extraButtons.get(place).get(i).getIcon()==null)
                                {
                                    String imgName=Update.getImgName(place,tile , extraButtons.size());
                                    URL url=getClass().getResource("Tiles/"+imgName);
                                    ImageIcon icon=new ImageIcon(url);
                                    extraButtons.get(place).get(i).setIcon(icon);
                                    extraButtons.get(place).get(i).setActionCommand(tile.getleft()+""+tile.getright());
                                    extraButtons.get(place).get(i).addActionListener(myButtonsListenerExtra);
                                    borrowedMessagePanel.addMessageLabel("Player "+human.getName()+" just borrowed Tile: "+tile.getleft()+"-"+tile.getright());
                             //   try {
                              //      Thread.sleep(2000);
                              //  } catch (InterruptedException ex) {
                              //      Logger.getLogger(ThreadHuman_withStack.class.getName()).log(Level.SEVERE, null, ex);
                              //  }
                                    break;
                                }
                            }
                        }
                               
                    }
       }
       
 

    
}
