package view.output;

import view.output.dto.InitialHandOutOutput;

public interface OutputView {

    void viewInitialHandOut(InitialHandOutOutput initialHandOutOutput);

    void viewParticipantsCards();

    void viewWinOrLose();
}
