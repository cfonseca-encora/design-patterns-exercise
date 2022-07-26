package oop.inheritance.core.printer.verifone;

import oop.inheritance.core.printer.Printer;
import oop.inheritance.core.printer.ingenico.IngenicoGenericPrinter;
import oop.library.v240m.VerifoneV240mPrinter;

public class VerifoneV240MGenericPrinter implements Printer {
    private final VerifoneV240mPrinter printer;

    private VerifoneV240MGenericPrinter() {
        printer = new VerifoneV240mPrinter();
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
        private static final VerifoneV240MGenericPrinter genericPrinter = new VerifoneV240MGenericPrinter();
    }

    public synchronized static VerifoneV240MGenericPrinter getInstance() {
        return GenericPrinterHolder.genericPrinter;
    }
}
