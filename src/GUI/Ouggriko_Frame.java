/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions_package.HasNoTiles;
import Exceptions_package.InvalidPlayerChoice_Number;
import Exceptions_package.InvalidPlayerChoice_String;
import Exceptions_package.MustChoose;
import Exceptions_package.NotAddableTile;
import Exceptions_package.NothingToPlay;
import Exceptions_package.NothingToPlayBot;
import Exceptions_package.OtherPlayerTile;
import Rest.ButtonsListener;
import Player.Bot;
import Player.Human;
import Player.Player;
import Round.Round;
import Rest.ButtonsListenerNotTurn;
import Rest.Choice;
import Rest.Cmd;
import DominoLine.DominoLine;
import DominoLine.DominoLine_1;
import Rest.DominoLinePanel;
import Rest.MessagePanel;
import Rest.PlayerDialog;
import Rest.ThreadBot;
import Rest.ThreadHuman;
import Rest.Tile;
import Round.Round_Ouggriko;
import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.LINE_END;
import static java.awt.BorderLayout.LINE_START;
import static java.awt.BorderLayout.PAGE_END;
import static java.awt.BorderLayout.PAGE_START;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import static java.awt.FlowLayout.LEFT;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Solon
 */
public class Ouggriko_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Ouggriko_Frame
     */
   private BorderLayout layout;
   private JPanel player1Panel;
   private JPanel player2Panel;
   private JPanel player3Panel;
   private JPanel player4Panel;
   protected JPanel centerPanel;
   private ArrayList<ArrayList<JButton>> playerButtons;
   private DominoLinePanel borrowedDominoPanel;
   private JPanel dominoLinePanel;
   private MessagePanel borrowedMessagePanel;
   private JPanel messagePanel;
   private ArrayList<Player> myPlayers;
   private  Round round;
   private DominoLine myDominoLine;
   private ButtonsListener myButtonsListener;
    
   public Ouggriko_Frame()
    {
        initComponents();

        //PlayerDialog dialog=new PlayerDialog(this);                                 //AAAA
        //Ouggriko_Frame(dialog.getPlayers());
        //this(new PlayerDialog(getFram).getPlayers());
    }
   
   public ArrayList<Player> getMyPlayers()
   {
       return myPlayers;
   }
    public Ouggriko_Frame(ArrayList<Player> myPlayers) {
        
        initComponents();
        setSize(900,700);
        layout=new BorderLayout();
        setLayout(layout);
        setLocationRelativeTo(null);
        myDominoLine=new DominoLine_1();
        this.myPlayers=myPlayers;
        this.setBackground(Color.black);
        //this.setVisible(true);
        
        //for(int i=0;i<myPlayers.size();i++)
        //    System.out.println(myPlayers.get(i).getName());
        //PlayerDialog dialog=new PlayerDialog(this);                                 //AAAA
        //myPlayers=dialog.getPlayers();
        
       //myPlayers=getPlayers();
        //int numberOfPlayers=myPlayers.size();        ///?????
        
       
        
        round=new Round_Ouggriko(myPlayers);
        
       // round=new Round(getPlayers());
        myPlayers=round.getPlayers();       //gia sosti seira
        int numberOfPlayers=myPlayers.size();
        playerButtons=new ArrayList<>();
        for(int i=0;i<numberOfPlayers;i++)      
        {   
            playerButtons.add(new ArrayList<JButton>());
        }
        player1Panel=new JPanel();
        player1Panel.setPreferredSize(new Dimension(800,100));
        player1Panel.setBackground(Color.black);
        player2Panel=new JPanel();
        player2Panel.setPreferredSize(new Dimension(800,100));
        player2Panel.setBackground(Color.black);
        player1Panel.add(new JLabel(myPlayers.get(0).getName()));         
        player2Panel.add(new JLabel(myPlayers.get(1).getName()));  
        //for(int j=0;j<2;j++)
            for(int i=0;i<24/numberOfPlayers;i++)
            {
                JButton button=new JButton();
                button.setPreferredSize(new Dimension(50,80));
                playerButtons.get(0).add(button);
               // if(j==0)
                    player1Panel.add(button);
              //  else
                //    player2Panel.add(button);

            }
        switch(numberOfPlayers)
        {
            case 2:
                
                add(player1Panel,PAGE_START);
                for(int i=0;i<24/numberOfPlayers;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(50,80));
                    playerButtons.get(1).add(button);
                    player2Panel.add(button);
                }
                add(player2Panel,PAGE_END);
                break;
        
        
            case 4:
               // add(player1Panel,PAGE_START);
               // player2Panel.setPreferredSize(new Dimension(100,700));
               // add(player2Panel,LINE_END);
                player4Panel=new JPanel();
                player4Panel.add(new JLabel(myPlayers.get(3).getName()));             //allaxe button

                player4Panel.setPreferredSize(new Dimension(100,700));
                player4Panel.setBackground(Color.black);
                for(int i=0;i<24/numberOfPlayers;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(80,50));
                    playerButtons.get(3).add(button);
                    player4Panel.add(button);
                }
                add(player4Panel,LINE_START);
              //  add(bottomPanel,LINE_END);
            case 3:
                add(player1Panel,PAGE_START);
                for(int i=0;i<24/numberOfPlayers;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(80,50));
                    playerButtons.get(1).add(button);
                    player2Panel.add(button);
                }
                player2Panel.setPreferredSize(new Dimension(100,700));
                add(player2Panel,LINE_END);
                player3Panel=new JPanel();
                player3Panel.add(new JLabel(myPlayers.get(2).getName()));          //allaxe button

                player3Panel.setPreferredSize(new Dimension(800,100));
                player3Panel.setBackground(Color.black);
                for(int i=0;i<24/numberOfPlayers;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(50,80));
                    playerButtons.get(2).add(button);
                    player3Panel.add(button);
                }
                add(player3Panel,PAGE_END);
                break;
                
            
                
        }
        for(int i=0;i<numberOfPlayers;i++)
        {
            Player aPlayer=round.getPlayers().get(i);
            HashSet<Tile> aPlayerHand=aPlayer.getHand();
            int temp=0;
            for(Tile j : aPlayerHand)
            {
                String imgName=null;
                if(i==0)
                {
                    imgName="Vertical "+j.getleft()+""+j.getright()+".png";
                }
                else if(i==1 && numberOfPlayers==2)
                {
                    imgName="Vertical "+j.getleft()+""+j.getright()+".png";
                    //imgName="VerticalQ.png";
                }
                else if(i==1 && numberOfPlayers>2)
                {
                   imgName="Horizontal "+j.getleft()+""+j.getright()+".png";
                   //imgName="HorizontalQ.png"; 

                }
                else if(i==2)
                {
                    imgName="Vertical "+j.getleft()+""+j.getright()+".png";
                    //imgName="VerticalQ.png";
                }
                else if(i==3)
                {
                    imgName="Horizontal "+j.getleft()+""+j.getright()+".png";
                    //imgName="HorizontalQ.png";

                }
                URL url = getClass().getResource("Tiles/"+imgName);
                ImageIcon icon;
                icon=new ImageIcon(url);

                playerButtons.get(i).get(temp).setIcon(icon);
                playerButtons.get(i).get(temp).setActionCommand(j.getleft()+""+j.getright());
              //  playerButtons.get(i).get(temp).addActionListener(new ButtonsListener());
                temp++;
            }
            
        }
                
        

       
        
        
        
        
        
        
        centerPanel=new JPanel();
        FlowLayout centerLayout=new FlowLayout();
        centerLayout.setAlignment(LEFT);
        centerPanel.setLayout(centerLayout);
        borrowedDominoPanel=new DominoLinePanel();
        dominoLinePanel=borrowedDominoPanel.getPanel();
        dominoLinePanel.setPreferredSize(new Dimension(450,500));
        dominoLinePanel.setBackground(Color.black);
        FlowLayout layout=new FlowLayout();
        layout.setAlignment(LEFT);
        dominoLinePanel.setLayout(layout);
        //dominoLinePanel.setSize(500, 500);
        //dominoLinePanel.setPreferredSize(new Dimension(500,500));
       // dominoLinePanel.setBackground(Color.yellow);
        centerPanel.add(dominoLinePanel);
        borrowedMessagePanel=new MessagePanel(7);
        messagePanel=borrowedMessagePanel.getPanel();
        messagePanel.setPreferredSize(new Dimension(220,500));
        messagePanel.setBackground(Color.black);
        centerPanel.add(messagePanel);
        add(centerPanel,CENTER);
       
        
       myButtonsListener=new ButtonsListener(myPlayers,myDominoLine,borrowedDominoPanel,playerButtons,borrowedMessagePanel,this);

        for(int i=0;i<numberOfPlayers;i++)
        {
            for(int j=0;j<myPlayers.get(i).getHand().size();j++)
            {
                                playerButtons.get(i).get(j).addActionListener(myButtonsListener);

            }
        }
        
        
        
        
       // JPanel panel=new JPanel();
       // panel.setPreferredSize(new Dimension(800,100));
       // add(panel,PAGE_START);
       // add(new JButton(),CENTER);
        
        //FlowLayout layout=new FlowLayout();
        //layout.setAlignment(FlowLayout.CENTER);
       // dialog.setLayout(layout);
       //play();
       setVisible(true);
       
       
    }
    
    public JFrame getFrame()
    {
        return this;
    }
 
  
    
   
    
    //ArrayList<Player> getPlayers()
   
    
   
    
    public void play() throws InterruptedException
    {
        //do{
        AtomicInteger counter=new AtomicInteger();
        counter.set(0);
       // round=new Round(myPlayers);
      
        do{
            for(int i=0;i<myPlayers.size();i++)
            {
               
               // try
               // {
                    if(myPlayers.get(i) instanceof Bot)
                    {
                       updateActionListenerBotPlay();
                       Bot bot=((Bot) myPlayers.get(i));
                       int place=i;
                       Thread botThread=new Thread(new ThreadBot(counter,bot,place,myPlayers,playerButtons,borrowedMessagePanel,myDominoLine,borrowedDominoPanel));
                       botThread.start();
                       botThread.join();
                       if(counter.get()==myPlayers.size())
                         break;
                    }
                    else if(myPlayers.get(i) instanceof Human)
                    {
                        updateActionListenerHumanPlay(i);
                        Human human=(Human) myPlayers.get(i);
                        int place=i;
                        Thread playerThread=new Thread(new ThreadHuman(place,counter,human,myDominoLine,borrowedMessagePanel,playerButtons));
                        playerThread.start();
                        playerThread.join();
                        if(counter.get()==myPlayers.size())
                            break;
                    }
                    
              //  }
             // System.out.println(counter.get()+ " o counter "+ myPlayers.size()+" to size");
             // Cmd cmd=new Cmd();
             // cmd.showDominoLine(myDominoLine);
              
            }
           
        }
        while(counter.get()<myPlayers.size());
        //while(counter<4);
        round.setWinnerPoints();
        for(int i=0;i<myPlayers.size();i++)
        {
            borrowedMessagePanel.addMessageLabel(myPlayers.get(i).getName()+" points: "+myPlayers.get(i).getPoints());
        }
        //round=new Round(myPlayers);
      //  if(!round.gameIsOver())
      //  {
            //round=new Round(myPlayers);
      //  }
       // }
        
      //  while(round.gameIsOver()==false);
        
        //Thread.sleep(10000);
        
    }
    void updateActionListenerHumanPlay(int place)
    {
        for(int j=0;j<playerButtons.get(place).size();j++)
        {
           ActionListener[] al=playerButtons.get(place).get(j).getActionListeners();
           for(ActionListener temp : al)
           {
               playerButtons.get(place).get(j).removeActionListener(temp);
           }
           playerButtons.get(place).get(j).addActionListener(myButtonsListener);

        }
    }
    void updateActionListenerBotPlay()
    {
          for(int i2=0;i2<myPlayers.size();i2++)
            {
                if(myPlayers.get(i2) instanceof Human)
                {
                    for(int j=0;j<playerButtons.get(i2).size();j++)
                    {
                       ActionListener[] al=playerButtons.get(i2).get(j).getActionListeners();
                       for(ActionListener temp : al)
                       {
                           playerButtons.get(i2).get(j).removeActionListener(temp);
                       }
                        playerButtons.get(i2).get(j).addActionListener(new ButtonsListenerNotTurn(borrowedMessagePanel));
                    }
                }
            } 
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void playGame(){//static void main(String args[]) {
        /* Set the Nimbus look and feel */
      

        /* Create and display the form */
       // java.awt.EventQueue.invokeLater(new Runnable() {
          //  public void run() {
             //   Ouggriko_Frame myFrame;
               // do
               // {
                  
                 //   PlayerDialog dialog=new PlayerDialog(new Ouggriko_Frame());         //edo!!!!!!
                 //   myFrame=new Ouggriko_Frame(dialog.getPlayers());                    //  allaxes!!!!
             //       myFrame=new Ouggriko_Frame(myPlayers);      //ayto bgale
             //       myFrame.setVisible(true);
                    
              
             // dispose();
               // Ouggriko_Frame myFrame;
               Ouggriko_Frame myFrame=this;
             
                  //  myFrame=new Ouggriko_Frame(myPlayers);      //ayto bgale
                   // myFrame.setVisible(true);
                    
                    
               do{
                   try {
                    myFrame.play();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                   
                   
                   if(myFrame.round.gameIsOver()==false)
                   {
                       myFrame.dispose();
                       myFrame=new Ouggriko_Frame(myFrame.getMyPlayers());
                       myFrame.setVisible(true);
                   }
            

                }
                while(myFrame.round.gameIsOver()==false);
               ArrayList<String> winners=myFrame.round.getWinner();
               String winnerMessage="";
                for(String string : winners)
                {
                    winnerMessage=winnerMessage+""+string+" won!";
                    winnerMessage=winnerMessage+"\n";
                    
                }
              //  try {
               //     Thread.sleep(10000);
               // } catch (InterruptedException ex) {
               // }
               myFrame.dispose();
               JOptionPane.showMessageDialog(myFrame,winnerMessage,"Winner",INFORMATION_MESSAGE);
              
              // try
              // {
                  // myFrame.setVisible(false);
                  // Thread.sleep(10000);
                  
              // }
              // catch(InterruptedException e){
              // }
              //exit();
            }
       // });
    }
       // });
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

