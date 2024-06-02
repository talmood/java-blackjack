package domain.game;

import domain.handouter.*;
import domain.validator.ObjectsValidator;
import domain.winorlose.BlackjackWinOrLoseDecider;
import domain.winorlose.FinalWinOrLose;
import view.input.InputView;
import view.output.OutputView;
import view.output.dto.BlackjackResultOutputs;
import view.output.dto.FinalWinOrLoseOutput;
import view.output.dto.InitialHandOutOutput;

public class BlackjackSimulator {

    private static final int INITIAL_HANDOUT_COUNT = 2;

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
        HandOutCount handOutCount = new HandOutCount(INITIAL_HANDOUT_COUNT);
        BlackjackHandOuter blackjackInitialHandOuter = new BlackjackInitialHandOuter(blackjackGame, handOutCount);
        BlackjackGame initialHandOutGame = blackjackInitialHandOuter.handOut();
        outputView.viewInitialHandOut(InitialHandOutOutput.of(handOutCount, initialHandOutGame));

        return initialHandOutGame;
    }

    public BlackjackGame handOutPlayers(BlackjackGame blackjackGame) {
        BlackjackHandOuter blackjackPlayersHandOuter = new BlackjackPlayersHandOuter(blackjackGame, inputView, outputView);
        return blackjackPlayersHandOuter.handOut();
    }

    public BlackjackGame handOutDealer(BlackjackGame blackjackGame) {
        BlackjackHandOuter blackjackDealerHandOuter = new BlackjackDealerHandOuter(blackjackGame, outputView);
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
