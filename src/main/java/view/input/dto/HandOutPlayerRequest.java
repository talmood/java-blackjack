package view.input.dto;

import domain.BlackjackPlayerName;

public class HandOutPlayerRequest {

    private final String playerName;

    public HandOutPlayerRequest(String playerName) {
        this.playerName = playerName;
    }

    public static HandOutPlayerRequest from(BlackjackPlayerName blackjackPlayerName) {
        return new HandOutPlayerRequest(blackjackPlayerName.name());
    }

    public String getPlayerName() {
        return playerName;
    }
}
