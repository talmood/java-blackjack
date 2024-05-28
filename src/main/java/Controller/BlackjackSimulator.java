package Controller;

import domain.*;
import view.input.InputView;
import view.input.dto.PlayersInput;
import view.output.OutputView;
import view.output.dto.BlackjackResultOutputs;
import view.output.dto.FinalWinOrLoseOutput;
import view.output.dto.InitialHandOutOutput;

import java.util.List;

public class BlackjackSimulator {

    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackSimulator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PlayersInput playersInput = inputView.viewPlayers();
        List<BlackjackPlayerName> blackjackPlayerNames = playersInput.toBlackjackPlayerNames();
        BlackjackPlayers blackjackPlayers = BlackjackPlayers.fromNamesWithEmptyCards(blackjackPlayerNames);
        BlackjackDealer blackjackDealer = BlackjackDealer.createWithEmptyCards();
        TrumpCardDeck trumpCardDeck = new TrumpCardDeck();

        BlackjackGame blackjackGame = new BlackjackGame(BlackjackParticipants.of(blackjackDealer, blackjackPlayers), trumpCardDeck);
        HandOutCount handOutCount = new HandOutCount(2);
        TrumpCardHandOuter trumpCardHandOuter = new TrumpCardHandOuter();

        BlackjackGame initialHandOutGame = blackjackGame.initialHandOut(trumpCardHandOuter, handOutCount);
        InitialHandOutOutput initialHandOutOutput = InitialHandOutOutput.of(handOutCount, initialHandOutGame.getBlackjackParticipants());
        outputView.viewInitialHandOut(initialHandOutOutput);

        BlackjackGame handOutAllPlayersGame = initialHandOutGame.handOutAllPlayers(trumpCardHandOuter, inputView, outputView);
        BlackjackGame handOutDealerGame = handOutAllPlayersGame.handOutDealer(trumpCardHandOuter, outputView);
        outputView.viewBlackjackResult(BlackjackResultOutputs.from(handOutDealerGame.getBlackjackParticipants()));

        FinalWinOrLose finalWinOrLose = handOutDealerGame.decideWinOrLose();
        outputView.viewFinalWinOrLose(FinalWinOrLoseOutput.from(finalWinOrLose));

    }
}
