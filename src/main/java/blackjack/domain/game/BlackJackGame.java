package blackjack.domain.game;

import blackjack.domain.card.CardDeck;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Players;
import blackjack.view.ResultView;

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
        playersTurn();
        dealerTurn();
        judge();
    }

    private void drawInitialCards(final CardDeck cardDeck) {
        dealer.drawInitialCards(cardDeck);
        players.drawInitialCards(cardDeck);
        ResultView.printShareInitialCards(players, dealer);
    }

    private void judge() {
    }

    private void dealerTurn() {
    }

    private void playersTurn() {

    }
}
