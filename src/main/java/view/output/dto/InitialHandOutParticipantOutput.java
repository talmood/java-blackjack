package view.output.dto;

import domain.BlackjackDealer;
import domain.BlackjackParticipant;
import domain.BlackjackPlayer;

import java.util.List;

public class InitialHandOutParticipantOutput {

    private final String participantName;

    private final List<String> cards;

    private final boolean player;

    public InitialHandOutParticipantOutput(String participantName, List<String> cards, boolean player) {
        this.participantName = participantName;
        this.cards = cards;
        this.player = player;
    }

    public static InitialHandOutParticipantOutput from(BlackjackParticipant blackjackParticipant) {
        if (blackjackParticipant instanceof BlackjackDealer) {
            return new InitialHandOutParticipantOutput("딜러", blackjackParticipant.fetchKoreanCardNames(), false);
        }

        if (blackjackParticipant instanceof BlackjackPlayer) {
            return new InitialHandOutParticipantOutput(
                    ((BlackjackPlayer) blackjackParticipant).getPlayerName(),
                    blackjackParticipant.fetchKoreanCardNames(),
                    true
            );
        }

        throw new IllegalArgumentException("유효하지 않은 블랙잭 참가자입니다.");
    }

    public String getJoinedCardNames() {
        return String.join(", ", this.cards);
    }

    public String getParticipantName() {
        return participantName;
    }

    public boolean isPlayer() {
        return player;
    }
}
