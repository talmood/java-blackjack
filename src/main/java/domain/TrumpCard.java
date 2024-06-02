package domain;

import domain.validator.ObjectsValidator;

import java.util.Objects;

public class TrumpCard {

    private final TrumpCardRank trumpCardRank;

    private final TrumpCardSuit trumpCardSuit;

    public TrumpCard(TrumpCardRank trumpCardRank, TrumpCardSuit trumpCardSuit) {
        ObjectsValidator.validateNotNull(trumpCardRank, trumpCardSuit);
        this.trumpCardRank = trumpCardRank;
        this.trumpCardSuit = trumpCardSuit;
    }

    public String fetchKoreanName() {
        return this.trumpCardRank.getExpression() + this.trumpCardSuit.getKoreanName();
    }

    public BlackjackPoint fetchMaxBlackjackPoint() {
        return new BlackjackPoint(trumpCardRank.fetchMaxValue());
    }

    public BlackjackPoint fetchMinBlackjackPoint() {
        return new BlackjackPoint(trumpCardRank.fetchMinValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrumpCard trumpCard = (TrumpCard) o;
        return trumpCardRank == trumpCard.trumpCardRank && trumpCardSuit == trumpCard.trumpCardSuit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trumpCardRank, trumpCardSuit);
    }
}
