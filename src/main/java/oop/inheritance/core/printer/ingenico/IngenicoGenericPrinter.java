package oop.inheritance.core.printer.ingenico;

import oop.inheritance.core.communicationdevices.ingenico.ethernet.IngenicoGenericEthernet;
import oop.inheritance.core.printer.Printer;
import oop.library.ingenico.services.IngenicoPrinter;

public class IngenicoGenericPrinter implements Printer {

    private final IngenicoPrinter printer;

    private IngenicoGenericPrinter() {
        printer = new IngenicoPrinter();
    }

    @Override
    public void print(int i, String message) {
        printer.print(i, message);
    }

    @Override
    public void lineFeed() {
        printer.lineFeed();
    }

    private static final class GenericPrinterHolder {
        private static final IngenicoGenericPrinter genericPrinter = new IngenicoGenericPrinter();
    }

    public synchronized static IngenicoGenericPrinter getInstance() {
        return GenericPrinterHolder.genericPrinter;
    }
}
