package model.participant;

import model.CardScore;
import view.dto.GameResult;
import model.card.Card;
import model.card.CardDispenser;
import model.card.CardHand;
import model.card.CardRecipient;

import java.util.List;

public class Dealer extends Participant implements CardRecipient {

    public static final CardScore ADDITIONAL_CARD_RECEIVABLE_UPPER_BOUND = new CardScore(16);

    private final CardDispenser dispenser;

    Dealer(CardHand cardHand, CardDispenser dispenser) {
        super(cardHand);
        this.dispenser = dispenser;
    }

    public static Dealer withInitialTwoCards(final CardDispenser dispenser) {
        final Dealer dealer = new Dealer(CardHand.emptyOf(), dispenser);
        dispenser.dispense(dealer, 2);
        return dealer;
    }

    public void dispenseInitialTwoCards(final List<Player> players) {
        players.forEach(player -> this.dispenser.dispense(player, 2));
    }

    public void dispenseCard(final CardRecipient recipient) {
        this.dispenser.dispense(recipient, 1);
    }

    @Override
    public boolean receivable() {
        return super.calculateScore().isEqualOrLessThan(ADDITIONAL_CARD_RECEIVABLE_UPPER_BOUND);
    }

    @Override
    public void receive(final Card card) {
        if (!receivable()) {
            throw new IllegalStateException("Dealer cannot receive Card %s".formatted(card.toString()));
        }
        super.addHand(card);
    }

    public void dispenseCardItSelf() {
        dispenseCard(this);
    }

    public GameResult calculateResult(List<Player> players) {
        final long wonCount = players.stream()
                .filter(player -> player.lose(this))
                .count();

        final long loseCount = players.stream()
                .filter(player -> player.won(this))
                .count();

        final long tieCount = players.stream()
                .filter(player -> player.tie(this))
                .count();

        return new GameResult(wonCount, loseCount, tieCount);
    }

}
