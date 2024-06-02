import java.util.ArrayList;
import java.util.List;

public abstract class CardHolder {
    protected List<Card> cards;

    public CardHolder() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void pickCard(CardSet cardSet) {
        Card pickedCard = cardSet.takeCard(cardSet);
        setCard(pickedCard);
    }
    public void setCard(Card pickedCard) {
        if(this.cards == null) this.cards = new ArrayList<>();
        this.cards.add(pickedCard);
    }

}
