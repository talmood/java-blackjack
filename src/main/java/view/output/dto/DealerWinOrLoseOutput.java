package view.output.dto;

import domain.DealerWinOrLose;

public class DealerWinOrLoseOutput {

    private final int winCount;

    private final int loseCount;

    private final int tieCount;

    public DealerWinOrLoseOutput(int winCount, int loseCount, int tieCount) {
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.tieCount = tieCount;
    }

    public static DealerWinOrLoseOutput from(DealerWinOrLose dealerWinOrLose) {
        return new DealerWinOrLoseOutput(dealerWinOrLose.winCount(), dealerWinOrLose.loseCount(), dealerWinOrLose.tieCount());
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public int getTieCount() {
        return tieCount;
    }
}
