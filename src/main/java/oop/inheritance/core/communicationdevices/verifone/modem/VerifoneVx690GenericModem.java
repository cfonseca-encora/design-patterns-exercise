package oop.inheritance.core.communicationdevices.verifone.modem;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.library.vx690.VerifoneVx690Modem;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneVx690GenericModem implements CommunicationDevice {
    private final VerifoneVx690Modem device;

    private VerifoneVx690GenericModem() {
        device = new VerifoneVx690Modem();
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
        private static final VerifoneVx690GenericModem genericDevice = new VerifoneVx690GenericModem();
    }

    public synchronized static VerifoneVx690GenericModem getInstance() {
        return GenericDeviceHolder.genericDevice;
    }
}
