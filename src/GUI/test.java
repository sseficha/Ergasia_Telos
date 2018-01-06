/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Player.Player;
import Rest.PlayerDialog;
import static java.awt.FlowLayout.CENTER;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Solon
 */
public class test  {

    /**
     * @param args the command line arguments
     */
    public test()
    {
        
       // add(centerPanel,CENTER);
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //test x=new test();
        JFrame a=new JFrame();
        PlayerDialog tade=new PlayerDialog(a);
        ArrayList<Player> o=tade.getPlayers();
        a.dispose();
        Ola7_Frame x=new Ola7_Frame(o);
        x.playGame();
        //test x=new test(o);
        //x.playGame();
        
    }

   
    
}
