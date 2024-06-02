package view.input;

import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.input.dto.PlayersInput;

public interface InputView {

    PlayersInput viewPlayers();

    HandOutPlayerInput viewHandOutCardForPlayer(HandOutPlayerRequest handOutPlayerRequest);

}
