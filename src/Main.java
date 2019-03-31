import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Mao mao = new Mao();
//        mao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JLabel emptyLabel = new JLabel("");
//       emptyLabel.setPreferredSize(new Dimension(175, 100));
//        mao.setVisible(true);
        boolean playGame = true;
        while (play(playGame)) {
        }
        System.out.println("Thank you for playing!");


    }

    public static boolean play(boolean playIn) {
        Scanner myScan = new Scanner(System.in);
        List<Card> deck = new ArrayList<Card>();
        List<Card> playDeck = new ArrayList<Card>();
        List<Player> players = new ArrayList<Player>();
        boolean won = false;

        //this creates the 52 card deck and prints it out
        for (Suit st : Suit.values()) {
            for (Value val : Value.values()) {
                deck.add(new Card(st, val));
            }
        }



        //takes in # of players and creates a list of players that size
        System.out.println("Enter how many players: ");
        int numPlayers = myScan.nextInt();

        for (int i = 0; i < numPlayers; i++) {
            //players.add(new Player());
            System.out.println("Player " + (i + 1) + ", what's your name?");
            String nextName = myScan.next();
            players.add(new Player(nextName));
        }

        //deals cards and displays results
        GamePlay.dealCards(deck, players);
        GamePlay.printCards(deck, players);

        //takes a card from the deck to be the first card of the playDeck (beginning of game)
        playDeck.add(deck.remove((int) (Math.random() * deck.size())));

        //printing check for deck and playDeck
//        System.out.println("DECK: " + deck);
        System.out.println("PLAYDECK: " + playDeck);

        while (!won) {
            for (int i = 0; i < players.size(); i++) {
                System.out.println("This is " + players.get(i).getName() + "'s turn.");
                System.out.println("PLAYDECK: " + playDeck.get(playDeck.size() - 1));
                GamePlay.turn(players.get(i), players, playDeck, deck);
                if (players.get(i).getSize() == 0) {
                    won = true;
                    System.out.println(players.get(i).getName() + " won!");
                    System.out.println("Would you like to play again?");
                    String playAgain = myScan.next();
                    if (playAgain.equalsIgnoreCase("yes")) {
                        playIn = true;
                    } else {
                        playIn = false;
                    }
                    return playIn;
                }
                if (deck.size() == 0) {
                    for (int j = 0; j < playDeck.size() - 1; j++) {
                        deck.add(playDeck.remove(j));
                    }
                    System.out.println("Deck has been refilled with playdeck stack.");
                }
            }

        }
        return false;
    }
}


