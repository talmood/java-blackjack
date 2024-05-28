package domain;

import view.input.InputView;
import view.output.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static domain.WinOrLose.*;

public class BlackjackGame implements HandOutForPlayerGame {

    private final BlackjackParticipants blackjackParticipants;
    private final TrumpCardDeck trumpCardDeck;

    public BlackjackGame(BlackjackParticipants blackjackParticipants, TrumpCardDeck trumpCardDeck) {
        this.validateNotNull(blackjackParticipants, trumpCardDeck);
        this.blackjackParticipants = blackjackParticipants;
        this.trumpCardDeck = trumpCardDeck;
    }

    public BlackjackGame initialHandOut(TrumpCardHandOuter trumpCardHandOuter, HandOutCount handOutCount) {
        BlackjackGame blackjackGame = this;

        for (int i = 0; i < handOutCount.getHandOutCount(); i++) {
            blackjackGame = trumpCardHandOuter.handOutAllParticipants(blackjackGame);
        }

        return blackjackGame;
    }

    public BlackjackGame handOutAllPlayers(TrumpCardHandOuter trumpCardHandOuter, InputView inputView, OutputView outputView) {
        return trumpCardHandOuter.handOutAllPlayers(this, inputView, outputView);
    }

    public BlackjackGame handOutDealer(TrumpCardHandOuter trumpCardHandOuter, OutputView outputView) {
        return trumpCardHandOuter.handOutDealer(this, outputView);
    }

    public BlackjackParticipants getBlackjackParticipants() {
        return this.blackjackParticipants;
    }

    public List<BlackjackParticipant> fetchBlackjackParticipants() {
        return this.blackjackParticipants.getBlackjackParticipants();
    }

    public List<BlackjackPlayer> fetchBlackjackPlayers() {
        return this.blackjackParticipants.findPlayers().getBlackjackPlayers();
    }

    public BlackjackDealer findDealer() {
        return this.blackjackParticipants.findDealer();
    }

    private void validateNotNull(BlackjackParticipants blackjackParticipants, TrumpCardDeck trumpCardDeck) {
        if (Objects.isNull(blackjackParticipants) || Objects.isNull(trumpCardDeck)) {
            throw new IllegalArgumentException("참가자 혹은 게임 덱은 null이면 안됩니다.");
        }
    }

    public TrumpCardDeck getTrumpCardDeck() {
        return trumpCardDeck;
    }

    public FinalWinOrLose decideWinOrLose() {
        int dealerWin = 0;
        int dealerLose = 0;
        int dealerTie = 0;

        List<PlayerWinOrLose> playerWinOrLoses = new ArrayList<>();

        BlackjackDealer dealer = this.blackjackParticipants.findDealer();
        BlackjackPoint dealerPoint = dealer.calculatePoint();

        BlackjackPlayers players = this.blackjackParticipants.findPlayers();
        List<BlackjackPlayer> blackjackPlayers = players.getBlackjackPlayers();

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
