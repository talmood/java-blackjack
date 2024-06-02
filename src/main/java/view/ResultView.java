package view;

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

}
