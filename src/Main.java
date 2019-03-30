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

        //takes in # of players and creates a list of players that size
        System.out.println("Enter how many players: ");
        int numPlayers = myScan.nextInt();

        for (int i = 0; i < numPlayers; i++){
            players.add(new Player());
        }

        //deals cards and displays results
        dealCards(deck, players);
        printCards(deck, players);

        //takes a card from the deck to be the first card of the playDeck (beginning of game)
        playDeck.add(deck.remove((int) (Math.random()* deck.size())));

        //printing check for deck and playDeck
        System.out.println("DECK: " + deck);
        System.out.println("PLAYDECK: " + playDeck);

        //turn for first player, runs until a valid move is played
        while (!turn(players.get(0), playDeck)){}

        //printing check for playDeck and the hands for all the players.
        System.out.println("PLAYDECK: " + playDeck);
        printCards(deck, players);


    }

    //deals 7 random  cards to each player --> should eventually change the #cards to adjust for #players
    public static void dealCards(List<Card> deckIn, List<Player> playersIn){
        for (int j = 0; j<7; j++)
        {
            for (int i = 0; i < playersIn.size(); i++){
                playersIn.get(i).addCard(deckIn.remove((int) (Math.random()* deckIn.size())));
            }
        }

    }

    //prints out all the cards for all the players
    public static void printCards(List<Card> deckIn, List<Player> playersIn){
        for (Player player: playersIn){
            List<Card> tempHand = player.displayHand();
            System.out.println(tempHand);
        }
    }

    //returns true if the move was valid (checks card validity and whether player has card)
    //also adds played card to playdeck and removes it from the player's hand
    public static boolean turn(Player playerIn, List<Card> playDeckIn){
        //takes in what the user would like to play
        Scanner myScan = new Scanner(System.in);
        System.out.println("What would you like to play? Your cards are: " + playerIn.displayHand());
        String cardChosen = myScan.nextLine();

        //checks if card is valid and acts accordingly
        for (int i = 0; i < playerIn.displayHand().size(); i++){
            if (cardChosen.equalsIgnoreCase(playerIn.displayHand().get(i).toString())){ //checking if card is in hand
                if (isValidMove(playerIn.displayHand().get(i), playDeckIn)){ //checks if card can be played
                    playDeckIn.add(playerIn.displayHand().get(i)); //adds card to playDeck
                    playerIn.playCard(playerIn.displayHand().get(i)); //removes card from player's hand
                    return true;
                }
                else{ //occurs if card is in hand but suit/value does not match
                    System.out.println("Invalid move. This cannot be played.");
                    return false;
                }
            }
        }
        //occurs if card is not in hand at all
        System.out.println("Invalid move. You do not own this card.");
        return false;

    }

    //checks if the card chosen and the last card in the play deck have either a matching value or a matching suit
    //returns true if the card is valid, false if not
    public static boolean isValidMove(Card cardIn, List<Card> playDeckIn){
        if (cardIn.getSuit().equals(playDeckIn.get(playDeckIn.size()-1).getSuit()) || cardIn.getValue().equals(playDeckIn.get(playDeckIn.size()-1).getValue())){
            return true;
        }
        return false;
    }

}
