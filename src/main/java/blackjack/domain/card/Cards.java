package blackjack.domain.card;

import java.util.List;

public class Cards {
    private final List<Card> cards;

    private Cards(final List<Card> cards) {
        this.cards = cards;
    }

    public static Cards of(final List<Card> cards) {
        return new Cards(cards);
    }

    public void add(final Card card) {
        cards.add(card);
    }

    public List<String> showCardsInfo() {
        return cards.stream()
                .map(Card::showCardInfo)
                .toList();
    }

    public boolean isBlackjack() {
        return calculateScore() == 21 && cards.size() == 2;
    }

    public int calculateScore() {

        int totalScore = cards.stream()
                .mapToInt(card -> card.getRank().getScore())
                .sum();

        int aceCount = (int) cards.stream()
                .map(Card::getRank)
                .filter(Rank.ACE::equals)
                .count();

        return calculateAceScore(totalScore, aceCount);
    }

    private int calculateAceScore(final int totalScore, int aceCount) {
        int score = totalScore;

        while (aceCount > 0 && score + 10 <= 21) {
            score += 10;
            aceCount--;
        }

        return score;
    }
}
