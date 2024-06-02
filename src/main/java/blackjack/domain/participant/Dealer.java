package blackjack.domain.participant;

public class Dealer extends Participant {

    private Dealer(final Name name) {
        super(name);
    }

    public static Dealer create() {
        return new Dealer(Name.of("딜러"));
    }
}
