package domain.participant;

import domain.trumpcard.TrumpCard;
import domain.winorlose.BlackjackPoint;

import java.util.List;

public interface BlackjackParticipant {

    BlackjackParticipant receiveCard(TrumpCard trumpCard);

    List<String> fetchKoreanCardNames();

    boolean isDealer();

    boolean isPlayer();

    BlackjackPoint calculatePoint();

    int fetchCardSize();
}
