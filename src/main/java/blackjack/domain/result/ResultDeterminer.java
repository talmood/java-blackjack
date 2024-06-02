package blackjack.domain.result;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;

public interface ResultDeterminer {
    boolean compare(Player player, Dealer dealer);
}