package model.card;

public interface CardRecipient {

    boolean receivable();

    void receive(Card card);

}
