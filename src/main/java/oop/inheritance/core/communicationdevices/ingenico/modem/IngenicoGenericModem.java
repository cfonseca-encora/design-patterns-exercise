package oop.inheritance.core.communicationdevices.ingenico.modem;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.services.IngenicoModem;

public class IngenicoGenericModem implements CommunicationDevice {
    private final IngenicoModem device;

    private IngenicoGenericModem() {
        device = new IngenicoModem();
    }

    @Override
    public boolean open() {
        return device.open();
    }

    @Override
    public boolean send(GenericTransaction genericTransaction) {
        oop.library.ingenico.model.Transaction customTransaction = new oop.library.ingenico.model.Transaction();

        customTransaction.setAmountInCents(genericTransaction.getAmountInCents());
        customTransaction.setLocalDateTime(genericTransaction.getLocalDateTime());
        customTransaction.setCard(new Card(genericTransaction.getCard().getAccount(), new oop.library.ingenico.model.ExpirationDate(genericTransaction.getCard().getExpirationDate().getMonth(), genericTransaction.getCard().getExpirationDate().getYear()), genericTransaction.getCard().getEntryMode()));

        return device.send(customTransaction);
    }

    @Override
    public GenericTransactionResponse receive() {
        oop.library.ingenico.model.TransactionResponse customTransactionResponse = device.receive();
        return new GenericTransactionResponse(customTransactionResponse.isApproved(), customTransactionResponse.getHostReference());
    }

    @Override
    public void close() {
        device.close();
    }

    private static final class GenericDeviceHolder {
        private static final IngenicoGenericModem genericDevice = new IngenicoGenericModem();
    }

    public synchronized static IngenicoGenericModem getInstance() {

        return GenericDeviceHolder.genericDevice;
    }
}
