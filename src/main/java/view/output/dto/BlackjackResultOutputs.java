package view.output.dto;

import domain.BlackjackGame;

import java.util.List;
import java.util.stream.Collectors;

public record BlackjackResultOutputs(List<BlackjackResultOutput> blackjackResultOutputs) {

    public static BlackjackResultOutputs from(BlackjackGame blackjackGame) {
        return new BlackjackResultOutputs(
                blackjackGame.fetchBlackjackParticipants().stream()
                        .map(BlackjackResultOutput::from)
                        .collect(Collectors.toList())
        );
    }
}
