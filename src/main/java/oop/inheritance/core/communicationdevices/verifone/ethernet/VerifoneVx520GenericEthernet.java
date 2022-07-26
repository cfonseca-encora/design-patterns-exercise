package oop.inheritance.core.communicationdevices.verifone.ethernet;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.vx520.VerifoneVx520Ethernet;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneVx520GenericEthernet implements CommunicationDevice {
    private final VerifoneVx520Ethernet ethernet;

    private VerifoneVx520GenericEthernet() {
        ethernet = new VerifoneVx520Ethernet();
    }

    @Override
    public boolean open() {
        return ethernet.open();
    }

    @Override
    public boolean send(GenericTransaction genericTransaction) {
        byte[] message = dataBuilder(genericTransaction);
        return ethernet.send(message);
    }

    @Override
    public GenericTransactionResponse receive() {
        byte[] response = ethernet.receive();

        return responseProcessor(response);
    }

    @Override
    public void close() {
        ethernet.close();
    }

    private static final class GenericEthernetHolder {
        private static final VerifoneVx520GenericEthernet genericDevice = new VerifoneVx520GenericEthernet();
    }

    public synchronized static VerifoneVx520GenericEthernet getInstance() {
        return GenericEthernetHolder.genericDevice;
    }


}
