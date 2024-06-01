package view;

import card.model.Card;
import card.model.CardRank;
import card.model.CardSuit;
import game.domain.GameJudgement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import participant.model.Participant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class OutputViewTest extends IOTest {

	@Test
	void 게임_참가자에게_최초_카드_분배한다는_메시지_출력_테스트() {
		OutputView sut = new OutputView();

		sut.firstDistributeCard(createParticipants(List.of("딜러", "pobi")));

		assertThat(fetchOutput()).contains("딜러와 pobi에게 2장을 나누었습니다.");
	}

	@ParameterizedTest
	@MethodSource("provideCard")
	void 참가자들의_현재_카드_상황_메시지_출력_테스트(String name, List<Card> dealerCards, List<Card> participantCards) {
		List<Participant> participants = createParticipants(List.of("딜러", name));
		dealerCards.forEach(card -> participants.get(0).addCard(card));
		participantCards.forEach(card -> participants.get(1).addCard(card));

		OutputView sut = new OutputView();

		String dealerCardJoining = dealerCards.stream()
			.map(Card::toString)
			.collect(Collectors.joining(", "));

		String participantCardJoining = participantCards.stream()
			.map(Card::toString)
			.collect(Collectors.joining(", "));

		sut.printParticipantsCard(participants);

		assertAll(
			() -> assertThat(fetchOutput()).contains("딜러카드: %s".formatted(dealerCardJoining)),
			() -> assertThat(fetchOutput()).contains("%s카드: %s".formatted(name, participantCardJoining))
		);
	}

	@ParameterizedTest
	@MethodSource("provideCard")
	void 최종_카드의_점수_현황_메시지_출력_테스트(String name, List<Card> dealerCards, List<Card> participantCards) {
		List<Participant> participants = createParticipants(List.of("딜러", name));
		Participant dealer = participants.get(0);
		Participant participant = participants.get(1);

		dealerCards.forEach(dealer::addCard);
		participantCards.forEach(participant::addCard);

		OutputView sut = new OutputView();

		String dealerCardJoining = dealerCards.stream()
			.map(Card::toString)
			.collect(Collectors.joining(", "));

		String participantCardJoining = participantCards.stream()
			.map(Card::toString)
			.collect(Collectors.joining(", "));

		sut.printFinalResult(participants);

		assertAll(
			() -> assertThat(fetchOutput()).contains("딜러 카드: %s - 결과: %d".formatted(dealerCardJoining, dealer.calculateCurrentScore())),
			() -> assertThat(fetchOutput()).contains("%s 카드: %s - 결과: %d".formatted(name, participantCardJoining, participant.calculateCurrentScore()))
		);
	}

	@ParameterizedTest
	@MethodSource("provideCard")
	void 최종_승패_판정_메시지_출력_테스트(String name, List<Card> dealerCards, List<Card> participantCards) {
		List<Participant> participants = createParticipants(List.of("딜러", name));
		Participant dealer = participants.get(0);
		Participant participant = participants.get(1);

		dealerCards.forEach(dealer::addCard);
		participantCards.forEach(participant::addCard);

		OutputView sut = new OutputView();

		sut.printGameJudgement(new GameJudgement(participants));

		assertThat(fetchOutput()).contains("%s: 승".formatted(name));
	}

	private List<Participant> createParticipants(final List<String> names) {
		return names.stream()
			.map(Participant::new)
			.toList();
	}

	private static Stream<Arguments> provideCard() {
		return Stream.of(
			Arguments.of("pobi",
				List.of(new Card(CardSuit.CLOVER, CardRank.TWO), new Card(CardSuit.CLOVER, CardRank.FIVE)),
				List.of(new Card(CardSuit.CLOVER, CardRank.NINE), new Card(CardSuit.CLOVER, CardRank.QUEEN))
			),
			Arguments.of("pobi",
				List.of(new Card(CardSuit.HEART, CardRank.NINE), new Card(CardSuit.HEART, CardRank.EIGHT)),
				List.of(new Card(CardSuit.HEART, CardRank.JACK), new Card(CardSuit.HEART, CardRank.ACE))
			)
		);
	}
}
