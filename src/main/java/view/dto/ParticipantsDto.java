package view.dto;

import model.participant.Dealer;
import model.participant.Player;

import java.util.List;
import java.util.stream.Collectors;

public record ParticipantsDto(
        DealerDto dealer,
        List<PlayerDto> players
) {

    public static ParticipantsDto of(final Dealer dealer, final List<Player> players) {
        return new ParticipantsDto(DealerDto.from(dealer), PlayerDto.from(players));
    }

    public String formatInitialCardDistributionMessage() {
        final String playerNames = this.players.stream()
                .map(PlayerDto::getName)
                .collect(Collectors.joining(", "));

        return "딜러와 %s에게 2장을 나누었습니다.".formatted(playerNames);
    }

    public String formatDealerScore() {
        return dealer.formatScore();
    }

}
