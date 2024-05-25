package view.input;

import view.input.dto.PlayersInput;

public interface InputView {

    PlayersInput viewPlayers();

    void viewInitCards();

    void viewMoreCard();

    void viewThresholdCard();
}
