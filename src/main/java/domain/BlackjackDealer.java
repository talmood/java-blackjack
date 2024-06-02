package domain;

import util.ObjectUtils;

import java.util.List;

public class BlackjackDealer implements BlackjackParticipant {

    private final TrumpCards trumpCards;

    public BlackjackDealer(TrumpCards trumpCards) {
        this.validateNotNull(trumpCards);
        this.trumpCards = trumpCards;
    }

    public static BlackjackDealer createWithEmptyCards() {
        return new BlackjackDealer(TrumpCards.createEmptyCards());
    }


    @Override
    public BlackjackDealer receiveCard(TrumpCard trumpCard) {
        return new BlackjackDealer(this.trumpCards.addCard(trumpCard));
    }

    @Override
    public List<String> fetchKoreanCardNames() {
        return this.trumpCards.fetchKoreanNames();
    }

    @Override
    public boolean isDealer() {
        return true;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public BlackjackPoint calculatePoint() {
        BlackjackPoint minBlackjackPoint = trumpCards.totalMinBlackjackPoint();
        BlackjackPoint maxBlackjackPoint = trumpCards.totalMaxBlackjackPoint();

        return minBlackjackPoint.fetchCloserPointThreshold(maxBlackjackPoint);
    }

    public void validateNotNull(TrumpCards trumpCards) {
        if (ObjectUtils.hasNull(trumpCards)) {
            throw new IllegalArgumentException("trumpCards는 null값이면 안됩니다.");
        }
    }
}
