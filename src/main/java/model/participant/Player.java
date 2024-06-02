package model.participant;

import view.dto.GameResult;
import model.card.Card;
import model.card.CardHand;
import model.card.CardRecipient;

import java.util.List;

public class Player extends Participant implements CardRecipient {

    private final PlayerName name;

    Player(CardHand hand, PlayerName name) {
        super(hand);
        this.name = name;
    }

    private static Player nameOf(PlayerName playerName) {
        return new Player(CardHand.emptyOf(), playerName);
    }

    public static List<Player> ofNames(final List<PlayerName> playerNames) {
        return playerNames.stream()
                .map(Player::nameOf)
                .toList();
    }

    @Override
    public boolean receivable() {
        return !super.busted();
    }

    @Override
    public void receive(final Card card) {
        if (!receivable()) {
            throw new IllegalStateException("Participant cannot receive card %s".formatted(card.toString()));
        }
        super.addHand(card);
    }

    public PlayerName getName() {
        return name;
    }

    public GameResult calculateResult(final Dealer dealer) {
        return new GameResult(
                won(dealer) ? 1 : 0,
                tie(dealer) ? 1 : 0,
                lose(dealer) ? 1 : 0
        );
    }

    public boolean won(final Dealer dealer) {
        if (dealer.busted()) {
            return !this.busted();
        }
        if (this.busted()) {
            return false;
        }
        return this.calculateScore().exceeds(dealer.calculateScore());
    }

    public boolean lose(final Dealer dealer) {
        if (dealer.busted()) {
            return false;
        }
        if (this.busted()) {
            return true;
        }
        return dealer.calculateScore().exceeds(this.calculateScore());
    }

    public boolean tie(final Dealer dealer) {
        if (dealer.busted() && this.busted()) {
            return true;
        }
        return dealer.calculateScore().equals(this.calculateScore());
    }

}
