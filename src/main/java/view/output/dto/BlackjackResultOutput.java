package view.output.dto;

import domain.BlackjackParticipant;
import domain.BlackjackPlayer;

import java.util.List;

public class BlackjackResultOutput {

    private final String participantName;

    private final List<String> cardKoreanNames;

    private final int totalPoint;

    public BlackjackResultOutput(String participantName, List<String> cardKoreanNames, int totalPoint) {
        this.participantName = participantName;
        this.cardKoreanNames = cardKoreanNames;
        this.totalPoint = totalPoint;
    }

    public static BlackjackResultOutput from(BlackjackParticipant blackjackParticipant) {
        String participantName = null;

        if (blackjackParticipant.isDealer()) {
            participantName = "딜러";
        }

        if (blackjackParticipant.isPlayer()) {
            participantName = ((BlackjackPlayer) blackjackParticipant).getPlayerName();
        }

        return new BlackjackResultOutput(participantName, blackjackParticipant.fetchKoreanCardNames(), blackjackParticipant.calculatePoint().point());
    }

    public String getParticipantName() {
        return participantName;
    }

    public List<String> getCardKoreanNames() {
        return cardKoreanNames;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public String fetchJoinedCardNames() {
        return String.join(", ", this.cardKoreanNames);
    }
}
