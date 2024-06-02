package domain.handouter;

public record HandOutCount(int handOutCount) {

    public HandOutCount {
        this.validateGreaterThanZero(handOutCount);
    }

    private void validateGreaterThanZero(int handOutCount) {
        if (handOutCount <= 0) {
            throw new IllegalArgumentException("나눠주는 카드는 1장 이상이어야 합니다.");
        }
    }
}
