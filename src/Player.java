import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;

    public Player() {
        hand = new ArrayList<Card>();
    }

    public void addCard(Card cardIn){
        hand.add(cardIn);
    }

    // removes specified card and returns # of cards left
    public int removeCard(Card cardIn){
        hand.remove(cardIn);
        return hand.size();
    }


}
