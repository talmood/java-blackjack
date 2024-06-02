package blackjack.domain.participant;

public class Player extends Participant {

    private Player(final Name name) {
        super(name);
    }

    public static Player of(final Name name) {
        return new Player(name);
    }
}
