package model.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CardHandTest {

    @DisplayName("핸드 점수가 21점 초과면 버스트이다.")
    @Test
    void isBust() {
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.JACK),
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.TEN)
        );

        final CardHand sut = new CardHand(cards);

        Assertions.assertThat(sut.isBust()).isTrue();
    }

    @DisplayName("핸드 점수가 21점 이하면 버스트가 아니다.")
    @Test
    void isBust_false() {
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.JACK),
                new Card(CardSuit.CLUBS, CardValue.ACE)
        );

        final CardHand sut = new CardHand(cards);

        Assertions.assertThat(sut.isBust()).isFalse();
    }

    @DisplayName("핸드의 점수 계산 시")
    @Nested
    class CalculateScore {

        @DisplayName("Ace가 포함되지 않을 경우 점수 계산")
        @ParameterizedTest
        @MethodSource("provideCardHandAndScoreWithAceExcluded")
        void calculateScore(List<Card> cards, int expectedScore) {
            assertCalculatedScore(cards, expectedScore);
        }

        @DisplayName("Ace가 포함될 경우")
        @Nested
        class AceIncluded {

            @DisplayName("점수 합이 21점이 넘지 않을 경우, Ace는 11점으로 계산된다.")
            @Test
            void case1() {
                assertCalculatedScore(
                        List.of(
                                new Card(CardSuit.CLUBS, CardValue.ACE),
                                new Card(CardSuit.CLUBS, CardValue.TEN)
                        ),
                        21
                );
            }

            @DisplayName("점수 합이 21점이 넘을 경우, Ace는 1점으로 계산된다.")
            @Test
            void case2() {
                assertCalculatedScore(
                        List.of(
                                new Card(CardSuit.CLUBS, CardValue.ACE),
                                new Card(CardSuit.CLUBS, CardValue.TEN),
                                new Card(CardSuit.CLUBS, CardValue.TWO)
                        ),
                        13
                );
                assertCalculatedScore(
                        List.of(
                                new Card(CardSuit.CLUBS, CardValue.ACE),
                                new Card(CardSuit.HEARTS, CardValue.ACE)
                        ),
                        12
                );
            }

        }

        private void assertCalculatedScore(final List<Card> cards, int expectedScore) {
            final CardHand sut = new CardHand(cards);
            assertThat(sut.calculateScore().value()).isEqualTo(expectedScore);
        }

        static Stream<Arguments> provideCardHandAndScoreWithAceExcluded() {
            return Stream.of(
                    Arguments.of(
                            List.of(
                                    new Card(CardSuit.CLUBS, CardValue.JACK),
                                    new Card(CardSuit.CLUBS, CardValue.TEN)
                            ),
                            20
                    ),
                    Arguments.of(
                            List.of(
                                    new Card(CardSuit.CLUBS, CardValue.JACK),
                                    new Card(CardSuit.CLUBS, CardValue.TEN),
                                    new Card(CardSuit.HEARTS, CardValue.TEN)
                            ),
                            30
                    )
            );
        }

    }

}