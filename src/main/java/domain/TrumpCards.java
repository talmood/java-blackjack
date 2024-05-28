package domain;

import domain.validator.TrumpCardsValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TrumpCards {

    private final List<TrumpCard> trumpCards;

    public TrumpCards(List<TrumpCard> trumpCards) {
        TrumpCardsValidator.validate(trumpCards);
        this.trumpCards = trumpCards;
    }

    public TrumpCards(TrumpCards trumpCards) {
        this.trumpCards = trumpCards.getCards();
    }

    public static TrumpCards createAll() {
        return new TrumpCards(
                Arrays.stream(TrumpCardRank.values())
                        .flatMap(rank -> Arrays.stream(TrumpCardSuit.values())
                                .map(suit -> new TrumpCard(rank, suit))
                        ).collect(Collectors.toList())
        );
    }

    public static TrumpCards createEmptyCards() {
        return new TrumpCards(
                Collections.emptyList()
        );
    }

    public TrumpCards shuffle() {
        Collections.shuffle(this.trumpCards);

        return new TrumpCards(List.copyOf(this.trumpCards));
    }

    public TrumpCard fetchTopOne() {
        this.validateHasCard();

        return this.trumpCards.get(0);
    }

    public TrumpCards takeOutTopOne() {
        this.validateHasCard();

        return new TrumpCards(this.trumpCards.subList(1, this.size()));
    }

    private void validateHasCard() {
        if (this.trumpCards.size() == 0) {
            throw new IllegalStateException("카드가 없습니다.");
        }
    }

    public TrumpCards addCard(TrumpCard trumpCard) {
        ArrayList<TrumpCard> trumpCards = new ArrayList<>(this.trumpCards);
        trumpCards.add(trumpCard);

        return new TrumpCards(Collections.unmodifiableList(trumpCards));
    }

    public BlackjackPoint totalMaxBlackjackPoint() {
        return this.trumpCards.stream()
                .map(TrumpCard::fetchMaxBlackjackPoint)
                .reduce(new BlackjackPoint(0), BlackjackPoint::sum);
    }

    public BlackjackPoint totalMinBlackjackPoint() {
        return this.trumpCards.stream()
                .map(TrumpCard::fetchMinBlackjackPoint)
                .reduce(new BlackjackPoint(0), BlackjackPoint::sum);
    }

    public List<TrumpCard> getCards() {
        return List.copyOf(this.trumpCards);
    }

    public int size() {
        return this.trumpCards.size();
    }

    public List<String> fetchKoreanNames() {
        return this.trumpCards.stream()
                .map(TrumpCard::fetchKoreanName)
                .collect(Collectors.toList());
    }
}
