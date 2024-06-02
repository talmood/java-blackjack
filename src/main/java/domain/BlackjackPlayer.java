package domain;

import domain.validator.ObjectsValidator;

import java.util.List;

public class BlackjackPlayer implements BlackjackParticipant {

    private final BlackjackPlayerName blackjackPlayerName;
    private final TrumpCards trumpCards;

    public BlackjackPlayer(BlackjackPlayerName blackjackPlayerName, TrumpCards trumpCards) {
        ObjectsValidator.validateNotNull(blackjackPlayerName, trumpCards);
        this.blackjackPlayerName = blackjackPlayerName;
        this.trumpCards = trumpCards;
    }

    @Override
    public BlackjackPlayer receiveCard(TrumpCard trumpCard) {
        return new BlackjackPlayer(this.blackjackPlayerName, this.trumpCards.addCard(trumpCard));
    }

    public BlackjackPlayerName getBlackjackPlayerName() {
        return this.blackjackPlayerName;
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
}
