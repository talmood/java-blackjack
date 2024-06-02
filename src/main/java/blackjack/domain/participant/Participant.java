package blackjack.domain.participant;

import blackjack.domain.card.CardDeck;
import blackjack.domain.card.Cards;

import java.util.ArrayList;

public abstract class Participant {
    protected Name name;
    protected Cards cards;

    protected Participant(final Name name) {
        this.name = name;
        this.cards = Cards.of(new ArrayList<>());
    }

    public void drawInitialCards(final CardDeck cardDeck) {
        cardDeck.drawInitialCards().forEach(cards::add);
    }

    public void drawCard(final CardDeck cardDeck) {
        cards.add(cardDeck.draw());
    }

    public boolean isBlackjack() {
        return cards.isBlackjack();
    }

    public boolean isBust() {
        return cards.calculateScore() > 21;
    }

    public int calculateScore() {
        return cards.calculateScore();
    }
    public abstract boolean canDrawCard();

    public String getName() {
        return name.getName();
    }

    public Cards getCards() {
        return cards;
    }
}
