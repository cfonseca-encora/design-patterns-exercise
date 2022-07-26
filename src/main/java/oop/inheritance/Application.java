package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.core.card.provider.Provider;
import oop.inheritance.core.abstractfactory.ITerminalFactory;
import oop.inheritance.core.card.Card;
import oop.inheritance.core.display.Display;
import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.keyboard.Keyboard;
import oop.inheritance.core.printer.Printer;
import oop.inheritance.core.transaction.GenericTransaction;
import oop.inheritance.core.transaction.GenericTransactionResponse;

public class Application {

    private final Keyboard keyboard;

    private final Display display;

    private final CommunicationDevice device;

    private final Printer printer;

    private final Provider provider;

    public Application(ITerminalFactory terminalFactory) {
        keyboard = terminalFactory.getKeyboard();
        display = terminalFactory.getDisplay();
        device = terminalFactory.getCommunicationDevice();
        printer = terminalFactory.getPrinter();
        this.provider = terminalFactory.getCardProvider();
    }

    public void showMenu() {
        display.print(5, 5, "MENU");
        display.print(5, 10, "1. VENTA");
        display.print(5, 13, "2. DEVOLUCION");
        display.print(5, 16, "3. REPORTE");
        display.print(5, 23, "4. CONFIGURACION");
    }

    public String readKey() {
        return keyboard.getKey();
    }


    public void doSale() {
        display.clear();
        display.print(5, 20, "Capture el monto:");

        String amount = keyboard.getKey();

        provider.readCard( (card) -> {
            GenericTransaction genericTransaction = new GenericTransaction();
            genericTransaction.setLocalDateTime(LocalDateTime.now());
            genericTransaction.setCard(card);
            genericTransaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")) * 100);
            GenericTransactionResponse response = sendSale(genericTransaction);

            if (response.isApproved()) {
                display.print(5, 25, "APROBADA");
                printReceipt(genericTransaction);
            } else {
                display.print(5, 25, "DENEGADA");
            }
        });
    }

    private void printReceipt(GenericTransaction genericTransaction) {
        Card card = genericTransaction.getCard();

        printer.print(5, "APROBADA");
        printer.lineFeed();
        printer.print(5, card.getAccount());
        printer.lineFeed();
        printer.print(5, "" + genericTransaction.getAmountInCents());
        printer.lineFeed();
        printer.print(5, "________________");
    }

    private GenericTransactionResponse sendSale(GenericTransaction genericTransaction) {
        device.open();
        device.send(genericTransaction);
        GenericTransactionResponse transactionResponse = device.receive();
        device.close();

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        display.clear();
    }
}
