/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Player.Player;
import Rest.PlayerDialog;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class test2 {
    
    
    public static void main(String[] args){
        JFrame a=new JFrame();
        PlayerDialog tade=new PlayerDialog(a);
        ArrayList<Player> o=tade.getPlayers();
        a.dispose();
        Ouggriko_Frame x=new Ouggriko_Frame(o);
        x.playGame();
    }
    
}
