package view.output;

import view.output.dto.InitialHandOutOutput;
import view.output.dto.InitialHandOutParticipantOutput;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private final static String INITIAL_HAND_OUT_CARDS_COUNT_NAVIGATION = "딜러와 %s에게 %d장을 나누었습니다.";
    private final static String INITIAL_HAND_OUT_CARDS_NAVIGATION = "%s카드: %s";
    private final OutputWriter outputWriter;

    public ConsoleOutputView(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    @Override
    public void viewInitialHandOut(InitialHandOutOutput initialHandOutOutput) {
        outputWriter.writeFormat(
                INITIAL_HAND_OUT_CARDS_COUNT_NAVIGATION,
                initialHandOutOutput.fetchJoinedPlayerNames(),
                initialHandOutOutput.getHandOutCount()
        );
        outputWriter.write(System.lineSeparator());

        List<InitialHandOutParticipantOutput> initialHandOutParticipantOutput =
                initialHandOutOutput.getInitialHandOutParticipantOutput();

        for (InitialHandOutParticipantOutput handOutParticipantOutput : initialHandOutParticipantOutput) {
            outputWriter.writeFormat(
                    INITIAL_HAND_OUT_CARDS_NAVIGATION,
                    handOutParticipantOutput.getParticipantName(),
                    handOutParticipantOutput.getJoinedCardNames()
            );
            outputWriter.write(System.lineSeparator());
        }
    }

    @Override
    public void viewParticipantsCards() {

    }

    @Override
    public void viewWinOrLose() {

    }
}
