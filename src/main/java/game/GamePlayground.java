package game;

import card.CardDeck;
import participant.model.Participant;

import java.util.ArrayList;
import java.util.List;

public class GamePlayground {
	private final List<Participant> participants = new ArrayList<>();
	private final CardDeck cardDeck = new CardDeck();

	public GamePlayground(final List<Participant> participants) {
		this.participants.addAll(participants);
	}
}
