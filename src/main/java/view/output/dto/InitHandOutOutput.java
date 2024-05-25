package view.output.dto;

import java.util.List;

public class InitHandOutOutput {

    private final int handOutCardsCount;

    private final List<InitHandOutParticipantOutput> initHandOutParticipantOutputs;

    public InitHandOutOutput(int handOutCardsCount, List<InitHandOutParticipantOutput> initHandOutParticipantOutputs) {
        this.handOutCardsCount = handOutCardsCount;
        this.initHandOutParticipantOutputs = initHandOutParticipantOutputs;
    }
}
