package domain;

public record DealerWinOrLose(int winCount, int loseCount, int tieCount) {

    public DealerWinOrLose {
        this.validateLowerThanZero(winCount, loseCount, tieCount);
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
