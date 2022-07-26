package oop.inheritance.core.card.provider.ingenico;

import oop.inheritance.core.card.Card;
import oop.inheritance.core.card.ExpirationDate;
import oop.inheritance.core.card.provider.CardConsumer;
import oop.inheritance.core.card.provider.Provider;
import oop.inheritance.core.card.util.CardUtils;
import oop.library.ingenico.services.IngenicoCardSwipper;
import oop.library.ingenico.services.IngenicoChipReader;

public class IngenicoCardProvider implements Provider {

    IngenicoCardSwipper cardSwipper;
    IngenicoChipReader chipReader;

    private IngenicoCardProvider() {
        cardSwipper = new IngenicoCardSwipper();
        chipReader = new IngenicoChipReader();
    }

    @Override
    public void readCard(CardConsumer cardConsumer) {
        Card genericCard;
        oop.library.ingenico.model.Card card;
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
        private static final IngenicoCardProvider instance = new IngenicoCardProvider();
    }

    public synchronized static IngenicoCardProvider getInstance() {
        return InstanceHolder.instance;
    }
}
