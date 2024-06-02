import java.util.List;
import java.util.Random;

public class CardSet {
    List<Card> cards;

    public CardSet(List<Card> cards) {
        this.cards = cards;
    }

    public Card takeCard(CardSet cardSet) {
        List<Card> cardSetCards = cardSet.cards;
        int randomIndex = new Random().nextInt(cardSetCards.size());
        Card pickedCard = cardSetCards.get(randomIndex);
        cardSetCards.remove(randomIndex);

        return pickedCard;
    }

}
