package domain.winorlose;

import domain.game.BlackjackGame;
import domain.participant.BlackjackDealer;
import domain.participant.BlackjackPlayer;
import domain.participant.BlackjackPlayers;
import domain.validator.ObjectsValidator;

import java.util.ArrayList;
import java.util.List;

import static domain.trumpcard.WinOrLose.*;

public class BlackjackWinOrLoseDecider {

    private final BlackjackGame blackjackGame;

    public BlackjackWinOrLoseDecider(BlackjackGame blackjackGame) {
        ObjectsValidator.validateNotNull(blackjackGame);
        this.blackjackGame = blackjackGame;
    }

    public FinalWinOrLose decide() {
        int dealerWin = 0;
        int dealerLose = 0;
        int dealerTie = 0;

        List<PlayerWinOrLose> playerWinOrLoses = new ArrayList<>();

        BlackjackDealer dealer = blackjackGame.findDealer();
        BlackjackPoint dealerPoint = dealer.calculatePoint();

        BlackjackPlayers players = blackjackGame.findPlayers();
        List<BlackjackPlayer> blackjackPlayers = players.fetchBlackjackPlayers();

        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            BlackjackPoint playerPoint = blackjackPlayer.calculatePoint();

            if (dealerPoint.isWin(playerPoint)) {
                dealerWin++;
                playerWinOrLoses.add(new PlayerWinOrLose(blackjackPlayer.getBlackjackPlayerName(), LOSE));
            }

            if (dealerPoint.isLose(playerPoint)) {
                dealerLose++;
                playerWinOrLoses.add(new PlayerWinOrLose(blackjackPlayer.getBlackjackPlayerName(), WIN));
            }

            if (dealerPoint.isTie(playerPoint)) {
                dealerTie++;
                playerWinOrLoses.add(new PlayerWinOrLose(blackjackPlayer.getBlackjackPlayerName(), TIE));
            }
        }

        return new FinalWinOrLose(new DealerWinOrLose(dealerWin, dealerLose, dealerTie), playerWinOrLoses);
    }
}
