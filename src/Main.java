import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        List<Card> deck = new ArrayList<Card>();
        List<Card> playDeck = new ArrayList<Card>();
        List<Player> players = new ArrayList<Player>();

        //this creates the 52 card deck and prints it out
        for (Suit st : Suit.values()) {
            for (Value val : Value.values()) {
                deck.add(new Card(st, val));
            }
        }
//        prints out all the cards in the deck
//        for (Card card : deck) {
//                System.out.println(card);
//        }
        System.out.println("Enter how many players: ");
        int numPlayers = myScan.nextInt();

        for (int i = 0; i < numPlayers; i++){
            players.add(new Player());
        }

        GamePlay.dealCards(deck, players);
        GamePlay.printCards(deck, players);

        playDeck.add(deck.remove((int) (Math.random()* deck.size())));

        System.out.println("DECK: " + deck);
        System.out.println("PLAYDECK: " + playDeck);

        while (!GamePlay.turn(players.get(0), playDeck)){}

        System.out.println("PLAYDECK: " + playDeck);
        GamePlay.printCards(deck, players);


    }


}
