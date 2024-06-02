package view.output.dto;

import domain.participant.BlackjackParticipant;
import domain.participant.BlackjackPlayerName;

import java.util.List;

public class HandOutPlayerOutput {

    private final String playerName;

    private final List<String> cardKoreanNames;

    public HandOutPlayerOutput(String playerName, List<String> cardKoreanNames) {
        this.playerName = playerName;
        this.cardKoreanNames = cardKoreanNames;
    }

    public static HandOutPlayerOutput of(BlackjackPlayerName blackjackPlayerName, BlackjackParticipant blackjackParticipant) {
        return new HandOutPlayerOutput(blackjackPlayerName.name(), blackjackParticipant.fetchKoreanCardNames());
    }

    public String getPlayerName() {
        return playerName;
    }

    public String fetchJoinedKoreanNames() {
        return String.join(", ", this.cardKoreanNames);
    }
}
