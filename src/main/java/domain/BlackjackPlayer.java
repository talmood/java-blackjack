package domain;

import java.util.List;

public class BlackjackPlayer implements BlackjackParticipant, ReHandOutPlayer {

    private final BlackjackPlayerName blackjackPlayerName;
    private final TrumpCards trumpCards;

    public BlackjackPlayer(BlackjackPlayerName blackjackPlayerName, TrumpCards trumpCards) {
        this.blackjackPlayerName = blackjackPlayerName;
        this.trumpCards = trumpCards;
    }

    @Override
    public BlackjackPlayer receiveCard(TrumpCard trumpCard) {
        return new BlackjackPlayer(this.blackjackPlayerName, this.trumpCards.addCard(trumpCard));
    }

    @Override
    public BlackjackPlayerName getBlackjackPlayerName() {
        return this.blackjackPlayerName;
    }

    @Override
    public String fetchPlayerNameToString() {
        return this.blackjackPlayerName.getName();
    }

    @Override
    public TrumpCards getTrumpCards() {
        return this.trumpCards;
    }

    @Override
    public List<String> fetchCardKoreanNames() {
        return this.trumpCards.fetchKoreanNames();
    }

    @Override
    public List<String> fetchKoreanCardNames() {
        return this.trumpCards.fetchKoreanNames();
    }

    @Override
    public boolean isDealer() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public BlackjackPoint calculatePoint() {
        BlackjackPoint minBlackjackPoint = trumpCards.totalMinBlackjackPoint();
        BlackjackPoint maxBlackjackPoint = trumpCards.totalMaxBlackjackPoint();

        return minBlackjackPoint.fetchCloserPointThreshold(maxBlackjackPoint);
    }

    public String getPlayerName() {
        return blackjackPlayerName.getName();
    }

    public boolean isEqualName(BlackjackPlayerName blackjackPlayerName) {
        return this.blackjackPlayerName.equals(blackjackPlayerName);
    }
}
