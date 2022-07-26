package oop.inheritance.core.card.provider.verifone;

import oop.inheritance.core.card.Card;
import oop.inheritance.core.card.ExpirationDate;
import oop.inheritance.core.card.provider.CardConsumer;
import oop.inheritance.core.card.provider.Provider;
import oop.inheritance.core.card.provider.ingenico.IngenicoCardProvider;
import oop.inheritance.core.card.util.CardUtils;
import oop.library.v240m.VerifoneV240mCardSwipper;
import oop.library.v240m.VerifoneV240mChipReader;

public class VerifoneV240MCardProvider implements Provider {
    VerifoneV240mCardSwipper cardSwipper;
    VerifoneV240mChipReader chipReader;

    private VerifoneV240MCardProvider() {
        cardSwipper = new VerifoneV240mCardSwipper();
        chipReader = new VerifoneV240mChipReader();
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
        private static final VerifoneV240MCardProvider instance = new VerifoneV240MCardProvider();
    }

    public synchronized static VerifoneV240MCardProvider getInstance() {
        return VerifoneV240MCardProvider.InstanceHolder.instance;
    }
}
