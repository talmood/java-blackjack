package view;

import controller.PlayerResult;
import view.dto.DealerDto;
import view.dto.DealerResult;
import view.dto.ParticipantsDto;
import view.dto.PlayerDto;

import java.util.List;

public class ResultView {

    private final ConsoleWriter consoleWriter;

    public ResultView(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public void showCards(final ParticipantsDto participantsDto) {
        consoleWriter.printMessage(participantsDto.formatInitialCardDistributionMessage());

        final DealerDto dealer = participantsDto.dealer();
        consoleWriter.printMessage(dealer.formatCardHand());

        participantsDto.players().forEach(player -> consoleWriter.printMessage(player.formatHand()));
    }

    public void showCards(final PlayerDto player) {
        consoleWriter.printMessage(player.formatHand());
    }

    public void notifyDealerReceivedAnotherCard() {
        consoleWriter.printMessage("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void showGameResult(final DealerResult dealerResult, final List<PlayerResult> playerResults) {
        consoleWriter.printMessage("##최종 승패");
        consoleWriter.printMessage(dealerResult.toResultFormat());
        playerResults.forEach(result -> consoleWriter.printMessage(result.toResultFormat()));
    }

    public void showCardScore(final ParticipantsDto participants) {
        consoleWriter.printMessage(participants.formatDealerScore());

        participants.players()
                .forEach(player -> consoleWriter.printMessage(player.formatScore()));
    }

}
