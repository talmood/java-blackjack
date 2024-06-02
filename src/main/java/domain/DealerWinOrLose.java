package domain;

public class DealerWinOrLose {

    private final int winCount;

    private final int loseCount;

    private final int tieCount;

    public DealerWinOrLose(int winCount, int loseCount, int tieCount) {
        this.validateLowerThanZero(winCount, loseCount, tieCount);
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

    private void validateLowerThanZero(int winCount, int loseCount, int tieCount) {
        if (this.hasLowerThanZero(winCount, loseCount, tieCount)) {
            throw new IllegalArgumentException("dealer 승패 수는 음수일 수 없습니다.");
        }
    }

    private boolean isLowerThanZero(int count) {
        return count < 0;
    }

    private boolean hasLowerThanZero(int winCount, int loseCount, int tieCount) {
        return this.isLowerThanZero(winCount) || this.isLowerThanZero(loseCount) || this.isLowerThanZero(tieCount);
    }
}
