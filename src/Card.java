enum Suit {
    HEARTS,
    DIAMONDS,
    SPADES,
    CLUBS
}

enum Value {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suitIn, Value valueIn) {
        suit = suitIn;
        value = valueIn;
    }

    public String toString() {
        return value + " of " + suit;
    }

    public Suit getSuit() {
        return suit;
    }
    public Value getValue() {
        return value;
    }
}
