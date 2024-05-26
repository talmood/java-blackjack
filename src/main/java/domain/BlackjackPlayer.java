package domain;

import java.util.List;

public class BlackjackPlayer implements BlackjackParticipant {

    private final BlackjackPlayerName blackjackPlayerName;
    private final TrumpCards trumpCards;

    public BlackjackPlayer(BlackjackPlayerName blackjackPlayerName, TrumpCards trumpCards) {
        this.blackjackPlayerName = blackjackPlayerName;
        this.trumpCards = trumpCards;
    }

    @Override
    public BlackjackParticipant receiveCard(TrumpCard trumpCard) {
        return new BlackjackPlayer(this.blackjackPlayerName, this.trumpCards.addCard(trumpCard));
    }

    @Override
    public List<String> fetchKoreanCardNames() {
        return this.trumpCards.fetchKoreanNames();
    }

    public String getPlayerName() {
        return blackjackPlayerName.getName();
    }
}
