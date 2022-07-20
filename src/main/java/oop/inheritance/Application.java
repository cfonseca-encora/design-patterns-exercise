package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.core.card.Card;
import oop.inheritance.core.display.Display;
import oop.inheritance.core.display.factory.DisplayFactory;
import oop.inheritance.core.keyboard.Keyboard;
import oop.inheritance.core.keyboard.factory.KeyboardFactory;
import oop.inheritance.core.transaction.Transaction;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.*;

public class Application {

    private final CommunicationType communicationType = CommunicationType.ETHERNET;
    private final SupportedTerminal supportedTerminal;

    private final Keyboard keyboard;

    private final Display display;

    public Application(SupportedTerminal supportedTerminal) {
        this.supportedTerminal = supportedTerminal;
        keyboard = KeyboardFactory.getInstance(supportedTerminal);
        display = DisplayFactory.getInstance(supportedTerminal);
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
        CardProvider cardProvider = CardProviderFactory.getInstance();

        display.clear();
        display.print(5, 20, "Capture el monto:");

        String amount = keyboard.getKey();

        Card card;

        Transaction transaction = TransactionFactory.getInstance(supportedTerminal);
        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")) * 100);

        //cardProvider.readCard( card -> {});

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.print(5, 20, "Capture monto:");

        Transaction transaction = new Transaction();

        //GenericTransaction genericTransaction = GenericTransactionFactoryImpl.getInstance(supportedTerminal);

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            display.print(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            display.print(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        IngenicoPrinter ingenicoPrinter = new IngenicoPrinter();
        Card card = transaction.getCard();

        ingenicoPrinter.print(5, "APROBADA");
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, card.getAccount());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "" + transaction.getAmountInCents());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "________________");

    }

    private TransactionResponse sendSale(Transaction transaction) {
        Ethernet ethernet = EthernetFactory.getInstance(supportedTerminal);
        IngenicoModem modem = new IngenicoModem();
        IngenicoGPS gps = new IngenicoGPS();
        TransactionResponse transactionResponse = null;

        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }

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
