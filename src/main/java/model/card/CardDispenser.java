package model.card;

public class CardDispenser {

    private final CardPack cardPack;

    private CardDispenser(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public static CardDispenser defaultOf() {
        return new CardDispenser(CardPack.defaultOf());
    }

    public void dispense(final CardRecipient cardRecipient, final int dispenseCount) {
        for (int i = 0; i < dispenseCount; i++) {
            dispenseOne(cardRecipient);
        }
    }

    private void dispenseOne(final CardRecipient cardRecipient) {
        if (cardRecipient.receivable()) {
            cardRecipient.receive(this.cardPack.drawOne());
        }
    }

}
