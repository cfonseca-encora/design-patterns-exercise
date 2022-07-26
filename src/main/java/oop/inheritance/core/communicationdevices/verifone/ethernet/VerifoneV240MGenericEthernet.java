package oop.inheritance.core.communicationdevices.verifone.ethernet;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.library.v240m.VerifoneV240mEthernet;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneV240MGenericEthernet implements CommunicationDevice {
    private final VerifoneV240mEthernet device;

    private VerifoneV240MGenericEthernet() {
        device = new VerifoneV240mEthernet();
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
        private static final VerifoneV240MGenericEthernet genericDevice = new VerifoneV240MGenericEthernet();
    }

    public synchronized static VerifoneV240MGenericEthernet getInstance() {
        return GenericDeviceHolder.genericDevice;
    }

}
