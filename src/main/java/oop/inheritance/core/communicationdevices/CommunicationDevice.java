package oop.inheritance.core.communicationdevices;

import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;

public interface CommunicationDevice {
    boolean open();

    boolean send(GenericTransaction genericTransaction);

    GenericTransactionResponse receive();

    void close();
}
