package oop.inheritance.core.card.provider.verifone;

import oop.inheritance.core.card.Card;
import oop.inheritance.core.card.ExpirationDate;
import oop.inheritance.core.card.provider.CardConsumer;
import oop.inheritance.core.card.provider.Provider;
import oop.inheritance.core.card.util.CardUtils;
import oop.library.v240m.VerifoneV240mCardSwipper;
import oop.library.v240m.VerifoneV240mChipReader;
import oop.library.vx520.VerifoneVx520CardSwipper;
import oop.library.vx520.VerifoneVx520ChipReader;

public class VerifoneVx520CardProvider implements Provider {
    VerifoneVx520CardSwipper cardSwipper;
    VerifoneVx520ChipReader chipReader;

    private VerifoneVx520CardProvider() {
        cardSwipper = new VerifoneVx520CardSwipper();
        chipReader = new VerifoneVx520ChipReader();
    }

    @Override
    public void readCard(CardConsumer cardConsumer) {
        Card genericCard;
        oop.library.verifone.model.Card card;
        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        genericCard = new Card(card.getAccount(), new ExpirationDate(card.getExpirationDate().getMonth(), card.getExpirationDate().getYear()), CardUtils.getGenericEntryMode(card.getEntryMode()));

        cardConsumer.consume(genericCard);
    }

    private static final class InstanceHolder {
        private static final VerifoneVx520CardProvider instance = new VerifoneVx520CardProvider();
    }

    public synchronized static VerifoneVx520CardProvider getInstance() {
        return VerifoneVx520CardProvider.InstanceHolder.instance;
    }
}
