package oop.inheritance.core.transaction;

import java.time.LocalDateTime;

import oop.inheritance.core.card.Card;

public class GenericTransaction {
    private int amountInCents;
    private LocalDateTime localDateTime;
    private Card card;

    public GenericTransaction() {}

    public GenericTransaction(int amountInCents, LocalDateTime localDateTime, Card card) {
        this.amountInCents = amountInCents;
        this.localDateTime = localDateTime;
        this.card = card;
    }

    public int getAmountInCents() {
        return amountInCents;
    }

    public void setAmountInCents(int amountInCents) {
        this.amountInCents = amountInCents;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
