package oop.inheritance.core.communicationdevices.verifone.ethernet;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.library.vx690.VerifoneVx690Ethernet;

import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.dataBuilder;
import static oop.inheritance.core.communicationdevices.verifone.util.VerifoneGenericUtils.responseProcessor;

public class VerifoneVx690GenericEthernet implements CommunicationDevice {
    private final VerifoneVx690Ethernet ethernet;

    private VerifoneVx690GenericEthernet() {
        ethernet = new VerifoneVx690Ethernet();
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
        private static final VerifoneVx690GenericEthernet genericEthernet = new VerifoneVx690GenericEthernet();
    }

    public synchronized static VerifoneVx690GenericEthernet getInstance() {
        return GenericEthernetHolder.genericEthernet;
    }

}
