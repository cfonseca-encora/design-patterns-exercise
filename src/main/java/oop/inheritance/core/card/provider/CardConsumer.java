package oop.inheritance.core.card.provider;

import oop.inheritance.core.card.Card;

@FunctionalInterface
public interface CardConsumer {
    void consume(Card card);
}
