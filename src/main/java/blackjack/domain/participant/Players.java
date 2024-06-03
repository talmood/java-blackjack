package blackjack.domain.participant;

import blackjack.domain.card.CardDeck;
import blackjack.domain.result.PlayerResult;

import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("플레이어는 최소 한 명 이상이어야 합니다.");
        }
        this.players = players;
    }

    public static Players of(final List<Player> players) {
        return new Players(players);
    }

    public void drawInitialCards(final CardDeck cardDeck) {
        players.forEach(player -> player.drawInitialCards(cardDeck));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public boolean isAllBlackjack() {
        return players.stream()
                .allMatch(Player::isBlackjack);
    }

    public List<PlayerResult> createResults(final Dealer dealer) {
        return players.stream()
                .map(player -> player.createResult(dealer))
                .toList();
    }
}
