package view.output.dto;

import domain.winorlose.PlayerWinOrLose;

public record PlayerWinOrLoseOutput(String playerName, String winOrLose) {

    public static PlayerWinOrLoseOutput from(PlayerWinOrLose playerWinOrLose) {
        return new PlayerWinOrLoseOutput(playerWinOrLose.fetchPlayerName(), playerWinOrLose.fetchWinOrLoseKoreanName());
    }
}
