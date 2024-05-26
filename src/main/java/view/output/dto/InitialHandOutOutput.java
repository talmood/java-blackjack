package view.output.dto;

import domain.BlackjackParticipants;
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

    public static InitialHandOutOutput of(HandOutCount handOutCount, BlackjackParticipants blackjackParticipants) {
        return new InitialHandOutOutput(
                handOutCount.getHandOutCount(),
                blackjackParticipants.getBlackjackParticipants().stream()
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
