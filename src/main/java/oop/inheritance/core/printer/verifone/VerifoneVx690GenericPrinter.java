package oop.inheritance.core.printer.verifone;

import oop.inheritance.core.printer.Printer;
import oop.library.vx690.VerifoneVx690Printer;

public class VerifoneVx690GenericPrinter implements Printer {
    private final VerifoneVx690Printer printer;

    private VerifoneVx690GenericPrinter() {
        printer = new VerifoneVx690Printer();
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
        private static final VerifoneVx690GenericPrinter genericPrinter = new VerifoneVx690GenericPrinter();
    }

    public synchronized static VerifoneVx690GenericPrinter getInstance() {
        return GenericPrinterHolder.genericPrinter;
    }
}
