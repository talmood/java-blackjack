package domain;

import java.util.List;

public interface ReHandOutPlayer {

    ReHandOutPlayer receiveCard(TrumpCard trumpCard);

    BlackjackPlayerName getBlackjackPlayerName();

    String fetchPlayerNameToString();

    TrumpCards getTrumpCards();

    List<String> fetchCardKoreanNames();
}
