package oop.inheritance.core.communicationdevices.verifone.gps;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.vx690.VerifoneVx690GPS;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneVx690GenericGPS implements CommunicationDevice {
    private final VerifoneVx690GPS device;

    private VerifoneVx690GenericGPS() {
        device = new VerifoneVx690GPS();
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
        private static final VerifoneVx690GenericGPS genericDevice = new VerifoneVx690GenericGPS();
    }

    public synchronized static VerifoneVx690GenericGPS getInstance() {
        return GenericDeviceHolder.genericDevice;
    }
}
