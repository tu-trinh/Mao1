public class Main {
    public static void main(String[] args) {
        Card[][] deck = new Card[4][13];
        int i = 0;
        int j = 0;
        for (Suit st : Suit.values()) {
            j = 0;
            for (Value val : Value.values()) {
                deck[i][j++] = new Card(st, val);
            }
            i++;
        }
        for (Card[] row : deck) {
            for (Card card : row) {
                System.out.println(card);
            }
        }
    }
}