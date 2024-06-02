package blackjack.domain.participant;

import blackjack.domain.result.DealerResult;
import blackjack.domain.result.PlayerResult;

import java.util.List;

public class Dealer extends Participant {

    private static final int DEALER_DRAW_THRESHOLD = 17;

    private Dealer(final Name name) {
        super(name);
    }

    @Override
    public boolean canDrawCard() {
        return cards.calculateScore() < DEALER_DRAW_THRESHOLD;
    }

    public static Dealer create() {
        return new Dealer(Name.of("딜러"));
    }

    public DealerResult createResult(final List<PlayerResult> playerResults) {
        return new DealerResult(playerResults);
    }
}
