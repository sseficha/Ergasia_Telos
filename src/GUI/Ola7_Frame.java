/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DominoLine.DominoLine;
import DominoLine.DominoLine_1;
import DominoLine.DominoLine_2;
import Player.Bot;
import Player.Bot_withStack;
import Player.Human;
import Player.Human_withStack;
import Player.Player;
import Rest.ButtonsListener;
import Rest.ButtonsListenerNotTurn;
import Rest.DominoLinePanel;
import Rest.MessagePanel;
import Rest.StackOfTiles;
import Rest.ThreadBot;
import Rest.ThreadBot_withStack;
import Rest.ThreadHuman;
import Rest.ThreadHuman_withStack;
import Rest.Tile;
import Rest.Update;
import static Rest.Update.getImgName;
import Round.Round;
import Round.Round_Ola7;
import Round.Round_Ouggriko;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;

/**
 *
 * @author Solon
 */
public class Ola7_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Ola7_Frame
     */
    
    
     private BorderLayout layout;
   private JPanel player1Panel;
   private JPanel player2Panel;
   private JPanel player3Panel;
   private JPanel player4Panel;
   protected JPanel centerPanel;
   private ArrayList<ArrayList<JButton>> playerButtons;
   private static ArrayList<ArrayList<JButton>> extraButtons;
   private JButton draw;
   private JButton pass;
   private DominoLinePanel borrowedDominoPanel;
   private JPanel dominoLinePanel;
   private MessagePanel borrowedMessagePanel;
   private JPanel messagePanel;
   private ArrayList<Player> myPlayers;
   private  Round_Ola7 round;
   private DominoLine_2 myDominoLine;
   private ButtonsListener myButtonsListener;
   private ButtonsListener myButtonsListener2;
   Thread botThread;
   Thread humanThread;
    
    
    public Ola7_Frame(ArrayList<Player> myPlayers) {
        initComponents();
        setSize(900,700);
        layout=new BorderLayout();
        setLayout(layout);
        setLocationRelativeTo(null);
        
        myDominoLine=new DominoLine_2();        //EDO EVALA DOMINOLINE_2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //for(int i=0;i<myPlayers.size();i++)
        //    System.out.println(myPlayers.get(i).getName());
       // PlayerDialog dialog=new PlayerDialog(this);                                 //AAAA
        //myPlayers=dialog.getPlayers();
        this.myPlayers=myPlayers;
        //myPlayers=getPlayers();
        //int numberOfPlayers=myPlayers.size();        ///?????
        
       
        
        round=new Round_Ola7(myPlayers);                //EDO EVALA ROUND_OLA7!!!!!!!!!!!!!!!!!!!!!!!!!!
        
       // round=new Round(getPlayers());
        myPlayers=round.getPlayers();       //gia sosti seira
        int numberOfPlayers=myPlayers.size();
        playerButtons=new ArrayList<>();
        extraButtons=new ArrayList<>();
        
        
        
        for(int i=0;i<numberOfPlayers;i++)      
        {   
            playerButtons.add(new ArrayList<JButton>());
            extraButtons.add(new ArrayList<JButton>());
        }
        player1Panel=new JPanel();
        player1Panel.setPreferredSize(new Dimension(800,100));
        player1Panel.setBackground(Color.LIGHT_GRAY);
        player2Panel=new JPanel();
        player2Panel.setPreferredSize(new Dimension(800,100));
        player2Panel.setBackground(Color.LIGHT_GRAY);
        player1Panel.add(new JLabel(myPlayers.get(0).getName()));         
        player2Panel.add(new JLabel(myPlayers.get(1).getName()));  
        //for(int j=0;j<2;j++)
        int number;
        if(numberOfPlayers==2)
            number=7;
        else
            number=5;
            
            for(int i=0;i<number;i++)
            {
                JButton button=new JButton();
                button.setPreferredSize(new Dimension(35,70));
                playerButtons.get(0).add(button);
               // if(j==0)
                    player1Panel.add(button);
              //  else
                //    player2Panel.add(button);

            }
            for(int j=0;j<12;j++)     
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(35,70));
                    button.setVisible(true);
                    extraButtons.get(0).add(button);
                    player1Panel.add(button);

                }
            
                
            
   
        switch(numberOfPlayers)
        {
            case 2:
                
                add(player1Panel,PAGE_START);
                for(int i=0;i<7;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(35,70));
                    playerButtons.get(1).add(button);
                    player2Panel.add(button);
                }
                for(int j=0;j<12;j++)     
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(35,70));
                    button.setVisible(true);
                    extraButtons.get(1).add(button);
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
                player4Panel.setBackground(Color.LIGHT_GRAY);
                for(int i=0;i<5;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(70,35));
                    playerButtons.get(3).add(button);
                    player4Panel.add(button);
                }
                for(int j=0;j<12;j++)     
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(70,35));
                    button.setVisible(true);
                    extraButtons.get(3).add(button);
                    player4Panel.add(button);

                }
                add(player4Panel,LINE_START);
              //  add(bottomPanel,LINE_END);
            case 3:
                add(player1Panel,PAGE_START);
                for(int i=0;i<5;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(70,35));
                    playerButtons.get(1).add(button);
                    player2Panel.add(button);
                }
                for(int j=0;j<12;j++)     
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(70,35));
                    button.setVisible(true);
                    extraButtons.get(1).add(button);
                    player2Panel.add(button);

                }
                player2Panel.setPreferredSize(new Dimension(100,700));
                add(player2Panel,LINE_END);
                player3Panel=new JPanel();
                player3Panel.add(new JLabel(myPlayers.get(2).getName()));          //allaxe button

                player3Panel.setPreferredSize(new Dimension(800,100));
                player3Panel.setBackground(Color.LIGHT_GRAY);
                for(int i=0;i<5;i++)
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(35,70));
                    playerButtons.get(2).add(button);
                    player3Panel.add(button);
                }
                for(int j=0;j<12;j++)     
                {
                    JButton button=new JButton();
                    button.setPreferredSize(new Dimension(35,70));
                    button.setVisible(true);
                    extraButtons.get(2).add(button);
                    player3Panel.add(button);

                }
                add(player3Panel,PAGE_END);
                break;
                
           
        }
        
       

       
        
        
        
        
        
        
        centerPanel=new JPanel();
        FlowLayout centerLayout=new FlowLayout();
        centerLayout.setAlignment(LEFT);
        centerPanel.setLayout(centerLayout);
        borrowedDominoPanel=new DominoLinePanel();
        dominoLinePanel=borrowedDominoPanel.getPanel();
        dominoLinePanel.setPreferredSize(new Dimension(450,400));
        pass=new JButton("pass");
        pass.setPreferredSize(new Dimension(150,100));
        dominoLinePanel.add(pass);
        draw=new JButton("Draw");
        draw.setPreferredSize(new Dimension(150,100));
        dominoLinePanel.add(draw);
        
        draw.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                StackOfTiles mystack=round.getStack();
               // if(mystack.getSize()==0)
                 Tile tileDrawn=mystack.draw();
                for(int i=0;i<getMyPlayers().size();i++)
                {
                    if(getMyPlayers().get(i) instanceof Human_withStack)
                    {
                        ((Human_withStack) getMyPlayers().get(i)).addToHand(tileDrawn);

                        for(int j=0;j<extraButtons.get(i).size();j++)
                        {
                            if(extraButtons.get(i).get(j).getIcon()==null)
                            {
                                String imgName="Vertical "+tileDrawn.getleft()+""+tileDrawn.getright()+".png";
                                URL url=getClass().getResource("Tiles/"+imgName);
                                ImageIcon icon=new ImageIcon(url);
                                extraButtons.get(i).get(j).setIcon(icon);
                                extraButtons.get(i).get(j).setActionCommand(tileDrawn.getleft()+""+tileDrawn.getright());
                                break;
                            }
                        }
                    }
                }
            }
            
        });
        
        pass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                humanThread.interrupt();
            }
            
        });
        
        
        
        
        
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
        messagePanel.setBackground(Color.yellow);
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
       myButtonsListener2=new ButtonsListener(myPlayers,myDominoLine,borrowedDominoPanel,extraButtons,borrowedMessagePanel,this);

          for(int i=0;i<extraButtons.size();i++)
            {
                for(int j=0;j<extraButtons.get(i).size();j++)
                {
                    extraButtons.get(i).get(j).addActionListener(myButtonsListener2);
                    

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
       putTheIcons();
       setVisible(true);
    }
    
    public void putTheIcons()
        {  
           int numberOfPlayers=myPlayers.size();
        for(int i=0;i<numberOfPlayers;i++)
        {
            Player aPlayer=round.getPlayers().get(i);
            HashSet<Tile> aPlayerHand=aPlayer.getHand();
            int temp=0;
            for(Tile j : aPlayerHand)
            {
                String imgName=Update.getImgName(i, j, numberOfPlayers);
                URL url = getClass().getResource("Tiles/"+imgName);
                ImageIcon icon;
                icon=new ImageIcon(url);

                playerButtons.get(i).get(temp).setIcon(icon);
                playerButtons.get(i).get(temp).setActionCommand(j.getleft()+""+j.getright());
              //  playerButtons.get(i).get(temp).addActionListener(new ButtonsListener());
                temp++;
            }
            
        }
                
        }
       
    
    public ArrayList<Player> getMyPlayers()
    {
        return myPlayers;
    }
    public JFrame getFrame()
    {
        return this;
    }
    public static ArrayList<ArrayList<JButton>> getExtraButtons()
    {
        return extraButtons;
    }
     public void play() throws InterruptedException
    {
        //do{
        AtomicInteger counter=new AtomicInteger();
        counter.set(0);
        //round=new Round(myPlayers);
        do{
            for(int i=0;i<myPlayers.size();i++)
            {
               // try
               // {
                    if(myPlayers.get(i) instanceof Bot)
                    {
                       updateActionListenerBotPlay();
                       Bot_withStack bot=((Bot_withStack) myPlayers.get(i));      //EDO ALLAGI!!!!!111
                       int place=i;
                       botThread=new Thread(new ThreadBot_withStack(this,round,counter,bot,place,myPlayers,playerButtons,extraButtons,borrowedMessagePanel,myDominoLine,borrowedDominoPanel));
                       botThread.start();
                       botThread.join();
                       if(counter.get()>=myPlayers.size())
                         break;
                    }
                    else if(myPlayers.get(i) instanceof Human)
                    {
                        updateActionListenerHumanPlay(i);
                        Human_withStack human=(Human_withStack) myPlayers.get(i);     //EDO ALLAGI!!!!
                        int place=i;
                        humanThread=new Thread(new ThreadHuman_withStack(this,myButtonsListener,myButtonsListener2,round,place,counter,human,myDominoLine,borrowedMessagePanel,playerButtons,extraButtons));
                        humanThread.start();
                        humanThread.join();
                        if(counter.get()>=myPlayers.size())
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
    public void updateActionListenerHumanPlay(int place)
    {
        for(int j=0;j<playerButtons.get(place).size();j++)
        {
           ActionListener[] al=playerButtons.get(place).get(j).getActionListeners();
           for(ActionListener temp : al)
           {
               playerButtons.get(place).get(j).removeActionListener(temp);
           }
           playerButtons.get(place).get(j).addActionListener(myButtonsListener);
           ActionListener[] al2=extraButtons.get(place).get(j).getActionListeners();
           for(ActionListener temp : al2)
           {
               extraButtons.get(place).get(j).removeActionListener(temp);
           }
           extraButtons.get(place).get(j).addActionListener(myButtonsListener2);

        }
    }
    public void updateActionListenerBotPlay()
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
                    for(int j=0;j<extraButtons.get(i2).size();j++)
                    {
                        ActionListener[] al=extraButtons.get(i2).get(j).getActionListeners();
                        for(ActionListener temp : al)
                       {
                           extraButtons.get(i2).get(j).removeActionListener(temp);
                       }
                        extraButtons.get(i2).get(j).addActionListener(new ButtonsListenerNotTurn(borrowedMessagePanel));

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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void playGame(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ola7_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ola7_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ola7_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ola7_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Ola7_Frame myFrame;
               // do
               // {
                  
                 //   PlayerDialog dialog=new PlayerDialog(new Ouggriko_Frame());         //edo!!!!!!
                 //   myFrame=new Ouggriko_Frame(dialog.getPlayers());                    //  allaxes!!!!
                    dispose();
                    myFrame=new Ola7_Frame(myPlayers);      //ayto bgale
                    myFrame.setVisible(true);
                    
                    
               do{
                   try {
                    myFrame.play();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                   if(myFrame.round.gameIsOver()==false)
                   {
                       myFrame.dispose();
                       myFrame=new Ola7_Frame(myFrame.getMyPlayers());
                       myFrame.setVisible(true);
                   }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ouggriko_Frame.class.getName()).log(Level.SEVERE, null, ex);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

