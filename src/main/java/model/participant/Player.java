package model.participant;

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
        return !super.isBust();
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

}
