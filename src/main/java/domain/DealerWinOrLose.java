package domain;

public class DealerWinOrLose {

    private final int winCount;

    private final int loseCount;

    private final int tieCount;

    public DealerWinOrLose(int winCount, int loseCount, int tieCount) {
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.tieCount = tieCount;
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
