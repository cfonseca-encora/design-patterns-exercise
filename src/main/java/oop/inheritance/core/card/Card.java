package oop.inheritance.core.card;

import oop.inheritance.core.card.EntryMode;
import oop.inheritance.core.card.util.CardUtils;

public class Card {
    private final String account;
    private final ExpirationDate expirationDate;
    private final EntryMode entryMode;

    public Card(String account, ExpirationDate expirationDate, EntryMode entryMode) {
        this.account = account;
        this.expirationDate = expirationDate;
        this.entryMode = entryMode;
    }

    public String getAccount() {
        return account;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public EntryMode getEntryMode() {
        return entryMode;
    }
}
