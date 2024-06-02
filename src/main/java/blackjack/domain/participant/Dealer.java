package blackjack.domain.participant;

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
}
