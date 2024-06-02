package domain.handouter;

import domain.game.BlackjackGame;
import domain.participant.BlackjackDealer;
import domain.participant.BlackjackParticipant;
import domain.participant.BlackjackParticipants;
import domain.trumpcard.TrumpCard;
import domain.trumpcard.TrumpCardDeck;
import domain.validator.ObjectsValidator;
import domain.winorlose.BlackjackPoint;
import view.output.OutputView;
import view.output.dto.HandOutDealerOutput;

import java.util.ArrayList;
import java.util.List;

public class BlackjackDealerHandOuter implements BlackjackHandOuter {

    private static final int DEALER_HAND_OUT_THRESHOLD = 17;

    private final BlackjackGame blackjackGame;

    private final OutputView outputView;

    public BlackjackDealerHandOuter(BlackjackGame blackjackGame, OutputView outputView) {
        ObjectsValidator.validateNotNull(blackjackGame, outputView);
        this.blackjackGame = blackjackGame;
        this.outputView = outputView;
    }

    @Override
    public BlackjackGame handOut() {
        List<BlackjackParticipant> receivedParticipants = new ArrayList<>(this.blackjackGame.fetchBlackjackPlayers());
        BlackjackDealer dealer = this.blackjackGame.findDealer();
        BlackjackPoint blackjackPoint = dealer.calculatePoint();
        TrumpCardDeck trumpCardDeck = this.blackjackGame.getTrumpCardDeck();

        if (blackjackPoint.isLowerThan(new BlackjackPoint(DEALER_HAND_OUT_THRESHOLD))) {
            TrumpCard trumpCard = trumpCardDeck.fetchTopOne();
            trumpCardDeck = trumpCardDeck.takeOutTopOne();
            dealer = dealer.receiveCard(trumpCard);
            this.outputView.viewHandOutDealer(new HandOutDealerOutput(DEALER_HAND_OUT_THRESHOLD - 1));
        }

        receivedParticipants.add(dealer);
        return new BlackjackGame(new BlackjackParticipants(receivedParticipants), trumpCardDeck);
    }
}
