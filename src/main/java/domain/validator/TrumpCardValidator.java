package domain.validator;

import domain.TrumpCardRank;
import domain.TrumpCardSuit;

import java.util.Objects;

public abstract class TrumpCardValidator {

    public static void validate(TrumpCardRank trumpCardRank, TrumpCardSuit trumpCardSuit) {
        validateNotNull(trumpCardRank, trumpCardSuit);
    }

    private static void validateNotNull(TrumpCardRank trumpCardRank, TrumpCardSuit trumpCardSuit) {
        if (hasNull(trumpCardRank, trumpCardSuit)) {
            throw new IllegalArgumentException("트럼프 카드 모양 또는 숫자가 null이면 안됩니다.");
        }
    }

    private static boolean hasNull(TrumpCardRank trumpCardRank, TrumpCardSuit trumpCardSuit) {
        return Objects.isNull(trumpCardRank) || Objects.isNull(trumpCardSuit);
    }
}
