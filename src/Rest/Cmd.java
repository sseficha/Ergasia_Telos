/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Ougriko_package.Player;
import Ougriko_package.Round;
import Solo1_package.AvailableTiles;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Υλοποιει ενα ειδος Interface μεσω του command line (cmd). Γενικα οσες κλασεις και 
 * ως αποτελεσμα συναρτησεις απαιτησουν ενα ειδος input η output το cmd θα περνιεται σαν παραμετρος
 * ωστε να επιτευχθει αυτο. Αν αργοτερα αλλαξει το Interface θα περνιεται ενα αλλο ειδος 
 * Interface ως παραμετρος (θα γινει με κληρονομικοτητα)
 * @author Solon Sefiha,Panos Papastergiou
 */
public class Cmd {
    Scanner input;
    public Cmd()
    {
        input=new Scanner(System.in);
    }
    public void showTile(Tile x)
    {
        System.out.print(x.getleft()+":"+x.getright());
    }
    
    public void showAvailableTiles(AvailableTiles AT)
    {
        ArrayList<ArrayList<Tile>> tableTiles=AT.getTableTiles();
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<tableTiles.get(i).size();j++)
            {
                showTile(tableTiles.get(i).get(j));
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }   
    
    public Tile selectTile()
    {
         boolean boolleft;
         boolean boolright;
         int left=-1;
         int right=-1;
        
        do
        {
            do
            {
                System.out.print("Dose ena Tile: ");
                boolleft=input.hasNextInt();
                if(boolleft!=false)
                    left=input.nextInt();
                boolright=input.hasNextInt();
                if(boolright!=false)
                    right=input.nextInt();
                if(boolleft==false || boolright==false)
                {
                    
                    input.nextLine();
                    System.out.println("Wrong input! Dose arithmous xorismenous me keno! ");
                }
            }
            while(boolleft==false || boolright==false);
            
            if(left>=0 && left<=6 && right>=0 && right<=6)
            {
                Tile tempTile=new Tile(left,right);
                input.nextLine();
                return tempTile;
            }
            else
                System.out.println("Wrong input! Dose arithmous 0-6 xorismenous me keno!");
        }
        while(true);
        
    }   

    
    public void showDominoLine(DominoLine DL)//ArrayList<Tile> dominoline
    {
        ArrayList<Tile> dominoline=DL.getrowTiles();
        System.out.print("I seira domino paei os exis: ");
        for(int i=0;i<dominoline.size();i++)
        {
            showTile(dominoline.get(i));
            if(i<dominoline.size()-1)
                System.out.print("-");
        }
        System.out.println("");
        System.out.println("");
        //System.out.println(dominoline.size()); ///!!!!!!!!!!!!!!!!!!!!!!
    }   
    public static String getChoice()
    {
        String answer;
        Scanner input2=new Scanner(System.in);
        System.out.print("Epelexe na bei stin arxi i sto telos: ");
        answer=input2.next();
        return answer;
        
    }
    
    public void showResult(boolean bool)
    {
        if(bool==true)
        {
            System.out.println("YOU WON");
        }
        else
            System.out.println("YOU LOST");
    }
    public void errorLastColumn()
    {
        System.out.println("Epelexe apo tous teleftaious arithmous anagastika!");
    }
    
    public void errorDoesntFit()
    {
        System.out.println("!Den bainei to plakidio pou epelexes stin seira Domino!");
    }
    
    public void errorChoice()
    {
        System.out.println("!Dose tin lexi arxi i tin lexi telos!");
    }
    
    public void errorDoesNotOwnTile(Tile x)
    {
        System.out.print("!Den diatheteis to tile ");
        showTile(x);
        System.out.print(" sta xeria sou!");
        System.out.println("");
    }
    public int getNofPlayers()
    {
        do
        {   
            System.out.print("Posoi paiktes tha simmetexoun sto paixnidi: ");
            boolean bool=input.hasNextInt();
            System.out.println("");
            if(bool==true)
            {
                int answer=input.nextInt();
                if(answer>0 && answer<=4)
                    return answer;
                else
                {
                    System.out.println("!Dose ena valid arithmo paikton (1-4)!");
                    input.nextLine();
                }
            }
            else
            {
                System.out.println("!Dose arithmo!");
                input.nextLine();
            }
        }
        while(true);
          
    }
    
    public String getHumanName()
    {
        input.nextLine();
        System.out.print("Dose to onoma sou: ");
        String answer;
        answer=input.nextLine();
       // name.append(answer);        //Dexetai mono to 1o meros!!!
        //input.nextLine();
        System.out.println("");
        return answer;
    }
    public String getBotName()
    {
        System.out.print("Dose to onoma tou bot: ");
        String answer;
        answer=input.nextLine();
        System.out.println("");
        return answer;
    }
    
    public void nothingToPlay(Player player)
    {
        System.out.println("O "+player.getName()+" den exei kati na paixei");
        System.out.println("");
    }
    
    public void nothingElseToPlay(Player player)
    {
        System.out.println("O "+player.getName()+" teliose na vazei plakidia");
        System.out.println("");
    }
    
    
    public void showPlayerTiles(Player player)
    {
        System.out.println("Ta plakidia tou paikti "+player.getName()+" einai ta exis:");
        for(Tile tile : player.getHand())
        {
            showTile(tile);
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void waitForEnter()
    {
        System.out.print("(Pata Enter gia sinexeia)");
        input.nextLine();
        System.out.println("");
    }
    
    public void hasNoMoreTiles(Player player)
    {
        System.out.println("O paiktis "+player.getName()+" den exei alla plakidia");
        System.out.println("");
        
    }
    
    public void showPlayerPoints(Round round)
    {
        System.out.println("Oi pontoi pane os exis:");
        System.out.println("");
        for(Player player : round.getPlayers())
            System.out.println(player.getName()+": "+player.getPoints());
        System.out.println("");
    }
    
    public void endOfRound()
    {
        System.out.println("TELOS GIROU!");
        System.out.println("");
    }
    
    public void showWinner(ArrayList<String> winner)
    {
        for(int i=0;i<winner.size();i++)
            System.out.println("NIKITIS O: "+winner.get(i));
    }
    
    public void newRound()
    {
        System.out.println("NEOS GIROS!");
        System.out.println("");
    }
}

