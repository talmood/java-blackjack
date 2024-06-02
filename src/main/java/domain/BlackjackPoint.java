package domain;

import java.util.Objects;

public class BlackjackPoint {

    private static final int RESULT_POINT_THRESHOLD = 21;
    private final int point;

    public BlackjackPoint(int point) {
        this.validateLowerThanZero(point);
        this.point = point;
    }

    public BlackjackPoint sum(BlackjackPoint blackjackPoint) {
        return new BlackjackPoint(this.point + blackjackPoint.point);
    }

    public boolean isLowerThan(BlackjackPoint blackjackPoint) {
        return this.point < blackjackPoint.point;
    }

    public BlackjackPoint fetchCloserPointThreshold(BlackjackPoint blackjackPoint) {
        int first = Math.abs(RESULT_POINT_THRESHOLD - this.point);
        int second = Math.abs(RESULT_POINT_THRESHOLD - blackjackPoint.point);

        if (first < second) {
            return this;
        }

        return blackjackPoint;
    }

    public int getPoint() {
        return point;
    }

    public boolean isWin(BlackjackPoint blackjackPoint) {
        return this.fetchDiff() < blackjackPoint.fetchDiff();
    }

    public boolean isLose(BlackjackPoint blackjackPoint) {
        return this.fetchDiff() > blackjackPoint.fetchDiff();
    }

    public boolean isTie(BlackjackPoint blackjackPoint) {
        return this.fetchDiff() == blackjackPoint.fetchDiff();
    }

    private int fetchDiff() {
        return Math.abs(RESULT_POINT_THRESHOLD - this.point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackjackPoint that = (BlackjackPoint) o;
        return point == that.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    private void validateLowerThanZero(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("블랙잭 포인트는 음수일 수 없습니다.");
        }
    }
}
