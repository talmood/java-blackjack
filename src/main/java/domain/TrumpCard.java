package domain;

import java.util.Objects;

public class TrumpCard {

    private final TrumpCardRank trumpCardRank;

    private final TrumpCardSuit trumpCardSuit;

    public TrumpCard(TrumpCardRank trumpCardRank, TrumpCardSuit trumpCardSuit) {
        this.trumpCardRank = trumpCardRank;
        this.trumpCardSuit = trumpCardSuit;
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
