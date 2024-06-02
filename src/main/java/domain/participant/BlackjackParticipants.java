package domain.participant;

import domain.validator.CollectionValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackParticipants {

    private final List<BlackjackParticipant> blackjackParticipants;

    public BlackjackParticipants(List<BlackjackParticipant> blackjackParticipants) {
        CollectionValidator.validateNotEmpty(blackjackParticipants);
        this.blackjackParticipants = blackjackParticipants;
    }

    public static BlackjackParticipants of(BlackjackDealer blackjackDealer, BlackjackPlayers blackjackPlayers) {
        ArrayList<BlackjackParticipant> participants = new ArrayList<>();
        participants.add(blackjackDealer);
        participants.addAll(blackjackPlayers.fetchBlackjackParticipant());

        return new BlackjackParticipants(
                participants
        );
    }

    public int size() {
        return this.blackjackParticipants.size();
    }

    public List<BlackjackParticipant> fetchBlackjackParticipants() {
        return List.copyOf(this.blackjackParticipants);
    }

    public BlackjackDealer findDealer() {
        return this.blackjackParticipants.stream()
                .filter(BlackjackParticipant::isDealer)
                .findAny()
                .map(BlackjackDealer.class::cast)
                .orElseThrow(() -> new IllegalStateException("참가자에 딜러가 존재하지 않습니다."));
    }

    public BlackjackPlayers findPlayers() {
        return new BlackjackPlayers(
                this.blackjackParticipants.stream()
                        .filter(BlackjackParticipant::isPlayer)
                        .map(BlackjackPlayer.class::cast)
                        .collect(Collectors.toList())
        );
    }
}
