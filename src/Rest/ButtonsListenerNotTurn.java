/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Solon
 */
 public class ButtonsListenerNotTurn implements ActionListener
    {
        private MessagePanel borrowedMessagePanel;
        public ButtonsListenerNotTurn(MessagePanel borrowedMessagePanel)
        {
            this.borrowedMessagePanel=borrowedMessagePanel;
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            borrowedMessagePanel.addMessageLabel("Its not your turn!");
        }
        
    }
