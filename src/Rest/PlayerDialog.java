/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Exceptions_package.InvalidPlayerChoice_Number;
import Exceptions_package.InvalidPlayerChoice_String;
import Player.Bot;
import Player.Bot_withStack;
import Player.Human;
import Player.Human_withStack;
import Player.Player;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;

/**
 *
 * @author Solon
 */
public class  PlayerDialog {
    
    private JFrame master;
    public PlayerDialog(JFrame master)
    {
        this.master=master;
    }
    
     public ArrayList<Player> getPlayers()
    {
        JDialog players;
        GridLayout dialogLayout;
        //JLabel nofPlayers;
        
        
        players=new JDialog(master,"Players",true);
        players.setSize(500,300);
        players.setLocation(500, 200);
        players.getContentPane().setBackground(Color.GRAY);
        dialogLayout=new GridLayout(0,2);
        players.setLayout(dialogLayout);
        //players.add(new JLabel("Give me the number of players (0-4)"));
        //players.add(getNofPlayers);
        JTextField getNofPlayers=new JTextField();
        //getNofPlayers.setActionCommand("number");
        ArrayList<JLabel> giveNames=new ArrayList<>();
        ArrayList<JTextField> getNames=new ArrayList<>();
        JButton entry=new JButton("OK");
        entry.setVisible(false);
        ArrayList<Player> myPlayers=new ArrayList<>();

        entry.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                for(int i=0;i<4;i++)
                {
                    if(getNames.get(i).isVisible())
                    {
                        if(i==0)
                            myPlayers.add(new Human_withStack(getNames.get(i).getText(),null));
                        else
                            myPlayers.add(new Bot_withStack(getNames.get(i).getText(),null));
                    }
                    else
                        break;
                    
                        
                }
                players.dispose();
               
            }
            
        });
        //JLabel x=new JLabel("Give me your name");
       // x.setVisible(false);
       // giveNames.add(x);
       // players.add(this)
        players.add(new JLabel("Give me the number of players (2-4)"));
        players.add(getNofPlayers);
        for(int i=1;i<5;i++)
        {
            JLabel label;
            if(i==1)
            {
                label=new JLabel("Give me your name");
            }
            else
            {
                int temp=i-1;
                label=new JLabel("Give name of bot "+temp);
            }
            label.setVisible(false);
            giveNames.add(label);
            players.add(label);
            JTextField field=new JTextField();
            field.setVisible(false);
            getNames.add(field);
            players.add(field);
        }
        players.add(new JLabel());
        //JButton tade=new JButton("OK");
        //tade.setPreferredSize(new Dimension(50,50));
        players.add(entry);
        getNofPlayers.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                entry.setVisible(true);
                for(int i=0;i<4;i++)
                {
                    giveNames.get(i).setVisible(false);
                    getNames.get(i).setVisible(false);
                }
                try{
                String string=getNofPlayers.getText();
                if(!isNumber(string))
                {
                   throw new InvalidPlayerChoice_String();
                }
                else
                {
                   int number=Integer.parseInt(string);
                   if(number<2 || number>4)
                   {
                      throw new InvalidPlayerChoice_Number();
                   }
                   else
                   {
                       for(int i=0;i<number;i++)
                       {
                           giveNames.get(i).setVisible(true);
                           getNames.get(i).setVisible(true);
                       }
                   }
                }
                }catch(InvalidPlayerChoice_String e)
                {
                    JOptionPane.showMessageDialog(players,e.getMessage(),"Error",ERROR_MESSAGE);
                }
                catch(InvalidPlayerChoice_Number e)
                {
                    JOptionPane.showMessageDialog(players,e.getMessage(),"Error",ERROR_MESSAGE);
                }
              //  else
                //{
                //    JOptionPane.showMessageDialog(players,ERROR_MESSAGE);
                    //System.out.println("aaaaaaaaaaa");
               // }
            }
            
        });
        
        players.setVisible(true);
        return myPlayers;
    }
     
      public boolean isNumber(String string)
    {
        boolean bool=true;
        try
        {
            Integer.parseInt(string);
        }
        catch(Exception e)
        {
              bool=false;      
        }
        return bool;
    }
}
