/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions_package.InvalidTile;

import Exceptions_package.NotAddableTile;
import Rest.Choice;
import Rest.Cmd;
import Rest.DominoLine;
import Rest.DominoLinePanel;
import Rest.MessagePanel;
import Rest.Tile;
import Solo1_package.AvailableTiles;
import Solo1_package.Solo1App;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import static java.awt.FlowLayout.LEFT;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Solon
 */
public class Solo1_Frame extends javax.swing.JFrame {
    
    AvailableTiles myAvailableTiles;
    DominoLine myDominoLine;
    Solo1App mySolo1App;
    ArrayList<ArrayList<JButton>> buttons;
    //ArrayList<JLabel> labels;
  //  ArrayList<JLabel> messageLabels;
    JPanel AvailableTilesPanel;
    JPanel messagePanel;
    JPanel dominoLinePanel;
    DominoLinePanel borrowedDominoPanel;
    MessagePanel borrowedMessagePanel;
    /**
     * Creates new form Solo1_Frame
     */
    public Solo1_Frame() {
        initComponents();
        FlowLayout layout=new FlowLayout();
        layout.setAlignment(LEFT);
        setLayout(layout);
        setSize(935,710);
        getContentPane().setBackground(Color.DARK_GRAY); 
        AvailableTilesPanel = new javax.swing.JPanel();
        AvailableTilesPanel.setPreferredSize(new Dimension(500,400));

        AvailableTilesPanel.setBackground(Color.BLACK);

       // AvailableTilesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Your Tiles"));
        TitledBorder titledBorderAvailableTiles = BorderFactory.createTitledBorder("Your Tiles");
        AvailableTilesPanel.setBorder(titledBorderAvailableTiles);
        titledBorderAvailableTiles.setTitleColor(Color.white);
       
     

        AvailableTilesPanel.setLayout(new java.awt.GridLayout(1, 0));
        
       // MessagePanel = new javax.swing.JPanel();
        borrowedMessagePanel=new MessagePanel(5);
        messagePanel=borrowedMessagePanel.getPanel();
       
       // messagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Messages"));
         TitledBorder titledBorderMessages = BorderFactory.createTitledBorder("Messages");
        messagePanel.setBorder(titledBorderMessages);
        titledBorderMessages.setTitleColor(Color.white);
        messagePanel.setPreferredSize(new Dimension(400,400));
        messagePanel.setBackground(Color.black);
      

     //   MessagePanel.setLayout(new java.awt.GridLayout(5, 1, 10, 10));
   //     MessagePanel.setPreferredSize(new Dimension(400,400));
        //myDominoLinePanel=new DominoLinePanel()
        //myDominoLinePanel.setSize(900, 250);
        borrowedDominoPanel=new DominoLinePanel();
        dominoLinePanel=borrowedDominoPanel.getPanel();
        
        //dominoLinePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Domino Line"));
        TitledBorder titledBorderDominoLine = BorderFactory.createTitledBorder("Domino Line");
        dominoLinePanel.setBorder(titledBorderDominoLine);
        titledBorderDominoLine.setTitleColor(Color.white);
        dominoLinePanel.setBackground(Color.black);

        dominoLinePanel.setPreferredSize(new Dimension(905,250));
       
        //DominoPanel
        add(AvailableTilesPanel);
        
        add(messagePanel);      //edo poio MessagePanel!!!
        add(dominoLinePanel);
        
        //setPrefferedSize(1000,1000);
        setLocationRelativeTo(null);
      //  FlowLayout layout=new FlowLayout();
      //  layout.setAlignment(LEFT);
      //  DominoLinePanel.setLayout(layout);
        ButtonsListener myButtonsListener=new ButtonsListener();
        myAvailableTiles=new AvailableTiles();
        myDominoLine=new DominoLine();
        mySolo1App=new Solo1App();
        buttons=new ArrayList<>();
       // labels=new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            buttons.add(new ArrayList<JButton>());
            
        }
        AvailableTilesPanel.setLayout(new GridLayout(4,7,5,5));
        for(int i=0;i<4;i++)
            for(int j=0;j<7;j++)
            {
                Tile temp=myAvailableTiles.getTile(i, j);
                String left=Integer.toString(temp.getleft());
                String right=Integer.toString(temp.getright());
                //JButton button=new JButton(left+""+right);            //ICON
                JButton button=new JButton();
                button.setBackground(Color.black);
                 Border emptyBorder = BorderFactory.createEmptyBorder();
                 button.setBorder(emptyBorder);
                String imgName="Vertical "+left+""+right+".png";
                //System.out.println(imgName);
                //button.setIcon(icon);
                URL url = getClass().getResource("Tiles/"+imgName);
                ImageIcon icon;
                icon=new ImageIcon(url);
                if(icon!=null)
                    button.setIcon(icon);

                button.setActionCommand(left+""+right);
                button.addActionListener(myButtonsListener);
                buttons.get(i).add(button);
                button.setPreferredSize(new Dimension(50,80));
                AvailableTilesPanel.add(button);
               //
             /*   JLabel label=new JLabel("");
                //label.setSize(30, 60);
                Dimension dimension=new Dimension(80,50);
                label.setPreferredSize(dimension);
               
                label.setBackground(Color.blue);
                label.setOpaque(true);
                labels.add(label);
                DominoLinePanel.add(label); */
               //
            }
          
        
      /*  messageLabels=new ArrayList<>();
        
        for(int i=0;i<5;i++)
        {
            JLabel label=new JLabel();
            messageLabels.add(label);
            MessagePanel.add(label);
        }*/
        //FlowLayout layout=new FlowLayout();
       // layout.setAlignment(LEFT);
       // DominoLinePanel.setLayout(layout);
     //  DominoLinePanel dominoLinePanel=new DominoLinePanel();
     //  DominoPanel=dominoLinePanel.getPanel();
       //(dominoLinePanel.getPanel());
        //add(dominoLinePanel.)
    }
    
    public Frame getFrame()
    {
        return this;
    }
    
   /* public void addMessageLabel(String string)
    {
        if(!messageLabels.get(0).getText().equals(""))          
        {

            for(int i=messageLabels.size()-1;i>0;i--)
            {
                JLabel label;
                label=messageLabels.get(i);
                label.setText(messageLabels.get(i-1).getText());
            }
        }
       JLabel label=messageLabels.get(0);      
       label.setText(string);
    }
    */
           
    
    
    
    public class ButtonsListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            boolean bool;
            String string=ae.getActionCommand();
            int left=Character.getNumericValue(string.charAt(0));
            int right=Character.getNumericValue(string.charAt(1));
            Tile tile=new Tile(left,right);                                                         
            
            try
            {
            //bool=
            mySolo1App.checkTile(tile,myAvailableTiles,myDominoLine);
               // if(bool==true)
            //{
            int place=myDominoLine.whereToAdd(tile);
            if(place==2)
            {
                Choice choice=new Choice(getFrame());
                place=choice.choose();
                
            }
           // else
            //{
                //myDominoLinePanel.putLabel(tile, place);
                //putLabel(tile,place);
                borrowedDominoPanel.putLabel(tile, place);
                myDominoLine.addToDominoLine(tile,place);
            //}
                updateButtons(myAvailableTiles.getLine(tile));
                myAvailableTiles.updateTable(myAvailableTiles.getLine(tile));
           // }
           // else
           // {
                //int temp=myDominoLine.whereToAdd(tile);
                

            //}
            }
            catch(InvalidTile e){
               borrowedMessagePanel.addMessageLabel(e.getMessage());        //tade.addMessageLabel
                
            }
            catch(NotAddableTile e){
               borrowedMessagePanel.addMessageLabel(e.getMessage());
            }
            if(mySolo1App.hasNoTilesToPlay(myAvailableTiles, myDominoLine))
            {
                borrowedMessagePanel.addMessageLabel("Im sorry! You lost");
                for(int i=0;i<4;i++)
                    for(int j=0;j<7;j++)
                    {
                        JButton button=buttons.get(i).get(j);
                        if(button.isEnabled())
                        {
                          //  button.setOpaque(false);
                          //  button.setBackground(Color.red);
                            button.setEnabled(false);
                            //button.setEnabled(false);
                        }
                    }
            }
            else if(myAvailableTiles.hasNoMoreTiles())
            {
               borrowedMessagePanel.addMessageLabel("Congratulations! You won!");
            }
            Cmd cmd=new Cmd();
            cmd.showAvailableTiles(myAvailableTiles);
            cmd.showDominoLine(myDominoLine);
        
    }
    
        public void updateButtons(int line)
        {
            
            int place=myAvailableTiles.getTableTiles().get(line).size()-1;
            JButton button=buttons.get(line).get(place);
            
            button.setVisible(false);
        }
        
     /*   public void putLabel(Tile tile,int place)
        {
            if(place==0)
            {
                putLabelBeginning(tile);
            }
            else if(place==1)
            {
                putLabelEnd(tile);
            }
           // else if(temp==2)
           // {
           //     choose(tile);
           // }
            
        }
        public void putLabelBeginning(Tile tile)
        {
            if(!labels.get(0).getText().equals(""))          ///????
            {
               
                for(int i=labels.size()-1;i>0;i--)
                {
                    JLabel label;
                    label=labels.get(i);
                    label.setText(labels.get(i-1).getText());
                   
                    //labels.get(i).setText(labels.get(i-1).getText());
                }
            }
           JLabel label=labels.get(0);      
           label.setText(tile.getleft()+""+tile.getright());        //icon
                
           
        }
        
        public void putLabelEnd(Tile tile)
        {
            int size=myDominoLine.getrowTiles().size();
            labels.get(size).setText(tile.getleft()+""+tile.getright());        //icon
        }
        */
        
    
    
   
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
        setTitle("Solo1");
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void playGame(){//static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Solo1_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solo1_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solo1_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solo1_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solo1_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
