package view.output;

import view.output.dto.*;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private final static String INITIAL_HAND_OUT_CARDS_COUNT_NAVIGATION = "딜러와 %s에게 %d장을 나누었습니다.";
    private final static String INITIAL_HAND_OUT_CARDS_NAVIGATION = "%s카드: %s";
    private final static String HAND_OUT_CARD_FOR_PLAYER_NAVIGATION = "%s카드 : %s";
    private final static String HAND_OUT_DEALER_NAVIGATION = "딜러는 %d이하라 한장의 카드를 더 받았습니다.";
    private final static String DEALER_WIN_OR_LOSE_NAVIGATION = "딜러 : %d승 %d무 %d패";
    private final static String PLAYER_WIN_OR_LOSE_NAVIGATION = "%s : %s";
    private final static String BLACKJACK_RESULT_NAVIGATION = "%s 카드: %s - 결과: %d";
    private final OutputWriter outputWriter;

    public ConsoleOutputView(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    @Override
    public void viewInitialHandOut(InitialHandOutOutput initialHandOutOutput) {
        outputWriter.writeFormat(
                INITIAL_HAND_OUT_CARDS_COUNT_NAVIGATION,
                initialHandOutOutput.fetchJoinedPlayerNames(),
                initialHandOutOutput.getHandOutCount()
        );
        outputWriter.write(System.lineSeparator());

        List<InitialHandOutParticipantOutput> initialHandOutParticipantOutput =
                initialHandOutOutput.fetchInitialHandOutParticipantOutput();

        for (InitialHandOutParticipantOutput handOutParticipantOutput : initialHandOutParticipantOutput) {
            outputWriter.writeFormat(
                    INITIAL_HAND_OUT_CARDS_NAVIGATION,
                    handOutParticipantOutput.getParticipantName(),
                    handOutParticipantOutput.getJoinedCardNames()
            );
            outputWriter.write(System.lineSeparator());
        }
    }

    @Override
    public void viewHandOutPlayer(HandOutPlayerOutput handOutPlayerOutput) {
        outputWriter.writeFormat(HAND_OUT_CARD_FOR_PLAYER_NAVIGATION, handOutPlayerOutput.getPlayerName(), handOutPlayerOutput.fetchJoinedKoreanNames());
        outputWriter.write(System.lineSeparator());
    }

    @Override
    public void viewHandOutDealer(HandOutDealerOutput handOutDealerOutput) {
        outputWriter.writeFormat(HAND_OUT_DEALER_NAVIGATION, handOutDealerOutput.handOutThreshold());
        outputWriter.write(System.lineSeparator());
    }

    @Override
    public void viewBlackjackResult(BlackjackResultOutputs blackjackResultOutput) {
        List<BlackjackResultOutput> blackjackResultOutputs = blackjackResultOutput.blackjackResultOutputs();
        blackjackResultOutputs.forEach(output -> {
            outputWriter.writeFormat(
                    BLACKJACK_RESULT_NAVIGATION,
                    output.getParticipantName(),
                    output.fetchJoinedCardNames(),
                    output.getTotalPoint()
            );

            outputWriter.write(System.lineSeparator());
        });
        outputWriter.write(System.lineSeparator());
    }

    @Override
    public void viewFinalWinOrLose(FinalWinOrLoseOutput finalWinOrLoseOutput) {
        this.printDealerWinOrLose(finalWinOrLoseOutput);
        outputWriter.write(System.lineSeparator());
        this.printPlayerWinOrLose(finalWinOrLoseOutput);
    }

    private void printDealerWinOrLose(FinalWinOrLoseOutput finalWinOrLoseOutput) {
        DealerWinOrLoseOutput dealerWinOrLoseOutput = finalWinOrLoseOutput.getDealerWinOrLoseOutput();
        outputWriter.writeFormat(
                DEALER_WIN_OR_LOSE_NAVIGATION,
                dealerWinOrLoseOutput.winCount(),
                dealerWinOrLoseOutput.tieCount(),
                dealerWinOrLoseOutput.loseCount()
        );
    }

    private void printPlayerWinOrLose(FinalWinOrLoseOutput finalWinOrLoseOutput) {
        List<PlayerWinOrLoseOutput> playerWinOrLoses = finalWinOrLoseOutput.fetchPlayerWinOrLoses();
        playerWinOrLoses.forEach(playerWinOrLoseOutput -> {
            outputWriter.writeFormat(
                    PLAYER_WIN_OR_LOSE_NAVIGATION,
                    playerWinOrLoseOutput.playerName(),
                    playerWinOrLoseOutput.winOrLose()
            );
            outputWriter.write(System.lineSeparator());
        });
    }
}
