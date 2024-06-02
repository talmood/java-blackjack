package controller;

import view.ParticipantsDto;
import model.participant.Dealer;
import model.participant.Player;
import model.participant.PlayerName;
import model.card.CardDispenser;
import view.InputView;
import view.ResultView;

import java.util.List;

public class BlackjackController {

    private final InputView inputView;
    private final ResultView resultView;

    public BlackjackController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        // 플레이어 이름 입력 기능
        final List<PlayerName> playerNames = inputView.inputPlayerNames();
        final List<Player> players = Player.ofNames(playerNames);

        // 카드 분배
        final Dealer dealer = Dealer.withInitialTwoCards(CardDispenser.defaultOf());
        dealer.dispenseInitialTwoCards(players);

        // 카드 분배 결과 출력
        final ParticipantsDto participants = ParticipantsDto.of(dealer, players);
        resultView.showCards(participants);

        // 플레이어 카드 draw

        // 딜러 카드 draw

        // 카드 draw 결과 출력

        // 승패 결과 출력
    }

}
