package blackjack.controller;

import blackjack.domain.card.CardDeck;
import blackjack.domain.game.BlackJackGame;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Name;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import blackjack.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGameController {

    public void run() {
        final CardDeck cardDeck = CardDeck.create();
        cardDeck.shuffle();

        final Dealer dealer = Dealer.create();
        final Players players = initPlayers();

        final BlackJackGame blackJackGame = new BlackJackGame(cardDeck, players, dealer);
        blackJackGame.play();
    }

    private Players initPlayers() {
        final List<String> playerNames = InputView.inputPlayerNames();
        final List<Player> players = playerNames.stream()
                .map(name -> Player.of(Name.of(name)))
                .collect(Collectors.toList());

        return Players.of(players);
    }
}
