import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
    }



    }
