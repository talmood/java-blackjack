package domain;

import domain.validator.BlackjackParticipantsValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BlackjackParticipants {

    private final List<BlackjackParticipant> blackjackParticipants;

    public BlackjackParticipants(List<BlackjackParticipant> blackjackParticipants) {
        BlackjackParticipantsValidator.validate(blackjackParticipants);
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

    public BlackjackParticipants handOutOneCardForAll(TrumpCards trumpCards) {
        this.validateParticipantsAndTrumpCardSizeEqual(trumpCards);
        List<TrumpCard> cards = trumpCards.getCards();

        return new BlackjackParticipants(
                IntStream.range(0, this.size())
                        .mapToObj(index -> this.blackjackParticipants.get(index).receiveCard(cards.get(index)))
                        .collect(Collectors.toList())
        );
    }

    private void validateParticipantsAndTrumpCardSizeEqual(TrumpCards trumpCards) {
        if (this.size() != trumpCards.size()) {
            throw new IllegalArgumentException("카드는 무조건 한장씩 나눠줘야 합니다.");
        }
    }

    public int size() {
        return this.blackjackParticipants.size();
    }

    public List<BlackjackParticipant> getBlackjackParticipants() {
        return List.copyOf(this.blackjackParticipants);
    }
}
