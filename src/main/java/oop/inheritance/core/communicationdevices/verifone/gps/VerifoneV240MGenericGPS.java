package oop.inheritance.core.communicationdevices.verifone.gps;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.v240m.VerifoneV240mGPS;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneV240MGenericGPS implements CommunicationDevice {
    private final VerifoneV240mGPS device;

    private VerifoneV240MGenericGPS() {
        device = new VerifoneV240mGPS();
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
        private static final VerifoneV240MGenericGPS genericDevice = new VerifoneV240MGenericGPS();
    }

    public synchronized static VerifoneV240MGenericGPS getInstance() {
        return GenericDeviceHolder.genericDevice;
    }
}
