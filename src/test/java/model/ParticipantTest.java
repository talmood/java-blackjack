package model;

import card.model.Card;
import card.model.CardRank;
import card.model.CardSuit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import participant.model.Participant;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantTest {

	@Test
	void 참가자가_딜러인지_확인하기() {
		Participant sut = new Participant("딜러");
		assertThat(sut.isDealer()).isTrue();
	}

	@ParameterizedTest
	@MethodSource("provideCard")
	void 참가자의_현재_카드_점수_합산(List<Card> cards) {
		Participant sut = new Participant("name");
		cards.forEach(sut::addCard);

		assertThat(sut.calculateCurrentScore()).isEqualTo(21);
	}

	@ParameterizedTest
	@MethodSource("provideCard")
	void 참가자의_현재_카드_점수_합산이_오버되었는지_확인하기(List<Card> cards) {
		Participant sut = new Participant("name");
		cards.forEach(sut::addCard);

		assertThat(sut.isOverWinningMaxScore()).isFalse();
	}

	private static Stream<Arguments> provideCard() {
		return Stream.of(
			Arguments.of(List.of(new Card(CardSuit.CLOVER, CardRank.ACE), new Card(CardSuit.CLOVER, CardRank.JACK))),
			Arguments.of(List.of(new Card(CardSuit.HEART, CardRank.ACE), new Card(CardSuit.SPADE, CardRank.ACE), new Card(CardSuit.DIAMOND, CardRank.KING), new Card(CardSuit.DIAMOND, CardRank.NINE)))
		);
	}
}
