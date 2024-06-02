package view.input;

import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.input.dto.PlayersInput;
import view.output.OutputWriter;


public class ConsoleInputView implements InputView {

    private final static String PLAYERS_NAVIGATION = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final static String HAND_OUT_PLAYER_NAVIGATION = "%s는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)";

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
    public HandOutPlayerInput viewHandOutCardForPlayer(HandOutPlayerRequest handOutPlayerRequest) {
        String playerName = handOutPlayerRequest.getPlayerName();
        outputWriter.writeFormat(HAND_OUT_PLAYER_NAVIGATION, playerName);
        String line = inputReader.readLine();

        return HandOutPlayerInput.from(line);
    }
}
