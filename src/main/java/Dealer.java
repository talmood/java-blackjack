import java.util.List;

public class Dealer {
    List<Card> cards;

    public Dealer(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
