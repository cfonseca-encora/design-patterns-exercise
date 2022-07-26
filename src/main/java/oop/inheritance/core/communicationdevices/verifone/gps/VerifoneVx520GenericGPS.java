package oop.inheritance.core.communicationdevices.verifone.gps;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.vx520.VerifoneVx520GPS;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneVx520GenericGPS implements CommunicationDevice {
    private final VerifoneVx520GPS device;

    private static VerifoneVx520GenericGPS genericDevice;

    private VerifoneVx520GenericGPS() {
        device = new VerifoneVx520GPS();
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

    public synchronized static VerifoneVx520GenericGPS getInstance() {
        if(genericDevice == null)
            genericDevice = new VerifoneVx520GenericGPS();

        return genericDevice;
    }
}
