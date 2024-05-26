package domain;

import java.util.List;

public class BlackjackDealer implements BlackjackParticipant {

    private final TrumpCards trumpCards;

    public BlackjackDealer(TrumpCards trumpCards) {
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
}
