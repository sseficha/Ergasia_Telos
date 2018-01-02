    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package Player;
import Exceptions_package.MustChoose;
import Exceptions_package.NotAddableTile;
import Exceptions_package.NothingToPlay;
import Exceptions_package.NothingToPlayBot;
import Exceptions_package.OtherPlayerTile;
    import Rest.Cmd;
    import DominoLine.DominoLine;
    import Rest.Tile;
    import Rest.Shuffler;
    import java.util.ArrayList;
    import java.util.HashSet;
import javax.swing.JPanel;


    /**
     *Η κλαση αναπαριστα ενα παικτη. O παικτης εχει την χερια του (hand) ενα ονομα,μια ιδιοτητα (human
     * or bot) και ενα συνολο ποντων. Η κυριες λειτουργιες της κλασης ειναι η προσθηκη Tile απο τον
     * Player στο DominoLine, με διαφορα αναλογα με την ιδιοτητα του.
     * @author Solon Sefiha,Panos Papastergiou
     */
    abstract public class Player {
        protected HashSet<Tile> hand; 
        protected final String name;
       // private final String property;
        private int totalPoints;

        Player(String name,HashSet<Tile> hand)  
        {
            this.name=name;
         //   this.property=property;
            this.hand=hand;
            totalPoints=0;

        }

        public void setHand(HashSet<Tile> hand)
        {
            this.hand=hand;
        }
        /**
         * Ελεγχει αμα ο παικτης δεν εχει αλλα Tile η ολα τα Tile που εχει δεν μπορουν να μπουν στο
         * DominoLine
         * @param DL
         * @return true αν δεν μπορει να παιξει αλλιως false.
         */
     /*   public boolean pass(DominoLine DL)
        {
            int counter=0;
            if(hand.size()==0)
                return true;
            for(Tile temp : hand)
                if(DL.whereToAdd(temp)==-1)
                    counter++;
            if(counter==hand.size())
                return true;
            else
                return false;

        }*/

        public boolean ownsTile(Tile tile)
        {
            int counter=0;
            for(Tile temp : hand)
            {
                if(tile.equals(temp))
                    return true;
            }
            return false;
        }


        public HashSet<Tile> getHand()
        {
            return hand;
        }

        public String getName()
        {
            return name;
        }
        
        abstract public void add(DominoLine DL,Tile tileToAdd) throws NotAddableTile, NothingToPlayBot, OtherPlayerTile, MustChoose, NothingToPlay;
        
       /**
        * 
        * @param DL
        * @param tileToAdd
        * @param cmd
        * @return true αν εγινε add αλλιως false
        */
     /*   public boolean addHuman(DominoLine DL,Tile tileToAdd,Cmd cmd)
        {

            if(ownsTile(tileToAdd)==false)
            {
                    cmd.errorDoesNotOwnTile(tileToAdd);
                return false;
            }
            else if(DL.whereToAdd(tileToAdd)==-1)
            {
                cmd.errorDoesntFit();
                return false;
            }
            else
            {
                DL.addToDominoLine(tileToAdd,"human",cmd);
                hand.removeIf(tile -> tile.equals(tileToAdd));
                return true;
            }

        }*/
        //Η διαφορα ειναι οτι δεν δεχεται Tile σε αντιθεση με παραπανω αλλα απλα βαζει το πρωτο
        //Tile που βρισκει οτι μπορει να μπει
     /*   public boolean addBot(DominoLine DL,Cmd cmd)
        {
            Tile tileToAdd=getTileForBot(DL);
            if(tileToAdd!=null)
            {
                DL.addToDominoLine(tileToAdd,"bot",cmd);
                hand.remove(tileToAdd);
                return true;
            }
            else
                return false;
        }   */

    /*    public Tile getTileForBot(DominoLine DL)    //Επιστρεφει το πρωτο Tile που μπορει να μπει στο 
                                                    //DominoLine απο το χερι του bot αλλιως γυρναει null
        {
            for(Tile tile : hand)
            {
                if(DL.whereToAdd(tile)!=-1)
                {
                    return tile;
                }
            }
            return null;
        }
*/
      /*  public boolean isHuman()
        {
            if(property.equals("human"))
                return true;
            return false;
        }   */

       /* public boolean isBot()
        {
            if(property.equals("bot"))
                return true;
            return false;
        }   */
        
      //  abstract public boolean playPlayer(DominoLine DL,Cmd cmd);  
        
        /**
         * Αρχικα βλεπει αν μπορει να παιξει ο παικτης μεσω της Pass. Αν μπορει τοτε θα επιμενει
         * να του ζηταει Tile μεχρι να δωσει Tile που μπαινει στο DominoLine.
         * @param DL
         * @param cmd
         * @return true αν επαιξε/μπορουσε να παιξει αλλιως false
         */
      /*  public boolean playPlayerHuman(DominoLine DL,Cmd cmd)
        {
            boolean bool;
            if(pass(DL))
            {
                return false;
            }
            else
            {
                    do
                    {
                        Tile tileToAdd=cmd.selectTile();        //cmd
                        bool=addHuman(DL, tileToAdd,cmd);
                    }
                    while(!bool);
            return true;

            }
        }   */
        
        /**
         * Ιδια νοοτροπια με την πανω. Απλα δεν χρησιμοποιειται η Pass γιατι η addBot
         * κανει απο μονη της search μεσα στο hand για πλακιδια και γυρναει αμα μπορει
         * να παιξει το bot η οχι. Οποτε αν εμπαινε η Pass θα γινοταν 2 φορες η ιδια δουλεια.
         * @param DL
         * @param cmd
         * @return true αν επαιξε/μπορουσε να παιξει αλλιως false
         */
        
     /*   public boolean playPlayerBot(DominoLine DL,Cmd cmd)
        {
            boolean bool;
                cmd.waitForEnter();             //cmd
                if(hand.size()==0)
                {
                    return false;
                } 
                Tile tileToAdd=getTileForBot(DL);
                bool=addBot(DL,tileToAdd,cmd);
                        return bool;
        }   */

      /*  public boolean playPlayer(DominoLine DL,Cmd cmd)  //den xreiazetai
        {
            if(isHuman())
            {
                return(playPlayerHuman(DL,cmd));
            }
            else
            {
                return (playPlayerBot(DL,cmd));
            }

        }   */

        public void addPoints(int points)
        {
            totalPoints+=points;
        }

        public int getPoints()
        {
            return totalPoints;
        }



    }   
