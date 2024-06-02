package controller;

import model.participant.Player;
import view.dto.GameResult;
import view.dto.PlayerDto;

public class PlayerResult {

    private final PlayerDto player;
    private final GameResult gameResult;

    private PlayerResult(final PlayerDto player, final GameResult gameResult) {
        this.player = player;
        this.gameResult = gameResult;
    }

    public static PlayerResult of(final Player player, final GameResult gameResult) {
        return new PlayerResult(PlayerDto.from(player), gameResult);
    }

    public String toResultFormat() {
        return player.getName() + ": " + getSuffix();
    }

    private String getSuffix() {
        if (gameResult.wonCount() > 0) {
            return "승";
        }
        if (gameResult.loseCount() > 0) {
            return "패";
        }
        return "무";
    }

}
