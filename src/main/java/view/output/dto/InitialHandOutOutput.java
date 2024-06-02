package view.output.dto;

import domain.BlackjackGame;
import domain.HandOutCount;

import java.util.List;
import java.util.stream.Collectors;

public class InitialHandOutOutput {

    private final int handOutCount;

    private final List<InitialHandOutParticipantOutput> initialHandOutParticipantOutput;

    public InitialHandOutOutput(int handOutCount, List<InitialHandOutParticipantOutput> initialHandOutParticipantOutput) {
        this.handOutCount = handOutCount;
        this.initialHandOutParticipantOutput = initialHandOutParticipantOutput;
    }

    public static InitialHandOutOutput of(HandOutCount handOutCount, BlackjackGame blackjackGame) {
        return new InitialHandOutOutput(
                handOutCount.getHandOutCount(),
                blackjackGame.fetchBlackjackParticipants().stream()
                        .map(InitialHandOutParticipantOutput::from)
                        .collect(Collectors.toList())
        );
    }

    public int getHandOutCount() {
        return handOutCount;
    }

    public List<InitialHandOutParticipantOutput> getInitialHandOutParticipantOutput() {
        return initialHandOutParticipantOutput;
    }

    public String fetchJoinedPlayerNames() {
        return this.initialHandOutParticipantOutput.stream()
                .filter(InitialHandOutParticipantOutput::isPlayer)
                .map(InitialHandOutParticipantOutput::getParticipantName)
                .collect(Collectors.joining(", "));
    }
}
