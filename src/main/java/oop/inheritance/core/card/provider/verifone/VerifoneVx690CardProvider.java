package oop.inheritance.core.card.provider.verifone;

import oop.inheritance.core.card.Card;
import oop.inheritance.core.card.ExpirationDate;
import oop.inheritance.core.card.provider.CardConsumer;
import oop.inheritance.core.card.provider.Provider;
import oop.inheritance.core.card.util.CardUtils;
import oop.library.vx520.VerifoneVx520CardSwipper;
import oop.library.vx520.VerifoneVx520ChipReader;
import oop.library.vx690.VerifoneVx690CardSwipper;
import oop.library.vx690.VerifoneVx690ChipReader;

public class VerifoneVx690CardProvider implements Provider {
    VerifoneVx690CardSwipper cardSwipper;
    VerifoneVx690ChipReader chipReader;

    private VerifoneVx690CardProvider() {
        cardSwipper = new VerifoneVx690CardSwipper();
        chipReader = new VerifoneVx690ChipReader();
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
        private static final VerifoneVx690CardProvider instance = new VerifoneVx690CardProvider();
    }

    public synchronized static VerifoneVx690CardProvider getInstance() {
        return VerifoneVx690CardProvider.InstanceHolder.instance;
    }
}
