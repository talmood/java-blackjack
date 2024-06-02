import java.util.ArrayList;
import java.util.List;

public class Card {

    Denomination number;
    Suit suit;

    public Card() {
    }

    public Card(Denomination number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public List<Card> generateCardSet () {
        List<Card> cards = new ArrayList<>();
        for (Denomination denomination : Denomination.values()) {
            for (Suit suit : Suit.values()){
                cards.add(new Card(denomination,suit));
            }
        }
        return cards;
    }
}
