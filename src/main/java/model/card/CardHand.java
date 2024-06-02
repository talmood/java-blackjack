package model.card;

import model.CardScore;

import java.util.ArrayList;
import java.util.List;

public class CardHand {

    private static final int BUST_SCORE = 21;

    private final List<Card> cards;

    public CardHand(List<Card> cards) {
        this.cards = cards;
    }

    public static CardHand emptyOf() {
        return new CardHand(new ArrayList<>());
    }

    public void addCards(final List<Card> toAdd) {
        this.cards.addAll(toAdd);
    }

    public boolean isBust() {
        return calculateScore().exceeds(BUST_SCORE);
    }

    public CardScore calculateScore() {
        final int scoreSum = getScoreSum();

        if (scoreSum > BUST_SCORE && containsAce()) {
            return new CardScore(scoreSum - 10);
        }

        return new CardScore(scoreSum);
    }

    private boolean containsAce() {
        return this.cards.stream().anyMatch(Card::isAce);
    }

    private int getScoreSum() {
        return this.cards.stream()
                .map(Card::getScore)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Card> getCards() {
        return List.copyOf(this.cards);
    }

}
