package blackjack.domain.result;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;

import java.util.Arrays;

public enum Result {
    WIN("승", (player, dealer) -> (player.isBlackjack() && !dealer.isBlackjack()) || (player.isBust() && !dealer.isBust()) || (player.calculateScore() > dealer.calculateScore() && !dealer.isBust())),
    LOSE("패", (player, dealer) -> (!player.isBlackjack() && dealer.isBlackjack()) || (!player.isBust() && dealer.isBust() && player.calculateScore() < dealer.calculateScore())),
    DRAW("무", (player, dealer) -> (player.calculateScore() == dealer.calculateScore()) || (player.isBust() && dealer.isBust()) || (player.isBlackjack() && dealer.isBlackjack()));

    private final String name;
    private final ResultDeterminer determiner;

    Result(final String name, final ResultDeterminer determiner) {
        this.name = name;
        this.determiner = determiner;
    }

    public static Result checkResult(final Player player, final Dealer dealer) {
        return Arrays.stream(values())
                .filter(result -> result.determiner.compare(player, dealer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과를 판단할 수 없습니다."));
    }

    public static Result reverse(final Result result) {
        if (result == WIN) {
            return LOSE;
        }
        if (result == LOSE) {
            return WIN;
        }
        return DRAW;
    }

    public String getName() {
        return name;
    }
}
