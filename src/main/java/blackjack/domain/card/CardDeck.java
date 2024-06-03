package blackjack.domain.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardDeck {
    private static final int DECK_SIZE = 52;
    private static final String DECK_EMPTY_MESSAGE = "덱이 비었습니다.";
    private static final String DECK_SIZE_MESSAGE = String.format("덱의 크기는 %d 입니다.", DECK_SIZE);
    private static final String DUPLICATE_CARD_MESSAGE = "중복된 카드가 존재합니다.";

    private final List<Card> cards;

    private CardDeck() {
        final List<Card> initializedCards = initialize();
        validate(initializedCards);
        this.cards = initializedCards;
    }

    public static CardDeck create() {
        return new CardDeck();
    }

    private static List<Card> initialize() {
        return Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Rank.values())
                        .map(rank -> Card.of(suit, rank)))
                .collect(Collectors.toList());
    }

    private static void validate(final List<Card> cards) {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException(DECK_EMPTY_MESSAGE);
        }
        if (cards.size() != DECK_SIZE) {
            throw new IllegalArgumentException(DECK_SIZE_MESSAGE);
        }
        if (cards.stream().distinct().count() != DECK_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_CARD_MESSAGE);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }


    /**
     * 초기 카드 2장을 뽑고, 덱에서 제거
     * @return List<Card> 초기 카드 2장
     */
    public List<Card> drawInitialCards() {
        return List.of(draw(), draw());
    }

    /**
     * 카드를 뽑고, 덱에서 제거
     * @return Card 뽑은 카드
     */
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException(DECK_EMPTY_MESSAGE);
        }
        // 마지막 카드를 뽑아내고, 덱에서 제거
        return cards.remove(cards.size() - 1);
    }
}
