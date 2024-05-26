package domain;

import domain.validator.TrumpCardValidator;

import java.util.Objects;

public class TrumpCard {

    private final TrumpCardRank trumpCardRank;

    private final TrumpCardSuit trumpCardSuit;

    public TrumpCard(TrumpCardRank trumpCardRank, TrumpCardSuit trumpCardSuit) {
        TrumpCardValidator.validate(trumpCardRank, trumpCardSuit);
        this.trumpCardRank = trumpCardRank;
        this.trumpCardSuit = trumpCardSuit;
    }

    public String fetchKoreanName() {
        return this.trumpCardRank.getExpression() + this.trumpCardSuit.getKoreanName();
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
