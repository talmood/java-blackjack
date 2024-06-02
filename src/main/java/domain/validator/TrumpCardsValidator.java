package domain.validator;

import domain.trumpcard.TrumpCard;

import java.util.HashSet;
import java.util.List;

public abstract class TrumpCardsValidator {

    public static void validate(List<TrumpCard> trumpCards) {
        validateUnique(trumpCards);
    }

    private static void validateUnique(List<TrumpCard> trumpCards) {
        if (!isUnique(trumpCards)) {
            throw new IllegalArgumentException("트럼프 카드들은 모두 달라야 합니다.");
        }
    }

    private static boolean isUnique(List<TrumpCard> trumpCards) {
        return new HashSet<>(trumpCards).size() == trumpCards.size();
    }
}
