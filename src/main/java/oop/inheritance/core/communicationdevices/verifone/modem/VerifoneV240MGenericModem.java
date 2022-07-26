package oop.inheritance.core.communicationdevices.verifone.modem;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.v240m.VerifoneV240mModem;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneV240MGenericModem implements CommunicationDevice {
    private final VerifoneV240mModem device;

    private VerifoneV240MGenericModem() {
        device = new VerifoneV240mModem();
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
        private static final VerifoneV240MGenericModem genericDevice = new VerifoneV240MGenericModem();
    }

    public synchronized static VerifoneV240MGenericModem getInstance() {
        return GenericDeviceHolder.genericDevice;
    }
}
