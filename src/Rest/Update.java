/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Solon
 */
public class Update {
    
    
    
    public static String getImgName(int i,Tile j,int numberOfPlayers)
    {
         String imgName=null;
         
                if(i==0)
                {
                    imgName="Vertical "+j.getleft()+""+j.getright()+".png";
                }
                else if(i==1 && numberOfPlayers==2)
                {
                    imgName="Vertical "+j.getleft()+""+j.getright()+".png";
                }
                else if(i==1 && numberOfPlayers>2)
                {
                   imgName="Horizontal "+j.getleft()+""+j.getright()+".png";

                }
                else if(i==2)
                {
                    imgName="Vertical "+j.getleft()+""+j.getright()+".png";
                }
                else if(i==3)
                {
                    imgName="Horizontal "+j.getleft()+""+j.getright()+".png";

                }
                return imgName;
    }
    
}
