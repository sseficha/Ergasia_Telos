
package Rest;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Solon
 */

public class MessagePanel {
    JPanel messagePanel;
    ArrayList<JLabel> messageLabels;
    int size;
    
    public MessagePanel(int nofMessages)
    {
       
        size=nofMessages;
        messagePanel = new javax.swing.JPanel();
        messagePanel.setLayout(new java.awt.GridLayout(size, 1, 10, 10));
        messageLabels=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            JLabel label=new JLabel();
            label.setForeground(Color.white);
            
            messageLabels.add(label);
            messagePanel.add(label);
        }
        
    }
    public JPanel getPanel()
    {
        return messagePanel;
    }
    
    public void addMessageLabel(String string)
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
}
