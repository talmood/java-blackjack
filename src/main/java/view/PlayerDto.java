package view;

import model.card.CardHand;
import model.participant.Player;
import model.participant.PlayerName;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerDto {

    private final CardHand hand;
    private final PlayerName name;

    public PlayerDto(final CardHand hand, final PlayerName name) {
        this.hand = hand;
        this.name = name;
    }

    public static List<PlayerDto> from(final List<Player> players) {
        return players.stream()
                .map(player -> new PlayerDto(player.getHand(), player.getName()))
                .toList();
    }

    public String formatHand() {
        final String formattedCardValues = this.hand.getCards()
                .stream()
                .map(CardValueFormatter::format)
                .collect(Collectors.joining(", "));

        return "%s카드: %s".formatted(name.value(), formattedCardValues);
    }

    public String getName() {
        return this.name.value();
    }

}
