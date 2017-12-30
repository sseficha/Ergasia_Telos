/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Solo1_package.Solo1App;
import Ougriko_package.OuggrikoApp;
import java.util.Scanner;

/**
 *
 * @author Solon
 */
public class PlayGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner=new Scanner(System.in);
        String answer;
        do
        {
            System.out.print("Poio paixnidi thes na paixeis: ");
            answer=scanner.next();
            System.out.println("");
            if(!answer.equals("Solo1") && !answer.equals("Ouggriko"))
            {
                System.out.println("!Oi epiloges sou einai: Solo1 kai Ouggriko!");
                scanner.nextLine();
            }
        }
        while(!answer.equals("Solo1") && !answer.equals("Ouggriko"));
        if(answer.equals("Solo1"))
        {
            Solo1App app=new Solo1App();
            app.playSolo1();
        }
        else if(answer.equals("Ouggriko"))
        {
            OuggrikoApp app=new OuggrikoApp();
            app.playOuggriko();
        }
    }
    
}
