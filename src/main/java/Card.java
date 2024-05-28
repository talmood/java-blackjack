import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    int number;
    Suits suits;

    public Card() {
        this.number = new Random().nextInt(11) + 1;
        this.suits = Suits.getRandomSuits();
    }

    public List<Card> generateCards (int numberOfCards) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(new Card());
        }
        return cards;
    }

}
