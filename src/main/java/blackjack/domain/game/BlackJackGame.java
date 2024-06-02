package blackjack.domain.game;

import blackjack.domain.card.CardDeck;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import blackjack.domain.result.DealerResult;
import blackjack.domain.result.PlayerResult;
import blackjack.view.InputView;
import blackjack.view.ResultView;

import java.util.List;

import static blackjack.view.ResultView.printBlankLine;

public class BlackJackGame {
    private final CardDeck cardDeck;
    private final Players players;
    private final Dealer dealer;

    public BlackJackGame(final CardDeck cardDeck, final Players players, final Dealer dealer) {
        this.cardDeck = cardDeck;
        this.players = players;
        this.dealer = dealer;
    }

    public void play() {
        drawInitialCards(cardDeck);
        if (!isGameOver()) {
            playersTurn();
            dealerTurn();
        }
        printResult();
        judge();
    }

    private boolean isGameOver() {
        return dealer.isBlackjack() || players.isAllBlackjack();
    }

    private void drawInitialCards(final CardDeck cardDeck) {
        dealer.drawInitialCards(cardDeck);
        players.drawInitialCards(cardDeck);
        ResultView.printShareInitialCards(players, dealer);
    }

    private void playersTurn() {
        for (final Player player : players.getPlayers()) {
            playerTurn(player);
        }
    }

    private void playerTurn(final Player player) {
        printBlankLine();
        while (player.canDrawCard() && InputView.printOrDrawOrStop(player.getName())) {
            player.drawCard(cardDeck);
            ResultView.printCardInfo(player);
        }
    }

    private void dealerTurn() {
        printBlankLine();
        while (dealer.canDrawCard()) {
            dealer.drawCard(cardDeck);
            ResultView.printDealerDrawCard();
        }
    }

    private void printResult() {
        printBlankLine();
        ResultView.printCardInfoWithScore(dealer);
        players.getPlayers().forEach(ResultView::printCardInfoWithScore);
    }

    private void judge() {
        final List<PlayerResult> playersResults = players.createResults(dealer);
        final DealerResult dealerResult = dealer.createResult(playersResults);
        ResultView.printResult(playersResults, dealerResult);
    }
}
