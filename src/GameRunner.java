//import javax.swing.*;
//import javax.swing.JFrame;
//import java.awt.*;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public abstract class GameRunner extends JFrame implements ActionListener {
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("FrameDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JLabel emptyLabel = new JLabel("");
//        emptyLabel.setPreferredSize(new Dimension(175, 100));
//        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args){
//                Scanner myScan = new Scanner(System.in);
//                List<Card> deck = new ArrayList<Card>();
//                List<Card> playDeck = new ArrayList<Card>();
//                List<Player> players = new ArrayList<Player>();
//
//                //this creates the 52 card deck and prints it out
//                for (Suit st : Suit.values()) {
//                    for (Value val : Value.values()) {
//                        deck.add(new Card(st, val));
//                    }
//                }
//
////        prints out all the cards in the deck
////        for (Card card : deck) {
////                System.out.println(card);
////        }
//
//                //takes in # of players and creates a list of players that size
//                System.out.println("Enter how many players: ");
//                int numPlayers = myScan.nextInt();
//
//                for (int i = 0; i < numPlayers; i++){
//                    players.add(new Player());
//                }
//
//                //deals cards and displays results
//                GamePlay.dealCards(deck, players);
//                GamePlay.printCards(deck, players);
//
//                //takes a card from the deck to be the first card of the playDeck (beginning of game)
//                playDeck.add(deck.remove((int) (Math.random()* deck.size())));
//
//                //printing check for deck and playDeck
//                System.out.println("DECK: " + deck);
//                System.out.println("PLAYDECK: " + playDeck);
//
//                //turn for first player, runs until a valid move is played
//                while (!GamePlay.turn(players.get(0), playDeck, deck)){}
//
//                //printing check for playDeck and the hands for all the players.
//                System.out.println("PLAYDECK: " + playDeck);
//                GamePlay.printCards(deck, players);
//
//
//            }
//
//
//        }
//
//    }
//}
