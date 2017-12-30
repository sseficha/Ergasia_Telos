/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Ougriko_package.Player;
import Rest.PlayerDialog;
import static java.awt.FlowLayout.CENTER;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Solon
 */
public class test extends Ouggriko_Frame {

    /**
     * @param args the command line arguments
     */
    public test(ArrayList<Player> o)
    {
        super(o);
       // add(centerPanel,CENTER);
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //test x=new test();
        JFrame a=new JFrame();
        PlayerDialog tade=new PlayerDialog(a);
        ArrayList<Player> o=tade.getPlayers();
        a.dispose();
        test x=new test(o);
        x.playGame();
        
    }
    
}
