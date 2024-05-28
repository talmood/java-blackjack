package view.output;

import view.output.dto.*;

public interface OutputView {

    void viewInitialHandOut(InitialHandOutOutput initialHandOutOutput);

    void viewHandOutPlayer(HandOutPlayerOutput handOutPlayerOutput);

    void viewHandOutDealer(HandOutDealerOutput handOutDealerOutput);

    void viewBlackjackResult(BlackjackResultOutputs blackjackResultOutput);

    void viewFinalWinOrLose(FinalWinOrLoseOutput finalWinOrLoseOutput);
}
