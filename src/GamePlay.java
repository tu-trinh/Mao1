import java.util.List;
import java.util.Scanner;

public class GamePlay {
    static Scanner myScan = new Scanner(System.in);

    //deals 7 random  cards to each player, also changes the # of cards to adjust for #players
    public static void dealCards(List<Card> deckIn, List<Player> playersIn){
        int numPlayers = playersIn.size();
        int numToDeal = 0;
        if (numPlayers < 4) {
            numToDeal = 8;
        } else if (numPlayers == 4) {
            numToDeal = 7;
        } else if (numPlayers == 5) {
            numToDeal = 6;
        } else if (numPlayers >= 6) {
            numToDeal = 5;
        }
        for (int j = 0; j < numToDeal; j++)
        {
            for (int i = 0; i < numPlayers; i++){
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
    public static boolean turn(Player playerIn, List<Player> playersIn, List<Card> playDeckIn, List<Card> deckIn){
        //takes in what the user would like to play
        System.out.println("What would you like to play? Your cards are: " + playerIn.displayHand());
        String cardChosen = myScan.nextLine();
        String declaration = "";

        if (cardChosen.equalsIgnoreCase("PENALTY")){
            castPenalty(deckIn, playersIn);
            System.out.println("What would you like to play? Your cards are: " + playerIn.displayHand());
            String cardChosen2 = myScan.nextLine();
            cardChosen = cardChosen2;
            if (cardChosen.equalsIgnoreCase("DRAW")){
                draw(playerIn, deckIn);
                System.out.println(playerIn.getName() + " has drawn one card. \n");
                return true;
            }
        }

        if (cardChosen.equalsIgnoreCase("DRAW")){
            draw(playerIn, deckIn);
            System.out.println(playerIn.getName() + " has drawn a card from the deck. \n");
            return true;
        }

        //checks if card is valid and acts accordingly
        for (int i = 0; i < playerIn.displayHand().size(); i++){
            if (cardChosen.equalsIgnoreCase(playerIn.displayHand().get(i).toString())){ //checking if card is in hand
                if (isValidMove(playerIn.displayHand().get(i), playDeckIn)){//checks if card can be played
                    // prompts player to say something
                    System.out.println("Do you have anything to declare?");
                    declaration = myScan.nextLine();

                    playDeckIn.add(playerIn.displayHand().get(i)); //adds card to playDeck
                    playerIn.playCard(playerIn.displayHand().get(i));//removes card from player's hand
                    // penalizes for forgetting to say mao with one card
                    if (playerIn.displayHand().size() == 1 && !declaration.equalsIgnoreCase("mao")) {
                        System.out.println("You've failed to say \"mao.\" You've incurred a one card penalty. \n");
                        penalty(playerIn, deckIn);
                        return false;
                    }
                    // prompts player to say something and displays for all to see
//                    System.out.println("Say something?");
//                    String answer = myScan.nextLine();
//                    if (answer.equalsIgnoreCase("No")) {
//                        System.out.println(playerIn + " has nothing to say.");
//                    } else {
//                        System.out.println(playerIn + " says " + answer + ".");
//                    }
                    System.out.println(playerIn.getName() + " has played the " + cardChosen +  ".\n");
                    return true;
                }
                else{//occurs if card is in hand but suit/value does not match
                    System.out.println("Invalid move. This cannot be played. You've incurred a one card penalty. \n");
                    penalty(playerIn, deckIn);
                    return false;
                }
            }
        }
        //occurs if card is not in hand at all
        System.out.println("Invalid move. You do not own this card. You've incurred a one card penalty. \n");
        penalty(playerIn, deckIn);
        return false;
    }

    // computer's turn to play
    public static boolean compTurn(Player playerIn, List<Card> playDeckIn, List<Card> deckIn) {
        // computer either plays a valid card or draws
        int cardIndex = 0;
        for (int i = 0; i < deckIn.size(); i++) {
            boolean valid = isValidMove(deckIn.get(i), playDeckIn);
            if (valid) {
                cardIndex = i;
                break;
            } else if (i == deckIn.size() - 1) {
                draw(playerIn, deckIn);
                System.out.println(playerIn.getName() + " has drawn one card from the deck. \n");
            }
        }
        playerIn.playCard(playerIn.displayHand().get(cardIndex));
        System.out.println(playerIn.getName() + " has played the " + deckIn.get(cardIndex) + ".");
        // computer can declare Mao
        if (deckIn.size() == 1) {
            System.out.println("Mao.");
        }
        return true;
    }

    //checks if the card chosen and the last card in the play deck have either a matching value or a matching suit
    //returns true if the card is valid, false if not
    public static boolean isValidMove(Card cardIn, List<Card> playDeckIn){
        if (cardIn.getSuit().equals(playDeckIn.get(playDeckIn.size()-1).getSuit()) || cardIn.getValue().equals(playDeckIn.get(playDeckIn.size()-1).getValue())){
            return true;
        }
        return false;
    }

    //takes a random card from the Deck and adds it to the player's hand
    public static void draw(Player playerIn, List<Card> deckIn){
        playerIn.addCard(deckIn.remove((int) (Math.random()* deckIn.size())));
        // prompts player to say something and displays for all to see
//        System.out.println("Say something?");
//        String answer = myScan.nextLine();
//        if (answer.equalsIgnoreCase("No")) {
//            System.out.println(playerIn + " has nothing to say.");
//        } else {
//            System.out.println(playerIn + " says " + answer + ".");
//        }
    }

    public static void penalty(Player playerIn, List<Card> deckIn){
        playerIn.addCard(deckIn.remove((int) (Math.random()* deckIn.size())));
    }

    public static void castPenalty(List<Card> deckIn, List<Player> playersIn){
        System.out.println("Who should be penalized?");
        String player = myScan.nextLine();
        System.out.println("What is the cause of the penalty?");
        String reason = myScan.nextLine();
        for (int i = 0; i < playersIn.size(); i++){
            if (player.equalsIgnoreCase(playersIn.get(i).getName())){
                playersIn.get(i).addCard(deckIn.remove((int) (Math.random()* deckIn.size())));
                System.out.println(playersIn.get(i).getName() + " has incurred a one card penalty for " + reason);
            }
        }
    }
}
