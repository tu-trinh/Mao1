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

        dealCards(deck, players);
        printCards(deck, players);

        playDeck.add(deck.remove((int) (Math.random()* deck.size())));

        System.out.println("DECK: " + deck);
        System.out.println("PLAYDECK: " + playDeck);

        turn(players.get(0), playDeck);
        System.out.println("PLAYDECK: " + playDeck);
        printCards(deck, players);


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

    public static void turn(Player playerIn, List<Card> playDeckIn){
        Scanner myScan = new Scanner(System.in);
        System.out.println("What would you like to play? Your cards are: " + playerIn.displayHand());
        String cardChosen = myScan.nextLine();
        for (int i = 0; i < playerIn.displayHand().size(); i++){
            if (cardChosen.equalsIgnoreCase(playerIn.displayHand().get(i).toString())){ //checking if card is in hand
                if (isValidMove(playerIn.displayHand().get(i), playDeckIn)){
                    playDeckIn.add(playerIn.displayHand().get(i));
                    playerIn.playCard(playerIn.displayHand().get(i));
                    return;
                }
                else{
                    System.out.println("Invalid move. This cannot be played.");
                    turn(playerIn, playDeckIn);
                }
            }
        }
        System.out.println("Invalid move. You do not own this card.");
        turn(playerIn, playDeckIn);

    }

    public static boolean isValidMove(Card cardIn, List<Card> playDeckIn){
        if (cardIn.getSuit().equals(playDeckIn.get(playDeckIn.size()-1).getSuit()) || cardIn.getValue().equals(playDeckIn.get(playDeckIn.size()-1).getValue())){
            return true;
        }
        return false;
    }

}
