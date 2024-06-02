package domain;

import domain.validator.ObjectsValidator;
import view.input.InputView;
import view.output.OutputView;
import view.output.dto.BlackjackResultOutputs;
import view.output.dto.FinalWinOrLoseOutput;
import view.output.dto.InitialHandOutOutput;

public class BlackjackSimulator {

    private final InputView inputView;

    private final OutputView outputView;

    public BlackjackSimulator(InputView inputView, OutputView outputView) {
        ObjectsValidator.validateNotNull(inputView, outputView);
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public BlackjackGame createNotPlayedGame() {
        BlackjackGameCreator blackjackGameCreator = new BlackjackGameCreator(inputView);
        return blackjackGameCreator.create();
    }

    public BlackjackGame InitialHandOutGame(BlackjackGame blackjackGame) {
        HandOutCount handOutCount = new HandOutCount(2);
        BlackjackInitialHandOuter blackjackInitialHandOuter = new BlackjackInitialHandOuter(blackjackGame, new HandOutCount(2));
        BlackjackGame initialHandOutGame = blackjackInitialHandOuter.handOut();
        outputView.viewInitialHandOut(InitialHandOutOutput.of(handOutCount, initialHandOutGame));

        return initialHandOutGame;
    }

    public BlackjackGame handOutPlayers(BlackjackGame blackjackGame) {
        BlackjackPlayersHandOuter blackjackPlayersHandOuter = new BlackjackPlayersHandOuter(blackjackGame, inputView, outputView);
        return blackjackPlayersHandOuter.handOut();
    }

    public BlackjackGame handOutDealer(BlackjackGame blackjackGame) {
        BlackjackDealerHandOuter blackjackDealerHandOuter = new BlackjackDealerHandOuter(blackjackGame, outputView);
        BlackjackGame dealerHandOutGame = blackjackDealerHandOuter.handOut();
        outputView.viewBlackjackResult(BlackjackResultOutputs.from(dealerHandOutGame));

        return dealerHandOutGame;
    }

    public void decideWinOrLose(BlackjackGame blackjackGame) {
        BlackjackWinOrLoseDecider blackjackWinOrLoseDecider = new BlackjackWinOrLoseDecider(blackjackGame);
        FinalWinOrLose winOrLose = blackjackWinOrLoseDecider.decide();
        outputView.viewFinalWinOrLose(FinalWinOrLoseOutput.from(winOrLose));
    }
}
