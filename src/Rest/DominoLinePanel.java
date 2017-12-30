/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Solon
 */
public class DominoLinePanel {
    
    private JPanel dominoLinePanel;
    private ArrayList<JLabel> labels;        //ALLAXE    
    public DominoLinePanel()
    {
        dominoLinePanel=new JPanel();  
        FlowLayout layout=new FlowLayout();
        layout.setAlignment(LEFT);
        dominoLinePanel.setLayout(layout);
        labels=new ArrayList<>();
        dominoLinePanel=new JPanel();
        for(int i=0;i<24;i++)
            //for(int j=0;j<7;j++)
            {
                JLabel label=new JLabel("");
                Dimension dimension=new Dimension(80,50);
                label.setPreferredSize(dimension);
                label.setBackground(Color.blue);
                label.setOpaque(true);
                labels.add(label);
                dominoLinePanel.add(label);
               //
            }
        //messageLabels=new ArrayList<>();
        
       
        //FlowLayout layout=new FlowLayout();
       // layout.setAlignment(LEFT);
       // DominoLinePanel.setLayout(layout);
        
    }
   
    public JPanel getPanel()
    {
        return dominoLinePanel;
    }
    public void putLabel(Tile tile,int place)
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
          //  if(!labels.get(0).getText().equals(""))          ///ICONNN
            if(labels.get(0).getIcon()!=null)
            {
               
                for(int i=labels.size()-1;i>0;i--)
                {
                    JLabel label;
                    label=labels.get(i);
                    label.setIcon(labels.get(i-1).getIcon());
                   
                    labels.get(i).setIcon(labels.get(i-1).getIcon());
                }
            }
           JLabel label=labels.get(0);      
           //label.setText(tile.getleft()+""+tile.getright());        //icon
           String imgName="Horizontal "+tile.getleft()+""+tile.getright()+".png";
           URL url = getClass().getResource("Tiles/"+imgName);
           ImageIcon icon;
           icon=new ImageIcon(url);
           if(icon!=null)
                label.setIcon(icon);
           
        }
        
        public void putLabelEnd(Tile tile)
        {
            //int size=myDominoLine.getrowTiles().size();
            int size=0;
            for(int i=0;i<24;i++)
            {
                //if(labels.get(i).getText()!="")   //META ICON!!!!!!!!!!!!1
                if(labels.get(i).getIcon()!=null)
                    size++;
                else
                    break;
            }
           String imgName="Horizontal "+tile.getleft()+""+tile.getright()+".png";
           URL url = getClass().getResource("Tiles/"+imgName);
           ImageIcon icon;
           icon=new ImageIcon(url);
           labels.get(size).setIcon(icon);        //icon
        }
        
        public void updateDominoLine(DominoLine dominoLine)
        {
            for(int i=0;i<dominoLine.getrowTiles().size();i++)                //1
                {
                    String string2="Horizontal "+dominoLine.getrowTiles().get(i).getleft()+""+dominoLine.getrowTiles().get(i).getright()+".png";
                    URL url = getClass().getResource("Tiles/"+string2);
                    ImageIcon ico = new ImageIcon(url);
                    labels.get(i).setIcon(ico);
                }
        }
}
    

