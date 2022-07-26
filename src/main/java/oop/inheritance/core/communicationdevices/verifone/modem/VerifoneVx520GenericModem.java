package oop.inheritance.core.communicationdevices.verifone.modem;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.vx520.VerifoneVx520Modem;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneVx520GenericModem implements CommunicationDevice {
    private final VerifoneVx520Modem device;

    private VerifoneVx520GenericModem() {
        device = new VerifoneVx520Modem();
    }

    @Override
    public boolean open() {
        return device.open();
    }

    @Override
    public boolean send(GenericTransaction genericTransaction) {
        byte[] message = dataBuilder(genericTransaction);
        return device.send(message);
    }

    @Override
    public GenericTransactionResponse receive() {
        byte[] response = device.receive();

        return responseProcessor(response);
    }

    @Override
    public void close() {
        device.close();
    }

    private static final class GenericDeviceHolder {
        private static final VerifoneVx520GenericModem genericDevice = new VerifoneVx520GenericModem();
    }

    public synchronized static VerifoneVx520GenericModem getInstance() {
        return GenericDeviceHolder.genericDevice;
    }
}
