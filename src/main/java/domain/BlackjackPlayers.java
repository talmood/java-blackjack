package domain;

import domain.validator.CollectionValidator;

import java.util.List;
import java.util.stream.Collectors;

public class BlackjackPlayers {

    private final List<BlackjackPlayer> blackjackPlayers;

    public BlackjackPlayers(List<BlackjackPlayer> blackjackPlayers) {
        CollectionValidator.validateNotEmpty(blackjackPlayers);
        this.blackjackPlayers = blackjackPlayers;
    }

    public static BlackjackPlayers fromNamesWithEmptyCards(List<BlackjackPlayerName> blackjackPlayerNames) {
        return new BlackjackPlayers(
                blackjackPlayerNames.stream()
                        .map(name -> new BlackjackPlayer(name, TrumpCards.createEmptyCards()))
                        .collect(Collectors.toList())
        );
    }

    public List<BlackjackParticipant> fetchBlackjackParticipant() {
        return List.copyOf(this.blackjackPlayers);
    }

    public List<BlackjackPlayer> fetchBlackjackPlayers() {
        return List.copyOf(this.blackjackPlayers);
    }
}
