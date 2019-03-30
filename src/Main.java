import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        List<Card> deck = new ArrayList<Card>();
        List<Player> players = new ArrayList<Player>();

        //this creates the 52 card deck and prints it out
        for (Suit st : Suit.values()) {
            for (Value val : Value.values()) {
                deck.add(new Card(st, val));
            }
        }
        for (Card card : deck) {
                System.out.println(card);
        }
        System.out.println("Enter how many players: ");
        int numPlayers = myScan.nextInt();

        for (int i = 0; i < numPlayers; i++){
            players.add(new Player());
        }

        dealCards(deck, players);
        printCards(deck, players);
        System.out.println(deck);
    }

    public static void dealCards(List<Card> deckIn, List<Player> playersIn){
        for (int j = 0; j<7; j++)
        {
            for (int i = 0; i < playersIn.size(); i++){
                playersIn.get(i).addCard(deckIn.remove((int) (Math.random()* deckIn.size())));
            }
        }

    }

    public static void printCards(List<Card> deckIn, List<Player> playersIn){
        for (Player player: playersIn){
            List<Card> tempHand = player.displayHand();
            System.out.println(tempHand);
        }
    }

}
