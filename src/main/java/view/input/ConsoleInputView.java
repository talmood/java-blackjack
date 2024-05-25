package view.input;

import view.input.dto.PlayersInput;
import view.output.OutputWriter;

public class ConsoleInputView implements InputView {

    private final static String PLAYERS_NAVIGATION = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public ConsoleInputView(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public PlayersInput viewPlayers() {

        outputWriter.writeLine(PLAYERS_NAVIGATION);
        String input = inputReader.readLine();

        return PlayersInput.from(input);
    }

    @Override
    public void viewMoreCard() {

    }

    @Override
    public void viewThresholdCard() {

    }
}
