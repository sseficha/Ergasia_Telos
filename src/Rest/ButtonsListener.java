/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import DominoLine.DominoLine;
import Exceptions_package.MustChoose;
import Exceptions_package.NotAddableTile;
import Exceptions_package.NothingToPlay;
import Exceptions_package.NothingToPlayBot;
import Exceptions_package.OtherPlayerTile;
import GUI.Ola7_Frame;
import GUI.Ouggriko_Frame;
import Player.Human;
import Player.Player;
import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.beans.Beans.isInstanceOf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Solon
 */
public class ButtonsListener implements ActionListener
    {
   
        private ArrayList<Player> myPlayers;
        private DominoLine myDominoLine;
        private DominoLinePanel borrowedDominoPanel;
        private ArrayList<ArrayList<JButton>> playerButtons;
        private MessagePanel borrowedMessagePanel;
        private Frame frame;
   public ButtonsListener(ArrayList<Player> myPlayers, DominoLine myDominoLine, DominoLinePanel borrowedDominoPanel, 
           ArrayList<ArrayList<JButton>> playerButtons, MessagePanel borrowedMessagePanel, Frame frame)
    {
        this.myPlayers=myPlayers;
        this.myDominoLine=myDominoLine;
        this.borrowedDominoPanel=borrowedDominoPanel;
        this.playerButtons=playerButtons;
        this.borrowedMessagePanel=borrowedMessagePanel;
        this.frame=frame;
        
    }

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            int place=0;
            for(int i=0;i<myPlayers.size();i++)
            {
                if(myPlayers.get(i) instanceof Human)
                {
                    place=i;
                }
            }
            Player player=myPlayers.get(place);
            player=((Human)player);
            String string=ae.getActionCommand();
            int left=Character.getNumericValue(string.charAt(0));
            int right=Character.getNumericValue(string.charAt(1));
            Tile tileToAdd=new Tile(left,right);  
            try {
             if(frame instanceof Ola7_Frame){
                 if(player instanceof Human)
                 if( left+right==7){
                     throw new MustChoose();
                 }
             }
               
                
            
                
                player.add(myDominoLine, tileToAdd);
                
                 //   borrowedDominoPanel.labels.get(i).setText(myDominoLine.getrowTiles().get(i).getleft()+""+myDominoLine.getrowTiles().get(i).getright());
                    
                borrowedDominoPanel.updateDominoLine(myDominoLine);
                for(JButton b : playerButtons.get(place))
                    {
                        if(ae.getActionCommand().equals(b.getActionCommand()))
                            b.setEnabled(false);
                           
                           // b.setVisible(false);
                    }
                borrowedMessagePanel.addMessageLabel("You just placed a Tile");
                //  if(player.ownsTile(tile))
                //{
                //playerButtons
                
                // }
            
            } catch (NotAddableTile ex) {
                borrowedMessagePanel.addMessageLabel(ex.getMessage());
            } catch (OtherPlayerTile ex) {
                //borrowedMessagePanel.addMessageLabel(ex.getMessage());
            } catch (MustChoose ex) {
                Choice choice=new Choice(frame);
                int temp=choice.choose();
                myDominoLine.addToDominoLine(tileToAdd,temp);      
                player.getHand().removeIf(tile -> tile.equals(tileToAdd));
                borrowedDominoPanel.updateDominoLine(myDominoLine);

                for(JButton b : playerButtons.get(place))
                    {
                        if(ae.getActionCommand().equals(b.getActionCommand()))
                            b.setEnabled(false);
                    }
                
                
            } catch (NothingToPlay ex) {
                //Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NothingToPlayBot ex) {
                Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
