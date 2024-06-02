package blackjack.domain.participant;

public class Player extends Participant {

    private static final int PLAYER_DRAW_THRESHOLD = 21;

    private Player(final Name name) {
        super(name);
    }

    @Override
    public boolean canDrawCard() {
        return cards.calculateScore() < PLAYER_DRAW_THRESHOLD;
    }

    public static Player of(final Name name) {
        return new Player(name);
    }
}
