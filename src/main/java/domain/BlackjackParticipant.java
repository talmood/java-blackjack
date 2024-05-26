package domain;

import java.util.List;

public interface BlackjackParticipant {

    BlackjackParticipant receiveCard(TrumpCard trumpCard);

    List<String> fetchKoreanCardNames();
}
