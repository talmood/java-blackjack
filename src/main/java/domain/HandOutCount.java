package domain;

public class HandOutCount {

    private final int handOutCount;

    public HandOutCount(int handOutCount) {

        this.handOutCount = handOutCount;
    }

    public int getHandOutCount() {
        return this.handOutCount;
    }

    private void validateGreaterThanZero(int handOutCount) {
        if (handOutCount <= 0) {
            throw new IllegalArgumentException("나눠주는 카드는 무조건 1장 이상이어야 합니다.");
        }
    }
}
