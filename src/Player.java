import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private String name;
    private static int playerNum = 1;

    public Player() {
        hand = new ArrayList<Card>();
        name = "Player " + playerNum++;
    }

    public String toString() {
        return name;
    }

    public void addCard(Card cardIn){
        hand.add(cardIn);
    }

    // removes specified card and returns # of cards left
    public int playCard(Card cardIn){
        hand.remove(cardIn);
        return hand.size();
    }

    public List<Card> displayHand(){
        return hand;
    }
}
