/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

/**
 *
 * @author Solon
 */
public class Choice {
    
    private Frame frame;
    private int number;
    public Choice(Frame frame)
    {
        this.frame=frame;
    }
    
    public void setNumber(int x)
    {
        number=x;
    }
    
     public int choose()    
        {
            JDialog dialog=new JDialog(frame,"Choice",true);
            dialog.setSize(200,100);
            dialog.setLocation(1000, 200);
            dialog.getContentPane().setBackground(Color.darkGray);
            FlowLayout layout=new FlowLayout();
            layout.setAlignment(FlowLayout.CENTER);
            dialog.setLayout(layout);
            JRadioButton start=new JRadioButton("Start");
            JRadioButton end=new JRadioButton("End");
            JButton entry=new JButton("Choose");
            entry.setEnabled(false);
            entry.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(start.isSelected())
                    {
                        setNumber(0);
                       // putLabel(tile,0);
                       // myDominoLine.addToDominoLine(tile,0);
                    }
                    else if(end.isSelected())
                    {
                        setNumber(1);
                       // putLabel(tile,1);
                       // myDominoLine.addToDominoLine(tile,1);
                    }
                    dialog.dispose();
                        
                }
                
            });
            ButtonGroup group=new ButtonGroup();
            
            start.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    entry.setEnabled(true);
                }
                
            });
            end.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    entry.setEnabled(true);
                }
                
            });
            
            //entry.setVisible(true);
            group.add(start);
            group.add(end);
            
            
            
            dialog.add(start);
            dialog.add(end);
            dialog.add(entry);

            dialog.setVisible(true);
            return number;
        
            
        }
    
}
