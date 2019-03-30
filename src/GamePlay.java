import java.util.List;
import java.util.Scanner;

public class GamePlay {

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

    public static boolean turn(Player playerIn, List<Card> playDeckIn){
        Scanner myScan = new Scanner(System.in);
        System.out.println("What would you like to play? Your cards are: " + playerIn.displayHand());
        String cardChosen = myScan.nextLine();
        for (int i = 0; i < playerIn.displayHand().size(); i++){
            if (cardChosen.equalsIgnoreCase(playerIn.displayHand().get(i).toString())){ //checking if card is in hand
                if (isValidMove(playerIn.displayHand().get(i), playDeckIn)){
                    playDeckIn.add(playerIn.displayHand().get(i));
                    playerIn.playCard(playerIn.displayHand().get(i));
//                    System.out.println("Card has been removed and added to playdeck");
//                    System.out.println(playDeckIn);
//                    System.out.println(playerIn.displayHand());
                    return true;
                }
                else{
                    System.out.println("Invalid move. This cannot be played.");
                    return false;
                }
            }
        }
        System.out.println("Invalid move. You do not own this card.");
        return false;

    }

    public static boolean isValidMove(Card cardIn, List<Card> playDeckIn){
        if (cardIn.getSuit().equals(playDeckIn.get(playDeckIn.size()-1).getSuit()) || cardIn.getValue().equals(playDeckIn.get(playDeckIn.size()-1).getValue())){
            return true;
        }
        return false;
    }

    public static draw()
}
