package view.output.dto;

import java.util.List;

public class InitHandOutParticipantOutput {

    private final String participantName;
    private final List<String> cards;

    public InitHandOutParticipantOutput(String participantName, List<String> cards) {
        this.participantName = participantName;
        this.cards = cards;
    }
}
