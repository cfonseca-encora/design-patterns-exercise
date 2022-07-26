package oop.inheritance.core.printer.verifone;

import oop.inheritance.core.printer.Printer;
import oop.library.vx520.VerifoneVx520Printer;

public class VerifoneVx520GenericPrinter implements Printer {
    private final VerifoneVx520Printer printer;

    private VerifoneVx520GenericPrinter() {
        printer = new VerifoneVx520Printer();
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
        private static final VerifoneVx520GenericPrinter genericPrinter = new VerifoneVx520GenericPrinter();
    }

    public synchronized static VerifoneVx520GenericPrinter getInstance() {
        return GenericPrinterHolder.genericPrinter;
    }
}
