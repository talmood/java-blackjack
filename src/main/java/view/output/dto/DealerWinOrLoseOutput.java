package view.output.dto;

import domain.DealerWinOrLose;

public record DealerWinOrLoseOutput(int winCount, int loseCount, int tieCount) {

    public static DealerWinOrLoseOutput from(DealerWinOrLose dealerWinOrLose) {
        return new DealerWinOrLoseOutput(dealerWinOrLose.winCount(), dealerWinOrLose.loseCount(), dealerWinOrLose.tieCount());
    }
}
