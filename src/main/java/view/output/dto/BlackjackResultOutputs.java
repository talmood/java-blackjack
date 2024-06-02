package view.output.dto;

import domain.BlackjackGame;

import java.util.List;
import java.util.stream.Collectors;

public class BlackjackResultOutputs {

    private final List<BlackjackResultOutput> blackjackResultOutputs;

    public BlackjackResultOutputs(List<BlackjackResultOutput> blackjackResultOutputs) {
        this.blackjackResultOutputs = blackjackResultOutputs;
    }

    public static BlackjackResultOutputs from(BlackjackGame blackjackGame) {
        return new BlackjackResultOutputs(
                blackjackGame.fetchBlackjackParticipants().stream()
                        .map(BlackjackResultOutput::from)
                        .collect(Collectors.toList())
        );
    }

    public List<BlackjackResultOutput> getBlackjackResultOutputs() {
        return blackjackResultOutputs;
    }
}
