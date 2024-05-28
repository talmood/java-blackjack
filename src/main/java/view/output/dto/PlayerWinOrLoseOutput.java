package view.output.dto;

import domain.PlayerWinOrLose;

public class PlayerWinOrLoseOutput {

    private final String playerName;

    private final String winOrLose;

    public PlayerWinOrLoseOutput(String playerName, String winOrLose) {
        this.playerName = playerName;
        this.winOrLose = winOrLose;
    }

    public static PlayerWinOrLoseOutput from(PlayerWinOrLose playerWinOrLose) {
        return new PlayerWinOrLoseOutput(playerWinOrLose.fetchPlayerName(), playerWinOrLose.fetchWinOrLoseKoreanName());
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getWinOrLose() {
        return winOrLose;
    }
}
