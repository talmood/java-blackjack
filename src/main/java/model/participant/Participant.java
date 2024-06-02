package model.participant;

import model.CardScore;
import model.card.Card;
import model.card.CardHand;

import java.util.List;

public class Participant {

    protected final CardHand hand;

    protected Participant(CardHand hand) {
        this.hand = hand;
    }

    public boolean isBust() {
        return this.hand.isBust();
    }

    public CardScore calculateScore() {
        return this.hand.calculateScore();
    }

    protected void addHand(final Card card) {
        this.hand.addCards(List.of(card));
    }

    public CardHand getHand() {
        return hand;
    }

}
