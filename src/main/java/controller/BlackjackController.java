package controller;

import view.dto.DealerResult;
import view.*;
import model.participant.Dealer;
import model.participant.Player;
import model.participant.PlayerName;
import model.card.CardDispenser;
import view.dto.ParticipantsDto;
import view.dto.PlayerDto;

import java.util.List;

public class BlackjackController {

    private final InputView inputView;
    private final ResultView resultView;

    public BlackjackController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        final List<Player> players = inputPlayers();
        final Dealer dealer = Dealer.withInitialTwoCards(CardDispenser.defaultOf());

        dispenseCards(dealer, players);

        askPlayersHit(players, dealer);

        doDealerHit(dealer);

        resultView.showCardScore(ParticipantsDto.of(dealer, players));

        showGameResult(dealer, players);
    }

    private void showGameResult(final Dealer dealer, final List<Player> players) {
        final DealerResult dealerResult = new DealerResult(dealer.calculateResult(players));

        final List<PlayerResult> playerResults = players.stream()
                .map(player -> PlayerResult.of(player, player.calculateResult(dealer)))
                .toList();

        resultView.showGameResult(dealerResult, playerResults);
    }

    private void doDealerHit(final Dealer dealer) {
        if (dealer.receivable()) {
            dealer.dispenseCardItSelf();
            resultView.notifyDealerReceivedAnotherCard();
        }
    }

    private void askPlayersHit(final List<Player> players, final Dealer dealer) {
        for (Player player : players) {
            askPlayerHit(player, dealer);
        }
    }

    private void askPlayerHit(final Player player, final Dealer dealer) {
        while (player.receivable()) {
            HitConfirmation confirmation = inputView.askHit(PlayerDto.from(player));

            if (!confirmation.wantToHit()) {
                break;
            }

            dealer.dispenseCard(player);
            resultView.showCards(PlayerDto.from(player));
        }
    }

    private void dispenseCards(final Dealer dealer, final List<Player> players) {
        dealer.dispenseInitialTwoCards(players);
        resultView.showCards(ParticipantsDto.of(dealer, players));
    }

    private List<Player> inputPlayers() {
        final List<PlayerName> playerNames = inputView.inputPlayerNames();
        return Player.ofNames(playerNames);
    }

}
